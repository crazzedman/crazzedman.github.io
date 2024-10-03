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
    int maxiterations;
    double threshold,learningrate,weight,weight1;
    String gatetype;
    ArrayList<Double> values,values1,targets;
    
    public perceptron(double cthreshold, double clearningrate,double cweight,double cweight1,String cgatetype,int cmaxiterations,ArrayList<Double> ctargets,ArrayList<Double> cvalues,ArrayList<Double> cvalues1)   {
       learningrate = clearningrate;
       gatetype = cgatetype;
       maxiterations = cmaxiterations;
       values = cvalues;
       values1 = cvalues1;
       weight = cweight;
       weight1 = cweight1;
       targets = ctargets;
       threshold = cthreshold;
    }
    public void drawGraph()
    {
       StdDraw.enableDoubleBuffering();
       StdDraw.setCanvasSize(600,600);
       StdDraw.setXscale(-1,3);
       StdDraw.setYscale(-1,3);
       StdDraw.setPenColor(StdDraw.BLACK);
       StdDraw.line(0,0,2,0);
       StdDraw.line(0,0,0,2);
       StdDraw.line(0,1,2,1);
       StdDraw.line(1,0,1,2);
       for(int i = 0; i < values.size();i++)
       {
           if(targets.get(i)==1)
           {
               StdDraw.setPenColor(StdDraw.GREEN);
           }
           else
           {
               StdDraw.setPenColor(StdDraw.RED);
           }
           StdDraw.circle(values.get(i),values1.get(i),0.05);
       }
       StdDraw.show();
    }
    public void learngate()
    {
       double error = values.size();
       while (error != 0)
       {
           error=values.size();
           for(int i = 0; i <values.size();i++)
           {
               if(gatetype.equals("or"))
               {
                   if(weight*values.get(i) > threshold || weight1*values1.get(i)>threshold)
                   {
                       if(!(targets.get(i)==1))
                       {
                           weight=weight+weightdelta(1,targets.get(i),values.get(i));                   
                           weight1=weight1+weightdelta(1,targets.get(i),values1.get(i));
                       }
                       else
                       {
                           error-=1;
                       }
                   }
                   else
                   {
                       if(!(targets.get(i)==0))
                       {
                           weight=weight+weightdelta(0,targets.get(i),values.get(i));                   
                           weight1=weight1+weightdelta(0,targets.get(i),values1.get(i));
                       }
                       else
                       {
                           error-=1;
                       }
                   }
               }
               else if(gatetype.equals("and"))
               {
                   if(weight*values.get(i)>threshold && weight1*values1.get(i) > threshold)
                   {
                       if(!(targets.get(i)==1))
                       {
                           weight=weight+weightdelta(1,targets.get(i),values.get(i));                   
                           weight1=weight1+weightdelta(1,targets.get(i),values1.get(i));
                       }
                       else
                       {
                           error-=1;
                       }
                   }
                   else
                   {
                       if(!(targets.get(i)==0))
                       {
                           weight=weight+weightdelta(0,targets.get(i),values.get(i));                   
                           weight1=weight1+weightdelta(0,targets.get(i),values1.get(i));
                       }
                       else
                       {
                           error-=1;
                       }
                   }
               }
           }
           if(error==0)
           {
               StdDraw.setPenColor(StdDraw.GREEN);
           }
           else
           {
               StdDraw.setPenColor(StdDraw.RED);
           }
           StdDraw.line(weight,0,0,weight1);
           System.out.println(weight);
           System.out.println(weight1);
           StdDraw.show();
       }
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
    public double weightdelta(double output, double target, double value)
    {
        return learningrate*(target-output)*value;
    }
}
