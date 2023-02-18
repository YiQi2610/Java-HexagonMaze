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
	
	public MazePanel(MazeFenetre mazeFenetre) {
		//setSize(new Dimension(1000,1000));
		//setBounds(100, 100, 800, 1000);
		setBackground(Color.white);
		setVisible(true);
		this.mazeFenetre = mazeFenetre;
		MazePanelMouseListener mazePanelMouseListener = new MazePanelMouseListener(mazeFenetre);
		addMouseListener(mazePanelMouseListener);	
	}
	
	
	protected void paintComponent(Graphics g) { 
		super.paintComponent(g);
		mazeFenetre.getMazeModel().createHexagonMaze(g);    
    }


	public void notifyForUpdate() {
		repaint();
		
	}
	
}
