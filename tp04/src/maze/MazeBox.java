package maze;

public abstract class MazeBox implements graph.Vertex{
	
	//Two attributs for coordinate
	private int xBox;
	private int yBox;
	private char name;
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
	
	
	public String getLabel() {
		String label = xBox + ":" + yBox;
		return label;
	}

	//To set the box name with its function (wall, empty, arrival or departure)
	public void setName(char name) {
		this.name = name;
	}
	
	//To know the function of the mazebox (is it a wall or an empty box?)
	public char getName() {
		return name;
	}

	public Maze getRefLabyrinthe() {
		return refLabyrinthe;
	}

	public void setRefLabyrinthe(Maze refLabyrinthe) {
		this.refLabyrinthe = refLabyrinthe;
	}

	
	//To identify whether the mazebox is a wall box
	public boolean isWall() {
		return false;
	}
		
	//To identify whether the mazebox is a departure box
	public boolean isDeparture() {
		return false;
	}
	
	//To identify whether the mazebox is an empty box
	public boolean isEmpty() {
		return false;
	}
	
	//To identify whether the mazebox is an arrival box
	public boolean isArrival() {
		return false;
	}
}
