import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.ArrayList;

/**
 * Write a description of class Map here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Map
{
    private static Map m_instance = null;
    private int [][] MAP_THREE = 
           {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,1,1,0,0,1,1,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0},
            {0,1,1,0,0,0,1,1,0,0,1,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0},
            {0,0,1,1,0,0,0,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
            {0,0,0,1,0,0,1,1,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0},
            {0,0,0,1,1,1,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,1,1,0,0},
            {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,1,1,1,1,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0},
            {0,0,0,0,0,1,1,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}}; 
     private static final int [][] MAP_ORIGINAL = 
           {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
            {0,0,0,0,0,0,0,1,1,1,1,1,0,0,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0},
            {0,0,0,0,1,1,0,0,0,0,0,1,1,1,1,0},
            {0,0,0,0,0,1,1,0,0,0,0,1,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
    private int endx,endy,startx,starty;
    Scanner sc;

    private Map(){
        sc = new Scanner(System.in);
        placeStart();
        placeEnd();
        endx = -1;
        endy = -1;
        startx = -1;
        starty = -1;
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
        System.out.print("Choose pathfinding algorithm : (1)Uniform Cost Search, (2)Greedy Search,or (3)A Star Search ::");
        int a = sc.nextInt();
        locateStart(MAP_THREE);
        locateEnd(MAP_THREE);
        printOutMap(MAP_THREE);
        if(a ==1)
        {
            ucs(MAP_THREE);
        }
        else if(a ==2)
        {
            greedys(MAP_THREE);
        }
        else if(a ==3)
        {
            astars(MAP_THREE);
        }
        else
        {
            System.out.println("Sorry not a valid method");
            System.exit(0);
        }
    }
    public void placeStart()
    {
        printOutMap(MAP_THREE);
        System.out.println();
        System.out.println("Place Start");
        int x = -1;
        int y = -1;
        while(x==-1&&y==-1)
        {
            System.out.print("Enter X Distance :: ");
            x = sc.nextInt();
            System.out.println();
            System.out.print("Enter Y Distance :: ");
            y = sc.nextInt();
            System.out.println();
            if(y>=MAP_THREE.length||y<0||x>=MAP_THREE[y].length||x<0)
            {
                x = -1;
                y = -1;
                System.out.println("ERROR, Out of bounds, different Distance needed");
                continue;
            }
            if(isBlocked(x,y))
            {
                x = -1;
                y = -1;
                System.out.println("There is a wall here");
            }
        }
        MAP_THREE[y][x]=2;
        StdDraw.pause(500);
        System.out.print('\u000C');
    }
    public void placeEnd()
    {
        printOutMap(MAP_THREE);
        System.out.println();
        System.out.println("Place End");
        int x = -1;
        int y = -1;
        while(x==-1&&y==-1)
        {
            System.out.print("Enter X Distance :: ");
            x = sc.nextInt();
            System.out.println();
            System.out.print("Enter Y Distance :: ");
            y = sc.nextInt();
            System.out.println();
            if(y>=MAP_THREE.length||x<0||x>=MAP_THREE[y].length||y<0)
            {
                x = -1;
                y = -1;
                System.out.println("ERROR, Out of bounds, different Distance needed");
                continue;
            }
            if(isBlocked(x,y))
            {
                x = -1;
                y = -1;
                System.out.println("There is a wall here");
            }
        }
        MAP_THREE[y][x]=3;
        StdDraw.pause(500);
        System.out.print('\u000C');
    }
    public void printOutMap(int [][] map)
    {
        for(int i = 0; i < map.length;i++)
        {
            for(int j = 0; j <map[i].length;j++)
            {
               if(j == 0)
               {
                   System.out.print("{"+ map[i][j]);
                   continue;
               }
               else if(j==map[0].length-1)
               {
                   System.out.print("," + map[i][j] + "}");
                   continue;
               }
               System.out.print("," + map[i][j]); 
            }
            System.out.println();
        }
    }
    public void locateStart(int[][] map)
    {
        for(int i = 0; i < map.length;i++)
        {
            for(int j = 0; j <map[i].length;j++)
            {
                if(map[i][j]==2)
                {
                    startx = j;
                    starty = i;
                }
            }
        }
    }
    public void locateEnd(int[][] map)
    {
        for(int i = 0; i < map.length;i++)
        {
            for(int j = 0; j <map[0].length;j++)
            {
                if(map[i][j]==3)
                {
                    endx = j;
                    endy = i;
                }
            }
        }
    }
    public boolean visit(Coordinate cord, ArrayList<Coordinate>visited)
    {
        boolean visits = false;
        for(int i = 0; i < visited.size();i++)
        {
            if(visited.get(i).getX()==cord.getX()&&visited.get(i).getY()==cord.getY())
            {
                visits = true;
            }
        }
        return visits;
    }
    public boolean isBlocked(int x , int y)
    {
        boolean visits = false;
        if(MAP_THREE[y][x]==1)
        {
            visits = true;
        }
        return visits;
    }
    public void ucs(int[][] map)
    {
        PriorityQueue<Distance> fringe = new PriorityQueue<Distance>();
        Coordinate start = new Coordinate(startx,starty);
        Coordinate dest = new Coordinate(endx,endy);
        PriorityQueue<Distance> why = getNearQueue(start,map);
        Distance a = null;
        Distance g;
        while(!why.isEmpty())
        {
            a = why.poll();
            g = new Distance(a.getOrigin(),a.getDest(),a.getList());
            g.addLocation(start);
            fringe.add(g);
        }
        boolean visit = false;
        PriorityQueue<Distance> d;
        Coordinate origin = start;
        ArrayList<Coordinate> visited = new ArrayList<Coordinate>();
        ArrayList<Coordinate> existsinfringe = new ArrayList<Coordinate>();
        Coordinate e;
        Coordinate f;
        Distance b = null;
        Distance h;
        Distance l;
        double cost = 0;
        while(dest.getX()!=origin.getX()||dest.getY()!=origin.getY())
        {
            b = fringe.poll();
            origin = b.getDest();
            d = getNearQueue(origin,map);            
            while(!d.isEmpty())
            {
                h = d.poll();
                f = h.getDest();
                if(visit(f,visited)||visit(f,existsinfringe))
                {
                    continue;
                }
                l = new Distance(origin,f,b.getDist()+h.calculateTotal(),combineList(h.getList(),b.getList()));
                fringe.add(l);
                existsinfringe.add(f);
            }
            visited.add(origin);
            map[origin.getY()][origin.getX()]=2;
            cost = b.getDist();
            StdDraw.pause(500);
            System.out.print('\u000C');
            printOutMap(map);
        }
        ArrayList<Coordinate>shortlist = b.getList();
        shortlist.add(0,origin);
        printShortPath(shortlist,dest,map);
        
    }
    public void greedys(int[][] map)
    {
        PriorityQueue<Distance> fringe = new PriorityQueue<Distance>();
        ArrayList<Coordinate> visited = new ArrayList<Coordinate>();
        Coordinate start = new Coordinate(startx,starty);
        Coordinate dest = new Coordinate(endx,endy);
        Distance a = new Distance(start,start);
        Coordinate origin = start;
        fringe.add(a);
        Coordinate previous = new Coordinate(-1,-1);
        Distance trash;
        int j = 0;
        int stuck = 0;
        while(dest.getX()!=origin.getX()||dest.getY()!=origin.getY())
        {
            a = fringe.poll();
            origin = a.getOrigin();
            j++;
            visited.add(origin);
            fringe = new PriorityQueue<Distance>();
            ArrayList<Coordinate> near = getNear(origin, map);
            for(int i = 0; i < near.size();i++)
            {
                    if(near.get(i).equals(previous)||visit(near.get(i),visited))
                    {
                    continue;
                }
                fringe.add(new Distance(near.get(i),dest));
            }
            previous = origin; 
            map[origin.getY()][origin.getX()]=2;
            StdDraw.pause(500);
            System.out.print('\u000C');
            printOutMap(map);
            if(j>map.length*map[0].length-2)
            {
                System.out.println("It is looping");
                break;
            }
            if(fringe.isEmpty())
            {
                System.out.println("It is stuck");
                stuck = 1;
                break;
            }
        }
        
        if(stuck==1)
        {
            printVisited(visited);
            System.out.println("It did not reach destination");
        }
        else
        {
            StdDraw.pause(500);
            System.out.print('\u000C');
            visited.add(origin);
            printShortPath(visited,dest,map);
            printTotal(visited);
        }
    }
    public void astars(int[][] map)
    {
        PriorityQueue<Distance> fringe = new PriorityQueue<Distance>();
        ArrayList<Coordinate> visited = new ArrayList<Coordinate>();
        ArrayList<Coordinate> existsinfringe = new ArrayList<Coordinate>();
        Coordinate start = new Coordinate(startx,starty);
        Coordinate dest = new Coordinate(endx,endy);
        Coordinate origin = start;
        Distance a = null;
        PriorityQueue<Distance> near;
        fringe.add(new Distance(start,start));

        Distance b;
        Distance c;
        Coordinate d; 
        while(dest.getX()!=origin.getX()||dest.getY()!=origin.getY())
        {
            a = fringe.poll();
            origin = a.getDest();
            if(visit(origin,visited))
            {
                continue;
            }
            visited.add(origin);
            existsinfringe.add(origin);
            near = getNearQueue(origin, map);
            while(!near.isEmpty())
            {
                b = near.poll();
                d = b.getDest();
                if(visit(d,existsinfringe))
                {
                    continue;
                }
                Distance me = new Distance(d,dest);
                Distance you = new Distance(origin,dest);
                c = new Distance(origin,d,me.calculateTotal()+a.getDist()-you.calculateTotal()+b.getDist(),combineList(b.getList(),a.getList()));
                fringe.add(c);
                existsinfringe.add(d);
            }
            map[origin.getY()][origin.getX()]=2;
            StdDraw.pause(500);
            System.out.print('\u000C');
            printOutMap(map);
        }
        ArrayList<Coordinate>shortlist = a.getList();
        shortlist.add(0,origin);
        printShortPath(shortlist,dest,map);
    }
    public ArrayList<Coordinate> combineList(ArrayList<Coordinate> list1,ArrayList<Coordinate> list2)
    {
        ArrayList<Coordinate>combined = new ArrayList<Coordinate>();
        for(int i = 0; i < list1.size();i++)
        {
            combined.add(list1.get(i));
        }
        for(int j = 0; j < list2.size();j++)
        {
            combined.add(list2.get(j));
        }
        return combined;
    }
    public ArrayList<Coordinate> getNear(Coordinate center,int[][]map)
    {
        ArrayList<Coordinate> nearby = new ArrayList<Coordinate>();
        int x = center.getX();
        int y = center.getY();
        for(int i = -1; i <= 1; i++)
        {
            for(int j = -1; j <= 1; j++)
            {
                if(y+j>=map.length||y+j<0||x+i>=map[y+j].length||x+i<0||map[y+j][x+i]==1)
                {
                    continue;
                }
                else
                {
                    nearby.add(new Coordinate(x+i,y+j));
                }
            }
        }
        return nearby;
    }
    public PriorityQueue<Distance> getNearQueue(Coordinate center,int[][]map)
    {
        PriorityQueue<Distance> nearby = new PriorityQueue<Distance>();
        int x = center.getX();
        int y = center.getY();
        for(int i = -1; i <= 1; i++)
        {
            for(int j = -1; j <= 1; j++)
            {
                if(y+j>=map.length||y+j<0||x+i>=map[y+j].length||x+i<0||map[y+j][x+i]==1)
                {
                    continue;
                }
                else
                {
                    nearby.add(new Distance(center,new Coordinate(x+i,y+j)));
                }
            }
        }
        return nearby;
    }
    public void printVisited(ArrayList<Coordinate>visited)
    {
        for(int i = 0; i < visited.size();i++)
        {
            System.out.println("We visited (" + visited.get(i).getX() +","+visited.get(i).getY()+")");
        }
    }
    public void printShortPath(ArrayList<Coordinate>shortpath,Coordinate dest,int[][]map)
    {
        ArrayList<Coordinate> aprint = new ArrayList<Coordinate>();
        for(int i = 0; i < shortpath.size();i++)
        {
            boolean here = false;
            for(int j = 0; j < aprint.size();j++)
            {
                if(aprint.get(j).equals(shortpath.get(i)))
                {
                    here = true;
                }
            }
            if(!here)
            {
                System.out.println("We visited " + shortpath.get(i)+ " on the shortest path to " + dest);
                aprint.add(shortpath.get(i));
                map[shortpath.get(i).getY()][shortpath.get(i).getX()]=4;
            }
        }
        printOutMap(map);
        printTotal(aprint);
    }
    public void printTotal(ArrayList<Coordinate>visited)
    {
        double total = 0;
        Distance a;
        String cord = "(" + visited.get(visited.size()-1).getX()+","+visited.get(visited.size()-1).getY()+")";
        for(int i = 0; i < visited.size()-1;i++)
        {
            a = new Distance(visited.get(i),visited.get(i+1));
            total+=a.calculateTotal();
        }
        System.out.println("It took " + total+" to reach " + cord);
    }
}
