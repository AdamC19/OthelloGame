package com.othello.game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

private class Space extends JButton implements ActionListener{
	/* default width and height of a Space */
	public static final int 	DEFAULT_WIDTH 	= 25;
	public static final int 	DEFAULT_HEIGHT 	= 25;
	public static final Color 	DEFAULT_BG 		= new Color(50, 155, 50); 	// sort of a green color

	private int width;
	private int height;
	private int x;
	private int y;
	private Color background;
	private OthelloChip chip;

	 public Space(int x, int y){
		this(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}public Space(int x, int y, int width, int height){
		this.x 		= x;
		this.y 		= y;
		this.width 	= width;
		this.height = height;
		background 	= DEFAULT_BG;
		this.setBounds(x, y, width, height);
		this.setBorderPainted(true);
		this.setBackground(background);
	}
	public Color getBackground(){return background;}

	public int getWidth() {return width;}
	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
		this.setBounds(x, y, width, height);
	}
	/**
	 * @return the height
	 */
	public int getHeight() {return height;}
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
		this.setBounds(x, y, width, height);
	}
	/**
	 * @return the x
	 */
	public int getX() {return x;}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
		this.setBounds(x, y, width, height);
	}
	/**
	 * @return the y
	 */
	public int getY() {return y;}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
		this.setBounds(x, y, width, height);
	}


	public void placeChip(OthelloChip chip){
		this.chip = chip;
		this.setIcon(chip);
	}
	public void removeChip(){
		this.chip = null;
		this.setIcon(null);
	}
}
public class OthelloBoard extends JFrame {
	private static final 	int 		DEFAULT_COLS 	= 8; 
	private static final 	int 		DEFAULT_ROWS 	= 8;
	private static final 	String 		DEFAULT_TITLE 	= "Othello";

	private int 		frameWidth;
	private int 		frameHeight;
	/* Number of SPACES */
	private int 		cols;
	private int 		rows;
	private int 		spacing;		// spacing between components
	private int 		edgePadding;	// spacing around edge
	private Spaces[][] 	board;		


	public OthelloBoard(){
		this(DEFAULT_COLS, DEFAULT_ROWS);
	}
	public OthelloBoard(int width){
		this(width, width);
	}
	public OthelloBoard(int width, String title){
		this(width, width, title);
	}
	public OthelloBoard(int cols, int rows){
		this(cols, rows, DEFAULT_TITLE);
	}
	public OthelloBoard(int cols, int rows, String title){
		super(title);
		cols 	= cols;
		rows	= rows;
		this.setSize(width, height);
		board 	= new Space[width][height];
		setupPane(this.getContentPane());		// do the work of adding stuff
	}
	private void setupPane(Container pane) {
		
		//SIZE THE WINDOW
		this.setSize(cols*(2*spacing+2)+2*edgePadding;, rows*(2*spacing+4)+2*edgePadding;);	// 
		
		//SET THE LOCATION OF GAME BOARD
		double[] dims = getScreenDims();
		int x = ((int)dims[0]-frameWidth)/2;		// puts the board at the center of the screen
		int y = ((int)dims[1]-frameHeight)/2;	//
		this.setTitle(titleBase);
		this.setLocation(new Point(x,y));
		
		int width 	= (int) pane.getSize().getWidth();	// width of the pane
		int height 	= (int) pane.getSize().getHeight();	//height of the pane
		
		// CREATE THE OBJECTS IN AN ARRAY
		populateBoard();
		
		pane.setLayout(null);
		
		// POPULATE THE PANE
		for(int col = 0; col<board.length; col++) {
			
			for(int row = 0; row<board[col].length; row++) {
				pane.add(board[col][row]);
			}
		}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	private void populateBoard(){
		int xdim = 25;
		int ydim = 25;
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				board[x][y] = new Space(x*xdim, y*ydim, xdim, ydim);
			}
		}
	}

}