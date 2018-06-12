package com.othello.game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Player {

	private String 	name;
	private Color 	chipColor;
	private int 	score;

	public Player(String name, Color chipColor){
		name 		= name;
		chipColor 	= chipColor;
	}

	public String 	getName()		{return name;}
	public Color 	getChipColor()	{return chipColor;}
	public int 		getScore() 		{return score;}
	
	public void 	changeScore(int deltaScore){ score += deltaScore;}
}