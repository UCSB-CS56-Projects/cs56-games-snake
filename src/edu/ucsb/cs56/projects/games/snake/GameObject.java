package edu.ucsb.cs56.projects.games.snake;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import javax.swing.*;

public class GameObject 
{
	public static final String BLACK = "black";
	public static final String RED = "red";
	public static final String GREEN = "green";
	public static final String ORANGE = "orange";
	
    private int x, y, width, height;
    private String color = "none";

    public GameObject() {};

    public GameObject(int a, int b){
	x = a;
	y = b;
    }

    public GameObject(int a, int b, int w, int h){
	x = a;
	y = b;
	width = w;
	height = h;
    }

    public void setPos(int a, int b){
	x = a;
	y = b;
    }
    
    // a function that allows a color to be input into the GameObject
    public void setColor(String color){
    	this.color = color;
    }
    
    // a function that returns the color of the GameObject
    public String getColor(){
    	return this.color;
    }

    public int getX(){ return x; }
    public int getY(){ return y; }
    public int getWidth(){ return width; }
    public int getHeight(){ return height; }
} 
