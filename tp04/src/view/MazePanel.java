package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import maze.Maze;

public class MazePanel extends JPanel{
	
	private final MazeFenetre mazeFenetre;
	private Hexagon[][] hexagonMaze;
	private int height;
	private int width;
	private Maze mazeModel = new Maze(width,height);
	
	public MazePanel(MazeFenetre mazeFenetre, int height, int width) {
		setSize(new Dimension(1000,1000));
		setBackground(Color.white);
		setVisible(true);
		this.mazeFenetre = mazeFenetre;
		this.height = height;
		this.width = width;
		this.hexagonMaze = createHexMaze();
		
	}
	
	public Hexagon[][] createHexMaze() {
		Hexagon[][] hexagonMaze = new Hexagon[width][height];
		int radius = (this.getSize().width)/(width*2);

		for(int row=0; row<height; row++) {
			for(int col=0; col<width; col++) {
				int cx = (int)(col*radius*1.5+radius);
				//int cy = (int)(row*radius*2+radius);
				int cy = (int)(int)((row*0.75*radius*Math.sqrt(3)+radius*Math.sqrt(3)/2));
				if(row % 2 != 0) {
					cx += (0.75*radius);
				}
				hexagonMaze[row][col] = new Hexagon(new Point(cx,cy), radius);
			}
		}
		return hexagonMaze;
	}
	
	protected void paintComponent(Graphics g) { 
		super.paintComponent(g);
        for(int i=0; i<height;i++) {
        	for(int j=0; j<width; j++) {	
        		g.setColor(Color.gray);
        		g.fillPolygon(hexagonMaze[i][j].getHexagon());
        		g.setColor(Color.black);
        		g.drawPolygon(hexagonMaze[i][j].getHexagon());
        	}
        }     
    }
	
	public Maze getMazeModel() {
		return mazeModel;
	}
	
	public void setMazeModel(Maze mazeModel) {
		this.mazeModel = mazeModel;
	}
	
}
