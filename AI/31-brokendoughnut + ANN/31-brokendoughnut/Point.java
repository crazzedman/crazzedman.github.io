
/**
 * Write a description of class Point here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Point
{
    double x,y;
    int tag;
    public Point(double cx,double cy, int ctag)
    {
        x = cx;
        y = cy;
        tag = ctag;
    }
    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }
    public int getTag()
    {
        return tag;
    }
    
}
