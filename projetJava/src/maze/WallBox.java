package maze;

public class WallBox extends MazeBox { //Wall box belongs to mazebox but not emptybox
		
	public WallBox(int xBox, int yBox, Maze refLabyrinthe) {
		super(xBox, yBox, refLabyrinthe);
		this.setName('W'); //label used to save a labyrinth in text file
	}
	
	/**
	 * Return true when checking if the mazebox is a wall box
	 */
	public boolean isWall() {
		return true;
	}
	
	
}
