
/**
 * Write a description of class GuessingGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Formatter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GuessingGame
{
    private BTNode root = null;
    private BTNode temp = null;
    private int preIndex = 0;
    LinkedList tree;
    LinkedList words;
    LinkedList wordsv2;
    
    // constructor ... you decide
    
    public void initialize () throws Exception
    {
        System.out.println("Think about a video game?");
        System.out.println();
        words = new LinkedList<BTNode>();
        wordsv2 = new LinkedList<BTNode>();
        Scanner sc = null;
        File file = new File("Test.txt");
        sc = new Scanner(file);
        while (sc.hasNextLine()) 
        {
            words.add(new BTNode(sc.nextLine()));
        }
        Scanner scv2 = null;
        File filev2 = new File("Test2.txt");
        scv2 = new Scanner(filev2);
        while (scv2.hasNextLine())
        {
            wordsv2.add(new BTNode(scv2.nextLine()));
        }
        root = buildTree(words,wordsv2,0,words.size()-1);
        temp = root;
        Scanner question = new Scanner(System.in);
        System.out.println(temp);
        int i = 1;
        while(i==1)
        {
            String answer = question.next();
            if(answer.equals("no"))
            {
                if(temp.left.toString().indexOf("?")<=0)
                {
                    i = 0;
                    System.out.println("is your game: " + temp.left + "?");
                    String answerv2 = question.next();
                    if(answerv2.equals("yes"))
                    {
                        System.out.println("Thanks for playing");
                    }   
                    else if(answerv2.equals("no"))
                    {
                        System.out.println("What is your game?");
                        String newgame = question.next();
                        System.out.println("What makes your game unique from " + temp.left+"?" + "(in form a question)");
                        BTNode temp1 = new BTNode(temp.left.toString());
                        BTNode temp2 = new BTNode(newgame);
                        String diff = question.next();
                        diff = question.nextLine();
                        diff = "Is"+diff;
                        temp.left=new BTNode(diff);
                        temp.left.left=temp1;
                        temp.left.right=temp2;
                        System.out.println("Thank you for your input.");
                    }
                }
                else 
                {
                    temp = temp.left;
                    System.out.println(temp);
                }
            }
            else if(answer.equals("yes"))
            {
                if(temp.right.toString().indexOf("?")<=0)
                {
                    i = 0;
                    System.out.println("is your game: " + temp.right+ "?");
                    String answerv2 = question.next();
                    if(answerv2.equals("yes"))
                    {
                        System.out.println("Thanks for playing");
                    }
                    else if(answerv2.equals("no"))
                    {
                        System.out.println("What is your game?");
                        String newgame = question.next();
                        System.out.println("What makes your game unique from " + temp.right+"?" + "(in form a question)");
                        BTNode temp1 = new BTNode(temp.right.toString());
                        BTNode temp2 = new BTNode(newgame);
                        String diff = question.next();
                        diff = question.nextLine();
                        diff = "Is"+diff;
                        temp.right=new BTNode(diff);
                        temp.right.left=temp1;
                        temp.right.right=temp2;
                        System.out.println("Thank you for your input.");
                    }
                }
                else
                {
                    temp = temp.right;
                    System.out.println(temp);
                }   
            }
            else
            {
                System.out.println("Wrong answer: Error");
                System.out.println("Try again");
            }
        }   
    }
    public BTNode buildTree(LinkedList<BTNode>set, LinkedList<BTNode>setv2, int inStrt, int inEnd)
    {
        if (inStrt > inEnd)
            return null;
        BTNode tNode = new BTNode(setv2.get(preIndex++).data);
        if (inStrt == inEnd)
            return tNode;
        int inIndex = search(set, inStrt, inEnd, tNode.data);
        tNode.left = buildTree(set, setv2, inStrt, inIndex - 1);
        tNode.right = buildTree(set, setv2, inIndex + 1, inEnd);
        return tNode;
    }
 
    public int search(LinkedList<BTNode>set, int strt, int end, String value)
    {
        int i;
        for (i = strt; i <= end; i++) {
            if (set.get(i).toString().equals(value))
                return i;
        }
        return i;
    }
    public void dump(BTNode node) {
       if (node == null)
            return;
        words.add(node.data);
        dump(node.left);
        dump(node.right);
    }
    public void dumpv2(BTNode node){
        if (node == null)
            return;
        dumpv2(node.left);
        wordsv2.add(node.data);
        dumpv2(node.right);
    }
    public void run () throws Exception{
        // entry point for your program.
        words = new LinkedList<BTNode>();
        wordsv2 = new LinkedList<BTNode>();
        initialize ();
        words.clear();
        wordsv2.clear();
        dump(root);
        dumpv2(root);
        Scanner revert = new Scanner(System.in);
        System.out.println("Do you want to clear data base");
        int correct = 1;
        while(correct==1)
        {
        String choice = revert.next();
        Formatter out = null;
        try {  
            out = new Formatter("Test.txt");
            
            if(choice.equals("no"))
            {
                correct = 0;
                for(int i = 0; i <words.size();i++)
                {
                    out.format("%s%n",wordsv2.get(i).toString());  
                }
                out.flush();
            }
            else if (choice.equals("yes"))
            {
                correct = 0;
                out.format("%s%n","Minecraft");
                out.format("%s%n","Is it a shooter game?");
                out.format("%s%n","Valorant");
            }
            else
            {
                System.out.println("Choose again");
                continue;
            }
        } catch (IOException e ) {
            System.out.println ("Error with the file");    

        } finally {
        
           if (out!= null) {
               out.close();
           }
        }
        Formatter outv2 = null;
        try {  
            outv2 = new Formatter("Test2.txt");
            if(choice.equals("no"))
            {
                correct = 0;
                for(int i = 0; i <words.size();i++)
                {
                    outv2.format("%s%n",words.get(i).toString());  
                }
                outv2.flush();
            }
            else if (choice.equals("yes"))
            {
                correct = 0;
                outv2.format("%s%n","Is it a shooter game?");
                outv2.format("%s%n","Minecraft");
                outv2.format("%s%n","Valorant");
            }
            else
            {
                correct = 1;
            } 
        } catch (IOException e ) {
              System.out.println ("Error with the file");    

        } finally {
        
           if (outv2!= null) {
               outv2.close();
           }
        } 
    }
    }
}
