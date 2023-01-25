package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class MazePanel extends JPanel{
	
	private final MazeFenetre mazeFenetre;
	private Hexagon[][] hexagonMaze;
	private int height;
	private int width;
	
	public MazePanel(MazeFenetre mazeFenetre, int height, int width) {
		setSize(new Dimension(1000,1000));
		setBackground(Color.white);
		setVisible(true);
		this.mazeFenetre = mazeFenetre;
		this.height = height;
		this.width = width;
		this.hexagonMaze = createHexMaze(width,height);
		
	}
	
	public Hexagon[][] createHexMaze(int width, int height) {
		Hexagon[][] hexagonMaze = new Hexagon[width][height];
		int radius = (this.getSize().width)/(width*2);

		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				int x = (int)((int)(j*radius*1.5+radius));
				int y = (int)(int)((i*0.75*radius*Math.sqrt(3)+radius*Math.sqrt(3)/2));
				if(i % 2 != 0) {
					x += (int) (radius * 0.75);
				}
				hexagonMaze[i][j] = new Hexagon(new Point(x,y), radius);
			}
		}
		return hexagonMaze;
	}
	
	protected void paintComponent(Graphics g) { 
		super.paintComponent(g);
		g.setColor(Color.darkGray);
        for(int i=0; i<height;i++) {
        	for(int j=0; j<width; j++) {
                g.drawPolygon(hexagonMaze[i][j].getHexagon());
        	}
        }     
    }
}
