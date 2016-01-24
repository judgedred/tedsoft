package ie.globalcom.dao;


public interface DeviceDao
{

    public Class getDeviceByKey(String key) throws DaoException;
    public void close() throws DaoException;
}
