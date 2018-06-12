package com.othello.game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OthelloChip implements Icon {

	/* default width and height of a Space */
	public static final int DEFAULT_WIDTH 	= 25;
	public static final int DEFAULT_HEIGHT 	= 25;
	private 			int height;
	private 			int width;
	private Color currentColor;
	private Player currentOwner;

	public OthelloChip(Player initOwner){
		this(initOwner, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	public OthelloChip(Player initOwner, int width, int height){
		this.width 	= width;
		this.height = height;
		this.setBackground(currentColor = initOwner.getChipColor());
		currentOwner = initOwner;
		this.setBounds(x,y,width,height);
	}
	/** (non-Javadoc)
	 * @see javax.swing.Icon#getIconHeight()
	 */
	public int getIconHeight() {
		return height;
	}

	/** (non-Javadoc)
	 * @see javax.swing.Icon#getIconWidth()
	 */
	public int getIconWidth() {
		return width;
	}
	
	public Color getBackground() {
		return currentColor;
	}

	/** (non-Javadoc)
	 * @see javax.swing.Icon#paintIcon(java.awt.Component, java.awt.Graphics, int, int)
	 */
	public void paintIcon(Component c, Graphics g, int xDim, int yDim) {
		Graphics2D g2D = (Graphics2D)g.create();
		g2D.setColor(getBackground());
		g2D.fillOval(xDim, yDim, getIconWidth(), getIconHeight());
		
	}


}