
public class Maze {
	
	private int largeurMaze;
	private int longueurMaze;
	private MazeBox[][] labyrinthe;
 
	
	public Maze(int largeurMaze, int longueurMaze) {
		super();
		this.largeurMaze = largeurMaze;
		this.longueurMaze = longueurMaze; 
		this.labyrinthe = new MazeBox[largeurMaze][longueurMaze];
	}
	
	public MazeBox[] getNeighbours(MazeBox box) {
		MazeBox[] boxNeighbours ;
		
		int xCoord = box.getxBox();
		int yCoord = box.getyBox();
		
		return boxNeighbours;	
	}
	
}
