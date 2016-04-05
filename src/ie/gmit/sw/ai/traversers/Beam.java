package ie.gmit.sw.ai.traversers;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import ie.gmit.sw.ai.*;

public class Beam {
	private int gR;
	private int gC;
	private int beamWidth = 1;
	
	public Beam(int gR, int gC, int beamWidth){
		this.gR = gR;
		this.gC = gC;
		this.beamWidth = beamWidth;
		//System.out.println("have goal");
	}
	
	public void findExit(char[][] model, int cR, int cC){
		LinkedList<Node> queue = new LinkedList<Node>();
		Node node = new Node(gR, gC);
		Node goal = new Node(cR, cC);
		queue.addFirst(node);
		//System.out.println(node.getRow() + " " + node.getCol());
		
		while(!queue.isEmpty()){
			node = queue.poll();
			//System.out.println(node.getRow() + " " + node.getCol());
			node.setVisited(true);
			
			if (node.isGoalNode()){
				System.exit(0);
			}
			
			//System.out.println("in the loop");
			
			//System.out.println("Starting node = " + node.getRow() + ", " + node.getCol());
			//System.out.println("Goal node = " + goal.getRow() + ", " + goal.getCol());
			
			//System.out.println(goal.getRow() + " " + goal.getCol());
			//System.out.println(node.getRow() + " " + node.getCol());
			
			if ((node.getRow() == goal.getRow()) && (node.getCol() == goal.getCol())){
				System.exit(0);
			}
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			java.util.List<Node> children = new java.util.ArrayList<Node>();
			Node ch;
			
			if(model[cR + 1][cC] == ' '){	
				ch = new Node(cR + 1, cC);
				children.add(ch);
			}
			
			if(model[cR][cC + 1] == ' '){
				ch = new Node(cR, cC + 1);
				children.add(ch);
			}
			
			if(model[cR -1][cC] == ' '){
				ch = new Node(cR - 1, cC);
				children.add(ch);
			}
			
			if(model[cR][cC -1] == ' '){
				ch = new Node(cR, cC - 1);
				children.add(ch);
			}
			System.out.println(children.get(0));
			
			//Collections.sort(Arrays.asList(children),(Node current, Node next) -> current.getHeuristic(goal) - next.getHeuristic(goal));
			Collections.sort(children, (Node current, Node next) -> current.getHeuristic(goal) - next.getHeuristic(goal));
			System.out.println(children.get(0));
			int bound = 0;
			
			if (children.size() < beamWidth){
				bound = children.size();
			}else{
				bound = beamWidth;
			}

			
			/*if (node == goal){
				System.exit(0);
			}*/
			//System.out.println(queue.size());
			//System.out.println(node.getHeuristic(goal));
			for (int i = 0; i < bound; i++) {
				if (children.get(i) != null && !children.get(i).isVisited()){
					children.get(i).setParent(node);
					queue.addFirst(children.get(i));
					//System.out.println(queue.get(i).getRow() + " " + queue.get(i).getCol());
				}
				//System.out.println(node.getRow() + " " + node.getCol());
			}
		}
	}
}
