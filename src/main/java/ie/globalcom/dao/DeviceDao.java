package ie.globalcom.dao;


import ie.globalcom.domain.Device;

public interface DeviceDao
{

    public Device getDeviceByKey(String key) throws DaoException;
    public void close() throws DaoException;
}
