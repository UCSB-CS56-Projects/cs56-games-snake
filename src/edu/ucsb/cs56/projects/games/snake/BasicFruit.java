package edu.ucsb.cs56.projects.games.snake;

import java.awt.Color;
import java.util.*;

/**
 * BasicFruit is a class that implements methods required by a basic (non-special) fruit.
 * This class is intended to create all basic fruit objects in the game.
 * 
 * @author Marcellis Carr-Barfield
 * @see         GameObject
 */
public class BasicFruit extends GameObject {
	
	public static final int HEIGHT = 15;
	public static final int WIDTH = 15;
	private static Random rng = new Random();

	/**Default Constructor
	 * <p>
	 * Creates a BasicFruit with random coordinates
	 */
    private static Color c;
    private final Color r = Color.RED;
    
	public BasicFruit(){
		super();
		int xPos = (int) (rng.nextDouble()*(SnakeFrame.getFrameWidth() - 74) + 25);
		int yPos = (int) (rng.nextDouble()*(SnakeFrame.getFrameHeight() - 164) + 115);
		this.setPos(xPos,  yPos);
		this.setColor("red");
		this.setColorObject(r);
	}
	
	/**
	 * Sets the BasicFruit object's X and Y positions, and sets size to 15 pixels
	 * 
	 * @param xPos x position of the BasicFruit
	 * @param yPos y position of the BasicFruit
	 */
	public BasicFruit(int xPos, int yPos){
		super(xPos, yPos, BasicFruit.WIDTH, BasicFruit.HEIGHT);
		this.setColor("red");
		this.setColorObject(r);
	}
	
	/**
	 * Sets the BasicFruit object's X and Y to random coordinates in the SnakeFrame
	 * 
	 * @param snakeFrameWidth width of the SnakeFrame object that the BasicFruit is drawn on
	 * @param snakeFrameHeight height of the SnakeFrame object that the BasicFruit is drawn on
	 * @return none
	 */
	public void setXYRandom(){
		//the random number generating code was derived from the original legacy project. There is not much 
		//in the way of explanation.
		int xPos = (int) (rng.nextDouble()*(SnakeFrame.getFrameWidth() - 74) + 25);
		int yPos = (int) (rng.nextDouble()*(SnakeFrame.getFrameHeight() - 164) + 115);
		this.setPos(xPos, yPos);
	}

	public static Color getColorObject(){
		return c;
	}
    public void setColorObject(Color c) {
	this.c = c;
	
    }

    public String getPowerUp() {
	return "NONE";

    }
}
