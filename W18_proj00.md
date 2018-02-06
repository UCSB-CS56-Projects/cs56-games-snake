Matt Gottlieb, Derek Zhang

a. This is a snake game made on Java.

b. User stories:

 * As a player, I can play snake.
 * As a player, I can select different game modes and difficulties and arena sizes.
 * As a player, I can play with one or two players.
 * As a player, I can pause my game.
 * As a player, I can retry when I get a game over.
 * As a player, I can check how to play the game.

c. It runs, but it's not really too playable due to major bugs.

d. Possible future features:

 * Better graphics.
 * Smoother gameplay.
 * Set up a point system.
 * Rework the multiplayer system.
 * Tighter movement.

e. Information that could be added:

 * Make the procedure to run the game more clear.
 * More headings and organization.

f. The current state of the build.xml file is runnable and it uses Ant. I do not see any old legacy JWS stuff in the build.xml that needs to be removed.

g. There is enough issues that you could earn 1000 points, it might be a little difficult if you can't complete some of the higher point issues though. The issues are clear in terms of what the expectations are.
The main issues that make the game unplayable are:
  * After eating speed fruit, the snake permanentaly stays at that speed even after death.
  * The snake goes through the top or bottom once, when it should kill the snake
  * It is not possible to get fruits that appear on the edge of the screen
  * The high score is not working.
  
h. We have no additional issues at this time.
  

i. The code in this project is structured so that every individual piece of the game (such as fruits and their generator, the snake, the high score) are separated into their own individual classes. From what I can tell, SnakeFrame.java is what holds everything together and does most of the functions related to running the game. Objects in the game, like fruit and pellets, are derived from the GameObject class, with GameObjectHandler handling these instances. The snake itself is separated into Snake.java, which holds the snake object, and tail.java, which seems to be what comprises the table. However, the mainpulation of the snake regarding user input seems to be handled by SnakeFrame.java. One thing that might be a problem is that a lot of the code and functions are held within SnakeFrame.jave; I will have to look into detail on the functions and code to see if this is really a problem though. While the code isn't too hard to follow in some aspects, a lot of the code may need cleaning and refactoring, particularly in SnakeFrame.java.

j. As far as I can tell, test coverage is not great. The only test file is TailTest.java, which only covers the Tail object. Everything else needs test coverage.
 
