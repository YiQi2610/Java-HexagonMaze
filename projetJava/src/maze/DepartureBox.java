package maze;

public class DepartureBox extends EmptyBox {//Departure box belongs to empty box

	public DepartureBox(int xBox, int yBox,Maze refLabyrinthe) {
		super(xBox, yBox, refLabyrinthe);
		this.setName('D');//label used to save a labyrinth in text file
	}
	
	/**
	 * Return true when checking if the mazebox is a departure box
	 */
	public boolean isDeparture() {
		return true;
	}
}
