package maze;
import java.awt.Color;

import graph.Vertex;

public class WallBox extends MazeBox {
	
	
	public WallBox(int xBox, int yBox, Maze refLabyrinthe) {
		super(xBox, yBox, refLabyrinthe);
		this.setName('W');
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
	
	//To identify whether the mazebox is a wall box
	public boolean isWall() {
		return true;
	}
	
	
}
