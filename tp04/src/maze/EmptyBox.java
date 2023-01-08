package maze;
import graph.Vertex;

public class EmptyBox extends MazeBox {

	public EmptyBox(int xBox, int yBox, Maze refLabyrinthe) {
		super(xBox, yBox, refLabyrinthe);
	}

	@Override
	public Vertex getVertexNotProcessed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vertex getPrevVertex() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vertex[] getSuccesors() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
