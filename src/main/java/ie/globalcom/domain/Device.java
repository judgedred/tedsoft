package ie.globalcom.domain;


public class Device
{
    private boolean isTurnedOn;

    public boolean toggle()
    {
        if(isTurnedOn)
        {
            isTurnedOn = false;
        }
        else
        {
            isTurnedOn = true;
        }
        return isTurnedOn;
    }
}
