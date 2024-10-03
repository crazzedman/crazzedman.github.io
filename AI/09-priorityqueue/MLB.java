
/**
 * Write a description of class AmongUsLocations here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.io.*;
import java.util.*;

public class MLB implements Comparable<MLB>
{
    int wins = 0;
    String name = "";
    public MLB(String teamname, int w)
    {
        name = teamname;
        wins = w;
    }
    public String toString()
    {
        return name + ": " + wins + " wins";
    }
    public int compareTo(MLB team)
    {
        // Two instance of class can be compared
        int diff = this.wins - team.wins;
 
        // Note: Two equal employee Id will return 0
        return diff;
    }
}