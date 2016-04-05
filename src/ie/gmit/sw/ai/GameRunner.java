package ie.gmit.sw.ai;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import ie.gmit.sw.ai.traversers.*;
import ie.gmit.sw.ai.player.*;

public class GameRunner implements KeyListener, Runnable{
	private static final int MAZE_DIMENSION = 60;
	private Player p = new Player();
	private char[][] model;
	private GameView view;
	private int currentRow;
	private int currentCol;
	private int zombRow0;
	private int zombCol0;
	private int zombRow1;
	private int zombCol1;
	private int zombRow2;
	private int zombCol2;
	private int zombRow3;
	private int zombCol3;
	private int zombRow4;
	private int zombCol4;
	private int zombRow5;
	private int zombCol5;
	private int exitRow;
	private int exitCol;
	public Maze m = new Maze(MAZE_DIMENSION, MAZE_DIMENSION);
	

	
	public GameRunner() throws Exception{
		model = m.getMaze();
    	view = new GameView(model);
    			
    	placePlayer();
    	placeExit();
    	placeEnemy0();
    	placeEnemy1();
    	placeEnemy2();
    	placeEnemy3();
    	placeEnemy4();
    	placeEnemy5();
    	
    	Dimension d = new Dimension(GameView.DEFAULT_VIEW_SIZE, GameView.DEFAULT_VIEW_SIZE);
    	view.setPreferredSize(d);
    	view.setMinimumSize(d);
    	view.setMaximumSize(d);
    	
    	JFrame f = new JFrame("G00301273 - Fuzzy Maze Challange");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.addKeyListener(this);
        f.getContentPane().setLayout(new FlowLayout());
        f.add(view);
        f.setSize(1000,1000);
        f.setLocation(100,100);
        f.pack();
        f.setVisible(true);
        //view.toggleZoom();
        
       	}	
	
	private void placePlayer(){   	
    	currentRow = (int) (MAZE_DIMENSION * Math.random());
    	currentCol = (int) (MAZE_DIMENSION * Math.random());
    	model[currentRow][currentCol] = 'E';
    	updateView(); 		
	}
	
	private void placeEnemy0(){
		zombRow0 = (int) (MAZE_DIMENSION * Math.random());
    	zombCol0 = (int) (MAZE_DIMENSION * Math.random());
    	model[zombRow0][zombCol0] = 'Z';
    	updateView(); 		
	}
	
	private void placeEnemy1(){
		zombRow1 = (int) (MAZE_DIMENSION * Math.random());
    	zombCol1 = (int) (MAZE_DIMENSION * Math.random());
    	model[zombRow1][zombCol1] = 'Z';
    	updateView(); 		
	}
	
	private void placeEnemy2(){
		zombRow2 = (int) (MAZE_DIMENSION * Math.random());
    	zombCol2 = (int) (MAZE_DIMENSION * Math.random());
    	model[zombRow2][zombCol2] = 'Z';
    	updateView(); 		
	}
	
	private void placeEnemy3(){
		zombRow3 = (int) (MAZE_DIMENSION * Math.random());
    	zombCol3 = (int) (MAZE_DIMENSION * Math.random());
    	model[zombRow3][zombCol3] = 'Z';
    	updateView(); 		
	}
	
	private void placeEnemy4(){
		zombRow4 = (int) (MAZE_DIMENSION * Math.random());
    	zombCol4 = (int) (MAZE_DIMENSION * Math.random());
    	model[zombRow4][zombCol4] = 'Z';
    	updateView(); 		
	}
	
	private void placeEnemy5(){
		zombRow5 = (int) (MAZE_DIMENSION * Math.random());
    	zombCol5 = (int) (MAZE_DIMENSION * Math.random());
    	model[zombRow5][zombCol5] = 'Z';
    	updateView(); 		
	}

	
	public void placeExit(){
		exitRow = (int) (MAZE_DIMENSION * Math.random());
    	exitCol = (int) (MAZE_DIMENSION * Math.random());
    	model[exitRow][exitCol] = 'L';
    	updateView(); 		
	}
	
	private void updateView(){
		view.setCurrentRow(currentRow);
		view.setCurrentCol(currentCol);
	}
	
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && currentCol < MAZE_DIMENSION - 1) {
        	if (isValidMove(currentRow, currentCol + 1)){
        		currentCol++;
        	}
        	else if(isPickup(currentRow, currentCol + 1)) {
        		p.playerStrength(2);
        		System.out.println();
        	}
        	else if(isExit(currentRow, currentCol + 1)) {
        		try {
					 
					System.exit(0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        }else if (e.getKeyCode() == KeyEvent.VK_LEFT && currentCol > 0) {
        	if (isValidMove(currentRow, currentCol - 1)) {
        		currentCol--;
        	}
        	else if(isPickup(currentRow, currentCol - 1)) {
        		p.playerStrength(2);        		
        	}
        	else if(isExit(currentRow, currentCol - 1)) {
        		try {
        			 
					System.exit(0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        }else if (e.getKeyCode() == KeyEvent.VK_UP && currentRow > 0) {
        	if (isValidMove(currentRow - 1, currentCol)) {
        		currentRow--;
        	}
        	else if(isPickup(currentRow - 1, currentCol)) {
        		p.playerStrength(2);        		
        	}
        	else if(isExit(currentRow - 1, currentCol)) {
        		try {
					System.exit(0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        }else if (e.getKeyCode() == KeyEvent.VK_DOWN && currentRow < MAZE_DIMENSION - 1) {
        	if (isValidMove(currentRow + 1, currentCol)) {
        		currentRow++;    	
        	}
        	else if(isPickup(currentRow + 1, currentCol)) {
        		p.playerStrength(2);        		
        	}
        	else if(isExit(currentRow + 1, currentCol)) {
        		try {
					System.exit(0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        }else if (e.getKeyCode() == KeyEvent.VK_Z){
        	view.toggleZoom();
        }else{
        	return;
        }
        updateView();       
    }
    public void keyReleased(KeyEvent e) {} //Ignore
	public void keyTyped(KeyEvent e) {} //Ignore

    
	private boolean isValidMove(int r, int c){
		if (r <= model.length - 1 && c <= model[r].length - 1 && model[r][c] == ' '){
			model[currentRow][currentCol] = ' ';
			model[r][c] = 'E';
			return true;
		}else if(r <= model.length - 1 && c <= model[r].length - 1 && model[r][c] == 'V'){
			model[currentRow][currentCol] = ' ';
			model[r][c] = 'C';
			return true;
		}else{
			return false; //Can't move
		}
	}
	
	private boolean isExit(int r, int c){
		if (r <= model.length - 1 && c <= model[r].length - 1 && model[r][c] == 'L'){
			model[currentRow][currentCol] = 'L';
			model[r][c] = 'E';
			return true;
		}else{
			return false; //Can't move
		}
	}
	
	private boolean isPickup(int r, int c){
		if (r <= model.length - 1 && c <= model[r].length - 1 && model[r][c] == 'W'){
			model[currentRow][currentCol] = 'W';
			model[r][c] = 'E';
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void main(String[] args) throws Exception{
		(new Thread(new GameRunner())).start();
	}
	
	public void run() {
		RandomWalk rW0 = new RandomWalk(model, zombRow0, zombCol0);
		RandomWalk rW1 = new RandomWalk(model, zombRow1, zombCol2);
		RandomWalk rW2 = new RandomWalk(model, zombRow2, zombCol2);
		RandomWalk rW3 = new RandomWalk(model, zombRow3, zombCol3);
		RandomWalk rW4 = new RandomWalk(model, zombRow4, zombCol4);
		RandomWalk rW5 = new RandomWalk(model, zombRow5, zombCol5);
	}
}