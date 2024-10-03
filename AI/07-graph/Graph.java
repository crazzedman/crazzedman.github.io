
/**
 * Write a description of class Graph here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Graph
{
    GNode A = null;
    public void run()
    {
        createGraph();
    }
    public void createGraph()
    {
        A = new GNode("A");
        GNode B = new GNode("B");
        GNode C = new GNode("C");
        GNode D = new GNode("D");
        GNode E = new GNode("E");
        GNode F = new GNode("F");
        createLink(A,B);
        createLink(B,C);
        createLink(C,D);
        createLink(A,F);
        createLink(B,E);
        createLink(B,F);
        createLink(E,F);
        
        createLink(B,A);
    }
    public void createLink(GNode node, GNode node2)
    {
        if(node.hasLink(node2))
        {
            System.out.println("Already linked");
            return;
        }
        else
        {
            System.out.println("Link formed between " + node.toString() + " and " + node2.toString());
            node.addLink(node2);
            node2.addLink(node);
        }
    }
}
