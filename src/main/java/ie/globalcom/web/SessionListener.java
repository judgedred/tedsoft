package ie.globalcom.web;


import ie.globalcom.dao.DaoException;
import ie.globalcom.service.DeviceService;
import ie.globalcom.service.DeviceServiceImpl;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener
{
    @Override
    public void sessionCreated(HttpSessionEvent event)
    {
        try
        {
            DeviceService deviceService = new DeviceServiceImpl();
            event.getSession().setAttribute("deviceService", deviceService);
        }
        catch(DaoException d)
        {
            d.printStackTrace();
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event)
    {
        try
        {
            DeviceService deviceService = (DeviceService)event.getSession().getAttribute("deviceService");
            if(deviceService != null)
            {
                deviceService.close();
            }
        }
        catch(DaoException d)
        {
            d.printStackTrace();
        }
    }
}
