/**
 * Write a description of class ThermostatAgent here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Agent
{
    private boolean[] direction;
    private int x;
    private int y;
    private int way;
    private int ctype;
    private int[][] map;
    public Agent(int realx, int realy,int type) {
        direction = new boolean[4];
        way = 4;
        x = realx;
        y = realy;
        ctype = type;
        if(type==0)
        StdDraw.picture(x+0.5,y+0.5,"pac.png",1,1);
        if(type==1)
        StdDraw.picture(x+0.5,y+0.5,"ghost.png",1,1);
        map = Gridworld.getInstance().getMap();
    }
     
    public void sense()
    {
        if(x == 0 && y == 0)
        {
            direction[1]=true;
        }
        else if(x == 49 && y == 0)
        {
            direction[2]=true;
        }
        else if(x == 0 && y == 49)
        {
            direction[0]=true;
        }
        else if(x == 49 && y == 49)
        {
            direction[3]=true;
        }
        else if(x == 0)
        {
            if(map[y][x+1]==0&&map[y+1][x+1]==0||map[y][x+1]==3&&map[y+1][x+1]==0||map[y][x+1]==0&&map[y+1][x+1]==3)
            {
                direction[1]=true;
            }
            if(map[y-1][x]==0&&map[y-1][x+1]==0||map[y-1][x]==0&&map[y-1][x+1]==3||map[y-1][x]==3&&map[y-1][x+1]==0)
            {
                direction[0]=true;
            }
        }
        else if(y == 0)
        {
            if(map[y][x+1]==0&&map[y+1][x+1]==0||map[y][x+1]==3&&map[y+1][x+1]==0||map[y][x+1]==0&&map[y+1][x+1]==3)
            {
                direction[1]=true;
            }
            if(map[y+1][x]==0&&map[y+1][x-1]==0||map[y+1][x]==3&&map[y+1][x-1]==0||map[y+1][x]==0&&map[y+1][x-1]==3)
            {
                direction[2]=true;
            } 
        }
        else if(y == 49)
        {
            if(map[y-1][x-1]==0&&map[y][x-1]==0||map[y-1][x-1]==0&&map[y][x-1]==3||map[y-1][x-1]==3&&map[y][x-1]==0)
            {
                direction[3]=true;
            }
            if(map[y-1][x]==0&&map[y-1][x+1]==0||map[y-1][x]==0&&map[y-1][x+1]==3||map[y-1][x]==3&&map[y-1][x+1]==0)
            {
                direction[0]=true;
            }
        }
        else if (x == 49)
        {
            if(map[y+1][x]==0&&map[y+1][x-1]==0||map[y+1][x]==3&&map[y+1][x-1]==0||map[y+1][x]==0&&map[y+1][x-1]==3)
            {
                direction[2]=true;
            }
            if(map[y-1][x-1]==0&&map[y][x-1]==0||map[y-1][x-1]==0&&map[y][x-1]==3||map[y-1][x-1]==3&&map[y][x-1]==0)
            {
                direction[3]=true;
            }
        }
        else
        {
            if(map[y][x+1]==0&&map[y+1][x+1]==0||map[y][x+1]==3&&map[y+1][x+1]==0||map[y][x+1]==0&&map[y+1][x+1]==3)
            {
                direction[1]=true;
            }
            if(map[y+1][x]==0&&map[y+1][x-1]==0||map[y+1][x]==3&&map[y+1][x-1]==0||map[y+1][x]==0&&map[y+1][x-1]==3)
            {
                direction[2]=true;
            } 
            if(map[y-1][x-1]==0&&map[y][x-1]==0||map[y-1][x-1]==0&&map[y][x-1]==3||map[y-1][x-1]==3&&map[y][x-1]==0)
            {
                direction[3]=true;
            }
            if(map[y-1][x]==0&&map[y-1][x+1]==0||map[y-1][x]==0&&map[y-1][x+1]==3||map[y-1][x]==3&&map[y-1][x+1]==0)
            {
                direction[0]=true;
            }
        }

    }
    public void decide()
    {
        if(direction[0]==true&&direction[1]==true&&direction[2]&&direction[3]==true)
        {
            way=0;
        }
        else if(direction[0]==true&&direction[1]==true&&direction[3]==true)
        {
            way=3;
        }
        else if(direction[0]==true&&direction[1]==true&&direction[2]==true)
        {
            way=0;
        }
        else if(direction[1]==true&&direction[2]==true&&direction[3]==true)
        {
            way=1;
        }
        else if(direction[0]==true&&direction[2]==true&&direction[3]==true)
        {
            way=2;
        }
        else if(direction[0]==true&&direction[1]==true)
        {
            way=0;
        }
        else if(direction[1]==true&&direction[2]==true)
        {
            way=1;
        }
        else if(direction[2]==true&&direction[3]==true)
        {
            way=2;
        }
        else if(direction[3]==true&&direction[0]==true)
        {
            way=3;
        }
        else if(direction[0]==true)
        {
            way=0;
        }
        else if(direction[1]==true)
        {
            way=1;
        }
        else if(direction[2]==true)
        {
            way=2;
        }
        else if(direction[3]==true)
        {
            way=3;
        }
    }
    public void act()
    {
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledSquare(x+0.5,y+0.5,0.5);
        map[y][x]=0;
        if(way == 0)
        {
            y-=1;
        }
        else if(way == 1)
        {
            x+=1;
        }
        else if(way == 2)
        {
            y+=1;
        }
        else if(way == 3)
        {
            x-=1;
        }
        way=4;
        for(int i = 0; i <=3;i++)
        {
            direction[i]=false;
        }
        if(map[y][x]==0)
        {
            if(ctype==0)
            StdDraw.picture(x+0.5,y+0.5,"pac.png",1,1);
            if(ctype==1)
            StdDraw.picture(x+0.5,y+0.5,"ghost.png",1,1);
        }
        if(map[y][x]==3)
        {
            StdDraw.setPenColor(StdDraw.MAGENTA);
            StdDraw.filledSquare(x+0.5,y+0.5,0.5);
        }
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
}

