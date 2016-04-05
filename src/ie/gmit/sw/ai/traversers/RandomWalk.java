package ie.gmit.sw.ai.traversers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ie.gmit.sw.ai.*;
import ie.gmit.sw.ai.player.*;

public class RandomWalk {
	
	private Player p = new Player();
	public List<Node> children = new ArrayList<Node>();
	private int baddie = 0;
	private char[][] model;
	private int r;
	private int c;
	
	public RandomWalk(char[][] model, int r, int c){
		new Thread(new Runnable() {
			public void run() {
				try {
					traverse(model, r, c);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}

	
	public char[][] traverse(char[][] model, int r, int c) throws InterruptedException{
		int steps = (int) Math.pow(model.length, 2) * 2;
		int visitCount = 0;
		
		while(visitCount <= steps){
			model[r][c] = ' ';
			
			Random rand = new Random();
			
			int randNum = rand.nextInt(20);
			//System.out.println(randNum);
			
			p.baddie(randNum);
			
			if((model[r + 1][c] == 'E') || (model[r][c + 1] == 'E') || (model[r - 1][c] == 'E') || (model[r][c - 1] == 'E')){
				p.playerCombat();
				break;
			}
			children.clear();
			
			Node ch;
			if(model[r + 1][c] == ' '){	
				ch = new Node(r + 1, c);
				children.add(ch);
			}
			if(model[r][c + 1] == ' '){
				ch = new Node(r, c + 1);
				children.add(ch);
			}
			if(model[r -1][c] == ' '){
				ch = new Node(r - 1, c);
				children.add(ch);
			}
			if(model[r][c -1] == ' '){
				ch = new Node(r, c - 1);
				children.add(ch);
			}
			
			Node bre = children.get((int)(children.size() * Math.random()));
			//System.out.println(children.size());
			//System.out.println(bre.getRow() + " " + bre.getCol());
			
			model[bre.getRow()][bre.getCol()] = 'Z';
			
			r = bre.getRow();
			c = bre.getCol();			
			Thread.sleep(800);
		}
		return model;
	}
}

