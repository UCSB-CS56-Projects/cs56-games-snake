package edu.ucsb.cs56.projects.games.snake;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import javax.swing.*;


public class FruitGenerator {

    public FruitGenerator() {}

    public static void generateNewFruit(GameObjectHandler GOH) {
	BasicFruit fruit_0 = chooseFruit();
	GOH.deleteAllFruits();
	GOH.addBasicFruit(fruit_0);
    }


    // RNG based function that randomly chooses a fruit
    private static BasicFruit chooseFruit() {
	Random rng = new Random();

	int rand1 = rng.nextInt(4);
	int rand2 = rng.nextInt(3);

	if(rand1 != 0) {
	    return new BasicFruit();
	} else {
	    if (rand2 == 0) {
		return new SpeedFruit();
	    } else if (rand2 == 1) {
		return new WidthFruit();
	    } else {
		return new GhostFruit();
	    }
	}
    }

    public static void MoveFruitRandomly(GameObjectHandler GOH) {
	BasicFruit fruit_0 = GOH.getBasicFruit(0);
	Rectangle fruit = new Rectangle(fruit_0.getX(), fruit_0.getY(), BasicFruit.WIDTH, BasicFruit.WIDTH);
	Rectangle head = new Rectangle(GOH.player_2.getGameObjectXPos(0), GOH.player_2.getGameObjectYPos(0), Snake.WIDTH, Snake.WIDTH);
	Rectangle head2 = new Rectangle(GOH.player_1.getGameObjectXPos(0), GOH.player_1.getGameObjectYPos(0), Snake.WIDTH, Snake.WIDTH);
	do {
	    fruit_0.setXYRandom();
	} while (head2.intersects(fruit_0.getX(), fruit_0.getY(), BasicFruit.WIDTH, BasicFruit.WIDTH) ||
		 head.intersects(fruit_0.getX(), fruit_0.getY(), BasicFruit.WIDTH, BasicFruit.WIDTH));
    }


}
