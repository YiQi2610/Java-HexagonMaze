package maze;

public class ArrivalBox extends EmptyBox { //arrival box belongs to emptybox

	public ArrivalBox(int xBox, int yBox, Maze refLabyrinthe) {
		super(xBox, yBox, refLabyrinthe);
		this.setName('A');//label used to save a labyrinth in text file
	}
	
	/**
	 * Return true when checking if the mazebox is an arrival box
	 */
	public boolean isArrival() {
		return true;
	}
}
