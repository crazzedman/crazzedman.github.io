import java.util.ArrayList;

/**
 * Write a description of class type here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Type
{
    String name;
    ArrayList<Type> weak,strong;
    public Type(String cname)
    {
        name = cname;
        weak = new ArrayList<Type>();
        strong = new ArrayList<Type>();
    }
}
