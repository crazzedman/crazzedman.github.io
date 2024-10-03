import java.util.ArrayList;
import java.util.Formatter;
import java.io.IOException;

/**
 * Write a description of class perceptron here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class perceptron
{
    int maxiterations, datasize;
    double threshold,learningrate,weight,weight1;
    ArrayList<Point> points;
    ArrayList<Double>weights;
    ArrayList<Integer> desired, guess;
    public perceptron(int cdatasize, double clearningrate,ArrayList<Double> cweights,int cmaxiterations,ArrayList<Point> cpoints, ArrayList<Integer>cdesired, ArrayList<Integer>cguess)   {
       learningrate = clearningrate;
       maxiterations = cmaxiterations;
       desired = cdesired;
       guess = cguess;
       points = cpoints;
       weights=cweights;
       threshold = 0;
       datasize = cdatasize;
    }
    public void drawGraph()
    {
       StdDraw.enableDoubleBuffering();
       StdDraw.setCanvasSize(600,600);
       int size = 10;
       StdDraw.setXscale(-5,5);
       StdDraw.setYscale(-5,5);
       StdDraw.setPenColor(StdDraw.GREEN);
       for(int j = -5; j < 5; j++)
       {
           StdDraw.line(-5,j,5,j);
           StdDraw.line(j,-5,j,5);
       }
       StdDraw.setPenColor(StdDraw.BLACK);
       StdDraw.line(-5,0,5,0);
       for(int i = 0; i < points.size();i++)
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
           StdDraw.circle(points.get(i).getX(),points.get(i).getY(),0.05);
       }
       StdDraw.show();
    }
    public void train()
    {
        for(int i = 0; i < points.size(); i++)
        {
            int error = desired.get(i)-guess.get(i);
            while(error!=0&&maxiterations!=0)
            {
                weights.set(i,weights.get(i)+weightdelta(guess.get(i),desired.get(i),points.get(i)));
                System.out.println(weights.get(i));
                if(weights.get(i)*points.get(i).getY()>threshold)
                {
                    guess.set(i,1);
                }
                else
                {
                    guess.set(i,0);
                }
                error = desired.get(i)-guess.get(i);
                maxiterations--;
            }
        }
    }
    public void test()
    {
        ArrayList<Point> newpoints = new ArrayList<Point>();
        for(int i = 0; i < datasize/2; i++)
        {
            double ang = ((Math.random()*1)+1) * Math.PI;
            double hyp = Math.sqrt(((Math.random()*0.5)+0.5)) * 2.5;
            double adj = Math.cos(ang) * hyp;
            double opp = Math.sin(ang) * hyp;
            newpoints.add(new Point(adj-1,opp+0.5,-1));
        }
        for(int j = datasize/2; j < datasize;j++)
        {
           
            double ang = Math.random() * Math.PI;           
            double hyp = Math.sqrt(((Math.random()*0.5)+0.5)) * 2.5;
            double adj = Math.cos(ang) * hyp;
            double opp = Math.sin(ang) * hyp;
            newpoints.add(new Point(adj+1,opp-0.5,-1));
        }
        StdDraw.clear();
        StdDraw.pause(1000);
        StdDraw.setPenColor(StdDraw.GREEN);
       for(int j = -5; j < 5; j++)
       {
           StdDraw.line(-5,j,5,j);
           StdDraw.line(j,-5,j,5);
       }
        
        StdDraw.pause(5000);
        for(int i = 0; i < newpoints.size();i++)
       {
           if(newpoints.get(i).getTag()==1)
           {
               StdDraw.setPenColor(StdDraw.BLUE);
           }
           else if(newpoints.get(i).getTag()==0)
           {
               StdDraw.setPenColor(StdDraw.RED);
           }
           else
           {
               StdDraw.setPenColor(StdDraw.BLACK);
           }
           
           StdDraw.circle(newpoints.get(i).getX(),newpoints.get(i).getY(),0.05);
           StdDraw.show();
       }
       
       for(int i = 0; i < newpoints.size();i++)
       {
           if(newpoints.get(i).getY()*weights.get(i)>threshold)
           {
               newpoints.set(i, new Point(newpoints.get(i).getX(),newpoints.get(i).getY(),1));
           }
           else
           {
               newpoints.set(i, new Point(newpoints.get(i).getX(),newpoints.get(i).getY(),0));
           }
           if(newpoints.get(i).getTag()==1)
           {
               StdDraw.setPenColor(StdDraw.BLUE);
           }
           else if(newpoints.get(i).getTag()==0)
           {
               StdDraw.setPenColor(StdDraw.RED);
           }
           else
           {
               StdDraw.setPenColor(StdDraw.BLACK);
           }
           StdDraw.circle(newpoints.get(i).getX(),newpoints.get(i).getY(),0.05);
           StdDraw.pause(10);
           StdDraw.show();
       }
       StdDraw.setPenColor(StdDraw.BLACK);
       StdDraw.line(-5,threshold,5,threshold);

    }
    public void saveWeight()
    {
        Formatter out = null;
        try {  
                    out = new Formatter("Data.txt");
                    out.format("%s%n","Weight :: "+weight);
                    out.format("%s%n","Weight1 :: "+weight1);
                } catch (IOException e ) {
                    System.out.println ("Error with the file");    
                } finally {
                    if (out!= null)
                    {
                        out.close();
                    }
                }
                
    }
    public String printList(ArrayList<Double> list)
    {
        String response = "";
        for(int i =0; i <list.size();i++)
        {
            
            if(i== 0)
            {
                response = response + list.get(i);
            }
            else
            {
                response = list.get(i) + ","+response;
            }
        }
        return response;
    }
    public double weightdelta(double output, double target, Point point)
    {
        return learningrate*(target-output)*point.getY();
    }
}
