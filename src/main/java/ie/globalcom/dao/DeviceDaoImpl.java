package ie.globalcom.dao;

import ie.globalcom.domain.Device;

import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DeviceDaoImpl implements DeviceDao
{
    private Connection connection;
    private PreparedStatement pstmtGetByKey = null;
    private ResultSet rs = null;
    private static final String sqlGetByKey = "Select class_name From Keywords k INNER JOIN Classes c ON k.binded_class = c.class_id  Where keyword = ?";

    private PreparedStatement getPstmtGetByKey() throws DaoException
    {
        try
        {
            if(pstmtGetByKey == null)
            {
                return pstmtGetByKey = connection.prepareStatement(sqlGetByKey);
            }
            else
            {
                return pstmtGetByKey;
            }
        }
        catch(Exception e)
        {
            throw new DaoException(e);
        }
    }

    @Override
    public Device getDeviceByKey(String key) throws DaoException
    {
        try
        {
            pstmtGetByKey = getPstmtGetByKey();
            pstmtGetByKey.setString(1, key);
            rs = pstmtGetByKey.executeQuery();
            if(rs.next())
            {
                String classNameStr = rs.getString(1);
                Device device = null;
                if(classNameStr != null)
                {
                    Class deviceClass = Class.forName(classNameStr);
                    Constructor constructor = deviceClass.getConstructor();
                    device = (Device)constructor.newInstance();
                }
                return device;
            }
            else
            {
                return null;
            }
        }
        catch(Exception e)
        {
            throw new DaoException(e);
        }
    }

    @Override
    public void close() throws DaoException
    {
        try
        {
            if(pstmtGetByKey != null)
            {
                pstmtGetByKey.close();
            }
            if(rs != null)
            {
                rs.close();
            }
            connection.close();
        }
        catch(Exception e)
        {
            throw new DaoException(e);
        }
    }

    public DeviceDaoImpl() throws DaoException
    {
        try
        {
            connection = DaoFactoryImpl.getConnection();
        }
        catch(Exception e)
        {
            throw new DaoException(e);
        }
    }
}
