package edu.ucsb.cs56.projects.games.snake;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sam
 */
public class Tail {
    
    private int x, y, width, height;
    //Cool kids way to make variables

    public Tail(){
        x = 50;
	y = 50;
	width = 15;
	height = 15;
    }
    
    public Tail(int a, int b){
        x = a;
        y = b;
	width = 15;
	height = 15;
    }
    
    public Tail(int a, int b, int c, int d){
        x = a;
        y = b;
        width = c;
        height = d;
    }
    
    public void setPos(int a, int b){
        x = a;
        y = b;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
}
