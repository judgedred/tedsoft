package ie.globalcom.service;


import ie.globalcom.dao.DaoException;
import ie.globalcom.domain.Device;

public interface DeviceService
{
    public Device getDeviceByKey(String key) throws DaoException;
    public void close() throws DaoException;
}
