package ie.globalcom.domain;


public class Computer
{
    private static boolean isTurnedOn;

    public static boolean toggle()
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
