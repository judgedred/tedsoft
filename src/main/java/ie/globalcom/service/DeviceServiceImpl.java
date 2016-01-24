package ie.globalcom.service;

import ie.globalcom.dao.DaoException;
import ie.globalcom.dao.DaoFactory;
import ie.globalcom.dao.DaoFactoryImpl;
import ie.globalcom.dao.DeviceDao;
import ie.globalcom.domain.Device;

import java.util.HashMap;
import java.util.Map;


public class DeviceServiceImpl implements DeviceService
{
    private DeviceDao deviceDao;
    private Map<String, Device> deviceMap = new HashMap<>();

    @Override
    public Device getDeviceByKey(String key) throws DaoException
    {
        Device device = deviceDao.getDeviceByKey(key);
        String deviceName = device.getClass().getSimpleName();
        if(deviceMap.get(deviceName) == null)
        {
            deviceMap.put(deviceName, device);
        }
        else
        {
            device = deviceMap.get(deviceName);
        }
        return device;
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
