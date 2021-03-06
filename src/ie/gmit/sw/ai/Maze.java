package ie.gmit.sw.ai;

public class Maze {
	private char[][] maze;
		
	public Maze(int rows, int cols){
		maze = new char[rows][cols];
		init();
		buildMaze();
		int featureNumber = (int)((rows * cols) * 0.01);
		addFeature('W', 'X', featureNumber);
	}
	
	private void init(){
		for (int row = 0; row < maze.length; row++){
			for (int col = 0; col < maze[row].length; col++){
				maze[row][col] = 'X';
			}
		}
	}
	
	private void addFeature(char feature, char replace, int number){
		int counter = 0;
		while (counter < number){									//	There was an error here. It was used to be while(counter < feature). That made no sense.
			int row = (int) (maze.length * Math.random());
			int col = (int) (maze[0].length * Math.random());
			
			if (maze[row][col] == replace){
				maze[row][col] = feature;
				counter++;
			}
		}
	}
	
	
	private void buildMaze(){
		for (int row = 0; row < maze.length; row++){
			for (int col = 0; col < maze[row].length - 1; col++){
				int num = (int) (Math.random() * 10);
				if (num >= 5 && col + 1 < maze[row].length - 1){
					maze[row][col + 1] = ' ';
					continue;
				}
				if (row + 1 < maze.length){ //Check south
					maze[row + 1][col] = ' ';
				}				
			}
		}
		for(int row = 0; row < maze.length; row++){
				int col = 0;
				maze[row][col] = 'X';
		}
		for(int col = 0; col < maze.length; col++){
			int row = 0;
			maze[row][col] = 'X';
		}
		for(int row = 0; row < maze.length; row++){
			int col = 59;
			maze[row][col] = 'X';
		}
		for(int col = 0; col < maze.length; col++){
			int row = 59;
			maze[row][col] = 'X';
		}
	}
	
	public char[][] getMaze(){
		return this.maze;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for (int row = 0; row < maze.length; row++){
			for (int col = 0; col < maze[row].length; col++){
				sb.append(maze[row][col]);
				if (col < maze[row].length - 1) sb.append(",");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}