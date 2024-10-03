
/**
 * Write a description of class Runner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import javax.swing.*;
public class Runner
{
    private int desiredtemp;
    private int outsidetemp;
    public static void main (String[]args) {
        Scanner j = new Scanner(System.in);
        javax.swing.JOptionPane.showMessageDialog(null,"Do you want to play with the temperature?");
        
        // ask for outside temp
        System.out.println("what is the outside temperature?");
        System.out.print("Outside Temperature :: ");
        double k = j.nextDouble();
        
        System.out.println();
        
        // ask for desired temp
        System.out.println("what is the desired temperature?");
        System.out.print("Desired Temperature :: ");
        double a = j.nextDouble();
        System.out.println(); 
        
        int result = JOptionPane.showConfirmDialog(null,"Do you want Thermoagent to help you?", "Thermoagent",
               JOptionPane.YES_NO_CANCEL_OPTION,
               JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION)
            {
                JOptionPane.showMessageDialog(null,"Ok, Thermoagent will help you");
                AC.acdisplay();
                if(k>a)
                {
                    AC.turnoff();
                }
                else if(a<k)
                {
                    AC.turnon();
                }
                else
                {
                    AC.turnoff();
                }
                while(1==1)
                {
                   k = Environment.simulate(k,a,false);
                   a = Environment.returndt();
                }
            }
            else if (result == JOptionPane.NO_OPTION)
            {
                JOptionPane.showMessageDialog(null,"Ok, you can't play with temperature without Thermoagent");
                System.exit(0);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wait what then do you not want to change the temperature?");
                
            }
            
        
    }
}
