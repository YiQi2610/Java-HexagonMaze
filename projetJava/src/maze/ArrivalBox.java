package maze;

public class ArrivalBox extends EmptyBox {

	public ArrivalBox(int xBox, int yBox, Maze refLabyrinthe) {
		super(xBox, yBox, refLabyrinthe);
		this.setName('A');
	}
	
	public boolean isArrival() {
		return true;
	}
}