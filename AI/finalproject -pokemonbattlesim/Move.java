
/**
 * Write a description of class move here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Move
{
    String typeofmove,name, effect;
    Type type;
    int value,accuracy,uses;
    public Move(String cname,Type ctype, String ctypeofmove, int cvalue, int caccuracy, int cuses, String ceffect){
        name = cname;
        type = ctype;
        typeofmove = ctypeofmove;
        value = cvalue;
        accuracy = caccuracy;
        uses = cuses;
        effect = ceffect;
    }
    public String toString()
    {
        return name + "PP :: " + uses + " / Accuracy :: " + accuracy + " / Power :: " + value;
    }
    public int doDamage()
    {
        double a = Math.random();
        if(a*100<accuracy)
        {
            uses--;
            return value;
        }
        uses--;
        return 0;
    }
}
