package ie.globalcom.dao;


public interface DaoFactory
{
    public DeviceDao getDeviceDao() throws DaoException;
}
