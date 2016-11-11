package edu.ucsb.cs56.projects.games.snake;

import java.awt.Color;
import java.util.*;


public class SpeedFruit extends BasicFruit {

    public static final int HEIGHT = 15;
    public static final int Width = 15;
    private static Random rng = new Random();
    private final String powerUp = "SPEED";
    private Color c;
    private final Color g = Color.GREEN;

    public SpeedFruit() {
	super();
	this.setColor("green");
	this.setColorObject(g);
    }
    

    public SpeedFruit(int xPos, int yPos) {
	super(xPos, yPos);
	this.setColor("green");
	this.setColorObject(g);
    }
    
    public String getPowerUp() {
	return powerUp;
    }

}