package ie.globalcom.web;


import com.opensymphony.xwork2.ActionSupport;
import ie.globalcom.domain.Device;
import ie.globalcom.service.DeviceService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class DeviceController extends ActionSupport
{
    private String keyword;
    private String deviceMsg;

    public String getDeviceMsg()
    {
        return deviceMsg;
    }

    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }

    public String processDeviceJSON() throws Exception
    {
        HttpSession session = ServletActionContext.getRequest().getSession();
        DeviceService deviceService = (DeviceService)session.getAttribute("deviceService");
        Device device = deviceService.getDeviceByKey(keyword);

        if(device != null)
        {
            boolean isTurnedOn = device.toggle();
            String deviceName = device.getClass().getSimpleName();
            if(isTurnedOn)
            {
                deviceMsg = deviceName + ": I am turned on!";
            }
            else
            {
                deviceMsg = deviceName + ": I am turned off!";
            }
        }
        return SUCCESS;
    }
}
