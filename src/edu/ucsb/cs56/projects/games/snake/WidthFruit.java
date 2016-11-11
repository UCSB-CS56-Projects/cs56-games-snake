package edu.ucsb.cs56.projects.games.snake;

import java.awt.Color;
import java.util.*;


public class WidthFruit extends BasicFruit {


    public static final int HEIGHT = 15;
    public static final int WIDTH = 15;
    private final String powerUp = "WIDTH";

    private Color c;
    private final Color p = Color.MAGENTA;

    public WidthFruit() {
	super();
	this.setColor("purple");
	this.setColorObject(p);
    }

    public WidthFruit(int xPos, int yPos) {
	super(xPos, yPos);
	this.setColor("purple");
	this.setColorObject(p);
    }

    public String getPowerUp() {
	return powerUp;
    }

}
