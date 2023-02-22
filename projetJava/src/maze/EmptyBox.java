package maze;
import graph.Vertex;

public class EmptyBox extends MazeBox {//EmptyBox belongs to MazeBox

	public EmptyBox(int xBox, int yBox, Maze refLabyrinthe) {
		super(xBox, yBox, refLabyrinthe);
		this.setName('E');//label used to save a labyrinth in text file
	}
	
	/**
	 * Return true when checking if the mazebox is a departure box
	 */
	public boolean isEmpty() {
		return true;
	}

	

}
