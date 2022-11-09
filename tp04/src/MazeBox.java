
public abstract class MazeBox {
	
	//Two attributs for coordinate
	private int xBox;
	private int yBox;
	
	//Constructor
	public MazeBox(int xBox, int yBox) {
		super();
		this.xBox = xBox;
		this.yBox = yBox;
	}

	public int getxBox() {
		return xBox;
	}

	public void setxBox(int xBox) {
		this.xBox = xBox;
	}

	public int getyBox() {
		return yBox;
	}

	public void setyBox(int yBox) {
		this.yBox = yBox;
	}
	
	
}
