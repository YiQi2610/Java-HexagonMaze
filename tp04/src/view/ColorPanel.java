package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColorPanel extends JPanel{
	private final JLabel emptyBoxLabel;
	private final JLabel wallBoxLabel;
	private final JLabel depBoxLabel;
	private final JLabel arrBoxLabel;
	private final JLabel pathBoxLabel;
	
	
	public ColorPanel(MazeFenetre mazeFenetre,Graphics g) {
		setLayout(new GridLayout(5,2));
		
		emptyBoxLabel = new JLabel("Empty Box");
		wallBoxLabel = new JLabel("Wall Box");
		depBoxLabel = new JLabel("Depature Box");
		arrBoxLabel = new JLabel("Arrival Box");
		pathBoxLabel = new JLabel("Path Box");
		
		JPanel emptyBoxPane = new JPanel();
		((ColorPanel) emptyBoxPane).paintRect(g,mazeFenetre.getMazeModel().getEmptyBoxColor());
		add(emptyBoxPane);
		add(emptyBoxLabel);
	}
	
	public void paintRect(Graphics g,Color color) {
	    g.fillRect (10, 10, 200, 200);
	    g.setColor(color);
	}
}
