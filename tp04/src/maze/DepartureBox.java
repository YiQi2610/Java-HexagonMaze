package maze;

public class DepartureBox extends EmptyBox {

	public DepartureBox(int xBox, int yBox,Maze refLabyrinthe) {
		super(xBox, yBox, refLabyrinthe);
	}
	
	public boolean isDeparture() {
		return true;
	}
}
