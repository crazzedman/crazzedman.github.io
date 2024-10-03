/**
 * Write a description of class Coordinate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coordinate
{
    int x,y;
    public Coordinate(int cx, int cy)
    {
        x = cx;
        y = cy;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public String toString()
    {
        return "("+x+","+y+")";
    }
}
