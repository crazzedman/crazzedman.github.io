import java.util.ArrayList;

/**
 * Write a description of class trainer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class trainer
{
    String name,wins,losses;
    ArrayList<pokemon> pokemons;
    public trainer(String cname, String cwins, String closses, ArrayList<pokemon> cpokemons)
    {
        name = cname;
        pokemons = cpokemons;
        wins = cwins;
        losses = closses;
    }
    public trainer(String cname)
    {
        name = cname;
        wins = "wins :: 0";
        losses = "losses :: 0";
        pokemons = new ArrayList<pokemon>();
    }
    public void addPokemon(pokemon poke)
    {
        pokemons.add(poke);
    }
    public ArrayList<pokemon> getPokemons()
    {
        return pokemons;
    }
}
