
/**
 * Write a description of class GameOfLife here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class GameOfLife
{
    //
    
    // Write your code here.
    public static boolean [][] initial;
    
    
    public static void start()
    {
        javax.swing.JOptionPane.showMessageDialog(null,"Do you want to play my game of life?");
        initial = new boolean[50][50];
        Scanner j = new Scanner(System.in);
        grid();
        System.out.println("Type 0 to see glider");
        System.out.println("Type 1 to see oscillator");
        System.out.println("Type 2 to see a boring blinker");
        System.out.println("Type 3 to see glider gun");
        System.out.println("Type 4 to see oscillator evolution");
        System.out.println("Type 5 to make your own pattern");
        
        int a = j.nextInt();
        
        switch(a)
        {
            case 0:
            initial = pattern(initial);
            break;
            case 1:
            initial = pattern1(initial);
            break;
            case 2:
            initial = pattern2(initial); 
            break;
            case 3:
            initial = pattern3(initial); 
            break;
            case 4:
            initial = pattern4(initial); 
            break;
            case 5:
            initial = patterncustom(initial);
            break;
        }
        //playaudio()
        movingmethod(initial);
                
    }
    public static boolean[][] movingmethod(boolean[][]initial)
    {
        boolean[][] finish = new boolean[50][50];
        StdDraw.pause(50);
        StdDraw.enableDoubleBuffering();
        finish = move(initial);
        constantmove(finish);
        resetLine();
        StdDraw.show();
        return movingmethod(finish);
    }
    public static void constantmove(boolean[][]finish)
    {
        for(int i = 0; i <= 49; i+=1)
        {
            for(int j = 0; j <=49; j+=1)
            {
                if(finish[i][j]==false)
                {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(i+0.5,j+0.5,0.5);
                }
                else if(finish[i][j]==true)
                {
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(i+0.5,j+0.5,0.5);
                }
            }
        }
    }
    public static boolean[][] move( boolean[][]initial)
    {
        boolean[][]finish = new boolean[50][50];
        for(int i = 0; i < 50; i++)
        {
            for(int j = 0; j < 50; j++)
            {
                int count = 0;
                for(int k = i-1; k <= i+1; k++)
                {
                    for(int g = j-1; g <= j+1; g++)
                    {
                        if(g==j&&k==i)
                        continue;
                        if(k>-1&&k<50&&g>-1&&g<50)
                        {
                                if(initial[k][g]==true)
                                {
                                    count++;
                                }
                        }
                    }
                }
                
                if(initial[i][j]==false)
                {
                     if(count == 3)
                    {
                        
                        finish[i][j]=true;
                    }
                    
                }
                else if(initial[i][j]==true)
                {
                   if(count==2||count==3)
                    {
                        finish[i][j]=true;
                    }
                }
            }
        }
       
        return finish;
    }
    
    public static void resetLine()
    {
        StdDraw.setPenColor(StdDraw.BLACK);
        for(int i = 1; i<=49; i+=1)
        {  
            StdDraw.line(0,i,50,i);
        }
        
        for(int j = 1; j <= 49; j+=1)
        {
            StdDraw.line(j,0,j,50);
        }
    }
    public static void grid()
    {
        StdDraw.setCanvasSize(500,500);
        StdDraw.setXscale(0,50);
        StdDraw.setYscale(50,0);
        for(int i = 1; i<=49; i++)
        {
            StdDraw.line(0,i,50,i);
        }
        
        for(int j = 1; j <= 49; j++)
        {
            StdDraw.line(j,0,j,50);
        }
    }
    public static boolean[][] pattern(boolean[][]initial)
    {
        
        initial[1][0]=true;
        initial[2][2]=true;
        initial[0][2]=true;
        initial[2][1]=true;
        initial[1][2]=true;
        StdDraw.enableDoubleBuffering();
        constantmove(initial);
        resetLine();
        StdDraw.show();
        return initial;
    }
    public static boolean[][] pattern1(boolean[][]initial)
    {
        initial[3][1]=true;
        initial[4][1]=true;
        initial[5][1]=true;
        initial[3][6]=true;
        initial[4][6]=true;
        initial[5][6]=true;
        initial[3][8]=true;   
        initial[4][8]=true;
        initial[5][8]=true;
        initial[3][13]=true;
        initial[4][13]=true;
        initial[5][13]=true;
        initial[9][1]=true;
        initial[10][1]=true;
        initial[11][1]=true;
        initial[9][6]=true;
        initial[10][6]=true;
        initial[11][6]=true;
        initial[9][8]=true;
        initial[10][8]=true;
        initial[11][8]=true;
        initial[9][13]=true;
        initial[10][13]=true;
        initial[11][13]=true;
        initial[1][9]=true;
        initial[1][10]=true;
        initial[1][11]=true;
        initial[6][9]=true;
        initial[6][10]=true;
        initial[6][11]=true;
        initial[8][9]=true;
        initial[8][10]=true;
        initial[8][11]=true;
        initial[13][9]=true;
        initial[13][10]=true;
        initial[13][11]=true;
        initial[1][3]=true;
        initial[1][4]=true;
        initial[1][5]=true;
        initial[6][3]=true;
        initial[6][4]=true;
        initial[6][5]=true;
        initial[8][3]=true;
        initial[8][4]=true;
        initial[8][5]=true;
        initial[13][3]=true;
        initial[13][4]=true;
        initial[13][5]=true;
        StdDraw.enableDoubleBuffering();
        constantmove(initial);
        resetLine();
        StdDraw.show();
        return initial;
    }
    public static boolean[][] pattern2(boolean[][] initial)
    {
        initial[9][9]=true;
        initial[8][8]=true;
        initial[8][9]=true;
        initial[9][8]=true;
        initial[10][10]=true;
        initial[11][11]=true;
        initial[10][11]=true;
        initial[11][10]=true;
        StdDraw.enableDoubleBuffering();
        constantmove(initial);
        resetLine();
        StdDraw.show();
        return initial;
        
    }
    public static boolean[][] pattern3(boolean[][] initial)
    {
        initial[1][12]=true;
        initial[1][13]=true;
        initial[2][12]=true;
        initial[2][13]=true;
        initial[36][10]=true;
        initial[35][10]=true;
        initial[36][11]=true;
        initial[35][11]=true;
        initial[11][12]=true;
        initial[11][13]=true;
        initial[11][14]=true;
        initial[12][11]=true;
        initial[12][15]=true;
        initial[13][10]=true;
        initial[13][16]=true;
        initial[14][10]=true;
        initial[14][16]=true;
        initial[15][13]=true;
        initial[16][11]=true;
        initial[16][15]=true;
        initial[17][12]=true;
        initial[17][13]=true;
        initial[17][14]=true;
        initial[18][13]=true;
        initial[21][10]=true;
        initial[21][11]=true;
        initial[21][12]=true;
        initial[22][10]=true;
        initial[22][11]=true;
        initial[22][12]=true;
        initial[23][9]=true;
        initial[23][13]=true;
        initial[25][8]=true;
        initial[25][14]=true;
        initial[25][9]=true;
        initial[25][13]=true;

        
        
        StdDraw.enableDoubleBuffering();
        constantmove(initial);
        resetLine();
        StdDraw.show();
        return initial;
    }
    public static boolean[][] pattern4(boolean[][] initital)
    {
        initial[8][8]=true;
        initial[8][9]=true;
        initial[8][10]=true;
        initial[9][8]=true;
        initial[9][9]=true;
        initial[9][10]=true;
        initial[10][8]=true;
        initial[10][9]=true;
        initial[10][10]=true;
        initial[11][11]=true;
        initial[11][12]=true;
        initial[11][13]=true;
        initial[12][11]=true;
        initial[12][12]=true;
        initial[12][13]=true;
        initial[13][11]=true;
        initial[13][12]=true;
        initial[13][13]=true;
        StdDraw.enableDoubleBuffering();
        constantmove(initial);
        resetLine();
        StdDraw.show();
        return initial;
    }
    public static boolean[][] patterncustom(boolean[][] initial)
    {
        Scanner f = new Scanner(System.in);
        System.out.println("bounding box starts from 0 and goes to 49 on both x and y axis");
        System.out.println("Enter 50 to exit");
        System.out.println("Enter 1 to continue");
        int j = f.nextInt();
        
        while(j!=50)
        {
            System.out.println("type x value");
            int d = f.nextInt();
            if(d>49||d<0)
            {
                System.out.println("outside bounding box");
                System.out.println("type x value");
                d = f.nextInt();
            }
            System.out.println("type y value");
            int g = f.nextInt();
            if(g>49||g<0)
            {
                System.out.println("outside bounding box");
                System.out.println("type y value");
                g = f.nextInt();
            }
            
            initial[d][g]=true;
            System.out.println("type 1 to continue inputing values and 50 to stop");
            j = f.nextInt();
        }
        StdDraw.enableDoubleBuffering();
        constantmove(initial);
        resetLine();
        StdDraw.show();
        
        
        System.out.println("type 1 to see your pattern");
        System.out.println("type 2 to exit game of life");
        j = f.nextInt();
        if(j==1)
        {
            return initial;
        }
        else
        {
            System.exit(0);
        }
        return initial;  
    }
    public static void playaudio()
    {
        
    }
    
}