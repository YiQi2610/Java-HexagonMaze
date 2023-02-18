package view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ColorPanel extends JPanel{
	private final MazeFenetre mazeFenetre;
	private final String[] labels;
	
	
	public ColorPanel(MazeFenetre mazeFenetre) {
		//setLayout(new GridLayout(5,2));
		this.mazeFenetre = mazeFenetre;
		this.labels = new String[5];
		
		labels[0] = "Empty Box";
		labels[1] = "Wall Box";
		labels[2] = "Departure Box";
		labels[3] = "Arrival Box";
		labels[4] = "Path Box";

	}
	
	 public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.setColor(mazeFenetre.getMazeModel().getEmptyBoxColor());
	        g.fillRect(10, 0, 35, 20);
	        g.setColor(mazeFenetre.getMazeModel().getWallBoxColor());
	        g.fillRect(10, 25, 35, 20);
	        g.setColor(mazeFenetre.getMazeModel().getDepBoxColor());
	        g.fillRect(10, 50, 35, 20);
	        g.setColor(mazeFenetre.getMazeModel().getArrBoxColor());
	        g.fillRect(10, 75, 35, 20);
	        g.setColor(mazeFenetre.getMazeModel().getPathBoxColor());
	        g.fillRect(10, 100, 35, 20);
	        
	        for(int i = 0; i<5; i++) {
	        	g.setColor(Color.black);
	        	g.drawString(labels[i], 60, 25*(i)+15);
	        }
	        
	    }

	public void notifyForUpdate() {
		repaint();
		
	}
}
