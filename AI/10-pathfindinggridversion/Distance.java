import java.util.PriorityQueue;
import java.util.ArrayList;

/**
 * Write a description of class Coordinate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Distance implements Comparable<Distance>
{
    int x,y,destx,desty;
    double total;
    Coordinate origin, dest;
    ArrayList<Coordinate>shortpath;
    public Distance(Coordinate corigin, Coordinate cdest)
    {
        x = corigin.getX();
        y = corigin.getY();
        destx = cdest.getX();
        desty = cdest.getY();
        origin = corigin;
        dest = cdest;
        total = calculateTotal();
        shortpath = new ArrayList<Coordinate>();
        shortpath.add(origin);
    }
    public Distance(Coordinate corigin, Coordinate cdest, ArrayList<Coordinate> cshortpath)
    {
        x = corigin.getX();
        y = corigin.getY();
        destx = cdest.getX();
        desty = cdest.getY();
        origin = corigin;
        dest = cdest;
        total=calculateTotal();
        shortpath = cshortpath;
        shortpath.add(origin);
    }
    public Distance(Coordinate corigin, Coordinate cdest, double cost,ArrayList<Coordinate> cshortpath)
    {
        x = corigin.getX();
        y = corigin.getY();
        destx = cdest.getX();
        desty = cdest.getY();
        origin = corigin;
        dest = cdest;
        total=cost;
        total+=calculateTotal();
        shortpath = cshortpath;
        shortpath.add(origin);
    }
    public ArrayList<Coordinate> getList()
    {
        return shortpath;
    }
    public double getDist()
    {
        return total;
    }
    public void addLocation(Coordinate cord)
    {
        shortpath.add(cord);
    }
    public double calculateTotal()
    {
        int xdiff = Math.abs(this.x-this.destx);
        int ydiff = Math.abs(this.y-this.desty);
        double dist = 0;
        if(xdiff==0&&ydiff==0)
        {
            return dist;
        }
        if(xdiff == 0)
        {
            dist +=ydiff;
        }
        else if(ydiff ==0)
        {
            dist +=xdiff;
        }
        else if(ydiff < xdiff)
        {
            dist +=Math.abs(xdiff-ydiff);
            dist += ydiff*1.4;
        }
        else if(ydiff>xdiff)
        {
            dist +=Math.abs(xdiff-ydiff);
            dist += xdiff*1.4;
        }
        else if(xdiff == ydiff)
        {
            dist += xdiff*1.4;
        }
        return dist;
    }
    public Coordinate getOrigin()
    {
        return origin;
    }
    public Coordinate getDest()
    {
        return dest;
    }
    public String toString()
    {
        return "This is distance : " + calculateTotal();
    }
    public int compareTo(Distance cord)
    {
        double here = this.total*10;
        double there = cord.total*10;
        int diff = (int)here- (int)there;
        return diff;
    }
}
