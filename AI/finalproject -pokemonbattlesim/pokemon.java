import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a description of class pokemon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class pokemon
{
    Type type;
    ArrayList<Move>moves;
    String name;
    int health, speed;
    public pokemon(String cname,int chealth, int cspeed, Type ctype,ArrayList<Move>cmoves)
    {
        name = cname;
        type = ctype;
        health = chealth;
        speed = cspeed;
        moves = cmoves;
    }
    public int getHealth()
    {
        return health;
    }
    public int getSpeed()
    {
        return speed;
    }
    public void changeHealth(int change)
    {
        health = health - change;
    }
    public String toString()
    {
        return name;
    }
    public void printMoves()
    {
        for(int i = 0; i < moves.size();i++)
        {
            System.out.println(moves.get(i));
        }
    }
    public Move useMove(int num)
    {
        Move move = null;
        if(num!=-1)
        {
            return moves.get(num);
        }
        printMoves();
        Scanner print = new Scanner(System.in);
        System.out.print("Choose Move :: ");
        int decide = print.nextInt();
        System.out.println();
        move = moves.get(decide-1);
        return move;
    }
}
