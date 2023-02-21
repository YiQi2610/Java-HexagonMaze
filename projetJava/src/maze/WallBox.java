package maze;
import java.awt.Color;

import graph.Vertex;

public class WallBox extends MazeBox {
	
	
	public WallBox(int xBox, int yBox, Maze refLabyrinthe) {
		super(xBox, yBox, refLabyrinthe);
		this.setName('W');
	}
	
	//To identify whether the mazebox is a wall box
	public boolean isWall() {
		return true;
	}
	
	
}
