/*package edu.ucsb.cs56.projects.games.snake;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import javax.swing.*;

public class Painter {

   // private final int width;
   // private final int height;
      Graphics g;

    public void paintFrame(SnakeFrame snake){
 // Paint display for main menu
                snake.setSize(500,500);
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, snake.getWidth(), snake.getHeight());
                g.setColor(Color.GREEN);
                // TODO: Make the centering calculation below a method
                g.drawString("Snake", snake.getWidth()/2-snake.getFm().stringWidth("Snake")/2, 80);
                String authorTitle="By: Sam Dowell, with Eric Huang, Sam Min";
                g.drawString(authorTitle, snake.getWidth()/2-snake.getFm().stringWidth(authorTitle)/2, 110);


                // Paint box displaying whether 1 or 2 players is selected
                // TODO: explain these magic numbers.

                g.setColor(Color.WHITE);
                if (snake.getPlayers() == 1) {
                    g.fillRect(208, 182, 22, 22);
                } else if (snake.getPlayers() == 2) {
                    g.fillRect(264, 182, 22, 22);
                                }

                // Paint box for window size preference
                if (snake.getScreenSize() == 0){g.fillOval(11,263,160,40);}
                else if (snake.getScreenSize() == 1){g.fillOval(171,263,160,40);}
                else if (snake.getScreenSize() == 2){g.fillOval(331,263,160,40);}

                if (snake.getPuddles() == false){g.fillOval(150, 325, 140, 40);}
                else if(snake.getPuddles() == true){g.fillOval(290,325, 140,40);}


                g.setColor(Color.RED);
                g.drawString("Number of Players", snake.getWidth() / 2 - snake.getFm().stringWidth("Number of Players") / 2, 170);
                g.setFont(snake.getFont2());
                g.drawString("1      2", snake.getWidth()/2 - snake.getFm().stringWidth("1      2")/2-15, 200);
                g.drawString("3)500 X 500    4)600 X 600    5)700 X 700", 20, 290);
                g.drawString("6)Normal    7)Puddles", snake.getWidth() /2 - snake.getFm().stringWidth("6)Normal    7)Puddles")/2, 350);
                g.setFont(snake.getFont1());
                g.drawString("Select window size: ", snake.getWidth() /2 - snake.getFm().stringWidth("Select window size: ")/2, 250);
                g.drawString("Select mode: ", snake.getWidth() /2 - snake.getFm().stringWidth("Select mode: ")/2, 320);
                g.drawString("Press Spacebar to Begin", snake.getWidth() / 2 - snake.getFm().stringWidth("Press Spacebar to Begin") / 2, 410);
                g.drawString("How to Play [H]", snake.getWidth() / 2 - snake.getFm().stringWidth("How to Play [H]") / 2, 380);
                                g.setFont(snake.getFont1());
       }
}*/
