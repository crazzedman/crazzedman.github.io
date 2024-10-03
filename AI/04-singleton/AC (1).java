

/**
 * Write a description of class AC here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AC
{
    
    public static boolean onoroff;
    // turn on
    public static void acdisplay()
    {
        StdDraw.setCanvasSize(500,350);
        StdDraw.setXscale(0,50);
        StdDraw.setYscale(50,0);
        StdDraw.picture(15,15,"yoda.jfif");
        StdDraw.text(40,10,"Yoda is your thermoagent");
        StdDraw.picture(40,20,"thermostat_cleanup.jpg",10,10);
        StdDraw.picture(25,40,"ac_cleanup.jpg");
    }
    public static double turnon()
    {
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(206,213,219);
        StdDraw.filledRectangle(38,17.5,1.5,1.5);
        StdDraw.setPenColor(StdDraw.BLACK);
        System.out.println("on");
        StdDraw.text(38,17.5,"on");
        StdDraw.setPenColor(157, 154, 237);
       for(int i = 10; i <=40;i+=2)
       {
           StdDraw.filledRectangle(i,49,0.75,1.5);
       }
        StdDraw.show();
        return 0.1;
    }
    
    // turn it off
    public static double turnoff()
    {
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(206,213,219);
        StdDraw.filledRectangle(38,17.5,1.5,1.5);
        StdDraw.setPenColor(StdDraw.BLACK);
        System.out.println("off");
       StdDraw.text(38,17.5,"off"); 
       StdDraw.setPenColor(StdDraw.WHITE);
       for(int i = 10; i <=40;i+=2)
       {
           StdDraw.filledRectangle(i,49,0.75,1.5);
       }
       StdDraw.show();
       return -0.1;
    }
    // other stuff
    
}
