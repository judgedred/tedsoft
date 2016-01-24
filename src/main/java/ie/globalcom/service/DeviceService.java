package ie.globalcom.service;


import ie.globalcom.dao.DaoException;

public interface DeviceService
{
    public Class getDeviceByKey(String key) throws DaoException;
    public void close() throws DaoException;
}
