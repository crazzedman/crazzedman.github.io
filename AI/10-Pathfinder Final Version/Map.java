import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Write a description of class Map here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Map
{
    Location Reactor, UpperEngine, LowerEngine, Security, Electrical,Storage, Cafeteria, Medbay,Admin,
    Communication,Shields,Navigation,O2, Weapons, Hallways;
    ArrayList<Location> locations;
    private static Map m_instance = null; 
    
    private Map(){
        storeLocationData();
        storeLinkData();
        loadLocationData();
        StdDraw.enableDoubleBuffering();
        mapGeneration();
        StdDraw.show();
    }
    public static Map getInstance() {
        if(m_instance == null) {
            m_instance = new Map();
        }
        return m_instance;
    }
    public void run()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose pathfinding algorithm : (1)Uniform Cost Search, (2)Greedy Search, or (3)A Star Search");
        int a = sc.nextInt();
        System.out.println("Click Starting Location");
        double startx = -1;
        double starty = -1;
        Location start = null;
        Location dest = null;
        while(startx == -1 && starty==-1)
        {
            if(StdDraw.isMousePressed())
            {
                startx = StdDraw.mouseX();
                starty = StdDraw.mouseY();
                if(locate(startx,starty).equals(Hallways))
                {
                    System.out.println("Choose Again");
                    startx=-1;
                    starty=-1;
                    StdDraw.pause(400);
                }
            }
        }
        System.out.println("Starting Location is " +locate(startx,starty));
        start = locate(startx,starty);
        StdDraw.pause(1000);
        if(a==1)
        {
            System.out.println("Click Destination");
            double destinationx = -1;
            double destinationy = -1;  
            while(destinationx == -1 && destinationy==-1)
            {
                if(StdDraw.isMousePressed())
                {
                    destinationx = StdDraw.mouseX();
                    destinationy = StdDraw.mouseY();
                    if(locate(destinationx,destinationy).equals(Hallways))
                    {
                        System.out.println("Choose Again");
                        destinationx=-1;
                        destinationy=-1;
                        StdDraw.pause(400);
                    }
                }
            }
            System.out.println("Destination is " + locate(destinationx,destinationy));
            dest = locate(destinationx,destinationy);
        }
        else if(a !=1)
        {
            dest = Medbay;
        }
        else
        {
            System.out.println("Sorry not valid method");
            StdDraw.pause(1000);
        }
        if(a==1)
        {
            ucs(start,dest);
        }
        else if(a==2)
        {
            greedys(start,dest);
        }
        else if(a==3)
        {
            astars(start,dest);
        }
    }
    public void reset()
    {
        storeLocationData();
        storeLinkData();
        loadLocationData();
        StdDraw.picture(487,279.5,"amongusmap.png",974, 559);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledRectangle(280,400,35,50);
        StdDraw.show();
        run();
    }
    public void mapGeneration()
    {
        StdDraw.setCanvasSize(974,559);
        StdDraw.setXscale(0,974);
        StdDraw.setYscale(0,659);
        StdDraw.picture(487,279.5,"amongusmap.png",974, 559);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledRectangle(280,400,35,50);
        StdDraw.text(487,600,"Red lines are routes in the Fringe");
        StdDraw.text(487,630,"Blue lines marks the Visited route");
        StdDraw.text(487, 570, "Green Lines at the end marks the Shortest path route");
    }
    public Location locate(double x, double y)
    {
        if(152<=x&&x<=238&&90<=y&&y<=200)//Lower Engine: (195,145,43,55); red
        {
            return LowerEngine;
        }
        else if(145<=x&&x<=245&&340<=y&&y<=450)//Upper Engine:(195,395,50,55); blue
        {
            return UpperEngine;
        }
        else if(60<=x&&x<=160&&195<=y&&y<=355)//Reactor:(110,275,50,80); green
        {
            return Reactor;
        }
        else if(245<=x&&x<=315&&225<=y&&y<=335)//Security:(280,280,35,55); magenta
        {
            return Security;
        }
        else if(440<=x&&x<=560&&20<=y&&y<=210)//Storage: (500,115,60,95); pink
        {
            return Storage;
        }
        else if(330<=x&&x<=430&&115<=y&&y<=235)//Electrical: (380,175,50,60); cyan
        {
            return Electrical;
        }
        else if(320<=x&&x<=400&&260<=y&&y<=370||320<=x&&x<=440&&260<=y&&y<=300)//Medbay: (360,315,40,55)&(380,280,60,20); gray
        {
            return Medbay;
        }
        else if(570<=x&&x<=680&&157.5<=y&&y<=262.5)//Admin:(625,210,55,52.5); light gray
        {
            return Admin;
        }
        else if(570<=x&&x<=680&&20<=y&&y<=100)//Communication:(625,60,55,40); dark gray
        {
            return Communication;
        }
        else if(685<=x&&x<=775&&452.5<=y&&y<=462.5)//Weapons: (730,407.5,45,55); white
        {
            return Weapons;
        }
        else if(850<=x&&x<=925&&240<=y&&y<=335)//Navigation:(887.5,287.5,37.5,47.5); book blue
        {
            return Navigation;
        }
        else if(645<=x&&x<=715&&270<=y&&y<=345||625<=x&&x<=695&&272.5<=y&&y<=322.5)//O2:(680,307.5,35,37.5)&(660,297.5,35,25); yellow
        {
            return O2;
        }
        else if(685<=x&&x<=775&&72.5<=y&&y<=182.5)//Shields:(730,127.5,45,55); orange
        {
            return Shields;
        }
        else if(415<=x&&x<=640&&325<=y&&y<=465||415<=x&&x<=640&&450<=y&&y<=510
        ||435<=x&&x<=620&&305<=y&&y<=335||450<=x&&x<=605&&280<=y&&y<=330)
        //Cafeteria:(527.5,395,112.5,70)&(527.5,480,112.5,30)&//(527.5,320,92.5,15)&(527.5,305,77.5,25); bookred
        {                                     
            return Cafeteria;
        }
        return Hallways;
    }
    public void ucs(Location start, Location destination)
    {
        PriorityQueue<Link>fringe = new PriorityQueue<Link>();
        Link a;
        Link g;
        while(!start.getLinks().isEmpty())
        {
            a = start.getLinks().poll();
            g = new Link(a.getLocation(),a.getDist(),a.getType(),a.getLocationsVisited());
            updateLine(0,a.getType());
            g.addLocation(start);
            fringe.add(g);
            StdDraw.pause(500);
        }
        Link b = null;
        String origin = start.toString();
        Link c;
        PriorityQueue<Link> d;
        Location e;
        Location l;
        Link f;
        boolean visit;
        boolean already;
        int cost = 0;
        ArrayList<Location> visited = new ArrayList<Location>();
        ArrayList<Location> existsinfringe = new ArrayList<Location>();
        visited.add(start);
        while(!origin.toString().equals(destination.toString()))
        {
            StdDraw.pause(300);
            b = fringe.poll();
            updateLine(1,b.getType());
            d = b.getLocation().getLinks();
            e = b.getLocation();
            already = false;
            for(int i = 0; i < visited.size();i++)
            {
                if(e.equals(visited.get(i)))
                {
                    already = true;
                }
            }
            if(already)
            {
                continue;
            }
            while(!d.isEmpty())
            {
                c = d.poll();
                l = c.getLocation();
                visit = false;
                for(int i = 0; i < existsinfringe.size();i++)
                {
                    if(l.equals(existsinfringe.get(i)))
                    {
                        visit = true;
                    }
                }
                if(!visit)
                {
                    updateLine(0,c.getType());
                    f = new Link(l,c.getDist()+b.getDist(),c.getType(),combineLists(c.getLocationsVisited(),b.getLocationsVisited()));
                    StdDraw.pause(300);
                    fringe.add(f);
                }
                existsinfringe.add(l);
            }
            System.out.println(b);
            origin = b.getLocation().toString();
            visited.add(e);
            cost = b.getDist();
            updateLine(1,b.getType());
        }
        ArrayList<Location> aprint = new ArrayList<Location>();
        for(int i = 0; i < b.getLocationsVisited().size();i++)
        {
            boolean here = false;
            for(int j = 0; j < aprint.size();j++)
            {
                if(aprint.get(j).equals(b.getLocationsVisited().get(i)))
                {
                    here = true;
                }
            }
            if(!here)
            {
                System.out.println("We visited " + b.getLocationsVisited().get(i)+ " on the shortest path to " + destination);
                aprint.add(b.getLocationsVisited().get(i));
            }
        }
        for(int i = 0; i < aprint.size()-1;i++)
        {
            updateLine(2,getLinkType(aprint.get(i),aprint.get(i+1)));
        }
        System.out.println("For Uniform-Cost Search, it takes " + cost + " to get to " + destination + " from " + start);
    }
    public void greedys(Location start, Location destination)
    {
        Link a;
        Location b;
        Location origin = start;
        Location previous = origin;
        int j = 0;
        int cost = 0;
        PriorityQueue<Location> locations;
        PriorityQueue<Link> fringe;
        ArrayList<Link> links;
        ArrayList<Location> aprint = new ArrayList<Location>();
        aprint.add(start);
        while(!origin.toString().equals(destination.toString()))
        {
            locations = new PriorityQueue<Location>();
            links = new ArrayList<Link>();
            fringe = origin.getLinks();
            while(!fringe.isEmpty())
            {
                a = fringe.poll();
                b = a.getLocation();
                if(!b.toString().equals(previous.toString()))
                {
                    links.add(a);
                    locations.add(b);
                    updateLine(0,a.getType());
                }
                StdDraw.pause(300);
            }
            previous = origin;
            if(locations.isEmpty())
            {
                System.out.println("This is a loop");
                break;
            }
            origin = locations.poll();
            for(int i = 0; i < links.size(); i++)
            {
                if(origin.toString().equals(links.get(i).getLocation().toString()))
                {
                    cost+=links.get(i).getDist();
                    updateLine(1,links.get(i).getType());
                    break;
                }
            }
            System.out.println("We are at " + origin.toString() + " : " + cost);
            aprint.add(origin);
        }
        if(origin.equals(destination))
        {
            System.out.println("For Greedy Search, it takes " + cost + " to get to " + destination + " from " + start);
        }
        for(int i = 0; i < aprint.size()-1;i++)
        {
            updateLine(2,getLinkType(aprint.get(i),aprint.get(i+1)));
        }
    }
    public void astars(Location start, Location destination)
    {
        Link a = null;
        Link b;
        Link c;
        Location d;
        Location origin = start;
        int j = 0;
        int cost = 0;
        boolean visit;
        PriorityQueue<Link> links;
        PriorityQueue<Link> fringe = new PriorityQueue<Link>();
        fringe.add(new Link(start,start.getSLD(),-1));
        ArrayList<Location> visited = new ArrayList<Location>();
        ArrayList<Location> existsinfringe = new ArrayList<Location>();
        while(!origin.toString().equals(destination.toString()))
        {
            a = fringe.poll();
            origin = a.getLocation();
            boolean already = false;
            for(int i = 0; i < visited.size();i++)
            {
                if(origin.equals(visited.get(i)))
                {
                    already = true;
                }
            }
            if(already)
            {
                continue;
            }
            updateLine(1,a.getType());
            existsinfringe.add(origin);
            visited.add(origin);
            System.out.println(a);
            links = origin.getLinks();
            while(!links.isEmpty())
            {
                b = links.poll();
                d = b.getLocation();
                visit = false;
                for(int i = 0; i < existsinfringe.size();i++)
                {
                    if(d.equals(existsinfringe.get(i)))
                    {
                        visit = true;
                    }
                }
                if(!visit)
                {
                    c = new Link(d,d.getSLD()+a.getDist()-origin.getSLD()+b.getDist(),b.getType(),combineLists(b.getLocationsVisited(),a.getLocationsVisited()));
                    updateLine(0,b.getType());
                    fringe.add(c);
                    existsinfringe.add(d);
                    StdDraw.pause(300);
                }
            }
            cost = a.getDist();
            StdDraw.pause(300);
        }
        ArrayList<Location> aprint = new ArrayList<Location>();
        for(int i = 0; i < a.getLocationsVisited().size();i++)
        {
            boolean here = false;
            for(int k = 0; k < aprint.size();k++)
            {
                if(aprint.get(k).equals(a.getLocationsVisited().get(i)))
                {
                    here = true;
                }
            }
            if(!here)
            {
                System.out.println("We visited " + a.getLocationsVisited().get(i)+ " on the shortest path to " + destination);
                aprint.add(a.getLocationsVisited().get(i));
            }
        }
        for(int i = 0; i < aprint.size()-1;i++)
        {
            updateLine(2,getLinkType(aprint.get(i),aprint.get(i+1)));
        }
        
        System.out.println("For A Star Search, it takes "+ cost + " to get to " + destination + " from " + start);
    }
    public ArrayList<Location> combineLists(ArrayList<Location> list1,ArrayList<Location> list2)
    {
        ArrayList<Location> combinelist = new ArrayList<Location>();
        for(int i = 0; i < list1.size();i++)
        {
            combinelist.add(list1.get(i));
        }
        for(int j = 0; j < list2.size();j++)
        {
            combinelist.add(list2.get(j));
        }
        return combinelist;
    }
    public void updateLine(int visited, int type)
    {
        StdDraw.setPenColor(StdDraw.RED);
        if(visited==1)
        {
            StdDraw.setPenColor(StdDraw.BLUE);
        }
        else if(visited==2)
        {
            StdDraw.setPenColor(StdDraw.GREEN);
        }
        if(type == 0)
        {
            StdDraw.line(192,362,192,285);
            StdDraw.line(192,285,142,285);
        }
        else if(type == 1)
        {
            StdDraw.line(206,362,206,279);
            StdDraw.line(206,279,256,279);
        }
        else if(type == 2)
        {
            StdDraw.line(135,266,194,266);
            StdDraw.line(194,266,194,189);
        }
        else if(type == 3)
        {
            StdDraw.line(265,273,204,273);
            StdDraw.line(204,273,204,186);
        }
        else if(type == 4)
        {
            StdDraw.line(232,150,292,150);
            StdDraw.line(292,150,292,94);
            StdDraw.line(292,94,347,94);
            StdDraw.line(347,94,347,146);
        }
        else if(type == 5)
        {
            StdDraw.line(232,155,297,155);
            StdDraw.line(297,150,297,99);
            StdDraw.line(297,99,454,99);
        }
        else if(type == 6)
        {
            StdDraw.line(352,146,352,89);
            StdDraw.line(352,89,454,89);
        }
        else if(type == 7)
        {
            StdDraw.line(526,186,526,237);
            StdDraw.line(526,237,591,237);
        }
        else if(type == 8)
        {
            StdDraw.line(546,132,638,132);
            StdDraw.line(638,132,638,86);
        }
        else if(type == 9)
        {
            StdDraw.line(531,186,531,312);
        }
        else if(type == 10)
        {
            StdDraw.line(439,397,354,397);
            StdDraw.line(354,397,354,345);
        }
        else if(type == 11)
        {
            StdDraw.line(616,404,723,404);
        }
        else if(type == 12)
        {
            StdDraw.line(591,232,520,232);
            StdDraw.line(520,232,520,312);
        }
        else if(type == 13)
        {
            StdDraw.line(710,142,643,142);
            StdDraw.line(643,142,643,86);
        }
        else if(type == 14)
        {
            StdDraw.line(730,159,730,241);
            StdDraw.line(730,241,778,241);
            StdDraw.line(778,241,778,304);
            StdDraw.line(778,304,681,304);
        }
        else if(type == 15)
        {
            StdDraw.line(878,285,773,285);
            StdDraw.line(773,285,773,309);
            StdDraw.line(773,309,681,309);
        }
        else if(type == 16)
        {
            StdDraw.line(736,394,736,294);
            StdDraw.line(736,294,681,294);
        }
        else if(type == 17)
        {
            StdDraw.line(720,394,720,297);
            StdDraw.line(720,297,773,297);
            StdDraw.line(773,297,773,280);
            StdDraw.line(878,280,773,280);
            
        }
        else if(type == 18)
        {
            StdDraw.line(730,159,730,246);
            StdDraw.line(730,246,778,246);
            StdDraw.line(778,246,778,285);
            StdDraw.line(778,285,878,285);
        }
        else if(type == 19)
        {
            StdDraw.line(730,159,730,246);
            StdDraw.line(730,246,778,246);
            StdDraw.line(778,246,778,304);
            StdDraw.line(778,304,726,304);
            StdDraw.line(726,304,726,394);
            
        }
        else
        {
            return;
        }
        StdDraw.show();
    }
    public void storeLinkData()
    {
        linkLocations(Reactor,UpperEngine,6,0);
        linkLocations(Security,UpperEngine,5,1);
        linkLocations(Reactor,LowerEngine,7,2);
        linkLocations(Security,LowerEngine,6,3);
        linkLocations(Electrical,LowerEngine,9,4);
        linkLocations(Storage,LowerEngine,10,5);
        linkLocations(Electrical,Storage,8,6);
        linkLocations(Storage,Admin,6,7);
        linkLocations(Storage,Communication,6,8);
        linkLocations(Storage,Cafeteria,9,9);
        linkLocations(Medbay,Cafeteria,8,10);
        linkLocations(Weapons,Cafeteria,5,11);
        linkLocations(Admin,Cafeteria,7,12);
        linkLocations(Shields,Communication,4,13);
        linkLocations(Shields,O2,9,14);
        linkLocations(Navigation,O2,7,15);
        linkLocations(Weapons,O2,5,16);
        linkLocations(Weapons,Navigation,8,17);
        linkLocations(Shields,Navigation,8,18);
        linkLocations(Weapons,Shields,10,19);
    }
    public int getLinkType(Location a, Location b)
    {
        if(a.equals(Reactor)&&b.equals(UpperEngine)||b.equals(Reactor)&&a.equals(UpperEngine))
        {
            return 0;
        }
        else if(a.equals(Security)&&b.equals(UpperEngine)||b.equals(Security)&&a.equals(UpperEngine))
        {
            return 1;
        }
        else if(a.equals(Reactor)&&b.equals(LowerEngine)||b.equals(Reactor)&&a.equals(LowerEngine))
        {
            return 2;
        }
        else if(a.equals(Security)&&b.equals(LowerEngine)||b.equals(Security)&&a.equals(LowerEngine))
        {
            return 3;
        }
        else if(a.equals(Electrical)&&b.equals(LowerEngine)||b.equals(Electrical)&&a.equals(LowerEngine))
        {
            return 4;
        }
        else if(a.equals(Storage)&&b.equals(LowerEngine)||b.equals(Storage)&&a.equals(LowerEngine))
        {
            return 5;
        }
        else if(a.equals(Storage)&&b.equals(Electrical)||b.equals(Storage)&&a.equals(Electrical))
        {
            return 6;
        }
        else if(a.equals(Storage)&&b.equals(Admin)||b.equals(Storage)&&a.equals(Admin))
        {
            return 7;
        }
        else if(a.equals(Storage)&&b.equals(Communication)||b.equals(Storage)&&a.equals(Communication))
        {
            return 8;
        }
        else if(a.equals(Storage)&&b.equals(Cafeteria)||b.equals(Storage)&&a.equals(Cafeteria))
        {
            return 9;
        }
        else if(a.equals(Medbay)&&b.equals(Cafeteria)||b.equals(Medbay)&&a.equals(Cafeteria))
        {
            return 10;
        }
        else if(a.equals(Weapons)&&b.equals(Cafeteria)||b.equals(Weapons)&&a.equals(Cafeteria))
        {
            return 11;
        }
        else if(a.equals(Admin)&&b.equals(Cafeteria)||b.equals(Admin)&&a.equals(Cafeteria))
        {
            return 12;
        }
        else if(a.equals(Shields)&&b.equals(Communication)||b.equals(Shields)&&a.equals(Communication))
        {
            return 13;
        }
        else if(a.equals(Shields)&&b.equals(O2)||b.equals(Shields)&&a.equals(O2))
        {
            return 14;
        }
        else if(a.equals(Navigation)&&b.equals(O2)||b.equals(Navigation)&&a.equals(O2))
        {
            return 15;
        }
        else if(a.equals(Weapons)&&b.equals(O2)||b.equals(Weapons)&&a.equals(O2))
        {
            return 16;
        }
        else if(a.equals(Weapons)&&b.equals(Navigation)||b.equals(Weapons)&&a.equals(Navigation))
        {
            return 17;
        }
        else if(a.equals(Shields)&&b.equals(Navigation)||b.equals(Shields)&&a.equals(Navigation))
        {
            return 18;
        }
        else if(a.equals(Weapons)&&b.equals(Shields)||b.equals(Weapons)&&a.equals(Shields))
        {
            return 19;
        }
        return -1;
    }
    public void linkLocations(Location A, Location B, int distance, int type)
    {
        A.addLink(B,distance,type);
        B.addLink(A,distance,type);
    }
    public void storeLocationData()
    {
        Reactor = new Location("Reactor",7);
        UpperEngine = new Location("Upper Engine",5);
        LowerEngine = new Location("Lower Engine",7);
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
        Hallways = new Location("Hallways",100);
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
        locations.add(Hallways);
    }
}
