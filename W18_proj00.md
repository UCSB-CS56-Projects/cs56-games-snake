Matt Gottlieb, Derek Zhang

1. This is a snake game made on Java.

2. User stories:

 * As a player, I can play snake.
 * As a player, I can select different game modes and difficulties and arena sizes.
 * As a player, I can play with one or two players.
 * As a player, I can pause my game.
 * As a player, I can retry when I get a game over.
 * As a player, I can check how to play the game.

3. It runs, but it's not really too playable due to major bugs.

4. Possible future features:

 * Better graphics.
 * Smoother gameplay.
 * Set up a point system.
 * Rework the multiplayer system.
 * Tighter movement.

5. Information that could be added:

 * Make the procedure to run the game more clear.
 * More headings and organization.

6. The current state of the build.xml file is runnable. It is using Ant, ...

7. There is enough issues that you could earn 1000 points, it might be a little difficult if you can't complete some of hte higher point issues though. The issues are clear in terms of what the expectations are.
The main issues that make the game unplayable are:
  * After eating speed fruit, the snake permanentaly stays at that speed even after death.
  * The snake goes through the top or bottom once, when it should kill the snake
  * It is not possible to get fruits that appear on the edge of the screen
  * The high score is not working.
  

8. The code in this project is structured so that every individual piece of the game (such as fruits and their generator, the snake, the high score) are separated into their own individual classes. From what I can tell, SnakeFrame.java is what holds everything together and does most of the functions related to running the game. Objects in the game, like fruit and pellets, are derived from the GameObject class, with GameObjectHandler handling these instances. The snake itself is separated into Snake.java, which holds the snake object, and tail.java, which seems to be what comprises the table. However, the mainpulation of the snake regarding user input seems to be handled by SnakeFrame.java. One thing that might be a problem is that a lot of the code and functions are held within SnakeFrame.jave; I will have to look into detail on the functions and code to see if this is really a problem though.

 While the code isn't too hard to follow in some aspects (classes and functions are labeled/named clearly, code is commented with explanations), there are parts that may need cleaning (for example, large blocks of commented-out code).

9. As far as I can tell, test coverage is not great. The only test file is TailTest.java, which only covers the Tail object. Everything else needs test coverage.
 
