
/**
 * Write a description of class PQTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.PriorityQueue;

public class PQTester
{
    public static void main(String args[])
    {
        PriorityQueue<MLB> pq = new PriorityQueue<MLB>();
        pq.add(new MLB("Dodgers",111));
        pq.add(new MLB("Astros",106));
        pq.add(new MLB("Braves",101));
        pq.add(new MLB("Mets",101));
        pq.add(new MLB("Yankees",99));
        pq.add(new MLB("Cardinals",93));
        pq.add(new MLB("Guardians",92));
        pq.add(new MLB("Blue Jays",92));
        pq.add(new MLB("Mariners",90));
        pq.add(new MLB("Padres",89));
        pq.add(new MLB("Phillies",87));
        pq.add(new MLB("Brewers",86));
        pq.add(new MLB("Rays",86));
        pq.add(new MLB("Orioles",83));
        pq.add(new MLB("White Sox",81));
        pq.add(new MLB("Giants",81));
        pq.add(new MLB("Red Sox",78));
        pq.add(new MLB("Twins",78));
        pq.add(new MLB("Diamondbacks",74));
        pq.add(new MLB("Cubs",74));
        pq.add(new MLB("Angels",73));
        pq.add(new MLB("Marlins",69));
        pq.add(new MLB("Rockies",68));
        pq.add(new MLB("Rangers",68));
        pq.add(new MLB("Tigers",66));
        pq.add(new MLB("Royals",65));
        pq.add(new MLB("Reds",62));
        pq.add(new MLB("Pirates",62));
        pq.add(new MLB("Athletics",60));
        pq.add(new MLB("Nationals",55));
        while (!pq.isEmpty()) {
            System.out.println (pq.poll());                 
        }
    }   
}
