package view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ColorPanel extends JPanel{
	private final MazeFenetre mazeFenetre;
	private final String[] labels;
	
	/**
	 * Color panel is to show colors used for different types of maze boxes
	 * @param mazeFenetre
	 */
	public ColorPanel(MazeFenetre mazeFenetre) {
		this.mazeFenetre = mazeFenetre;
		this.labels = new String[5];
		
		//Define five labels for five types of maze boxes
		labels[0] = "Empty Box";
		labels[1] = "Wall Box";
		labels[2] = "Departure Box";
		labels[3] = "Arrival Box";
		labels[4] = "Path Box";

	}
	
	/**
	 * Draw a color bar which has five rectangles filled with color on the left and five labels on the right
	 */
	 public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        // Get color of empty box from maze model
	        g.setColor(mazeFenetre.getMazeModel().getEmptyBoxColor());
	        // Fill respective color in rectangle at position x=10, y=0 with width=35 and height=20
	        g.fillRect(10, 0, 35, 20);
	        // Get color of wall box from maze model
	        g.setColor(mazeFenetre.getMazeModel().getWallBoxColor());
	        // Same step as above but moved 25 downwards
	        g.fillRect(10, 25, 35, 20);
	        // Get color of departure box from maze model
	        g.setColor(mazeFenetre.getMazeModel().getDepBoxColor());
	        // Same step as above but moved 25 downwards
	        g.fillRect(10, 50, 35, 20);
	        // Get color of arrival box from maze model
	        g.setColor(mazeFenetre.getMazeModel().getArrBoxColor());
	        // Same step as above but moved 25 downwards
	        g.fillRect(10, 75, 35, 20);
	        // Get color of path box from maze model
	        g.setColor(mazeFenetre.getMazeModel().getPathBoxColor());
	        // Same step as above but moved 25 downwards
	        g.fillRect(10, 100, 35, 20);
	        
	        // Draw labels besides all color rectangles 
	        for(int i = 0; i<5; i++) {
	        	g.setColor(Color.black);
	        	g.drawString(labels[i], 60, 25*(i)+15);
	        }
	        
	    }
	 
	/**
	 * Receive messages from ConfigurationPanel when there is modification in maze model
	 * Repaint the color bar when message received to update the colors
	 */
	public void notifyForUpdate() {
		repaint();		
	}
}
