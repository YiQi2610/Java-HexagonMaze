package maze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public abstract class MazeBox implements graph.Vertex{
	
	
	private final int row; // number of row of mazebox
	private final int column; // number of column of mazebox
	private char name;// label of mazebox (ex: A,D,W,E)
	private boolean isPath;// true if the mazebox is in the shortest path, false if not
	
	
	//Constructor
	public MazeBox(int row, int column) {
		super();
		this.row = row;
		this.column = column;
		this.isPath = false;
	}

	//Getter and setter
	public int getxBox() {
		return row;
	}

	public int getyBox() {
		return column;
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
		String label = row + ":" + column;
		return label;
	}

	/**
	 * To set the box name with its function (wall, empty, arrival or departure)
	 * Used in classes which extend Mazebox
	 * @param name
	 */
	public void setName(char name) {
		this.name = name;
	}
	
	/**
	 * To know the function of the mazebox (is it a wall,empty, arrival or departure box?)
	 * Used when saving a labyrinth in a text file
	 * @return label of Mazebox
	 */
	public char getName() {
		return name;
	}
	
	/**
	 * To identify whether the mazebox is a wall box, return true only when the mazebox is a wall box
	 * To avoid comaparing the name of mazebox everytime to know its type
	 * @return false
	 */
	public boolean isWall() {
		return false;
	}
		
	/**
	 * To identify whether the mazebox is a departure box, return true only when the mazebox is a departure box
	 * @return false 
	 */
	public boolean isDeparture() {
		return false;
	}
	
	/**
	 * To identify whether the mazebox is an empty box, return true only when the mazebox is a empty box
	 * @return false
	 */
	public boolean isEmpty() {
		return false;
	}
	
	/**
	 * To identify whether the mazebox is an arrival box, return true only when the mazebox is an arrival box
	 * @return false
	 */
	public boolean isArrival() {
		return false;
	}
			
	/**
	 * Draw hexagon box on panel based on its type, color, radius and center
	 * redraw when there are changes in maze model
	 * @param graphics
	 * @param radius
	 * @param center
	 * @param color
	 */
	public void paint(Graphics graphics, int radius, Point center, Color color) {
		// create a new Polygon object to hold the vertices of the hexagon
		Polygon polygon = new Polygon();
		
		// loop through 6 vertices of the hexagon
        for (int i = 0; i < 6; i++) {
        	// calculate the x and y coordinates of the current vertex using trigonometry
            int xval = (int) (center.x + radius* Math.sqrt(3)/2*Math.cos(i * Math.PI / 3 + Math.PI/ 6));
            int yval = (int) (center.y + radius* Math.sqrt(3)/2*Math.sin(i * Math.PI / 3 + Math.PI/ 6));
            // add the vertex to the Polygon object
            polygon.addPoint(xval, yval);
        }
        // set the fill color to the given color and fill the hexagon
        graphics.setColor(color);
		graphics.fillPolygon(polygon);
		// set the outline color to black and draw the outline of the hexagon
		graphics.setColor(Color.black);
		graphics.drawPolygon(polygon);

	}
}
