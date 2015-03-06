package edu.ucsb.cs56.projects.games.snake;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import javax.swing.*;

public class GameObject 
{
    private int x, y, width, height;

    public GameObject() {};

    public GameObject(int a, int b){
	x = a;
	y = b;
    }

    public GameObject(int a, int b, int w, int h){
	x = a;
	y = b; // was originally a. typo?
	width = w;
	height = h;
    }

    public void setPos(int a, int b){
	x = a;
	y = b;
    }

    public int getX(){ return x; }
    public int getY(){ return y; }
    public int getWidth(){ return width; }
    public int getHeight(){ return height; }
} 
