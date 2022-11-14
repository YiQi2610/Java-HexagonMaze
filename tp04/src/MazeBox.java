import java.util.ArrayList;

public abstract class MazeBox implements graph.Vertex{
	
	//Two attributs for coordinate
	private int xBox;
	private int yBox;
	private Maze refLabyrinthe;
	
	//Constructor
	public MazeBox(int xBox, int yBox, Maze refLabyrinthe) {
		super();
		this.xBox = xBox;
		this.yBox = yBox;
		this.refLabyrinthe = refLabyrinthe;
	}

	//Getter and setter
	public int getxBox() {
		return xBox;
	}

	public void setxBox(int xBox) {
		this.xBox = xBox;
	}

	public int getyBox() {
		return yBox;
	}

	public void setyBox(int yBox) {
		this.yBox = yBox;
	}

	public Maze getRefLabyrinthe() {
		return refLabyrinthe;
	}

	public void setRefLabyrinthe(Maze refLabyrinthe) {
		this.refLabyrinthe = refLabyrinthe;
	}
	
	//Ask for neighbors from labyrinth 
	public ArrayList <MazeBox> getNeighboursList(MazeBox box) {
		return box.refLabyrinthe.getNeighbours(box);
	}
	
	public String getLabel() {
		String label = "(" + this.getxBox() + "," + this.getyBox() + ")";
		return label ;
	}
}
