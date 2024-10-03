
/**
 * Write a description of class Environment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.util.Scanner;
public class Environment
{
    
    // method to return temp
    public static double currenttemp;
    public static double desiredtemp;
    public static boolean on; 
    public static double factor;
    public static boolean finalwarning;
    private static Environment m_instance = null;
    private Environment () {
         currenttemp = 0.0;
     }
     public static Environment getInstance () {
         if (m_instance == null) {
             m_instance = new Environment ();
         }
         return m_instance;
     }
     
    
    public double simulate(double ct, double dt, boolean fw)
    {
        if(ct<0)
        {
            StdDraw.enableDoubleBuffering();
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.text(25,25,"Agent Yoda: Dead Are You Not to Hyphothermia?");
            StdDraw.show();
            StdDraw.pause(10000);
            System.exit(0);
        }
        else if(ct>54)
        {
            StdDraw.enableDoubleBuffering();
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.text(25,40,"Agent Yoda: Dead Are You Not to the Heat?");
            StdDraw.show();
            StdDraw.pause(10000);
            System.exit(0);
        
        }
        else if(ct < 4&&finalwarning==false||ct > 42&&finalwarning==false)
        {
            int result = JOptionPane.showConfirmDialog(null,"To change desired temperature, Last Chance you get", "Thermoagent",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
               Scanner j = new Scanner(System.in);
            if(result == JOptionPane.YES_OPTION)
            {
                JOptionPane.showMessageDialog(null,"make wise choice you do");
                System.out.print("New Desired Temperature :: ");
                dt = j.nextDouble();
                System.out.println();
                finalwarning = true;
            }
            else if (result == JOptionPane.NO_OPTION)
            {
                finalwarning = true;
                JOptionPane.showMessageDialog(null," gave you last chance I did");
            }
        }
        
        currenttemp = ct;
        desiredtemp = dt;
        Agent.sense(currenttemp, desiredtemp);
        Agent.decide();
        if(Agent.act()==true&&on==false)
        {
            factor = AC.turnon();
            on = true;
        }
        else if(Agent.act()==false&&on==true)
        {
            factor = AC.turnoff();
            on = false;
        }
        else if(Agent.act()==true&&on==true)
        {
            factor = -0.1;
        }
        else if(Agent.act()==false&&on==false)
        {
            factor = 0.1;
        }
        Environment.changetemp();
        returntemp();
        StdDraw.pause(200);
        return currenttemp;
    }
    public void returntemp()
    {
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(206,213,219);
        StdDraw.filledSquare(40,20,1.5);
        StdDraw.setPenColor(StdDraw.BLACK);
        System.out.println(String.format("%.1f", currenttemp));
        StdDraw.text(40,20,String.format("%.1f", currenttemp));
        StdDraw.show();
    }
    public double returndt()
    {
        return desiredtemp;
    }
    // method to change temp
    
    public static double changetemp()
    {
        currenttemp+=factor;
        return currenttemp;
    }
}
