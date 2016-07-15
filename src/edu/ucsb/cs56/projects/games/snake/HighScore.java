package edu.ucsb.cs56.projects.games.snake;

import java.io.*;

public class HighScore implements Serializable {

    private int score;

    public HighScore(int score){
	this.score = score;
    }

    public String toString(){
	return "" + this.score;
    }

    public int getScore(){ return this.score; }
   
    public void setScore(int x){ this.score = x; } 

    public void saveHighScore() throws IOException { 
        FileOutputStream fileOut = new FileOutputStream("src/edu/ucsb/cs56/projects/games/snake/Highscore.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(this);
        out.close();
        fileOut.close();
    }

    public static HighScore loadHighScore() {//throws IOException{
        HighScore hs = null;

        try {
            FileInputStream fileIn = new FileInputStream("src/edu/ucsb/cs56/projects/games/snake/Highscore.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            hs = (HighScore) in.readObject();
            in.close();
            fileIn.close();

        } catch (Exception ex){
	     ex.printStackTrace();
	     hs = new HighScore(0);
        }
        if(hs == null){
            hs = new HighScore(0);
            hs.loadHighScore();
        }
        return hs;
    }

    public void saveHighScore2() throws IOException { 
        FileOutputStream fileOut = new FileOutputStream("src/edu/ucsb/cs56/projects/games/snake/Highscore2.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(this);
        out.close();
        fileOut.close();
    }

    public static HighScore loadHighScore2() {//throws IOException{
        HighScore hs = null;

        try {
            FileInputStream fileIn = new FileInputStream("src/edu/ucsb/cs56/projects/games/snake/Highscore2.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            hs = (HighScore) in.readObject();
            in.close();
            fileIn.close();

        } catch (Exception ex){
	     ex.printStackTrace();
	     hs = new HighScore(0);
        }
        if(hs == null){
            hs = new HighScore(0);
            hs.loadHighScore2();
        }
        return hs;
    }

    public void saveHighScore3() throws IOException { 
        FileOutputStream fileOut = new FileOutputStream("src/edu/ucsb/cs56/projects/games/snake/Highscore3.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(this);
        out.close();
        fileOut.close();
    }

    public static HighScore loadHighScore3() {//throws IOException{
        HighScore hs = null;

        try {
            FileInputStream fileIn = new FileInputStream("src/edu/ucsb/cs56/projects/games/snake/Highscore3.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            hs = (HighScore) in.readObject();
            in.close();
            fileIn.close();

        } catch (Exception ex){
	     ex.printStackTrace();
	     hs = new HighScore(0);
        }
        if(hs == null){
            hs = new HighScore(0);
            hs.loadHighScore3();
        }
        return hs;
    }
 
}


