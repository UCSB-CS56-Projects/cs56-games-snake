package edu.ucsb.cs56.projects.games.snake;

import java.io.*;

public class HighScoreStorage implements Serializable {

    //private HighScore list = new HighScore();
  
    
    public void saveHighScore() throws IOException {
	FileOutputStream fileOut = new FileOutputStream("edu/ucsb/cs56/projects/games/snake/Highscore.ser");
	ObjectOutputStream out = new ObjectOutputStream(fileOut);
	out.writeObject(this);
	out.close();
	fileOut.close();
    }

    public static HighScoreStorage loadHighScore() throws IOException{
	HighScoreStorage hss = null;
	
	try {
	    FileInputStream fileIn = new FileInputStream("edu/ucsb/cs56/projects/games/snake/Highscore.ser");
	    ObjectInputStream in = new ObjectInputStream(fileIn);
	    hss = (HighScoreStorage) in.readObject();
	    in.close();
	    fileIn.close();

	} catch (Exception ex){

	}
	if(hss == null){
	    hss = new HighScoreStorage();
            hss.loadHighScore();
        }
	return hss;
    }
}
