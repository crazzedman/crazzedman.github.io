/**
 * Write a description of class Runner here.
 *
 * @author (your name)
 * @version (a version number or a date)
*/
import java.util.Arrays;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.util.TransferFunctionType;
import org.neuroph.nnet.learning.BackPropagation;
import java.util.ArrayList;

public class Runner
{
    public static void main(String args[])
    {
        StdDraw.setCanvasSize(600,600);
        BackPropagation rule = new BackPropagation();
        rule.setMaxError(0.0001);
        rule.setMaxIterations(100000);//nothing over 100,000
        rule.setLearningRate(0.3);
        DataSet data = new DataSet(2,1);
        //doughnut change to area
        double deltax=-0.5;
        double deltax1=0.5;
        double deltay=1;
        double deltay1=-1;
        int datasize = 400;
        for(int i = 0; i < datasize/2; i++)
        {
            double ang = ((Math.random()*1)+1) * Math.PI;
            double hyp = Math.sqrt(((Math.random()*0.5)+0.5)) * 2.5;
            double adj = Math.cos(ang) * hyp;
            double opp = Math.sin(ang) * hyp;
            data.addRow(new DataSetRow(new double[] {adj+deltax,opp+deltay},new double[] {0}));        
        }
        for(int i = 0; i < datasize/2; i++)
        {
            double ang = Math.random() * Math.PI;
            double hyp = Math.sqrt(((Math.random()*0.5)+0.5)) * 2.5;
            double adj = Math.cos(ang) * hyp;
            double opp = Math.sin(ang) * hyp;    
            data.addRow(new DataSetRow(new double[] {adj+deltax1,opp+deltay1},new double[] {1}));        
        }
        MultiLayerPerceptron mlp = new MultiLayerPerceptron(TransferFunctionType.SIGMOID, 2, 5,1); 
        mlp.learn(data,rule);
        testNeuralNetwork(mlp, data, false);
        StdDraw.clear();
        mlp.save("myMlPerceptron.nnet");
        NeuralNetwork loadedMLP = NeuralNetwork.createFromFile("myMlPerceptron.nnet");
        DataSet testdata = new DataSet(2,1);
        int testdatasize = 1000;
        for(int i = 0; i < testdatasize;i++)
        {
            double ang = (Math.random()*2) * Math.PI;
            double hyp = Math.sqrt(Math.random()) * 10;
            double adj = Math.cos(ang) * hyp;
            double opp = Math.sin(ang) * hyp;
            double rand = Math.random();
            if(rand > 0.5)
            {
                testdata.addRow(new DataSetRow(new double[] {adj,opp},new double[] {0}));
            }
            else
            {
                testdata.addRow(new DataSetRow(new double[] {adj,opp},new double[] {1}));
            }
        }
        testNeuralNetwork(loadedMLP, testdata, true);
        testNeuralNetwork(loadedMLP, data, false);
        System.out.println("Total Error : "+ rule.getTotalNetworkError());
        System.out.println("# Iterations: "+ rule.getCurrentIteration());
    }
    
    public static void drawGraph(ArrayList<Point> points, boolean color)
    {
       StdDraw.enableDoubleBuffering();
       int size = 10;
       StdDraw.setXscale(-5,5);
       StdDraw.setYscale(-5,5);
       StdDraw.setPenColor(StdDraw.GREEN);
       for(int j = -5; j < 5; j++)
       {
           StdDraw.line(-5,j,5,j);
           StdDraw.line(j,-5,j,5);
       }
       for(int i = 0; i < points.size();i++)
       {
           if(color)
           {
               if(points.get(i).getTag()==1)
               {
                   StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
               }
               else if(points.get(i).getTag()==0)
               {
                   StdDraw.setPenColor(StdDraw.BOOK_RED);
               }
               else
               {
                   StdDraw.setPenColor(StdDraw.BLACK);
               }
           }
           else
           {
               if(points.get(i).getTag()==1)
               {
                   StdDraw.setPenColor(StdDraw.BLUE);
               }
               else if(points.get(i).getTag()==0)
               {
                    StdDraw.setPenColor(StdDraw.RED);
               }
               else
               {
                   StdDraw.setPenColor(StdDraw.BLACK);
               }
           }
           StdDraw.circle(points.get(i).getX(),points.get(i).getY(),0.05);
           StdDraw.show();
           StdDraw.pause(20);
       }
       
    }
    public static void testNeuralNetwork(NeuralNetwork nnet, DataSet testSet, boolean color) {
        ArrayList<Point> points = new ArrayList<Point>();
        for(DataSetRow dataRow : testSet.getRows()) {
            nnet.setInput(dataRow.getInput());
            nnet.calculate();
            double[ ] networkOutput = nnet.getOutput();
            if(Math.abs(networkOutput[0]-1)>0.5)
            {
                points.add(new Point(dataRow.getInput()[0],dataRow.getInput()[1],0));
            }
            if(Math.abs(networkOutput[0]-1)<0.5)
            {
                points.add(new Point(dataRow.getInput()[0],dataRow.getInput()[1],1));
            }
            System.out.print("Input: " + Arrays.toString(dataRow.getInput()) );
            System.out.println(" Output: " + Arrays.toString(networkOutput) );
        }
        drawGraph(points,color);
    }
}
