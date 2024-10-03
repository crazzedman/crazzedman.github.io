import java.util.ArrayList;

/**
 * Write a description of class aitrainer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class aitrainer
{
    String name,difficulty;
    ArrayList<pokemon> pokemons;
    public static int currenthealth;
    public static int aboveorbelow;
    public aitrainer(String cname, String cdifficulty,ArrayList<pokemon> cpokemons)
    {
        name = cname;
        pokemons = cpokemons;
        difficulty = cdifficulty;
    }
    public ArrayList<pokemon> getPokemons()
    {
        return pokemons;
    }
    
    public static int act()
    {
        return aboveorbelow;
    }
    public static void decide()
    {
        if(currenthealth>=10&&currenthealth<=20)
        {
            aboveorbelow = 0;
        }
        else if(currenthealth<=10)
        {
            aboveorbelow = 1;
        }
        else if(currenthealth>=20&&currenthealth<=30)
        {
            aboveorbelow = 2;
        }
        else
        {
            aboveorbelow = 3;
        }
    }
    public static void sense(int ct)
    {
        currenthealth = ct;
    }
}
    
    
    
