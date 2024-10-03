import java.util.ArrayList;

/**
 * Write a description of class GNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class GNode
{
    public String data;
    ArrayList links;
    
    public GNode(String s)
    {
        data = s;
        links = new ArrayList<GNode>();
    }
    public String toString()
    {
        return data;
    }
    public void addLink(GNode newnode)
    {
        links.add(newnode);
    }
    public boolean hasLink(GNode node)
    {
        for(int i = 0; i < links.size(); i++)
        {
            if(links.get(i).toString().equals(node.toString()))
            {
                return true;
            }
        }
        return false;
    }
}
