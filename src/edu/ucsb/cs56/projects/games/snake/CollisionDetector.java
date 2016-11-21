package edu.ucsb.cs56.projects.games.snake;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import javax.swing.*;


public class CollisionDetector extends JFrame {

    public CollisionDetector() {
    }
    
    public static boolean headToTailCollision(Snake player, int playerNumber, int width, GameObjectHandler goh){
	for (int i = player.size() - 1; i > 1; i--) {
	    // Create rectangle for head and for a Tail in the ArrayList
	    Rectangle p = new Rectangle(player.getGameObjectXPos(i), player.getGameObjectYPos(i), width, width);
	    Rectangle head = new Rectangle(player.getGameObjectXPos(0), player.getGameObjectYPos(0), width, width);
	    // If the head intersects with the Tail, add one to loss counter
	    if (head.intersects(p)) {
		if (playerNumber == 1)
		    goh.respawnPlayer(goh.player_1);
		else{
		    goh.respawnPlayer(goh.player_2);
		}
		return true;
	    }
	}
	return false;
    }

    public static int headToTailCollisionSinglePlayer(GameObjectHandler GOH, int width, Graphics g){
	int loser = 0;
	for (int i = GOH.player_1.size() - 1; i > 1; i--) {
	    // Create rectangle for head and for a Tail in the ArrayList
	    Rectangle p = new Rectangle(GOH.player_1.getGameObjectXPos(i), GOH.player_1.getGameObjectYPos(i), width, width);
	    Rectangle head = new Rectangle(GOH.player_1.getGameObjectXPos(0), GOH.player_1.getGameObjectYPos(0), width, width);
	    // If the head intersects with the Tail, add one to loss counter
	    if (head.intersects(p)) {
		loser++;
		// This is to prevent the head from being overlapped by the green tail in the final image
		g.setColor(Color.BLACK);
		g.fillRect(GOH.player_1.getGameObjectXPos(1), GOH.player_1.getGameObjectYPos(1), width, width);
		// Set color to red and fill the tail block which the head intersected with
		g.setColor(Color.RED);
		g.fillRect(GOH.player_1.getGameObjectXPos(i), GOH.player_1.getGameObjectYPos(i), width, width);
	    }
	}
	return loser;
    }

    public static void fruitRespawnCollisionDetect(int numPlayers, GameObjectHandler GOH, int snakeWidth, int fruitWidth) {
	boolean hasIntersected = false;
	do {
	    hasIntersected = false;
	    for (int i = 0; i < GOH.player_1.size(); i++) {
		Rectangle r = new Rectangle(GOH.player_1.getGameObjectXPos(i), GOH.player_1.getGameObjectYPos(i), snakeWidth, snakeWidth);
		Rectangle fruit = new Rectangle(GOH.getBasicFruit(0).getX(), GOH.getBasicFruit(0).getY(), fruitWidth, fruitWidth);
		if (r.intersects(fruit)) {
		    hasIntersected = handleFruitIntersection(GOH, fruitWidth, r);
		}
	    }
	    if (numPlayers == 2){
		for (int i = 0; i < GOH.player_2.size(); i++) {
		    Rectangle r = new Rectangle(GOH.player_2.getGameObjectXPos(i), GOH.player_2.getGameObjectYPos(i), snakeWidth, snakeWidth);
		    Rectangle fruit = new Rectangle(GOH.getBasicFruit(0).getX(), GOH.getBasicFruit(0).getY(), fruitWidth, fruitWidth);
		    if (r.intersects(fruit)) {
			hasIntersected = handleFruitIntersection(GOH, fruitWidth, r);
		    }
		}
	    }
	} while (hasIntersected);
    }

	public static void respawnCollisionPlayer(boolean hasIntersected, GameObjectHandler GOH, int player){
		while (hasIntersected) {
		    hasIntersected = false;
		    for (int j = 0; j < GOH.player_1.size(); j++) {
		        for (int i = 0; i < GOH.player_2.size(); i++) {
		            Rectangle box1 = new Rectangle(GOH.player_1.getGameObjectXPos(j), GOH.player_1.getGameObjectYPos(j), Snake.WIDTH, Snake.WIDTH);
		            Rectangle box2 = new Rectangle(GOH.player_2.getGameObjectXPos(i), GOH.player_2.getGameObjectYPos(i), Snake.WIDTH, Snake.WIDTH);
		            if (box1.intersects(box2)) {
		                hasIntersected = true;
		                if(player == 1) 
		                	GOH.respawnPlayer(GOH.player_1);
		                else 
		                	GOH.respawnPlayer(GOH.player_2); 
		            }
		        }
		    }
		}
	} 


    private static boolean handleFruitIntersection(GameObjectHandler GOH, int fruitWidth, Rectangle r){
	boolean hasIntersected = false;
	while (r.intersects(GOH.getBasicFruit(0).getX(), GOH.getBasicFruit(0).getY(), fruitWidth, fruitWidth)) {
	    FruitGenerator.generateNewFruit(GOH); 
	    hasIntersected = true;
	    System.out.println("hasIntersected");
	}

	return hasIntersected;
    }


    
}
