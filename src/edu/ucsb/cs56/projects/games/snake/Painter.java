//@@@ TODO FYI this code is the paint method from SnakeFrame waiting to be implemented

/*package edu.ucsb.cs56.projects.games.snake;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import javax.swing.*;

public class Painter 
{
   //changed this to s
      
   public void paint(Graphics g) { //changed graphics to g
	//Painter paint = new Painter();
        // Create font
       // Begin painting
        // Get the offscreen graphics for double buffer
        g = offscreen.getGraphics();
        g.setFont(font1);
              // Create a menu screen for the initial launch, leave menu when spacebar is pressed
        if (menu == 0) {
            if (controls == false) {
	//	paint.paintFrame(this);
                // Paint display for main menu
                this.setSize(500,500);
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, s.getWidth(), s.getHeight());
                g.setColor(Color.GREEN);
		// TODO: Make the centering calculation below a method
                g.drawString("Snake", s.getWidth()/2-fm.stringWidth("Snake")/2, 80);
		String authorTitle="By: Sam Dowell, with Eric Huang, Sam Min";
                g.drawString(authorTitle, s.getWidth()/2-fm.stringWidth(authorTitle)/2, 110);
                
                
                // Paint box displaying whether 1 or 2 players is selected
		// TODO: explain these magic numbers.

                g.setColor(Color.WHITE);
                if (players == 1) {
                    g.fillRect(208, 182, 22, 22);
                } else if (players == 2) {
                    g.fillRect(264, 182, 22, 22);
				}
                
                // Paint box for window size preference
                if (screenSize == 0){g.fillOval(11,263,160,40);}
                else if (screenSize == 1){g.fillOval(171,263,160,40);}
                else if (screenSize == 2){g.fillOval(331,263,160,40);}
                
                if (puddles == false){g.fillOval(150, 325, 140, 40);}
                else if(puddles == true){g.fillOval(290,325, 140,40);}
                
                
                g.setColor(Color.RED);
                g.drawString("Number of Players", s.getWidth() / 2 - fm.stringWidth("Number of Players") / 2, 170);
                g.setFont(font2);
                g.drawString("1      2", s.getWidth()/2 - fm.stringWidth("1      2")/2-15, 200);
                g.drawString("3)500 X 500    4)600 X 600    5)700 X 700", 20, 290);
                g.drawString("6)Normal    7)Puddles", s.getWidth() /2 - fm.stringWidth("6)Normal    7)Puddles")/2, 350);
                g.setFont(font1);
                g.drawString("Select window size: ", s.getWidth() /2 - fm.stringWidth("Select window size: ")/2, 250);
                g.drawString("Select mode: ", s.getWidth() /2 - fm.stringWidth("Select mode: ")/2, 320);
                g.drawString("Press Spacebar to Begin", s.getWidth() / 2 - fm.stringWidth("Press Spacebar to Begin") / 2, 410);
                g.drawString("How to Play [H]", s.getWidth() / 2 - fm.stringWidth("How to Play [H]") / 2, 380);
				g.setFont(font1);
		
		
		
            } else {
                // Display Control screen
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, s.getWidth(), s.getHeight());
                g.setColor(Color.GREEN);
                g.setFont(font0);
                g.drawString("Single Player", 50, 50);
                g.drawString("Controls:", 50, 70);
                g.drawString("\u2190\u2192", 105, 70); // Arrows.  See; http://en.wikipedia.org/wiki/Arrow_(symbol)
                g.drawString(" \u2191 ", 111, 63);
                g.drawString(" \u2193 ", 111, 78);
                g.drawString("How to Play:", 50, 90);
                g.drawString("Use the arrow keys to control", 50, 110);
                g.drawString("the snake and eat as many", 50, 125);
                g.drawString("apples as possible without", 50, 140);
                g.drawString("running into the tail.", 50, 155);
                g.drawString("Two Player", 250, 50);
                g.drawString("Controls:", 250, 70);
                g.drawString("Green Snake:", 305, 70);
                g.drawString("\u2190\u2192", 395, 70); // Arrows.  See; http://en.wikipedia.org/wiki/Arrow_(symbol)
                g.drawString(" \u2191 ", 401, 63);
                g.drawString(" \u2193 ", 401, 78);
                g.drawString("Orange Snake:  WASD", 305, 90);
                g.drawString("How to Play:", 250, 110);
                g.drawString("Each player must try to eat", 250, 130);
                g.drawString("as many apples as possible.", 250, 145);
                g.drawString("If you collide with your", 250, 160);
                g.drawString("tail or the other snake, your", 250, 175);
                g.drawString("tail will revert back to its", 250, 190);
                g.drawString("original size. If the heads", 250, 205);
                g.drawString("collide, both snakes will", 250, 220);
                g.drawString("revert to their original size.", 250, 235);
                g.drawString("A new fruit will appear every", 250, 250);
                g.drawString("thirty seconds if not eaten.", 250, 265);
                g.drawString("Have the biggest size when", 250, 280);
                g.drawString("the apples run out to win.", 250, 295);
                g.setColor(Color.WHITE);
                g.drawString("Puddle Mode:",50,190);
                g.drawString("In s mode, there will be", 40, 205);
                g.drawString("several puddles placed around", 40,220);
                g.drawString("the map which will hide some", 40,235);
                g.drawString("fruits as they spawn. The", 40,250);
                g.drawString("objective remains the same", 40,265);
                g.drawString("but are you up for the challenge?", 40,280);
                g.setColor(Color.ORANGE);
                g.drawString("Return to Menu [M]", s.getWidth() - 125, s.getHeight() - 25);

            }
	    
        } else if (pause == false) {
            if (players == 1) {
                // If the player has not yet lost, paint the next image of snake movement
                if (loser == 0) {
                    // Set the color to green to paint the background
                    Color c = new Color(24,107,31);
                    Color b = new Color(61,226,235);
					g.setColor(c);
					//Set window size
                    if (screenSize == 0)
                    {
						s.setSize(500,500);
					}
                    else if (screenSize == 1)
                    {
						s.setSize(600,600);
					}
                    else if (screenSize == 2)
                    {
						s.setSize(700,700);
					}
                    g.fillRect(0,0,700,700);
                    
                    // Set color to red and paint the fruit
                    g.setColor(Color.RED);
                    g.fillRect(particlex, particley, fWIDTH, fWIDTH);
                    if(puddles){
						g.setColor(b);
						g.fillOval(50,90,100,50);
						g.fillOval(s.getWidth()-120,200, 60, 90);
						g.fillOval(s.getWidth()/3,s.getHeight()-300,80,30); 
						g.fillOval(80,s.getHeight()-100,110,60);
						g.fillOval(s.getWidth()-200,s.getHeight()-100,70,70);
                    }
                    // Set the growsnake value to false
                    growsnake = false;
                    // Set the headcolor value to 0
                    headcolor = 0;
                    for (GameObject t : player1) {
                        // Make color of first block (head) black
                        if (headcolor == 0) {
                            g.setColor(Color.BLACK);
                            // Make the rest of the snake green
                        } else {
                            g.setColor(Color.GREEN);
                        }
                        // Set turn back to 0 to indicate that the turn has been displayed
                        turn = 0;
                        // Add to headcolor counter so that only the first block is black
                        headcolor++;
                        // Create rectangles for the snake head and the fruit in order to check for intersection
                        Rectangle r = new Rectangle(t.getX(), t.getY(), WIDTH, WIDTH);
                        Rectangle fruit = new Rectangle(particlex, particley, fWIDTH, fWIDTH);
                        Rectangle head = new Rectangle(player1.get(0).getX(), player1.get(0).getY(), WIDTH, WIDTH);
                        // Paint the snake
                        g.fillRect(t.getX(), t.getY(), WIDTH, WIDTH);
                        // If the Snake head intersects with fruit, randomly generate new location for fruit away from the snake
                        if (head.intersects(fruit)) {
                            while (head.intersects(particlex, particley, WIDTH, WIDTH)) {
                                                particlex = gen.nextInt(s.getWidth()/WIDTH-3)*WIDTH + 2*WIDTH;
								particley = gen.nextInt(s.getWidth()/WIDTH-3)*WIDTH + 2*WIDTH;
                            }
                            // Set growsnake to true to increase size of snake by 1
                            growsnake = true;
                            // Add to score
                            score++;
                        }
			
			
                    }
		    
                    // If the Snake ate a fruit, make the snake grow one block 
                    if (growsnake) {
                        s.shiftSnake();
                    }
                    // Check for if fruit relocated on top of tail
                    do {
                        hasIntersected = false;
                        for (int i = 0; i < player1.size(); i++) {
                            Rectangle r = new Rectangle(player1.get(i).getX(), player1.get(i).getY(), WIDTH, WIDTH);
                            Rectangle fruit = new Rectangle(particlex, particley, fWIDTH, fWIDTH);
                            if (r.intersects(fruit)) {
                                while (r.intersects(particlex, particley, fWIDTH, fWIDTH)) {
                                    particlex = gen.nextInt(s.getWidth()/WIDTH-3)*WIDTH + 2*WIDTH;
									particley = gen.nextInt(s.getWidth()/WIDTH-3)*WIDTH + 2*WIDTH;
                                    hasIntersected = true;
                                    System.out.println("hasIntersected");
                                }
                            }
                        }
                    } while (hasIntersected);
                    // Create loop to check if the head has intersected the tail (Game Over)
                    for (int i = player1.size() - 1; i > 1; i--) {
                        // Create rectangle for head and for a Tail in the ArrayList
                        Rectangle p = new Rectangle(player1.get(i).getX(), player1.get(i).getY(), WIDTH, WIDTH);
                        Rectangle head = new Rectangle(player1.get(0).getX(), player1.get(0).getY(), WIDTH, WIDTH);
                        // If the head intersects with the Tail, add one to loss counter
                        if (head.intersects(p)) {
                            loser++;
                            // This is to prevent the head from being overlapped by the green tail in the final image
                            g.setColor(Color.BLACK);
                            g.fillRect(player1.get(1).getX(), player1.get(1).getY(), WIDTH, WIDTH);
                            // Set color to red and fill the tail block which the head intersected with
                            g.setColor(Color.RED);
                            g.fillRect(player1.get(i).getX(), player1.get(i).getY(), WIDTH, WIDTH);
                        }
                    }
                    // Display the score and time
                    g.setColor(Color.WHITE);
                    g.drawString("Score: " + score, 50, 50);
                    g.drawString("High Score: " + highScore,50,80);
                    //display variables
                    //g.drawString("getWidth: " + s.getWidth() + ", screenSize: " + screenSize + ", loser: " + loser, 50, 100);
                    g.drawString("Time: " + watch.toString(), s.getWidth() - 50 - fm.stringWidth("Time: " + watch.toString()), 50);
                    //350
                    // Display Pause option if game is in progress
                    if (loser == 0) {
                        g.drawString("[P] to Pause", s.getWidth() - 50 - fm.stringWidth("[P] to Pause"), s.getHeight() - 25);
                    }
                }
                if (loser > 0) {
                    // If the player has lost, display message
                    g.setColor(Color.RED);
                    g.drawString("Game Over!", s.getWidth() / 2 - fm.stringWidth("Game Over!") / 2, 240);
                    g.setColor(Color.WHITE);
                    g.drawString("Do you want to play again?", s.getWidth() / 2 - fm.stringWidth("Do you want to play again?") / 2, 260);
                    g.drawString("Yes [Y] or No [N]", s.getWidth() / 2 - fm.stringWidth("Yes [Y] or No [N]") / 2, 280);
                    g.drawString("Return to Menu [M]", s.getWidth() / 2 - fm.stringWidth("Return to Menu [M]") / 2, 300);
                }
            } else if (players == 2) {
                if (loser == 0) {
					Color c = new Color(24,107,31);
                    Color b = new Color(61,226,235);
					// Set the color to white to paint the background
					g.setColor(c);
					//Set window size
                    if (screenSize == 0)
                    {
						s.setSize(500,500);
					}
                    else if (screenSize == 1)
                    {
						s.setSize(600,600);
					}
                    else if (screenSize == 2)
                    {
						s.setSize(700,700);
					}
                    g.fillRect(0,0,700,700);
                    
                    // Set color to Orange and paint the fruit                    
                    g.setColor(Color.RED);
                    g.fillRect(particlex, particley, fWIDTH, fWIDTH);
                    if(puddles){
						g.setColor(b);
						g.fillOval(50,90,100,50);
						g.fillOval(s.getWidth()-120,200, 60, 90);
						g.fillOval(s.getWidth()/3,s.getHeight()-300,80,30); 
						g.fillOval(80,s.getHeight()-100,110,60);
						g.fillOval(s.getWidth()-200,s.getHeight()-100,70,70);
                    }
                    // Set the growsnake value to false
                    growsnake = false;
                    growsnake2 = false;
                    // Set the headcolor value to 0
                    headcolor = 0;
                    for (GameObject t : player1) {
                        // Make color of first block (head) black
                        if (headcolor == 0) {
                            g.setColor(Color.BLACK);
                            // Make the rest of the snake green
                        } else {
                            g.setColor(Color.GREEN);
                        }
                        // Set turn back to 0 to indicate that the turn has been displayed
                        turn = 0;
                        // Add to headcolor counter so that only the first block is black
                        headcolor++;
                        // Create rectangles for the snake head and the fruit in order to check for intersection
                        Rectangle r = new Rectangle(t.getX(), t.getY(), WIDTH, WIDTH);
                        Rectangle fruit = new Rectangle(particlex, particley, fWIDTH, fWIDTH);
                        Rectangle head = new Rectangle(player1.get(0).getX(), player1.get(0).getY(), WIDTH, WIDTH);
                        Rectangle head2 = new Rectangle(player2.get(0).getX(), player2.get(0).getY(), WIDTH, WIDTH);
                        // Paint the snake
                        g.fillRect(t.getX(), t.getY(), WIDTH, WIDTH);
                        // If the Snake head intersects with fruit, randomly generate new location for fruit away from the snake
                        if (head.intersects(fruit)) {
                            while (head.intersects(particlex, particley, fWIDTH, fWIDTH) || head2.intersects(particlex, particley, fWIDTH, fWIDTH)) {
                                                particlex = gen.nextInt(s.getWidth()/WIDTH-3)*WIDTH + 2*WIDTH;
								particley = gen.nextInt(s.getWidth()/WIDTH-3)*WIDTH + 2*WIDTH;
                            }
                            // Set growsnake to true to increase size of snake by 1
                            growsnake = true;
			    
                            // Add to score
                            score1++;
                            size1++;
                            fruits--;
                            fruittimer.start();
                        }
                    }
                    headcolor2 = 0;
                    for (GameObject t : player2) {
                        // Make color of first block (head) black
                        if (headcolor2 == 0) {
                            g.setColor(Color.BLACK);
                            // Make the rest of the snake green
                        } else {
                            g.setColor(Color.ORANGE);
                        }
                        // Set turn back to 0 to indicate that the turn has been displayed
                        turn2 = 0;
                        // Add to headcolor counter so that only the first block is black
                        headcolor2++;
                        // Create rectangles for the snake head and the fruit in order to check for intersection
                        Rectangle r = new Rectangle(t.getX(), t.getY(), WIDTH, WIDTH);
                        Rectangle fruit = new Rectangle(particlex, particley, fWIDTH, fWIDTH);
                        Rectangle head = new Rectangle(player2.get(0).getX(), player2.get(0).getY(), WIDTH, WIDTH);
                        Rectangle head2 = new Rectangle(player1.get(0).getX(), player1.get(0).getY(), WIDTH, WIDTH);
                        // Paint the snake
                        g.fillRect(t.getX(), t.getY(), WIDTH, WIDTH);
                        // If the Snake head intersects with fruit, randomly generate new location for fruit away from the snake
                        if (head.intersects(fruit)) {
                            while (head.intersects(particlex, particley, fWIDTH, fWIDTH) || head2.intersects(particlex, particley, fWIDTH, fWIDTH)) {
								particlex = gen.nextInt(s.getWidth()/WIDTH-3)*WIDTH + 2*WIDTH;
								particley = gen.nextInt(s.getWidth()/WIDTH-3)*WIDTH + 2*WIDTH;
                                
                            }
                            // Set growsnake to true to increase size of snake by 1
                            growsnake2 = true;

                            // Add to score
                            score2++;
                            size2++;
                            fruits--;
                            fruittimer.start();
                        }

			
                    }
		    
		    
                    // If the Snake ate a fruit, make the snake grow one block 
                    if (growsnake) {
                        shiftSnake();
                    }
                    if (growsnake2) {
                        shiftSnake2();
                    }
                    // Check for if fruit relocated on top of either snake, if so create new location and check again
                    do {
                        hasIntersected = false;
                        for (int i = 0; i < player1.size(); i++) {
                            Rectangle r = new Rectangle(player1.get(i).getX(), player1.get(i).getY(), WIDTH, WIDTH);
                            Rectangle fruit = new Rectangle(particlex, particley, fWIDTH, fWIDTH);
                            if (r.intersects(fruit)) {
                                while (r.intersects(particlex, particley, fWIDTH, fWIDTH)) {
									particlex = gen.nextInt(s.getWidth()/WIDTH-3)*WIDTH + 2*WIDTH;
									particley = gen.nextInt(s.getWidth()/WIDTH-3)*WIDTH + 2*WIDTH;
                                    hasIntersected = true;
                                    System.out.println("hasIntersected");
                                }
                            }
                        }
                        for (int i = 0; i < player2.size(); i++) {
                            Rectangle r = new Rectangle(player2.get(i).getX(), player2.get(i).getY(), WIDTH, WIDTH);
                            Rectangle fruit = new Rectangle(particlex, particley, fWIDTH, fWIDTH);
                            if (r.intersects(fruit)) {
                                while (r.intersects(particlex, particley, WIDTH, WIDTH)) {
									particlex = gen.nextInt(s.getWidth()/WIDTH-3)*WIDTH + 2*WIDTH;
									particley = gen.nextInt(s.getWidth()/WIDTH-3)*WIDTH + 2*WIDTH;
                                    hasIntersected = true;
                                    System.out.println("hasIntersected");
                                }
                            }
                        }
                    } while (hasIntersected);
                    // Check for collisions between snakes if the game has not yet ended
                    if (fruits > 0) {
                        Rectangle p1head = new Rectangle(player1.get(0).getX(), player1.get(0).getY(), WIDTH, WIDTH);
                        Rectangle p2head = new Rectangle(player2.get(0).getX(), player2.get(0).getY(), WIDTH, WIDTH);
                        if (p1head.intersects(p2head)) {
                            ismovingRIGHT = false;
                            ismovingLEFT = false;
                            ismovingUP = true;
                            ismovingDOWN = false;
                            player1.clear();
                            for (int j = 0; j < 3; j++) {
                                player1.add(new GameObject(playerx, playery));
                            }
                            // Set starting positions for the tail
                            player1.get(0).setPos(s.getWidth() - 150, s.getHeight() - 150);
                            player1.get(1).setPos(s.getWidth() - 150, s.getHeight() - 135);
                            player1.get(2).setPos(s.getWidth() - 150, s.getHeight() - 120);
                            ismovingRIGHT2 = false;
                            ismovingLEFT2 = false;
                            ismovingUP2 = true;
                            ismovingDOWN2 = false;
                            player2.clear();
                            for (int j = 0; j < 3; j++) {
                                player2.add(new GameObject(400, 400));
                            }
                            player2.get(0).setPos(150, s.getHeight() - 150);
                            player2.get(1).setPos(150, s.getHeight() - 135);
                            player2.get(2).setPos(150, s.getHeight() - 120);
                            size1 = 3;
                            size2 = 3;
                        }
                        // Create loop to check if the head has intersected the tail (Game Over)
                        hasIntersected = false;
                        for (int i = player1.size() - 1; i > 1; i--) {
                            // Create rectangle for head and for a Tail in the ArrayList
                            Rectangle p = new Rectangle(player1.get(i).getX(), player1.get(i).getY(), WIDTH, WIDTH);
                            Rectangle head = new Rectangle(player1.get(0).getX(), player1.get(0).getY(), WIDTH, WIDTH);
                            // If the head intersects with the Tail, add one to loss counter
                            if (head.intersects(p)) {
                                ismovingRIGHT = false;
                                ismovingLEFT = false;
                                ismovingUP = true;
                                ismovingDOWN = false;
                                player1.clear();
                                for (int j = 0; j < 3; j++) {
                                    player1.add(new GameObject(playerx, playery));
                                }
                                int x = (gen.nextInt(31) + 10) * WIDTH;
                                int y = (gen.nextInt(31) + 10) * WIDTH;
                                // Set starting positions for the tail
                                player1.get(0).setPos(x, y);
                                player1.get(1).setPos(x, y + WIDTH);
                                player1.get(2).setPos(x, y + (2*WIDTH));
                                size1 = 3;
                                hasIntersected = true;
                                break;
                            }
                        }
                        // Check for if the new random location is on top of the other snake
                        // In this case create a new random location
                        while (hasIntersected) {
                            hasIntersected = false;
                            for (int j = 0; j < player1.size(); j++) {
                                for (int i = 0; i < player2.size(); i++) {
                                    Rectangle box1 = new Rectangle(player1.get(j).getX(), player1.get(j).getY(), WIDTH, WIDTH);
                                    Rectangle box2 = new Rectangle(player2.get(i).getX(), player2.get(i).getY(), WIDTH, WIDTH);
                                    if (box1.intersects(box2)) {
                                        hasIntersected = true;
                                        player1.clear();
                                        for (int p = 0; p < 3; p++) {
                                            player1.add(new GameObject(playerx, playery));
                                        }
                                        int x = (gen.nextInt(31) + 10) * WIDTH;
                                        int y = (gen.nextInt(31) + 10) * WIDTH;
                                        // Set starting positions for the tail
                                        player1.get(0).setPos(x, y);
                                        player1.get(1).setPos(x, y + WIDTH);
                                        player1.get(2).setPos(x, y + WIDTH);
                                        System.out.println("tail reset");
                                    }
                                }
                            }
                        }
                        // Check for head on collision, if so reset both snakes
                        boolean headon = false;
                        for (int q = player2.size() - 1; q > 0; q--) {
                            Rectangle p2tail = new Rectangle(player2.get(q).getX(), player2.get(q).getY(), WIDTH, WIDTH);
                            Rectangle head = new Rectangle(player1.get(0).getX(), player1.get(0).getY(), WIDTH, WIDTH);
                            if (head.intersects(p2tail)) {
                                for (int w = player1.size() - 1; w > 0; w--) {
                                    Rectangle p1tail = new Rectangle(player1.get(w).getX(), player1.get(w).getY(), WIDTH, WIDTH);
                                    Rectangle head1 = new Rectangle(player2.get(0).getX(), player2.get(0).getY(), WIDTH, WIDTH);
                                    // If both heads intersect the tail of the other respective tail, a head on collision has occured
                                    // In this case reset both tails
                                    if (head1.intersects(p1tail)) {
                                        ismovingRIGHT = false;
                                        ismovingLEFT = false;
                                        ismovingUP = true;
                                        ismovingDOWN = false;
                                        player1.clear();
                                        for (int j = 0; j < 3; j++) {
                                            player1.add(new GameObject(playerx, playery));
                                        }
                                        // Set starting positions for the tail
                                        player1.get(0).setPos(s.getWidth() - 150, s.getHeight() - 150);
                                        player1.get(1).setPos(s.getWidth() - 150, s.getHeight() - 135);
                                        player1.get(2).setPos(s.getWidth() - 150, s.getHeight() - 120);
                                        ismovingRIGHT2 = false;
                                        ismovingLEFT2 = false;
                                        ismovingUP2 = true;
                                        ismovingDOWN2 = false;
                                        player2.clear();
                                        for (int j = 0; j < 3; j++) {
                                            player2.add(new GameObject(400, 400));
                                        }
                                        player2.get(0).setPos(150, s.getHeight() - 150);
                                        player2.get(1).setPos(150, s.getHeight() - 135);
                                        player2.get(2).setPos(150, s.getHeight() - 120);
                                        size1 = 3;
                                        size2 = 3;
                                        headon = true;
                                        break;
                                    }
				    
                                }
                                // Otherwise, just reset player 1's tail
                                if (!headon) {
                                    hasIntersected = true;
                                    ismovingRIGHT = false;
                                    ismovingLEFT = false;
                                    ismovingUP = true;
                                    ismovingDOWN = false;
                                    player1.clear();
                                    for (int j = 0; j < 3; j++) {
                                        player1.add(new GameObject(playerx, playery));
                                    }
                                    int x = (gen.nextInt(31) + 10) * WIDTH;
                                    int y = (gen.nextInt(31) + 10) * WIDTH;
                                    // Set starting positions for the tail
                                    player1.get(0).setPos(x, y);
                                    player1.get(1).setPos(x, y + WIDTH);
                                    player1.get(2).setPos(x, y + (2*WIDTH));
                                    size1 = 3;
                                }
                            }
                        }
                        // If the new random location for one snake if on top of the others tail, create new random location
                        while (hasIntersected) {
                            hasIntersected = false;
                            for (int j = 0; j < player1.size(); j++) {
                                for (int i = 0; i < player2.size(); i++) {
                                    Rectangle box1 = new Rectangle(player1.get(j).getX(), player1.get(j).getY(), WIDTH, WIDTH);
                                    Rectangle box2 = new Rectangle(player2.get(i).getX(), player2.get(i).getY(), WIDTH, WIDTH);
                                    if (box1.intersects(box2)) {
                                        hasIntersected = true;
                                        player1.clear();
                                        for (int p = 0; p < 3; p++) {
                                            player1.add(new GameObject(playerx, playery));
                                        }
                                        int x = (gen.nextInt(31) + 10) * WIDTH;
                                        int y = (gen.nextInt(31) + 10) * (2*WIDTH);
                                        // Set starting positions for the tail
                                        player1.get(0).setPos(x, y);
                                        player1.get(1).setPos(x, y + WIDTH);
                                        player1.get(2).setPos(x, y + (2*WIDTH));
                                        System.out.println("tail reset");
                                    }
                                }
                            }
                        }
                        // Check for collision between the second player and his own tail
                        for (int i = player2.size() - 1; i > 1; i--) {
                            // Create rectangle for head and for a Tail in the ArrayList
                            Rectangle p = new Rectangle(player2.get(i).getX(), player2.get(i).getY(), WIDTH, WIDTH);
                            Rectangle head = new Rectangle(player2.get(0).getX(), player2.get(0).getY(), WIDTH, WIDTH);
                            if (head.intersects(p)) {
                                hasIntersected = true;
                                ismovingRIGHT2 = false;
                                ismovingLEFT2 = false;
                                ismovingUP2 = true;
                                ismovingDOWN2 = false;
                                player2.clear();
                                for (int j = 0; j < 3; j++) {
                                    player2.add(new GameObject(400, 400));
                                }
                                int x = (gen.nextInt(31) + 10) * WIDTH;
                                int y = (gen.nextInt(31) + 10) * WIDTH;
                                player2.get(0).setPos(x, y);
                                player2.get(1).setPos(x, y + WIDTH);
                                player2.get(2).setPos(x, y + (2*WIDTH));
                                size2 = 3;
                                break;
                            }
                        }
                        // If the new location for player 2 is on player 1's tail, create new random location for player 2's tail
                        while (hasIntersected) {
                            hasIntersected = false;
                            for (int j = 0; j < player1.size(); j++) {
                                for (int i = 0; i < player2.size(); i++) {
                                    Rectangle box1 = new Rectangle(player1.get(j).getX(), player1.get(j).getY(), WIDTH, WIDTH);
                                    Rectangle box2 = new Rectangle(player2.get(i).getX(), player2.get(i).getY(), WIDTH, WIDTH);
                                    if (box1.intersects(box2)) {
                                        hasIntersected = true;
                                        player2.clear();
                                        for (int p = 0; p < 3; p++) {
                                            player2.add(new GameObject(playerx, playery));
                                        }
                                        int x = (gen.nextInt(31) + 10) * WIDTH;
                                        int y = (gen.nextInt(31) + 10) * WIDTH;
                                        // Set starting positions for the tail
                                        player2.get(0).setPos(x, y);
                                        player2.get(1).setPos(x, y + WIDTH);
                                        player2.get(2).setPos(x, y + (2*WIDTH));
                                        System.out.println("tail reset");
                                    }
                                }
                            }
                        }
                        // Check for intersection from player 2's head to player 1's tail
                        for (int w = player1.size() - 1; w > 0; w--) {
                            Rectangle p1tail = new Rectangle(player1.get(w).getX(), player1.get(w).getY(), WIDTH, WIDTH);
                            Rectangle head = new Rectangle(player2.get(0).getX(), player2.get(0).getY(), WIDTH, WIDTH);
                            if (head.intersects(p1tail)) {
                                hasIntersected = true;
                                ismovingRIGHT2 = false;
                                ismovingLEFT2 = false;
                                ismovingUP2 = true;
                                ismovingDOWN2 = false;
                                player2.clear();
                                for (int j = 0; j < 3; j++) {
                                    player2.add(new GameObject(400, 400));
                                }
                                int x = (gen.nextInt(31) + 10) * WIDTH;
                                int y = (gen.nextInt(31) + 10) * WIDTH;
                                player2.get(0).setPos(x, y);
                                player2.get(1).setPos(x, y + WIDTH);
                                player2.get(2).setPos(x, y + (2*WIDTH));
                                size2 = 3;
                            }

                        }
                        // If the new random location for player 2 is atop player 1's tail
                        // Create new random location until a good location is found
                        while (hasIntersected) {
                            hasIntersected = false;
                            for (int j = 0; j < player1.size(); j++) {
                                for (int i = 0; i < player2.size(); i++) {
                                    Rectangle box1 = new Rectangle(player1.get(j).getX(), player1.get(j).getY(), WIDTH, WIDTH);
                                    Rectangle box2 = new Rectangle(player2.get(i).getX(), player2.get(i).getY(), WIDTH, WIDTH);
                                    if (box1.intersects(box2)) {
                                        hasIntersected = true;
                                        player2.clear();
                                        for (int p = 0; p < 3; p++) {
                                            player2.add(new GameObject(playerx, playery));
                                        }
                                        int x = (gen.nextInt(31) + 10) * WIDTH;
                                        int y = (gen.nextInt(31) + 10) * WIDTH;
                                        // Set starting positions for the tail
                                        player2.get(0).setPos(x, y);
                                        player2.get(1).setPos(x, y + WIDTH);
                                        player2.get(2).setPos(x, y + (2*WIDTH));
                                        System.out.println("tail reset");
                                    }
                                }
                            }
                        }
                    }
                    // Display the score and time
                    g.setColor(Color.WHITE);
                    g.drawString("Orange Score: " + score2, 50, 50);
                    g.drawString("Orange Size: " + size2, 50, 75);
                    g.drawString("Time: " + watch.toString(), s.getWidth() / 2 - fm.stringWidth("Time: " + watch.toString()) / 2, 50);
                    g.drawString("New Fruit in: " + (30 - fruittimer.getSeconds()), s.getWidth() / 2 - fm.stringWidth("New Fruit in: " + (30 - fruittimer.getSeconds())) / 2, 100);
                    g.drawString("Fruit Remaining: " + fruits, s.getWidth() / 2 - fm.stringWidth("Fruit Remaining: " + fruits) / 2, 75);
                    g.drawString("Green Score: " + score1, s.getWidth() - 50 - fm.stringWidth("Green score: " + 1), 50);
                    g.drawString("Green Size: " + size1, s.getWidth() - 50 - fm.stringWidth("Green score: " + 1), 75);
                    //display varaibles
                    //g.drawString("getWidth: " + this.getWidth() + ", screenSize: " + screenSize + ", loser: " + loser, 50, 120);
                    // Display Pause option if game is in progress
                    if (loser == 0) {
                        g.drawString("[P] to Pause", s.getWidth() - 50 - fm.stringWidth("[P] to Pause"), s.getHeight() - 25);
                    }
                }
                if (loser > 0) {
                    // If the player has lost, display message
                    g.setColor(Color.RED);
                    g.drawString("Game Over!", s.getWidth() / 2 - fm.stringWidth("Game Over!") / 2, 280);
                    g.setColor(Color.WHITE);
                    if (size1 == size2) {
                        g.drawString("Tie Game!", s.getWidth() / 2 - fm.stringWidth("Tie Game!") / 2, 300);
                    } else if (size1 > size2) {
                        g.drawString("Green Wins!", s.getWidth() / 2 - fm.stringWidth("Green Wins!") / 2, 300);
                    } else if (size2 > size1) {
                        g.drawString("Orange Wins!", s.getWidth() / 2 - fm.stringWidth("Orange Wins!") / 2, 300);
                    }
                    g.drawString("Do you want to play again?", s.getWidth() / 2 - fm.stringWidth("Do you want to play again?") / 2, 320);
                    g.drawString("Yes [Y] or No [N]", s.getWidth() / 2 - fm.stringWidth("Yes [Y] or No [N]") / 2, 340);
                    g.drawString("Return to Menu [M]", s.getWidth() / 2 - fm.stringWidth("Return to Menu [M]") / 2, 360);
                }
            }

        }            // If the player pauses, display that the game is paused and the resume option

        if (pause == true && players == 1) {
			g.setColor(Color.WHITE);
            g.drawString("Paused", s.getWidth() / 2 - fm.stringWidth("Paused") / 2, 250);
            g.drawString("[P] to Resume", s.getWidth() / 2 - fm.stringWidth("[P] to Resume") / 2, 270);
            g.drawString("[M] Return to Menu", s.getWidth() / 2 - fm.stringWidth("[M] Return to Menu") / 2, 290);
        } else if (pause == true && players== 2) {
            g.setColor(Color.WHITE);
            g.drawString("Paused", s.getWidth() / 2 - fm.stringWidth("Paused") / 2, 375);
            g.drawString("[P] to Resume", s.getWidth() / 2 - fm.stringWidth("[P] to Resume") / 2, 395);
            g.drawString("[M] Return to Menu", s.getWidth() / 2 - fm.stringWidth("[M] Return to Menu") / 2, 415);
        }
        // Prepare next image for double buffer

        graph.drawImage(offscreen, 0, 0, s);
    }
}
*/ 
