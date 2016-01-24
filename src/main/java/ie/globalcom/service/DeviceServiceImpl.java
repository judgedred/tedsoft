package ie.globalcom.service;

import ie.globalcom.dao.DaoException;
import ie.globalcom.dao.DaoFactory;
import ie.globalcom.dao.DaoFactoryImpl;
import ie.globalcom.dao.DeviceDao;


public class DeviceServiceImpl implements DeviceService
{
    private DeviceDao deviceDao;

    @Override
    public Class getDeviceByKey(String key) throws DaoException
    {
        return deviceDao.getDeviceByKey(key);
    }

    @Override
    public void close() throws DaoException
    {
        if(deviceDao != null)
        {
            deviceDao.close();
        }
    }

    public DeviceServiceImpl() throws DaoException
    {
        DaoFactory daoFactory = new DaoFactoryImpl();
        deviceDao = daoFactory.getDeviceDao();
    }
}
