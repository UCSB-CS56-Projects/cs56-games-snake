package edu.ucsb.cs56.projects.games.snake;

/**
 * A class that paint the snake and modify its attribute depending
 * on user input
 * @author Sam Dowell (original)
 * @author Sam Min, Eric Huang (CS56, Spring 2013)
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import javax.swing.*;

//Note to self: SnakeFrame is similar to Game.java

public class SnakeFrame extends JFrame implements KeyListener,MouseListener {
	// This variable determines the speed of the snake, and corresponds to the difficulty
    private int speed= 75;

    // Establish variables
    // Starting X and Y coordinates for the snake playerx and playery
    private int playerx, playery;

    // X and Y coordinates for the fruit
    // Variable "turn" indicates if a directional change has been displayed
    private int particlex, particley, turn, turn2;

    HighScore temp = new HighScore(0);
    HighScore hScore = HighScore.loadHighScore();

    // Score of fruit eaten, Head color counter, win/loss variable
    private int score = 0, score1 = 0, highScore = hScore.getScore();
    private int score2 = 0, headcolor = 0, loser = 0, menu = 0, players = 1;
    private int headcolor2 = 0, size1 = 3, size2 = 3, fruits = 50, screenSize = 0;

    // Width of the snake
    private final int WIDTH = 15;
    private final int fWIDTH = 15;

    // Create random generator
    private Random gen = new Random();

    // Create an ArrayList for the Tail
    private ArrayList<GameObject> player1 = new ArrayList<GameObject>(3);
    private ArrayList<GameObject> player2 = new ArrayList<GameObject>(3);

    private boolean ismovingLEFT = false, ismovingRIGHT = false;
    private boolean ismovingUP = true, ismovingDOWN = false, growsnake = false;

    private boolean ismovingLEFT2 = false, ismovingRIGHT2 = false;
    private boolean ismovingUP2 = true, ismovingDOWN2 = false, growsnake2 = false;

    // Create boolean values for when to play again
    private boolean playagainyes = false, playagainno = false, pause = false;
    private boolean frameresized = false, controls = false, hasIntersected;

    // Create offscreen image for double buffering
    private Image offscreen;

    // Create graphics
    Graphics g;

    // Create stopwatch
    private Stopwatch watch = new Stopwatch();
    private Stopwatch fruittimer = new Stopwatch();
    private boolean puddles = false;
    
    public int getPlayers(){ return players;}
    public int getScreenSize(){ return screenSize;}
    public boolean getPuddles(){ return puddles;}  






	class task implements ActionListener{		
		@Override
		public void actionPerformed(ActionEvent e) {
		    doaction();
		}
	    };

    private task atask=new task();
    private Timer atime=new Timer(speed,atask);
    //JLabel label, m;
    //JButton button;
    
    /** Creates new form SnakeFrame */
    public SnakeFrame() {
	// Call JFrame constructor and give it the title "Snake"
        super("Snake");

        // Initialize components
        initComponents();

        // Set boundaries for playing field
        this.setSize(500,500);
        setLocationRelativeTo(null);
        this.setResizable(false);
	
        // Add a KeyListener
        addKeyListener(this);
        

        //mouse listener...........this is mouse listener
        addMouseListener(this);


        // Set player starting position
     	playerx=this.getWidth()/5*3;
     	playery=this.getHeight()/5*3;

        // Create random starting X and Y coordinate for fruit
        particley = gen.nextInt(this.getWidth()-50-115+1) + 115;
        particlex = gen.nextInt(this.getWidth()-50-25+1) + 25;
        
        // Create 3 starting blocks for Tail
        for (int i = 0; i < 3; i++) {
            player1.add(new GameObject(playerx, playery));
        }
        
        // Set starting positions for the tail
        player1.get(0).setPos(playerx,playery);
        player1.get(1).setPos(playerx,playery+WIDTH);
        player1.get(2).setPos(playerx,playery+(2*WIDTH));
        for (int i = 0; i < 3; i++) {
            player2.add(new GameObject(400, 400));
        }
        player2.get(0).setPos(playerx/3*2, playery);
        player2.get(1).setPos(playerx/3*2, playery+WIDTH);
        player2.get(2).setPos(playerx/3*2, playery+(2*WIDTH));

        // Create offscreen image
        offscreen = this.createImage(this.getWidth(), this.getHeight());

        // Create an ActionListener
	// ActionListener task = new ActionListener() {		
	//	@Override
	//	public void actionPerformed(ActionEvent e) {
	//	    doaction();
	//	}
	//  };

        // Create Timer
        atime.start();
    }
    
    public void shiftSnake() {
        // Create a new Tail in front of the Snake based on the direction
	// moving and set it to the 0th element
        if (ismovingLEFT) {
            // If the tail movement is within the boundaries, move it forward one space
            if (player1.get(0).getX() >= WIDTH) { player1.add(0, new GameObject(player1.get(0).getX() - WIDTH, player1.get(0).getY()));
            }
	    
	    // Otherwise loop it to the opposite end of the window
	    else {
		player1.add(0, new GameObject(player1.get(0).getX() + this.getWidth() - WIDTH, player1.get(0).getY()));
            }
        } 
	
	else if (ismovingRIGHT) {
            // Same method repeated for if it is moving RIGHT, etc...
            if (player1.get(0).getX() <= (this.getWidth() - WIDTH)) { player1.add(0, new GameObject(player1.get(0).getX() + WIDTH, player1.get(0).getY()));
            } 
	    else {
                player1.add(0, new GameObject(player1.get(0).getX() - this.getWidth() - WIDTH, player1.get(0).getY()));
            }
        }

	else if (ismovingUP) {
            if (player1.get(0).getY() >= WIDTH + WIDTH + WIDTH) { player1.add(0, new GameObject(player1.get(0).getX(), player1.get(0).getY() - WIDTH));
            }
	    else { player1.add(0, new GameObject(player1.get(0).getX(), player1.get(0).getY() + this.getHeight() - WIDTH));}
        }

	else if (ismovingDOWN) {
            if (player1.get(0).getY() <= this.getHeight() - WIDTH) { player1.add(0, new GameObject(player1.get(0).getX(), player1.get(0).getY() + WIDTH));
            }
	    else {
                player1.add(0, new GameObject(player1.get(0).getX(), player1.get(0).getY() - this.getHeight() + WIDTH));
            }
        }
    }
    
    public void shiftSnake2() {
        // Create a new Tail in front of the Snake based on the direction 
	// moving and set it to the 0th element
        if (ismovingLEFT2) {
            // If the tail movement is within the boundaries, move it forward one space
            if (player2.get(0).getX() >= WIDTH) { player2.add(0, new GameObject(player2.get(0).getX() - WIDTH, player2.get(0).getY()));
                // Otherwise loop it to the opposite end of the window
            }
	    else {
                player2.add(0, new GameObject(player2.get(0).getX() + this.getWidth() - WIDTH, player2.get(0).getY()));	
            }
        }

	else if (ismovingRIGHT2) {
            // Same method repeated for if it is moving RIGHT, etc...
            if (player2.get(0).getX() <= (this.getWidth() - WIDTH)) { player2.add(0, new GameObject(player2.get(0).getX() + WIDTH, player2.get(0).getY()));
            }
	    else {
                player2.add(0, new GameObject(player2.get(0).getX() - this.getWidth() - WIDTH, player2.get(0).getY()));	
            }
        }

	else if (ismovingUP2) {
            if (player2.get(0).getY() >= WIDTH) { player2.add(0, new GameObject(player2.get(0).getX(), player2.get(0).getY() - WIDTH));
            }
	    else {
                player2.add(0, new GameObject(player2.get(0).getX(), player2.get(0).getY() + this.getHeight() - WIDTH));
            }
        }
	
	else if (ismovingDOWN2) {
            if (player2.get(0).getY() <= this.getHeight() - WIDTH) { player2.add(0, new GameObject(player2.get(0).getX(), player2.get(0).getY() + WIDTH));
            }
	    else {
                player2.add(0, new GameObject(player2.get(0).getX(), player2.get(0).getY() - this.getHeight() + WIDTH));
	    }
        }
    }
    
    public void doaction() {
        if (loser > 0) {   
	    if(score>highScore){
		highScore=score;
		hScore.setScore(highScore);	
		try {
		    hScore.saveHighScore();
		}
		catch(Exception exc) {
		    exc.printStackTrace(); 
		}
	    }
	    
	    // If user chooses yes, restart the program
	    if (playagainyes == true) {
		//Set window size
                
		if (screenSize == 0){ this.setSize(500,500);}
		else if (screenSize == 1){ this.setSize(600,600);}
		else if (screenSize == 2){ this.setSize(700,700);}
		
		if(score>highScore){
		    highScore=score;
		}
		
		setLocationRelativeTo(null);
		frameresized = false;
		controls = false;
		score = 0;
		fruits = 50;
		score1 = 0;
		score2 = 0;
		size1 = 3;
		size2 = 3;
		
		// Establish starting X and Y coordinate for Snake
		playerx = this.getWidth()/2;
		playery = this.getHeight()/2;
		
		// Create random starting X and Y coordinate for fruit
        particley = gen.nextInt(this.getWidth()-50-115+1) + 115;
	particlex = gen.nextInt(this.getWidth()-50-25+1) + 25;
		
		// Create 3 starting blocks for GameObject
		player1.clear();
		for (int i = 0; i < 3; i++) {
		    player1.add(new GameObject(playerx, playery));
		}
		
		// Set starting positions for the tail
		player1.get(0).setPos(playerx,playery);
		player1.get(1).setPos(playerx,playery+WIDTH);
		player1.get(2).setPos(playerx,playery+(2*WIDTH));
		player2.clear();
		for (int i = 0; i < 3; i++) {
		    player2.add(new GameObject(650, 650));
		}
		player2.get(0).setPos(playerx/3*2, playery);
		player2.get(1).setPos(playerx/3*2, playery+WIDTH);
		player2.get(2).setPos(playerx/3*2, playery+(2*WIDTH));
		
		// Start stopwatch
		watch.start();
		
		// Reinitialize direction variables
		ismovingLEFT = false;
		ismovingRIGHT = false;
		ismovingUP = true;
		ismovingDOWN = false;
		ismovingLEFT2 = false;
		ismovingRIGHT2 = false;
		ismovingUP2 = true;
		ismovingDOWN2 = false;
		
		// Reset playagain variable
		playagainyes = false;
		
		// Reset loser variable
		loser = 0;
	    }
	    
	    // If user chooses no, exit the program
	    if (playagainno == true) {
		System.exit(0);
	    }	     
        }
        if ((menu != 0) && (players == 2) && (frameresized == false)) {
            // If the game starts as 2 player, initialize two player settings
	    
            //Set window size
            if (screenSize == 0){this.setSize(500,500);}
            else if (screenSize == 1){this.setSize(600,600);}
            else if (screenSize == 2){this.setSize(700,700);}
            setLocationRelativeTo(null);
            this.setVisible(true);
            frameresized = true;
            offscreen = this.createImage(this.getWidth(), this.getHeight());
            particley = gen.nextInt(this.getWidth()-50-115+1) + 115;
            particlex = gen.nextInt(this.getWidth()-50-25+1) + 25;
            player1.clear();
            fruittimer.start();
            for (int i = 0; i < 3; i++) {
                player1.add(new GameObject(playerx, playery));
            }
	    
            // Set starting positions for the tail
            player1.get(0).setPos(this.getWidth() - 150, this.getHeight() - 150);
            player1.get(1).setPos(this.getWidth() - 150, this.getHeight() - 135);
            player1.get(2).setPos(this.getWidth() - 150, this.getHeight() - 120);
        }
        
        if ((menu != 0) && (players == 1) && (frameresized == false)) {
	    if (screenSize == 0){this.setSize(500,500);}
            else if (screenSize == 1){this.setSize(600,600);}
            else if (screenSize == 2){this.setSize(700,700);}
            setLocationRelativeTo(null);
            this.setVisible(true);
            frameresized = true;
            offscreen = this.createImage(this.getWidth(), this.getHeight());
            particley = gen.nextInt(this.getWidth()-50-115+1) + 115;
            particlex = gen.nextInt(this.getWidth()-50-25+1) + 25;
            player1.clear();
            fruittimer.start();
            for (int i = 0; i < 3; i ++)
            	player1.add(new GameObject(playerx, playery));
	    
            player1.get(0).setPos(this.getWidth() - 150, this.getHeight() - 150);
            player1.get(1).setPos(this.getWidth() - 150, this.getHeight() - 135);
            player1.get(2).setPos(this.getWidth() - 150, this.getHeight() - 120);
	    
        }
        
        // If game is in progress and is not paused,
        // send one block from the back to the front
        if ((menu != 0) && (pause == false) && (players == 1)) {
	    shiftSnake();
            player1.remove(player1.size() - 1);
        } 
	
        // Do the same for two player except with both arraylists
        else if ((menu != 0) && (pause == false) && (players == 2)) {
            shiftSnake();
            player1.remove(player1.size() - 1);
            shiftSnake2();
            player2.remove(player2.size() - 1);
        }
	
        // End game when the fruits run out in two player game
        if (fruits <= 0) {
            loser = 1;
        }
        // If in two player, and a fruit has not been eaten for 30 seconds
        // create new random location for fruit
        if (players == 2 && loser == 0 && fruittimer.getSeconds() >= 30 && menu != 0) {
            Rectangle fruit = new Rectangle(particlex, particley, fWIDTH, fWIDTH); 
            Rectangle head = new Rectangle(player2.get(0).getX(), player2.get(0).getY(), WIDTH, WIDTH);
            Rectangle head2 = new Rectangle(player1.get(0).getX(), player1.get(0).getY(), WIDTH, WIDTH);
            do {
            	particley = gen.nextInt(this.getWidth()-50-115+1) + 115;
            	particlex = gen.nextInt(this.getWidth()-50-25+1) + 25;
                System.out.println("fruittime reset");
            } while (head2.intersects(particlex, particley, fWIDTH, fWIDTH) || head.intersects(particlex, particley, fWIDTH, fWIDTH));
            fruittimer.start();
        }
        repaint();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
	
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));
	
        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    Font font0 = new Font("Times New Roman", Font.PLAIN, 12);
    Font font1 = new Font("Helvetica", Font.PLAIN, 15);
    Font font2 = new Font("Comic Sans", Font.BOLD, 20);
    FontMetrics fm = this.getFontMetrics(font1);
    
    public Font getFont0(){ return font0; }
    public Font getFont1(){ return font1; }
    public Font getFont2(){ return font2; }
    public FontMetrics getFm(){ return fm;}
    
    public void paint(Graphics graph) {
        // Create font
    	// Begin painting
        // Get the offscreen graphics for double buffer
        g = offscreen.getGraphics();
        g.setFont(font1);
        // Create a menu screen for the initial launch, leave menu when spacebar is pressed
        if (menu == 0) {
            if (controls == false) {
                //Set the height and width of the main menu (this line affects resizeability)
                this.setSize(500,500);
                //Set the color of the main menu and fill it
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
                g.setColor(Color.GREEN);
		// TODO: Make the centering calculation below a method
                //print the authors and title of game in green
                g.drawString("Snake", this.getWidth()/2-fm.stringWidth("Snake")/2, 80);
                String authorTitle="By: Sam Dowell, with Eric Huang, Sam Min";
                g.drawString(authorTitle, this.getWidth()/2-fm.stringWidth(authorTitle)/2, 110);
                
                
                // Paint box displaying whether 1 or 2 players is selected
                // Set the color of the graphics object to white
                g.setColor(Color.WHITE);
                // Depending on the number of players, fill in a white rectangle to highlight the number of players desired
                // The parameters of the fillRect method correspond to the pixel locations of the white highlight.
                if (players == 1) {
                    g.fillRect(211, 182, 22, 22);
                } else if (players == 2) {
                    g.fillRect(257, 182, 22, 22);
                }
                
                // Paint box for window size preference
                // if (screenSize == 0){g.fillOval(11,263,160,40);}
                // else if (screenSize == 1){g.fillOval(171,263,160,40);}
                // else if (screenSize == 2){g.fillOval(331,263,160,40);}
                
                // These methods change the size of the oval used to select whether puddles are enabled or disabled in the
                // main menu.
                if (puddles == false){g.fillRect(177, 325, 70, 40);}
                else if(puddles == true){g.fillRect(286,325, 80,40);}
                
                // The methods below highlight the difficulty of the snake game at the bottom of the main menu.
                if (speed == 75) {
                    g.fillRect(115, 410, 50, 30);
                } else if (speed == 50) {
                    g.fillRect(205, 410, 75, 30);
                } else if (speed ==25) {
                    g.fillRect(320, 410, 75, 30);
                }

                // Draw the menu options that will be highlighted
                String numPlayer = new String("Number of Players");
                String numPlayerOptions = new String("1      2");
                String modeOptions = new String("6)Normal    7)Puddles");
                String difficultyOptions = new String("8)Easy    9)Medium    0)Difficult");
                String modeSelect = new String("Select mode: ");
                String difficultySelect = new String("Select difficulty: ");
                String begin_and_tutorial = new String("Press Spacebar to Begin   |   How to Play [H]");
                g.setColor(Color.RED);
                g.drawString(numPlayer, this.getWidth() / 2 - fm.stringWidth(numPlayer) / 2, 170);
                g.setFont(font2);
                g.drawString(numPlayerOptions, this.getWidth()/2 - fm.stringWidth(numPlayerOptions)/2-15, 200);
                g.drawString(modeOptions, this.getWidth() /2 - fm.stringWidth(modeOptions)/2 -20, 350);
                g.drawString(difficultyOptions, this.getWidth() /2 - fm.stringWidth(difficultyOptions)/2-50, 430);
                g.setFont(font1);
                g.drawString(modeSelect, this.getWidth() /2 - fm.stringWidth(modeSelect)/2, 320);
                g.drawString(difficultySelect, this.getWidth() / 2 - fm.stringWidth(difficultySelect) / 2, 400);
                g.drawString(begin_and_tutorial, this.getWidth() / 2 - fm.stringWidth(begin_and_tutorial) / 2 - 20, 490);
				g.setFont(font1);
		
		
		
		
            } else {
                // Display Control screen
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
                g.setColor(Color.GREEN);
                g.setFont(font0);
                g.drawString("Single Player",85, 50);
                g.drawString("\u2191 ", 91, 67);
                g.drawString("Controls: \u2190   \u2192", 20, 75); // Arrows.  See; http://en.wikipedia.org/wiki/Arrow_(symbol)
		g.drawString("\u2193", 91, 79);
		g.drawString("How to Play:", 20, 115);
                g.drawString("Use the arrow keys to control the", 20, 135);
                g.drawString("snake and eat as many apples as", 20, 150);
                g.drawString("possible without running into the", 20, 165);
                g.drawString("tail.", 20, 180);


                g.drawString("Two Player", 325, 50);
                g.drawString("Controls:   Green Snake: \u2190   \u2192", 250, 75);
                g.drawString(" \u2191 ", 414, 67);
                g.drawString(" \u2193 ", 414, 79);
                g.drawString("  Orange Snake: WASD", 302, 93);
                g.drawString("How to Play:", 250, 115);
                g.drawString("Each player must try to eat as many", 250, 135);
                g.drawString("apples as possible. If you collide with", 250, 150);
                g.drawString("any part of a tail, you will revert back", 250, 165);
                g.drawString("to your original size. If your heads", 250, 180);
                g.drawString("collide, you will both revert back to", 250, 195);
                g.drawString("your original sizes. A new fruit will", 250, 210);
                g.drawString("appear every 30 seconds if not eaten.", 250, 225);
		g.drawString("Act quickly! There are only 50 apples!", 250, 240);
                g.drawString("To win, have the bigger size when the", 250, 255);
                g.drawString("the apples run out", 250, 270);


                g.setColor(Color.WHITE);
                g.drawString("Puddle Mode:",200,310);
                g.drawString("In this mode, there will be several puddles placed around the map", 40, 330);
                g.drawString("which will hide some fruits as they spawn. The objective remains", 45,345);
                g.drawString("the same but are you up for the challenge?", 100,360);


                g.setColor(Color.ORANGE);
                g.drawString("Return to Menu [M]", this.getWidth() - 135, this.getHeight() - 15);

            }
	    
        } else if (pause == false) {
            if (players == 1) {
                // If the player has not yet lost, paint the next image of snake movement
                if (loser == 0) {
                    // Set the color to green to paint the background
                    Color c = new Color(2,115,153);
                    Color b = new Color(61,226,235);
					g.setColor(c);
					//Set window size
                    if (screenSize == 0)
                    {
						this.setSize(500,500);
					}
                    else if (screenSize == 1)
                    {
						this.setSize(600,600);
					}
                    else if (screenSize == 2)
                    {
						this.setSize(700,700);
					}
                    g.fillRect(0,0,700,700);
                    
                    // Set color to red and paint the fruit
                    g.setColor(Color.RED);
                    g.fillRect(particlex, particley, fWIDTH, fWIDTH);
                    if(puddles){
						g.setColor(b);
						g.fillOval(50,90,100,50);
						g.fillOval(this.getWidth()-120,200, 60, 90);
						g.fillOval(this.getWidth()/3,this.getHeight()-300,80,30); 
						g.fillOval(80,this.getHeight()-100,110,60);
						g.fillOval(this.getWidth()-200,this.getHeight()-100,70,70);
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
         particley = gen.nextInt(this.getWidth()-50-115+1) + 115;
	particlex = gen.nextInt(this.getWidth()-50-25+1) + 25;
                            }
                            // Set growsnake to true to increase size of snake by 1
                            growsnake = true;
                            // Add to score
                            score++;
                        }
			
			
                    }
		    
                    // If the Snake ate a fruit, make the snake grow one block 
                    if (growsnake) {
                        shiftSnake();
                    }
                    // Check for if fruit relocated on top of tail
                    do {
                        hasIntersected = false;
                        for (int i = 0; i < player1.size(); i++) {
                            Rectangle r = new Rectangle(player1.get(i).getX(), player1.get(i).getY(), WIDTH, WIDTH);
                            Rectangle fruit = new Rectangle(particlex, particley, fWIDTH, fWIDTH);
                            if (r.intersects(fruit)) {
                                while (r.intersects(particlex, particley, fWIDTH, fWIDTH)) {
        particley = gen.nextInt(this.getWidth()-50-115+1) + 115;
	particlex = gen.nextInt(this.getWidth()-50-25+1) + 25;
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
		    //bar
                    g.setColor(Color.WHITE);
		    g.fillRect(0, 0, this.getWidth(), 90);
                   // Display the score and time
		    g.setColor(Color.BLACK);
                    g.drawString("Score: " + score, 50, 50);
                    g.drawString("High Score: " + highScore,50,70);
                    //display variables
                    //g.drawString("getWidth: " + this.getWidth() + ", screenSize: " + screenSize + ", loser: " + loser, 50, 100);
                    g.drawString("Time: " + watch.toString(), this.getWidth() - 50 - fm.stringWidth("Time: " + watch.toString()), 50);
                    //350
                    // Display Pause option if game is in progress
                    if (loser == 0) {
			// g.drawString("[P] to Pause", this.getWidth() - 50 - fm.stringWidth("[P] to Pause"), this.getHeight() - 25);
			g.drawString("[P] to Pause", this.getWidth() - 50 - fm.stringWidth("[P] to Pause"), 70);
                    }
                }
                if (loser > 0) {
                    // If the player has lost, display message
                    g.setColor(Color.RED);
                    g.drawString("Game Over!", this.getWidth() / 2 - fm.stringWidth("Game Over!") / 2, 240);
                    g.setColor(Color.WHITE);
                    g.drawString("Do you want to play again?", this.getWidth() / 2 - fm.stringWidth("Do you want to play again?") / 2, 260);
                    g.drawString("Yes [Y] or No [N]", this.getWidth() / 2 - fm.stringWidth("Yes [Y] or No [N]") / 2, 280);
                    g.drawString("Return to Menu [M]", this.getWidth() / 2 - fm.stringWidth("Return to Menu [M]") / 2, 300);
                }
            } else if (players == 2) {
                if (loser == 0) {
					Color c = new Color(2,115,153);
                    Color b = new Color(61,226,235);
					// Set the color to white to paint the background
					g.setColor(c);
					//Set window size
                    if (screenSize == 0)
                    {
						this.setSize(500,500);
					}
                    else if (screenSize == 1)
                    {
						this.setSize(600,600);
					}
                    else if (screenSize == 2)
                    {
						this.setSize(700,700);
					}
                    g.fillRect(0,0,700,700);
                    
                    // Set color to Orange and paint the fruit                    
                    g.setColor(Color.RED);
                    g.fillRect(particlex, particley, fWIDTH, fWIDTH);
                    if(puddles){
						g.setColor(b);
						g.fillOval(50,90,100,50);
						g.fillOval(this.getWidth()-120,200, 60, 90);
						g.fillOval(this.getWidth()/3,this.getHeight()-300,80,30); 
						g.fillOval(80,this.getHeight()-100,110,60);
						g.fillOval(this.getWidth()-200,this.getHeight()-100,70,70);
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
        particley = gen.nextInt(this.getWidth()-50-115+1) + 115;
	particlex = gen.nextInt(this.getWidth()-50-25+1) + 25;
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
        particley = gen.nextInt(this.getWidth()-50-115+1) + 115;
	particlex = gen.nextInt(this.getWidth()-50-25+1) + 25;
                                
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
        particley = gen.nextInt(this.getWidth()-50-115+1) + 115;
	particlex = gen.nextInt(this.getWidth()-50-25+1) + 25;
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
        particley = gen.nextInt(this.getWidth()-50-115+1) + 115;
	particlex = gen.nextInt(this.getWidth()-50-25+1) + 25;
                                    hasIntersected = true;
                                    System.out.println("hasIntersected");
                                }
                            }
                        }
                    }  while (hasIntersected);


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
                            player1.get(0).setPos(this.getWidth() - 150, this.getHeight() - 150);
                            player1.get(1).setPos(this.getWidth() - 150, this.getHeight() - 135);
                            player1.get(2).setPos(this.getWidth() - 150, this.getHeight() - 120);
                            ismovingRIGHT2 = false;
                            ismovingLEFT2 = false;
                            ismovingUP2 = true;
                            ismovingDOWN2 = false;
                            player2.clear();
                            for (int j = 0; j < 3; j++) {
                                player2.add(new GameObject(400, 400));
                            }
                            player2.get(0).setPos(150, this.getHeight() - 150);
                            player2.get(1).setPos(150, this.getHeight() - 135);
                            player2.get(2).setPos(150, this.getHeight() - 120);
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
                                        player1.get(0).setPos(this.getWidth() - 150, this.getHeight() - 150);
                                        player1.get(1).setPos(this.getWidth() - 150, this.getHeight() - 135);
                                        player1.get(2).setPos(this.getWidth() - 150, this.getHeight() - 120);
                                        ismovingRIGHT2 = false;
                                        ismovingLEFT2 = false;
                                        ismovingUP2 = true;
                                        ismovingDOWN2 = false;
                                        player2.clear();
                                        for (int j = 0; j < 3; j++) {
                                            player2.add(new GameObject(400, 400));
                                        }
                                        player2.get(0).setPos(150, this.getHeight() - 150);
                                        player2.get(1).setPos(150, this.getHeight() - 135);
                                        player2.get(2).setPos(150, this.getHeight() - 120);
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
		    g.fillRect(0, 0, this.getWidth(), 90);

		    g.setColor(Color.BLACK);
                    g.drawString("Orange Score: " + score2, 50, 50);
                    //g.drawString("Orange Size: " + size2, 50, 75);
                    g.drawString("Time: " + watch.toString(), this.getWidth() / 2 - fm.stringWidth("Time: " + watch.toString()) / 2, 50);
		    // g.drawString("New Fruit in: " + (30 - fruittimer.getSeconds()), this.getWidth() / 2 - fm.stringWidth("New Fruit in: " + (30 - fruittimer.getSeconds())) / 2, 100);
		    g.drawString("New Fruit in: " + (30 - fruittimer.getSeconds()),50, 75);
                    //g.drawString("Fruit Remaining: " + fruits, this.getWidth() / 2 - fm.stringWidth("Fruit Remaining: " + fruits) / 2, 75);
                    g.drawString("Green Score: " + score1, this.getWidth() - 50 - fm.stringWidth("Green score: " + 1), 50);
                    //g.drawString("Green Size: " + size1, this.getWidth() - 50 - fm.stringWidth("Green score: " + 1), 75);
                    //display varaibles
                    //g.drawString("getWidth: " + this.getWidth() + ", screenSize: " + screenSize + ", loser: " + loser, 50, 120);
                    // Display Pause option if game is in progress
                    if (loser == 0) {
			// g.drawString("[P] to Pause", this.getWidth() - 50 - fm.stringWidth("[P] to Pause"), this.getHeight() - 25);
			g.drawString("[P] to Pause", this.getWidth() - 50 - fm.stringWidth("[P] to Pause"), 75);
                    }
                }
                if (loser > 0) {
                    // If the player has lost, display message
                    g.setColor(Color.RED);
                    g.drawString("Game Over!", this.getWidth() / 2 - fm.stringWidth("Game Over!") / 2, 280);
                    g.setColor(Color.WHITE);
                    if (size1 == size2) {
                        g.drawString("Tie Game!", this.getWidth() / 2 - fm.stringWidth("Tie Game!") / 2, 300);
                    } else if (size1 > size2) {
                        g.drawString("Green Wins!", this.getWidth() / 2 - fm.stringWidth("Green Wins!") / 2, 300);
                    } else if (size2 > size1) {
                        g.drawString("Orange Wins!", this.getWidth() / 2 - fm.stringWidth("Orange Wins!") / 2, 300);
                    }
                    g.drawString("Do you want to play again?", this.getWidth() / 2 - fm.stringWidth("Do you want to play again?") / 2, 320);
                    g.drawString("Yes [Y] or No [N]", this.getWidth() / 2 - fm.stringWidth("Yes [Y] or No [N]") / 2, 340);
                    g.drawString("Return to Menu [M]", this.getWidth() / 2 - fm.stringWidth("Return to Menu [M]") / 2, 360);
                }
            }

        }            // If the player pauses, display that the game is paused and the resume option

        if (pause == true && players == 1) {
			g.setColor(Color.WHITE);
            g.drawString("Paused", this.getWidth() / 2 - fm.stringWidth("Paused") / 2, 250);
            g.drawString("[P] to Resume", this.getWidth() / 2 - fm.stringWidth("[P] to Resume") / 2, 270);
            g.drawString("[M] Return to Menu", this.getWidth() / 2 - fm.stringWidth("[M] Return to Menu") / 2, 290);
        } else if (pause == true && players== 2) {
            g.setColor(Color.WHITE);
            g.drawString("Paused", this.getWidth() / 2 - fm.stringWidth("Paused") / 2, 375);
            g.drawString("[P] to Resume", this.getWidth() / 2 - fm.stringWidth("[P] to Resume") / 2, 395);
            g.drawString("[M] Return to Menu", this.getWidth() / 2 - fm.stringWidth("[M] Return to Menu") / 2, 415);
        }
        // Prepare next image for double buffer

        graph.drawImage(offscreen, 0, 0, this);
    }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        // Track key using KeyListener
        int key = ke.getKeyCode();
        // If the user presses an arrow key, change the direction values
        // Don't allow the direction to directly reverse; and dont allow direction to change near the edges
        if (key == KeyEvent.VK_LEFT) {
            if ((!ismovingRIGHT) && (player1.get(0).getY() > WIDTH) && (player1.get(0).getY() < (this.getHeight() - WIDTH)) && (turn == 0)) {
                ismovingRIGHT = false;
                ismovingLEFT = true;
                ismovingUP = false;
                ismovingDOWN = false;
                turn++;
            }
        } else if (key == KeyEvent.VK_RIGHT) {
            if ((!ismovingLEFT) && (player1.get(0).getY() > WIDTH) && (player1.get(0).getY() < (this.getHeight() - WIDTH)) && (turn == 0)) {
                ismovingRIGHT = true;
                ismovingLEFT = false;
                ismovingUP = false;
                ismovingDOWN = false;
                turn++;
            }
        } else if (key == KeyEvent.VK_UP) {
            if ((!ismovingDOWN) && (player1.get(0).getX() < (this.getWidth() - WIDTH)) && (player1.get(0).getX() > WIDTH) && (turn == 0)) {
                ismovingRIGHT = false;
                ismovingLEFT = false;
                ismovingUP = true;
                ismovingDOWN = false;
                turn++;
            }
        } else if (key == KeyEvent.VK_DOWN) {

            if ((!ismovingUP) && (player1.get(0).getX() < (this.getWidth() - WIDTH)) && (player1.get(0).getX() > WIDTH) && (turn == 0)) {
                ismovingRIGHT = false;
                ismovingLEFT = false;
                ismovingUP = false;
                ismovingDOWN = true;
                turn++;
            }
        }
        // Create key listeners for player movement for second player WASD
        if (key == KeyEvent.VK_A) {
            if ((!ismovingRIGHT2) && (player2.get(0).getY() > WIDTH) && (player2.get(0).getY() < (this.getHeight() - WIDTH)) && (turn2 == 0)) {
                ismovingRIGHT2 = false;
                ismovingLEFT2 = true;
                ismovingUP2 = false;
                ismovingDOWN2 = false;
                turn2++;
            }
        } else if (key == KeyEvent.VK_D) {
            if ((!ismovingLEFT2) && (player2.get(0).getY() > WIDTH) && (player2.get(0).getY() < (this.getHeight() - WIDTH)) && (turn2 == 0)) {
                ismovingRIGHT2 = true;
                ismovingLEFT2 = false;
                ismovingUP2 = false;
                ismovingDOWN2 = false;
                turn2++;
            }
        } else if (key == KeyEvent.VK_W) {
            if ((!ismovingDOWN2) && (player2.get(0).getX() < (this.getWidth() - WIDTH)) && (player2.get(0).getX() > WIDTH) && (turn2 == 0)) {
                ismovingRIGHT2 = false;
                ismovingLEFT2 = false;
                ismovingUP2 = true;
                ismovingDOWN2 = false;
                turn2++;
            }
        } else if (key == KeyEvent.VK_S) {

            if ((!ismovingUP2) && (player2.get(0).getX() < (this.getWidth() - WIDTH)) && (player2.get(0).getX() > WIDTH) && (turn2 == 0)) {
                ismovingRIGHT2 = false;
                ismovingLEFT2 = false;
                ismovingUP2 = false;
                ismovingDOWN2 = true;
                turn2++;
            }
            // Listen for the "y" and "n" key for when the game has ended (replay)
        } else if (key == KeyEvent.VK_Y) {
            if (loser > 0) {
                playagainyes = true;
                playagainno = false;
            }
        } else if (key == KeyEvent.VK_N) {
            if (loser > 0) {
                playagainyes = false;
                playagainno = true;
            }
        } // If the spacebar is pressed, add one to menu so that it doesnt return
        else if (key == KeyEvent.VK_SPACE) {
            if (menu == 0 && controls == false) {
                menu++;
                // Start stopwatch
                watch.start();
            }
            // If "m" key is pressed when the game has ended, restart game and return to menu screen
        } else if (key == KeyEvent.VK_M) {
            if (((loser > 0) || (pause))&&(menu != 0)) {
                playagainyes = true;
                playagainno = false;
                menu = 0;
                players = 1;
                screenSize = 0;
                pause = false;
                loser = 1;
            } else if (controls == true) {
                controls = !(controls);
            }
            // If "p" key is pressed while game is in progress, pause/unpause the game and stopwatch
        } else if (key == KeyEvent.VK_P) {
            if ((menu != 0) && (loser == 0)) {
                pause = !(pause);
                if (pause == true) {
                    watch.stop();
                } else if (pause == false) {
                    watch.unpause();
                }
            }
            // Key listener for menu screen 1/2 players
        } else if (key == KeyEvent.VK_1) {
            if (menu == 0 && controls == false) {
                players = 1;

            }
        } else if (key == KeyEvent.VK_2) {
            if (menu == 0 && controls == false) {
                players = 2;
            }
            // Key listener for How to Play in main menu
        } else if (key == KeyEvent.VK_H) {
            if (menu == 0 && controls == false) {
                controls = !(controls);
            }
        }
        //key listeners for window sizes
		else if (key == KeyEvent.VK_3){
			if (menu == 0 && controls == false){
				screenSize = 0;
			}
		}
		else if (key == KeyEvent.VK_4){
			if (menu == 0 && controls == false){
				screenSize = 1;
			}
		}
		else if (key == KeyEvent.VK_5){
			if (menu == 0 && controls == false){
				screenSize = 2;
			}
		}
		else if (key == KeyEvent.VK_6){
			if (menu == 0 && controls == false){
				puddles = false;
			}
		}
		else if (key == KeyEvent.VK_7){
			if (menu == 0 && controls == false){
				puddles = true;
			}
		}
	else if (key == KeyEvent.VK_8){
	    if (menu == 0 ){
		speed=75;
		atime.stop();
		atime.setDelay(speed);
		atime.restart();
	    }
	}
	else if (key == KeyEvent.VK_9){
	    if (menu == 0 ){
		speed=50;
		atime.stop();
		atime.setDelay(speed);
		atime.restart();
	    }
	}
	else if (key == KeyEvent.VK_0){
	    if (menu == 0 ){
		speed=25;
		atime.stop();
		atime.setDelay(speed);
		atime.restart();
              
	    }
	}
    }
    
    
    //mouselistener...........listener
    public void mouseClicked(MouseEvent e) {
	if ((menu != 0) && (loser == 0)) {
	    pause = !(pause);
	    if (pause == true) {
		watch.stop();
                } else if (pause == false) {
		watch.unpause();
	    }
	}
    }
	
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}



	@Override
	    public void keyReleased(KeyEvent key) {
	}
    }
