package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class MazePanel extends JPanel{
	
	private final MazeFenetre mazeFenetre;
	
	public MazePanel(MazeFenetre mazeFenetre) {
		setBackground(Color.white);
		setVisible(true);
		this.mazeFenetre = mazeFenetre;
		//add a mouse listener to this panel to enable user to modify the panel with mouse actions
		MazePanelMouseListener mazePanelMouseListener = new MazePanelMouseListener(mazeFenetre);
		addMouseListener(mazePanelMouseListener);		
	}
	
	/**
	 * Draw a hexagon labyrinth on maze panel by calling the maze model to draw it
	 * Give size of panel as parameter for calculation of radius
	 */
	protected void paintComponent(Graphics g) { 
		super.paintComponent(g);
		mazeFenetre.getMazeModel().createHexagonMaze(g,this.getSize());  
    }
	
	/**
	 * When there is modification from maze model, maze panel will receive notification from window panel to repaint the labyrinth
	 */
	public void notifyForUpdate() {
		repaint();	
	}
	
}
