
/**
 * Write a description of class BTNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BTNode
{
    public String data;
    public BTNode right;
    public BTNode left;

    
    public BTNode(String s)
    {
        data=s;
        left=right=null;
    }
    public String toString()
    {
        return data;
    }
    // write your BTNode class.
}
