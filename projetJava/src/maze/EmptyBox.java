package maze;
import graph.Vertex;

public class EmptyBox extends MazeBox {

	public EmptyBox(int xBox, int yBox, Maze refLabyrinthe) {
		super(xBox, yBox, refLabyrinthe);
		this.setName('E');
	}
	
	public boolean isEmpty() {
		return true;
	}

	

}
