import java.util.ArrayList;

/**
 * Write a description of class Map here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Map
{
    Location Reactor, UpperEngine, LowerEngine, Security, Electrical,Storage, Cafeteria, Medbay,Admin,
    Communication,Shields,Navigation,O2, Weapons;
    ArrayList<Location> locations;
    private static Map m_instance = null;
    
    private Map(){
        storeLocationData();
        storeLinkData();
        loadLocationData();
    }
    public static Map getInstance() {
        if(m_instance == null) {
            m_instance = new Map();
        }
        return m_instance;
    }
    public void run()
    {
        
    }
    public int ufc(Location start, Location destination, int cost)
    {
        for(int i = 1; i < start.getLinks().size();i++)
        {
            start.getLinks().poll();
        }
        return 0;
    }
    public void storeLinkData()
    {
        linkLocations(Reactor,UpperEngine,6);
        linkLocations(Security,UpperEngine,5);
        linkLocations(Reactor,LowerEngine,7);
        linkLocations(Security,LowerEngine,6);
        linkLocations(Electrical,LowerEngine,9);
        linkLocations(Storage,LowerEngine,10);
        linkLocations(Electrical,Storage,8);
        linkLocations(Storage,Admin,6);
        linkLocations(Storage,Communication,6);
        linkLocations(Storage,Cafeteria,9);
        linkLocations(Medbay,Cafeteria,8);
        linkLocations(Weapons,Cafeteria,5);
        linkLocations(Admin,Cafeteria,7);
        linkLocations(Shields,Communication,4);
        linkLocations(Shields,O2,9);
        linkLocations(Navigation,O2,7);
        linkLocations(Weapons,O2,5);
        linkLocations(Weapons,Navigation,8);
        linkLocations(Shields,Navigation,8);
        linkLocations(Weapons,Shields,10);
    }
    public void linkLocations(Location A, Location B, int distance)
    {
        A.addLink(B,distance);
        B.addLink(A,distance);
    }
    public void storeLocationData()
    {
        Reactor = new Location("Reactor",7);
        UpperEngine = new Location("Upper Engine",5);
        LowerEngine = new Location("Lower Engline",7);
        Security = new Location("Security",3);
        Electrical = new Location("Electrical",4);
        Storage = new Location("Storage",5);
        Cafeteria = new Location("Cafeteria",5);
        Medbay = new Location("Medbay",0);
        Admin = new Location("Admin",8);
        Communication = new Location("Communication",11);
        Shields = new Location("Shields",12);
        Navigation = new Location("Navigation",15);
        O2 = new Location("Oxygen",9);
        Weapons = new Location("Weapons",11);
    }
    public void loadLocationData()
    {
        locations = new ArrayList<Location>();
        locations.add(Reactor);
        locations.add(UpperEngine);
        locations.add(LowerEngine); 
        locations.add(Security); 
        locations.add(Electrical);
        locations.add(Storage); 
        locations.add(Cafeteria); 
        locations.add(Medbay);
        locations.add(Admin);
        locations.add(Communication);
        locations.add(Shields);
        locations.add(Navigation);
        locations.add(O2);
        locations.add(Weapons);
    }
}
