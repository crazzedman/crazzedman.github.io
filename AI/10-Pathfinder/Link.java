
/**
 * Write a description of class Link here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Link implements Comparable<Link>
{
    int dist;
    Location name;
    public Link(Location cname, int cdist)
    {
        dist = cdist;
        name = cname;
    }
    public Location getLocation()
    {
        return name;
    }
    public int compareTo(Link link)
    {
        int diff = this.dist - link.dist;
        return diff;
    }
}
