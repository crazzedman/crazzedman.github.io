
/**
 * Write a description of class Runner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Runner
{
    public static void main(String args[]) throws Exception
    {
        Scanner input = new Scanner(System.in);
        boolean inputs = true;
        double weight = 0;
        double weight1 = 0;
        String w = "";
        String w1 = "";
        ArrayList<Double> values = new ArrayList<Double>();
        ArrayList<Double> values1 = new ArrayList<Double>();
        ArrayList<Double> targets = new ArrayList<Double>();
        ArrayList<Double> outputs = new ArrayList<Double>();
        System.out.print("Do you want to import data and weights?");
        String response = input.next();
        if(response.equals("yes"))
        {
            File file = new File("Data.txt");
            Scanner scan = new Scanner(file);
            w = scan.nextLine();
            w1= scan.nextLine();
            System.out.println(w);
            System.out.println(w1);
            weight = new Double(w.substring(10));
            weight1 = new Double(w1.substring(10));
        }
        else
        {
            weight = Math.random();
            weight1 = Math.random();
        }
        while(inputs)
        {
            System.out.print("What is your first value? :: ");
            values.add(input.nextDouble());
            System.out.println();
            System.out.print("What is your second value? :: ");
            values1.add(input.nextDouble());
            System.out.println();
            System.out.print("What is your target? :: ");
            targets.add(input.nextDouble());
            System.out.println();
            System.out.print("Do you wish to continue inputting data (y/n)? :: ");
            response = input.next();
            if(response.equals("y"))
            {
                inputs = true;
            }
            else if(response.equals("n"))
            {
                inputs = false;
            }
            else
            {
                System.out.println("Not a valid response will continue to learning gates");
                inputs = false;
            }
        }
        
        System.out.print("What is your learning rate? :: ");
        double learningrate = input.nextDouble();
        System.out.println();
        System.out.print("What is your threshold? :: ");
        double threshold = input.nextDouble();
        System.out.println();
        System.out.print("Do you wish to and or or? :: ");
        String gatetype = input.next();
        System.out.println();
        System.out.print("What is the maximum amount of iterations :: ");
        int maxiterations = input.nextInt();
        System.out.println();
        System.out.println(weight);
        System.out.println(weight1);
        perceptron pc = new perceptron(threshold,learningrate,weight,weight1,gatetype, maxiterations,targets,values,values1);
        pc.drawGraph();
        pc.learngate();
        pc.saveWeight();
    }
}
