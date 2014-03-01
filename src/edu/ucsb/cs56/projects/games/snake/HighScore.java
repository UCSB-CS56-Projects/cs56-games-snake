package edu.ucsb.cs56.projects.games.snake;

import java.io.Serializable;

public class HighScore {

    private final int score;

    public HighScore(int score){
	this.score = score;
    }

    public String toString(){
	return "" + this.score;
    }

    public int getScore(){ return this.score; }
}


