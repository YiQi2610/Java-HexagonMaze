package maze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public abstract class MazeBox implements graph.Vertex{
	
	//Two attributs for coordinate
	private int xBox;
	private int yBox;
	private char name;
	private Maze refLabyrinthe;
	private boolean isPath;
	
	
	//Constructor
	public MazeBox(int xBox, int yBox, Maze refLabyrinthe) {
		super();
		this.xBox = xBox;
		this.yBox = yBox;
		this.isPath = false;
		this.refLabyrinthe = refLabyrinthe;
	}

	//Getter and setter
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
	
	public boolean isPath() {
		return isPath;
	}

	public void setPath(boolean isPath) {
		this.isPath = isPath;
	}
	
	/**
	 * To know the coordinates x and y of vertex 
	 * @return String of "x:y"
	 */
	public String getLabel() {
		String label = xBox + ":" + yBox;
		return label;
	}

	//To set the box name with its function (wall, empty, arrival or departure)
	public void setName(char name) {
		this.name = name;
	}
	
	//To know the function of the mazebox (is it a wall or an empty box?)
	public char getName() {
		return name;
	}

	public Maze getRefLabyrinthe() {
		return refLabyrinthe;
	}

	public void setRefLabyrinthe(Maze refLabyrinthe) {
		this.refLabyrinthe = refLabyrinthe;
	}

	//To identify whether the mazebox is a wall box
	public boolean isWall() {
		return false;
	}
		
	//To identify whether the mazebox is a departure box
	public boolean isDeparture() {
		return false;
	}
	
	//To identify whether the mazebox is an empty box
	public boolean isEmpty() {
		return false;
	}
	
	//To identify whether the mazebox is an arrival box
	public boolean isArrival() {
		return false;
	}
			

	public void paint(Graphics graphics, int radius, Point center, Color color) {
		Polygon polygon = new Polygon();

        for (int i = 0; i < 6; i++) {
            int xval = (int) (center.x + radius* Math.sqrt(3)/2*Math.cos(i * Math.PI / 3 + Math.PI/ 6));
            int yval = (int) (center.y + radius* Math.sqrt(3)/2*Math.sin(i * Math.PI / 3 + Math.PI/ 6));
            polygon.addPoint(xval, yval);
        }
        graphics.setColor(color);
		graphics.fillPolygon(polygon);
		graphics.setColor(Color.black);
		graphics.drawPolygon(polygon);

	}
}
