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
    
    private int x, y, width, height; // x, y coordinate; width, and height
    /** Default constructor
	sets default values to location (50, 50) with side lengths 15
    */
    public Tail(){
        x = 50;
	y = 50;
	width = 15;
	height = 15;
    }
    /** Two param constructor
	@param a x-coordinate
	@param b y-coordinate
    */
    public Tail(int a, int b){
        x = a;
        y = b;
	width = 15;
	height = 15;
    }
    /** Four param constructor
	@param a x-coordinate
	@param b y-coordinate
	@param c width
	@param d height
    */
    public Tail(int a, int b, int c, int d){
        x = a;
        y = b;
        width = c;
        height = d;
    }
    /** Setter for position
	@param a x-coordinate
	@param b y-coordinate
    */
    public void setPos(int a, int b){
        x = a;
        y = b;
    }
    /** Getter for x-coordinate
	@return x-coordinate
    */
    public int getX(){
        return x;
    }
    /** Getter for y-coordinate
	@return y-coordinate
    */
    public int getY(){
        return y;
    }
    /** Getter for width
	@return width
    */
    public int getWidth(){
        return width;
    }
    /** Getter for height
	@return height
    */
    public int getHeight(){
        return height;
    }
    
}
