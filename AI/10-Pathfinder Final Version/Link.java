import java.util.ArrayList;

/**
 * Write a description of class Link here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Link implements Comparable<Link>
{
    int dist;
    int type;
    Location name;
    ArrayList<Location>visited;
    public Link(Location cname, int cdist, int ctype)
    {
        dist = cdist;
        name = cname;
        type = ctype;
        visited = new ArrayList<Location>();
        visited.add(cname);
    }
    public Link(Location cname, int cdist, int ctype,ArrayList<Location>cvisited)
    {
        dist = cdist;
        name = cname;
        type = ctype;
        visited = cvisited;
        visited.add(cname);
    }
    public Location getLocation()
    {
        return name;
    }
    public int getType()
    {
        return type;
    }
    public String toString()
    {
        return name.toString() + " is " + dist+ " away";
    }
    public int getDist()
    {
        return dist;
    }
    public ArrayList<Location> getLocationsVisited()
    {
        return visited;
    }
    public void addLocation(Location loc)
    {
        visited.add(loc);
    }
    public int compareTo(Link link)
    {
        int diff = this.dist - link.dist;
        return diff;
    }
}
