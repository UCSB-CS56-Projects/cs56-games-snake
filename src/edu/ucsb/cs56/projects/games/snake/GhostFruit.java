package edu.ucsb.cs56.projects.games.snake;

import java.awt.Color;
import java.util.*;


public class GhostFruit extends BasicFruit {

    public static final int HEIGHT = 15;
    public static final int Width = 15;
    private static Random rng = new Random();
    private final String powerUp = "GHOST";
    private Color c;
    private final Color b = Color.BLACK;

    public GhostFruit() {
	super();
	this.setColor("black");
	this.setColorObject(b);
    }
    

    public GhostFruit(int xPos, int yPos) {
	super(xPos, yPos);
	this.setColor("black");
	this.setColorObject(b);
    }
    
    public String getPowerUp() {
	return powerUp;
    }

}
