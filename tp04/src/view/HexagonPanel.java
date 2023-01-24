package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class HexagonPanel extends JPanel {
	
	public HexagonPanel(MazeFenetre mazeFenetre) {
		
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Hexagon hexagon = new Hexagon(new Point(250,250), 100);
        g.setColor(Color.RED);
        g.drawPolygon(hexagon.getHexagon());
    }
}
