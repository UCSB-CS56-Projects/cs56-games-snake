/**
 * 
 */
package edu.ucsb.cs56.projects.games.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Marcellis Carr-Barfield
 * This is a class for snake objects.
 */
public class Snake {

	//Define constants for snake object direction setters
	public static final String UP = "UP";
	public static final String DOWN = "DOWN";
	public static final String LEFT = "LEFT";
	public static final String RIGHT = "RIGHT";
	
	// Width of all snakes created
    public static final int WIDTH = 15;
	
    // Establish variables
    // Starting X and Y coordinates for the snake head
    private int snake_x_pos, snake_y_pos;
    
    //variable storing the length of the snake
    private int snake_length = 0;

    // Create an ArrayList of GameObjects to represent the Snake object.
    private ArrayList<GameObject> snake = new ArrayList<GameObject>();

    private boolean ismovingLEFT = false, ismovingRIGHT = false;
    private boolean ismovingUP = true, ismovingDOWN = false, growsnake = false;
    
    //tells us whether the snake's direction has been changed on the screen when it turns
    private int turn;
    

    // Create graphics
    //Graphics g;
    
    // 
    public Snake(){
    	this.snake_x_pos = 0;
    	this.snake_y_pos = 0;
    	
    }
    //creates a snake that is three GameObjects long
    public Snake(int snake_x_pos, int snake_y_pos){
    	this.snake_x_pos = snake_x_pos;
    	this.snake_y_pos = snake_y_pos;
    	for (int i = 0; i < 3; i++) {
		    this.snake.add(new GameObject(snake_x_pos, snake_y_pos));
		}
    	// Set starting positions for the tail
        this.snake.get(0).setPos(snake_x_pos,snake_y_pos);
        this.snake.get(1).setPos(snake_x_pos,snake_y_pos+WIDTH);
        this.snake.get(2).setPos(snake_x_pos,snake_y_pos+(2*WIDTH));
        this.snake_length = 3;
    }
	
    //function for changing direction of the snake
    public void setDirection(String direction){
    	switch(direction){
    	case "UP":		
    		this.ismovingDOWN = false;
    		this.ismovingLEFT = false;
    		this.ismovingRIGHT = false;
    		this.ismovingUP = true;
    		break;
    	case "DOWN":
    		this.ismovingLEFT = false;
    		this.ismovingRIGHT = false;
    		this.ismovingUP = false;
    		this.ismovingDOWN = true;
    		break;
    	case "LEFT":
    		this.ismovingRIGHT = false;
    		this.ismovingUP = false;
    		this.ismovingDOWN = false;
    		this.ismovingLEFT = true;
    		break;
    	case "RIGHT":
    		this.ismovingUP = false;
    		this.ismovingDOWN = false;
    		this.ismovingLEFT = false;
    		this.ismovingRIGHT = true;
    		break;
    	}
    }
    
    //get the direction of the snake
    public String getDirection(){
    	if(this.ismovingDOWN)
    		return Snake.DOWN;
    	if(this.ismovingUP)
    		return Snake.UP;
    	if(this.ismovingLEFT)
    		return Snake.LEFT;
    	if(this.ismovingRIGHT)
    		return Snake.RIGHT;
    	return "NONE";
    }
    
    //function to indicate the snake has been turned a turn value > 0 means it has been turned but not drawn
    public void turn(){
    	this.turn++;
    }
    
    //function to get the turn value
    public boolean hasTurned(){
    	if (turn == 0)
    		return false;
    	else
    		return true;
    }
    
    //create the setters for the snake positions
    public void set_x_pos(int x_pos){
    	this.snake_x_pos = x_pos;
    }
    
    public void set_y_pos(int y_pos){
    	this.snake_y_pos = y_pos;
    }
    
    //create the getters for the snake positions
    public int get_x_pos(){
    	return this.snake_x_pos;
    }
    
    public int get_y_pos(){
    	return this.snake_y_pos;
    }
    
    //create setters for the GameObject array
    public void setGameObjectPos(int x_pos, int y_pos, int index){
    	this.snake.get(index).setPos(x_pos, y_pos);
    }
    
    //create getters for the GameObject x position
    public int getGameObjectXPos(int index){
    	return this.snake.get(index).getX();
    }
    
    //create getters for the GameObject y position
    public int getGameObjectYPos(int index){
    	return this.snake.get(index).getY();
    }
    
    //create setters for the head color of the snake
    public void setSnakeHeadColor(String color){
    	if (color == "black")
    		this.snake.get(0).setColor(GameObject.BLACK);
    	if (color == "red")
    		this.snake.get(0).setColor(GameObject.RED);
    	if (color == "green")
    		this.snake.get(0).setColor(GameObject.GREEN);
    }
    
    //create setter for the tail color of the snake
    public void setSnakeTailColor(String color){
    	if (color == "black"){
    		for(int i = 1; i < this.snake_length - 1; i++){
    			this.snake.get(i).setColor(GameObject.BLACK);
    		}
    	}
    	if (color == "red"){
    		for(int i = 1; i < this.snake_length - 1; i++){
    			this.snake.get(i).setColor(GameObject.RED);
    		}
    	}
    	if (color == "green"){
    		for(int i = 1; i < this.snake_length - 1; i++){
    			this.snake.get(i).setColor(GameObject.GREEN);
    		}
    	}
    	if (color == "orange"){
    		for(int i = 1; i < this.snake_length - 1; i++){
    			this.snake.get(i).setColor(GameObject.ORANGE);
    		}
    	}
    }
    
    public String getSnakeColorAtIndex(int index){
    	return this.snake.get(index).getColor();
    }
    //removes the GameObject at the specified index in a snake's array
    public void removeGameObject(int index){
    	this.snake.remove(index);
    	this.snake_length--;
    }
    
    //sets the size of the snake
    public void setSize(int size){
    	this.snake_length = size;
    }
    
    //returns the size of the snake
    public int size(){
    	return this.snake_length;
    }
    
    //This method seems to move the snake object, and also seems to grow the snake size by one
	public void shiftSnake() {
        // Create a new Tail in front of the Snake based on the direction
    	// moving and set it to the 0th element
        if (this.ismovingLEFT) {
            // If the tail movement is within the boundaries, move it forward one space
            if (this.snake.get(0).getX() >= WIDTH) { 
            	this.snake.add(0, new GameObject(this.snake.get(0).getX() - WIDTH, this.snake.get(0).getY()));
            }
	    
	    // Otherwise loop it to the opposite end of the window
            else {
            	this.snake.add(0, new GameObject(this.snake.get(0).getX() + SnakeFrame.getFrameWidth() - WIDTH, this.snake.get(0).getY()));
            }
        } 
	
        else if (this.ismovingRIGHT) {
            // Same method repeated for if it is moving RIGHT, etc...
            if (this.snake.get(0).getX() <= (SnakeFrame.getFrameWidth() - WIDTH)) { 
            	this.snake.add(0, new GameObject(this.snake.get(0).getX() + WIDTH, this.snake.get(0).getY()));
            } 
            else {
            	this.snake.add(0, new GameObject(this.snake.get(0).getX() - SnakeFrame.getFrameWidth() - WIDTH, this.snake.get(0).getY()));
            }
        }

        else if (this.ismovingUP) {
            if (this.snake.get(0).getY() >= 95) { 
            	this.snake.add(0, new GameObject(this.snake.get(0).getX(), this.snake.get(0).getY() - WIDTH));
            }
            else { 
            	this.snake.add(0, new GameObject(this.snake.get(0).getX(), this.snake.get(0).getY() + SnakeFrame.getFrameHeight() - 90 - WIDTH));
        	}
        }

        else if (this.ismovingDOWN) {
            if (this.snake.get(0).getY() <= SnakeFrame.getFrameHeight() - WIDTH) { this.snake.add(0, new GameObject(this.snake.get(0).getX(), this.snake.get(0).getY() + WIDTH));
            }
	    else {
                this.snake.add(0, new GameObject(this.snake.get(0).getX(), this.snake.get(0).getY() - SnakeFrame.getFrameHeight() + 90 + WIDTH));
            }
        }
        //increment the snake length
        this.snake_length++;
    }
	
}
