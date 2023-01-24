package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class MazePanel extends JPanel{
	
	private final MazeFenetre mazeFenetre;
	private HexagonPanel[][] hexagonPanel;
	private int height;
	private int width;
	
	public MazePanel(MazeFenetre mazeFenetre) {
		this.mazeFenetre = mazeFenetre;
		
		setPreferredSize(new Dimension(500,500));
		setBackground(Color.white);
		
		hexagonPanel = new HexagonPanel[width][height];
		
	}
	
	public void drawHexMaze(int width, int height) {
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				double x = 100 + 2*30*Math.sqrt(3*j) + (i%2)*Math.sqrt(3*30);
				double y = 100 + i*3*30;
			}
		}
	}
	
}
