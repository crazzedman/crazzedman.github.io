
/**
 * Write a description of class Agent here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Agent
{
    // do what agents do
    public static double currenttemp;
    public static double desiredtemp;
    public static boolean aboveorbelow;
    public static boolean act()
    {
        return aboveorbelow;
    }
    public static void decide()
    {
        if(desiredtemp+2<=currenttemp)
        {
            aboveorbelow = true;
        }
        else if(desiredtemp-2>=currenttemp)
        {
            aboveorbelow = false;
        }
    }
    public static void sense(double ct, double dt)
    {
        currenttemp = ct;
        desiredtemp = dt;
    }
}
