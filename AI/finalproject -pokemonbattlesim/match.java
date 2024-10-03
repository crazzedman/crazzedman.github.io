import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.util.Formatter;
import java.io.IOException;
import javax.swing.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class match
{
    private static match m_instance = null;
    trainer t;
    aitrainer at;
    Scanner sc;
    private match() throws Exception{
        sc = new Scanner(System.in);
        playMusic();
        t = chooseTrainer();
        at = chooseAITrainer();
    }
    public static match getInstance() throws Exception{
        if(m_instance == null) {
            m_instance = new match();
        }
        return m_instance;
    }
    public void run()
    {
        simulateBattle(at,t);
    }
    public void simulateBattle(aitrainer ai,trainer me)
    {
        ArrayList<pokemon> trainerpokemons = me.getPokemons();
        ArrayList<pokemon> aipokemons = ai.getPokemons();
        System.out.println("Let's start playing");
        pokemon tp = trainerpokemons.get(0);
        pokemon aip = aipokemons.get(0);
        int currentai = 0;
        int currentme = 0;
        while(stillAlive(trainerpokemons)&&stillAlive(aipokemons))
        {
            System.out.print("Do you want to Switch out pokemon (Y)or(N)?");
            String key = sc.next();
            System.out.println();
            if(key.equals("Y"))
            {
                System.out.println("Ok, Switchout pokemon");
                System.out.println("Choose Pokemon to Swap out with");
                int swap = -1;
                for(int i = 0; i < trainerpokemons.size();i++)
                {
                    System.out.println(trainerpokemons.get(i));
                }
                System.out.println("The pokemon to swap out");
                swap = sc.nextInt();
                if(swap>trainerpokemons.size())
                {
                    System.exit(0);
                }
                tp = trainerpokemons.get(swap-1);
                currentme = swap-1;
            }
            else if (key.equals("N"))
            {
                System.out.println("Your Move");
            }
            System.out.println("AI :: "+aip);
            System.out.println("Trainer :: " +tp);
            System.out.println("My Health :: " + tp.getHealth());
            System.out.println("There Health :: " + aip.getHealth());
            ai.sense(tp.getHealth());
            ai.decide();
            if(tp.getSpeed()>aip.getSpeed())
            {
                aip.changeHealth(tp.useMove(-1).doDamage());
                if(aip.getHealth()<=0)
                {
                    aipokemons.remove(currentai);
                    if(!stillAlive(aipokemons))
                    {
                        break;
                    }
                    aip = aipokemons.get(0);
                    continue;
                }
                tp.changeHealth(aip.useMove(ai.act()).doDamage());
            }
            else
            {
                tp.changeHealth(aip.useMove(ai.act()).doDamage());
                if(tp.getHealth()<=0)
                {
                    trainerpokemons.remove(currentme);
                    if(!stillAlive(trainerpokemons))
                    {
                        break;
                    }
                    for(int i = 0; i < trainerpokemons.size();i++)
                    {
                        System.out.println(trainerpokemons.get(i));
                    }
                    System.out.println("The pokemon to swap out");
                    int swap = sc.nextInt();
                    tp = trainerpokemons.get(swap-1);
                    currentme = swap-1;
                    continue;
                }
                aip.changeHealth(tp.useMove(-1).doDamage());
            }
            System.out.println("My Health :: " + tp.getHealth());
            System.out.println("There Health :: " + aip.getHealth());
            if(aip.getHealth()<= 0)
            {
                aipokemons.remove(currentai);
                if(!stillAlive(aipokemons))
                {
                    break;
                }
                aip = aipokemons.get(0);
            }
            if(tp.getHealth()<= 0)
            {
                trainerpokemons.remove(currentme);
                if(!stillAlive(trainerpokemons))
                {
                    break;
                }
                for(int i = 0; i < trainerpokemons.size();i++)
                {
                    System.out.println(trainerpokemons.get(i));
                }
                System.out.println("The pokemon to swap out");
                int swap = sc.nextInt();
                tp = trainerpokemons.get(swap-1);
                currentme = swap-1;
            }
        }
        if(!stillAlive(aipokemons))
        {
            System.out.println("Trainer wins");
        }
        else
        {
            System.out.println("AI wins");
        }
    }
    public void playMusic() throws IOException,javax.sound.sampled.LineUnavailableException,javax.sound.sampled.UnsupportedAudioFileException
    {
            File musicpath = new File("pokemon.wav");
            if(musicpath.exists())
            {
                AudioInputStream audioinput = AudioSystem.getAudioInputStream(musicpath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioinput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }        
    }
    public trainer chooseTrainer() throws Exception
    {
        String answer = "";
        trainer me = null;
        while(answer.equals(""))
        {
            System.out.print("Do you already have an avatar :: ");
            answer = sc.next();
            System.out.println();
            if(answer.equals("yes"))
            {
                String name = "";
                System.out.println("What is your name?");
                name = sc.next();   
                if(findAvatar(name)==null)
                {
                    answer = "";
                    System.out.println("Try Again");
                }
                else
                {
                    me = findAvatar(name);
                }
            }
            else if(answer.equals("no"))
            {
                String name = "";
                ArrayList<pokemon> pokemons = new ArrayList<pokemon>();
                System.out.println("Please enter name");
                System.out.print("Name :: ");
                name = sc.next();
                me = new trainer(name);
                Formatter out = null;
                try {  
                    out = new Formatter("Avatars.txt");
                    out.format("%s%n","Name :: " + name);
                    out.format("%s%n","wins :: 0");
                    out.format("%s%n","losses :: 0");
                } catch (IOException e ) {
                    System.out.println ("Error with the file");    
                } finally {
                    if (out!= null)
                    {
                        out.close();
                    }
                }
            }
            else
            {
                answer = "";
                System.out.println("Different answer, you can only answer yes or no");
            }
        }
        return me;
    }
    public aitrainer chooseAITrainer() throws Exception
    {
        aitrainer ai = null;
        String answer = "";
        while(answer.equals(""))
        {
            System.out.print("Do you already have an ai you want to play :: ");
            answer = sc.next();
            System.out.println();
            if(answer.equals("yes"))
            {
                String name = "";
                System.out.println("What is the ai's name?");
                name = sc.next();   
                if(findAvatar(name)==null)
                {
                    answer = "";
                    System.out.println("Try Again");
                }
                else
                {
                    ai = findAI(name);
                }
            }
            else if(answer.equals("no"))
            {
                System.out.println("You will play default AI");
                ai = findAI("Red");
            }
            else
            {
                answer = "";
                System.out.println("Different answer, you can only answer yes or no");
            }
        }
        return ai;
    }
    public trainer findAvatar(String name) throws Exception
    {
        trainer me = null;
        Scanner scan = null;
        File file = new File("Avatars.txt");
        scan = new Scanner(file);
        boolean hasavatar = false;
        String wins = "";
        String losses = "";
        ArrayList<pokemon> pokemons = new ArrayList<pokemon>();
        while (scan.hasNextLine())
        {
            if(scan.nextLine().equals("Name :: "+ name))
            {
                hasavatar = true;
                break;
            }
        }
        if(hasavatar)
        {
            wins = scan.nextLine();
            losses = scan.nextLine();
            pokemons.add(findPokemon(scan.nextLine()));
            pokemons.add(findPokemon(scan.nextLine()));
            pokemons.add(findPokemon(scan.nextLine()));
            me = new trainer(name,wins,losses,pokemons);
        }
        else
        {
            System.out.println("There is no valid trainer with that name");
            System.exit(0);
        }
        return me;
    }
    public aitrainer findAI(String name) throws Exception
    {
        aitrainer ai = null;
        Scanner scan = null;
        File file = new File("AIs.txt");
        scan = new Scanner(file);
        boolean hasai = false;
        ArrayList<pokemon> pokemons = new ArrayList<pokemon>();
        String difficulty = "";
        while (scan.hasNextLine())
        {
            if(scan.nextLine().equals("Name :: "+ name))
            {
                hasai = true;
                break;
            }
        }
        if(hasai)
        {
            difficulty = scan.nextLine();
            pokemons.add(findPokemon(scan.nextLine()));
            pokemons.add(findPokemon(scan.nextLine()));
            pokemons.add(findPokemon(scan.nextLine()));
            ai = new aitrainer(name,difficulty,pokemons);
        }
        else
        {
            System.out.println("There is no valid ai with that name");
            System.exit(0);
        }
        return ai;
    }
    public pokemon findPokemon(String name) throws Exception
    {
        pokemon poke = null;
        Scanner scan = null;
        File file = new File("Pokemons.txt");
        scan = new Scanner(file);
        boolean haspokemon = false;
        while (scan.hasNextLine())
        {
            if(scan.nextLine().equals("Name :: "+ name))
            {
                haspokemon = true;
                break;
            }
        }
        if(haspokemon)
        {
            String type = scan.nextLine();
            int health = Integer.valueOf(scan.nextLine());
            int speed = Integer.valueOf(scan.nextLine());
            ArrayList<Move>moves = new ArrayList<Move>();
            moves.add(findMove(scan.nextLine()));
            moves.add(findMove(scan.nextLine()));
            moves.add(findMove(scan.nextLine()));
            moves.add(findMove(scan.nextLine()));
            poke = new pokemon(name,health,speed,new Type(type),moves);
        }
        else
        {
            System.out.println("There is no valid pokemon with that name");
            System.exit(0);
        }
        return poke;
    }
    public Move findMove(String name) throws Exception
    {
        Move move = null;
        Scanner scan = null;
        File file = new File("Moves.txt");
        scan = new Scanner(file);
        boolean hasmoves = false;  
        String type = "";
        String typeofmove = "";
        int accuracy = 0;
        int uses = 0;
        int value = 0;
        String effect = "";
        while (scan.hasNextLine())
        {
            if(scan.nextLine().equals(name))
            {
                hasmoves = true;
                break;
            }
        }
        if(hasmoves)
        {
            type = scan.nextLine();
            typeofmove = scan.nextLine();
            value = Integer.valueOf(scan.nextLine());
            accuracy = Integer.valueOf(scan.nextLine());
            uses = Integer.valueOf(scan.nextLine());
            effect = scan.nextLine();
            move = new Move(name,new Type(type),typeofmove,value, accuracy,uses,effect);
        }
        else
        {
            System.out.println("Doesn't exist");
        }
        return move;
    }
    public boolean stillAlive(ArrayList<pokemon> pokemons)
    {
        return (pokemons.size()!=0);
    }
    //add later if needed
    /*public Effect findEffect(String name)
    {
        
    }*/
}
