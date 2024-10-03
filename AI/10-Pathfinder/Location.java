import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Write a description of class Location here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Location implements Comparable<Location>
{
    PriorityQueue<Link> links;
    ArrayList<Link> tlinks;
    int sld;
    String name;
    public Location(String cname,  int csld)
    {
        sld = csld;
        name = cname;
        links = new PriorityQueue<Link>();
        tlinks = new ArrayList<Link>();
    }
    public String toString()
    {
        return name;
    }
    public int compareTo(Location place)
    {
        int diff = this.sld - place.sld;
        return diff;
    }
    public void addLink(Location A, int distance)
    {
        if(!isLinked(A))
        {
            links.add(new Link(A,distance));
            tlinks.add(new Link(A, distance));
            System.out.println(this.name +" and "+A.name+ " are now linked.");
        }
        else
        {
            System.out.println(this.name +" and "+A.name+ " are already linked.");
        }
    }
    public boolean isLinked(Location A)
    {
        if(links.size()==0)
        {
            return false;
        }
        for(int i = 0; i < links.size();i++)
        {
            if(tlinks.get(i).getLocation().toString().equals(A.toString()))
            {
                return true;
            }
        }
        return false;
    }
    public PriorityQueue getLinks()
    {
        return links;
    }
}
