package edu.ucsb.cs56.projects.games.snake;
import java.util.ArrayList;
import java.awt.event.*;

/**
 * GameObjectHandler is a class that handles the creation of all GameObjects to be drawn, and is responsible for changing their data members.
 * <p>
 * This class also reads the key presses to change object state.
 * 
 * @author Marcellis Carr-Barfield
 * @see         GameObject
 */
public class GameObjectHandler implements KeyListener {
    //create private default position variables
    private int defaultX = SnakeFrame.getFrameWidth()/5*3;
    private int defaultY = SnakeFrame.getFrameHeight()/5*3;
    
    //create private snake objects since the GameObjectHandler is the only one changing their state.
    public Snake player_1; 
    public Snake player_2;
    
    /*
    //create private ints to store the time when an arrow or wasd key is pressed for a debounce
    //so that the snake cannot turn onto intself
    private int upStart = 0;
    private int downStart = 0;
    private int rightStart = 0;
    private int leftStart = 0;

    private int wStart = 0;
    private int aStart = 0;
    private int sStart = 0;
    private int dStart = 0;
    
    private Stopwatch watch = new Stopwatch();
    private final int debounce = 300;
    */


    //create a private ArrayList of basicFruits, in case we need to implement multiple fruit on screen later down the road.
    private ArrayList<BasicFruit> basicFruits = new ArrayList<BasicFruit>();

    
    
    /**
     * Default constructor. Initializes player_1 and player_2 back to their default positions.
     */
    public GameObjectHandler() {
	player_1 = new Snake(defaultX-150, defaultY-150);
	player_2 = new Snake(defaultX, defaultY);
    }
    
    /**Adds a BasicFruit object to the object handler.
     * @param fruit a BasicFruit object
     * @see BasicFruit
     */
    public void addBasicFruit(BasicFruit fruit){
	basicFruits.add(fruit);
    }
    
    /**Returns a BasicFruit with the given fruitNumber
     * @param fruitNumber The GameObjectHandler numbers each fruit in the order it receives them, starting with 0 
     * @see BasicFruit
     */
    public BasicFruit getBasicFruit(int fruitNumber){
	return basicFruits.get(fruitNumber);
    }
    
    /**Removes all BasicFruit objects from the GameObjectHandler
     * @see BasicFruit
     */
    public void deleteAllFruits(){
	this.basicFruits.removeAll(this.basicFruits);
    }
    
    
    
    /**Reinitializes both players to the default state
     * @see Snake
     */
    public void newPlayers(){
	player_1 = new Snake(defaultX-150, defaultY-150);
	player_2 = new Snake(defaultX, defaultY);
    }
    
    /**Restarts the indicated player to its initial state
     * @param playerNum the player to be restarted
     * @see Snake
     */
    public void restartPlayer(int playerNum){
	if (playerNum == 1){
	    player_1 = new Snake(defaultX-150, defaultY-150); 
	}
	else
	    player_2 = new Snake(defaultX, defaultY);
    }
    
    /**Respawns the given player to a random location
     * @param player the player to be respawned
     * @see Snake
     */
    public void respawnPlayer(Snake player){
	int x = (int) ((Math.random()*31 + 10) * Snake.WIDTH);
        int y = (int) ((Math.random()*31 + 10) * Snake.WIDTH);
        player.setGameObjectPos(x, y, 0);
        player.setGameObjectPos(x, y + Snake.WIDTH, 1);
        player.setGameObjectPos(x, y + (2*Snake.WIDTH), 2);
    }
    /**
     * When a key is pressed, change the snake's direction and indicate that it has turned
     * 
     * @param e A KeyEvent object
     * @see KeyEvent
     */
    
    public void keyPressed(KeyEvent e){	
	int key = e.getKeyCode();
	// If the user presses an arrow key, change the direction values
	// Don't allow the direction to directly reverse; and dont allow direction to change near the edges

	
	if (key == KeyEvent.VK_LEFT) {
	    if ((player_1.getDirection() != Snake.RIGHT) && 
		(player_1.getGameObjectYPos(0) > Snake.WIDTH) && 
		(player_1.getGameObjectYPos(0)) < (SnakeFrame.getFrameHeight() - Snake.WIDTH) &&
		(player_1.hasTurned())) 
            	{
		    player_1.setDirection(Snake.LEFT);
		    player_1.turn();
		    SnakeFrame.waitFlag = false;
		}
	} else if (key == KeyEvent.VK_RIGHT) {
	    if ((player_1.getDirection() != Snake.LEFT) && 
		(player_1.getGameObjectYPos(0) > Snake.WIDTH) && 
		(player_1.getGameObjectYPos(0) < (SnakeFrame.getFrameHeight() - Snake.WIDTH)) &&
		(player_1.hasTurned())) 
		{
		    player_1.setDirection(Snake.RIGHT);
		    player_1.turn();
		    SnakeFrame.waitFlag = false;
		}
	} else if (key == KeyEvent.VK_UP) {
	    if ((player_1.getDirection() != Snake.DOWN) &&
		(player_1.getGameObjectXPos(0) < (SnakeFrame.getFrameWidth() - Snake.WIDTH)) &&
		(player_1.getGameObjectXPos(0) > Snake.WIDTH) &&
		(player_1.hasTurned())) 
		{
		    player_1.setDirection(Snake.UP);
		    player_1.turn();
		    SnakeFrame.waitFlag = false;
		}
	} else if (key == KeyEvent.VK_DOWN) {
	    
	    if ((player_1.getDirection() != Snake.UP) &&
		(player_1.getGameObjectXPos(0) < (SnakeFrame.getFrameWidth() - Snake.WIDTH)) &&
		(player_1.getGameObjectXPos(0) > Snake.WIDTH) &&
		(player_1.hasTurned())) 
		{
		    player_1.setDirection(Snake.DOWN);
		    player_1.turn();
		    SnakeFrame.waitFlag = false;
		}
	}
	// Create key listeners for player movement for second player WASD
	if (key == KeyEvent.VK_A) {
	    if ((player_2.getDirection() != Snake.RIGHT) &&
		(player_2.getGameObjectYPos(0) > Snake.WIDTH) &&
		(player_2.getGameObjectYPos(0) < (SnakeFrame.getFrameHeight() - Snake.WIDTH)) &&
		(player_2.hasTurned())) {
		player_2.setDirection(Snake.LEFT);
		player_2.turn();
		SnakeFrame.waitFlag = false;
	    }
	} else if (key == KeyEvent.VK_D) {
	    if ((player_2.getDirection() != Snake.LEFT) &&
		(player_2.getGameObjectYPos(0) > Snake.WIDTH) &&
		(player_2.getGameObjectYPos(0) < (SnakeFrame.getFrameHeight() - Snake.WIDTH)) &&
		(player_2.hasTurned())) {
		player_2.setDirection(Snake.RIGHT);
		player_2.turn();
		SnakeFrame.waitFlag = false;
	    }
	} else if (key == KeyEvent.VK_W) {
	    if ((player_2.getDirection() != Snake.DOWN) &&
		(player_2.getGameObjectXPos(0) < (SnakeFrame.getFrameWidth() - Snake.WIDTH)) &&
		(player_2.getGameObjectXPos(0) > Snake.WIDTH) &&
		(player_2.hasTurned())) {
		player_2.setDirection(Snake.UP);
		player_2.turn();
		SnakeFrame.waitFlag = false;
	    }
	} else if (key == KeyEvent.VK_S) {
	    
	    if ((player_2.getDirection() != Snake.UP) &&
		(player_2.getGameObjectXPos(0) < (SnakeFrame.getFrameWidth() - Snake.WIDTH)) &&
		(player_2.getGameObjectXPos(0) > Snake.WIDTH) &&
		(player_2.hasTurned())) {
		player_2.setDirection(Snake.DOWN);
		player_2.turn();
		SnakeFrame.waitFlag = false;
	    }
	}
    }
    /*
    @Override    
    public void keyPressed(KeyEvent e){
	int currentTimeInMilli = (((watch.getHour() * 60) + watch.getMinutes())*60
				  + watch.getSeconds()) * 1000 + watch.getMillis();
	int key = e.getKeyCode();

	// If the user presses an arrow key, change the direction values
	// Don't allow the direction to directly reverse; and dont allow direction to change near the edges
	
	if (key == KeyEvent.VK_LEFT) {
	    if ((currentTimeInMilli-rightStart > debounce) && 
		(player_1.getDirection() != Snake.RIGHT) &&
		(player_1.getGameObjectYPos(0) > Snake.WIDTH) && 
		(player_1.getGameObjectYPos(0)) < (SnakeFrame.getFrameHeight() - Snake.WIDTH) &&
		(player_1.hasTurned()))
		{
		    player_1.setDirection(Snake.LEFT);
		    player_1.turn();
		    leftStart = currentTimeInMilli;
		    
		    
		} 
	} else if (key == KeyEvent.VK_RIGHT) {
	    if ((currentTimeInMilli-leftStart > debounce) &&
		(player_1.getDirection() != Snake.LEFT) &&
		(player_1.getGameObjectYPos(0) > Snake.WIDTH) && 
		(player_1.getGameObjectYPos(0) < (SnakeFrame.getFrameHeight() - Snake.WIDTH)) &&
		(player_1.hasTurned())) 
		{
		    player_1.setDirection(Snake.RIGHT);
		    player_1.turn();
		    rightStart = currentTimeInMilli;
		    }
	} else if (key == KeyEvent.VK_UP) {
	    if ((currentTimeInMilli-downStart > debounce) &&
		(player_1.getDirection() != Snake.DOWN) &&
		(player_1.getGameObjectXPos(0) < (SnakeFrame.getFrameWidth() - Snake.WIDTH)) &&
		(player_1.getGameObjectXPos(0) > Snake.WIDTH) &&
		(player_1.hasTurned())) 
		{
		    player_1.setDirection(Snake.UP);
		    player_1.turn();
		    upStart = currentTimeInMilli;
		}
	} else if (key == KeyEvent.VK_DOWN) {
	    
	    if ((currentTimeInMilli-upStart > debounce) &&
		(player_1.getDirection() != Snake.UP) &&
		(player_1.getGameObjectXPos(0) < (SnakeFrame.getFrameWidth() - Snake.WIDTH)) &&
		(player_1.getGameObjectXPos(0) > Snake.WIDTH) &&
		(player_1.hasTurned())) 
		{
		    player_1.setDirection(Snake.DOWN);
		    player_1.turn();
		    downStart = currentTimeInMilli;
		    }
	}
	// Create key listeners for player movement for second player WASD
	if (key == KeyEvent.VK_A) {
	    if ((currentTimeInMilli-dStart > debounce) &&
		(player_1.getDirection() != Snake.RIGHT) &&
		(player_2.getGameObjectYPos(0) > Snake.WIDTH) &&
		(player_2.getGameObjectYPos(0) < (SnakeFrame.getFrameHeight() - Snake.WIDTH)) &&
		(player_2.hasTurned())) {
		player_2.setDirection(Snake.LEFT);
		player_2.turn();
		aStart = currentTimeInMilli;
	    }
	} else if (key == KeyEvent.VK_D) {
	    if ((currentTimeInMilli-aStart > debounce) &&
		(player_1.getDirection() != Snake.LEFT) &&
		(player_2.getGameObjectYPos(0) > Snake.WIDTH) &&
		(player_2.getGameObjectYPos(0) < (SnakeFrame.getFrameHeight() - Snake.WIDTH)) &&
		(player_2.hasTurned())) {
		player_2.setDirection(Snake.RIGHT);
		player_2.turn();
		dStart = currentTimeInMilli;
	    }
	} else if (key == KeyEvent.VK_W) {
	    if ((currentTimeInMilli-sStart > debounce) &&
		(player_1.getDirection() != Snake.DOWN) &&
		(player_2.getGameObjectXPos(0) < (SnakeFrame.getFrameWidth() - Snake.WIDTH)) &&
		(player_2.getGameObjectXPos(0) > Snake.WIDTH) &&
		(player_2.hasTurned())) {
		player_2.setDirection(Snake.UP);
		player_2.turn();
		wStart = currentTimeInMilli;
	    }
	} else if (key == KeyEvent.VK_S) {
	    
	    if ((currentTimeInMilli-wStart > debounce) &&
		(player_1.getDirection() != Snake.UP) &&
		(player_2.getGameObjectXPos(0) < (SnakeFrame.getFrameWidth() - Snake.WIDTH)) &&
		(player_2.getGameObjectXPos(0) > Snake.WIDTH) &&
		(player_2.hasTurned())) {
		player_2.setDirection(Snake.DOWN);
		player_2.turn();
		sStart = currentTimeInMilli;
	    }
	}
    }
    */
    public void keyTyped(KeyEvent e){
    }


    public void keyReleased (KeyEvent e) {
    }
}
