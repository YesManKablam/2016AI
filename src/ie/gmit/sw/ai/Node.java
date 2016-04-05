package ie.gmit.sw.ai;

public class Node {
	
	private int row = -1;
	private int col = -1;
	private boolean visited = false;
	public boolean goal;
	private Node parent;
	
	public Node(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	public int getRow(){
		return row;
	}
	
	public int getCol(){
		return col;
	}
	
	public void setVisited(boolean visited){
		this.visited = visited;
	}
	
	public boolean isVisited() {
		//System.out.println(visited);
		return visited;
	}
	
	public void setGoalNode(boolean goal){
		this.goal = goal;
	}
	
	public boolean isGoalNode(){
		return goal;
	}
	
	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public int getHeuristic(Node goal){
		double x1 = this.col;
		double y1 = this.row;
		double x2 = goal.getCol();
		double y2 = goal.getRow();
		return (int) Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
	}
	
	/*public Node[] children(char[][] model){
		java.util.List<Node> children = new java.util.ArrayList<Node>();
		
		if(model[row + 1][col] == ' '){
			children.add(model[row + 1][col]);
		}
		
		if(model[row][col + 1] == ' '){
			
		}
		
		if(model[row -1][col] == ' '){
			
		}
		
		if(model[row][col -1] == ' '){
			
		}
		
		return (Node[]) children.toArray(new Node[children.size()]);
	}*/
}
