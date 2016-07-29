cs56-games-snake
================

project history
===============
```
 W14 | bronhuston 4pm | vinlara | Snake game
 W16 | omeedrabani 6pm| rkuang, robingorge (zehaoli)| Snake game
```

A Snake game, originally by Sam Dowell, and edited by Samuel Min Eric Huang.
edited by Vincente Lara 02/28/2014 

![](http://i.imgur.com/dwAqko6.png)

The game is dependent on two things. 
First dependent it that the game is built using java, 
make sure to have Java Development Kit 1.7 downloaded.

The second dependency is apache ant.
Apache ant is use to compile and run the code.

Both are free to download.
Once you have java and ant installed 
you can use the following command to run the game.

ant run

your should execute this command where the build.xml
file is located which should be the project root directory.

The game features two different modes. 
One player mode and two player mode. As well as two different levels. 
Normal mode: No obstacles or walls
Puddle mode: Puddles that sometimes hide the fruit

Single Player mode:
In single player mode, your goal is to see how long of a snake you can make
without running into your tail. In order for your snake to grow,
you must eat the red fruit the randomly appears on the map.
You control the snake with the arrow keys. There is no time limit.

Two Player mode:
In two player mode, there are two snakes.
One snake controlled with the WASD keys.
The other snake is controlled by the arrow keys.
The goal of two player mode is to see which player is biggest before the
50 fruit are all gone.
If the heads of the two snakes collide both snakes revert to the original size.
If one snake collides with the other. The collider is reverted back to 
original size. Whoever is the biggest in the end is the winner.


W16 final remarks
=================

1,what the code does: 
In this legacy code, the Jframe, game object and the controller are all in only one class. The snake is formed by an arraylist of the game object. When you eat a fruit, there will be an additional object in the arraylist. When you chang the direction, the next object in the arraylist will be created in different x coordinate or y coordinate (according to the direction key you press).

2,what the feature could add: 
For now, the death of the snake only happens when its head meets its body. You can make the wall to be untouchable part in the game.
Also, you can add more modes in the game like make some monsters moving in the game.

3,what bugs exist: 
The ingame bar may cover some game space.You can change it to fit the windows.

4,What refactoring opportunities: 
You can use MVC design pattern to creat other two files to place game object and the input helper(controller). For now, all the methods and classes are in just one snake frame.
