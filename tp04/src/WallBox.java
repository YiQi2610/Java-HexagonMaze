import graph.Vertex;

public class WallBox extends MazeBox {

	public WallBox(int xBox, int yBox, Maze refLabyrinthe) {
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

	@Override
	public void setPrevious(Vertex prevVertex) {
		// TODO Auto-generated method stub
		
	}

}
