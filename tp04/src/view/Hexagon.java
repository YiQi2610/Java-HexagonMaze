package view;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;

public class Hexagon extends Polygon{
	
	private final int radius;
	private final Point center;
	private final Polygon hexagon;
	private final Color color;
	
	public Hexagon(Point center, int radius){
		this.center = center;
		this.radius = radius;
		this.hexagon = createHexagon();
		this.color = null;
		
	}
	
	private Polygon createHexagon() {
        Polygon polygon = new Polygon();

        for (int i = 0; i < 6; i++) {
            int xval = (int) (center.x + radius* Math.sqrt(3)/2*Math.cos(i * Math.PI / 3 + Math.PI/ 6));
            int yval = (int) (center.y + radius* Math.sqrt(3)/2*Math.sin(i * Math.PI / 3 + Math.PI/ 6));
            polygon.addPoint(xval, yval);
        }

        return polygon;
    }

	public int getRadius() {
		return radius;
	}

	public Point getCenter() {
		return center;
	}

	public Polygon getHexagon() {
		return hexagon;
	}
	
	public Color getColor() {
		return color;
	}
	
	
}
