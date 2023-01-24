import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class JCPanel extends JPanel implements MouseListener{
	public JCPanel() {
		super();
		setPreferredSize(new Dimension(500,500));
		setBackground(Color.white);
		addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		g.clearRect(0,0,500,500);
		g.setColor(Color.red);
		g.fillOval(200, 200, 200, 200);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		double d = Math.sqrt((x-300)*(x-300)+(y-300)*(y-300));
		if(d <= 100) {
			Color c = Color.cyan;
			repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
