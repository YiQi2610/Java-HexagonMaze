package maze;

public class DepartureBox extends EmptyBox {

	public DepartureBox(int xBox, int yBox,Maze refLabyrinthe) {
		super(xBox, yBox, refLabyrinthe);
		this.setName('D');
	}
	
	public boolean isDeparture() {
		return true;
	}
}
