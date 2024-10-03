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
        String w = "";
        String w1 = "";
        ArrayList<Point> points = new ArrayList<Point>();
        ArrayList<Double> weights = new ArrayList<Double>();
        ArrayList<Integer> desired = new ArrayList<Integer>();
        ArrayList<Integer> guess = new ArrayList<Integer>();
        int datasize = 500;
        System.out.print("Do you want to import data and weights?");
        String response = input.next();

            
        for(int i = 0; i < datasize/2; i++)
        {
            double ang = ((Math.random()*1)+1) * Math.PI;
            double hyp = Math.sqrt(((Math.random()*0.5)+0.5)) * 2.5;
            double adj = Math.cos(ang) * hyp;
            double opp = Math.sin(ang) * hyp;
            points.add(new Point(adj-1,opp+0.5,0));
        }
        for(int i = 0; i < datasize/2; i++)
        {
            double ang = Math.random() * Math.PI;
            double hyp = Math.sqrt(((Math.random()*0.5)+0.5)) * 2.5;
            double adj = Math.cos(ang) * hyp;
            double opp = Math.sin(ang) * hyp;
            points.add(new Point(adj+1,opp-0.5,1));
        }
        for(int i = 0; i < datasize; i++)
        {
            double weight = Math.random()*2-1;
            weights.add(weight);
            desired.add(0);
            guess.add(0);
            if(points.get(i).getY() > 0)
            {
                desired.set(i,1);
            }    
            if(points.get(i).getY()*weight > 0 )
            {
                guess.set(i,1);
            }
        }
        System.out.print("What is your learning rate? :: ");
        double learningrate = input.nextDouble();
        System.out.println();
        System.out.print("What is the maximum amount of iterations :: ");
        int maxiterations = input.nextInt();
        System.out.println();
        perceptron pc = new perceptron(datasize,learningrate,weights, maxiterations,points, desired, guess);
        pc.drawGraph();
        pc.train();
        pc.test();
        pc.saveWeight();
    }
}
