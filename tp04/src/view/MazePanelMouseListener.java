package view;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MazePanelMouseListener extends MouseAdapter implements MouseListener{
	
	private final MazeFenetre mazeFenetre;
	
	public MazePanelMouseListener(MazeFenetre mazeFenetre) {
		super();
		this.mazeFenetre = mazeFenetre;		
	}
	
	public final void mouseClicked(MouseEvent e) {
//		int x = e.getX();
//	    int y = e.getY();
//	    int x0 = 100;
//	    int y0 = 100;
//	    int s = mazeFenetre.getMazeModel().getRadiusHexagon();
//	    int q = (int) Math.round((2.0/3 * (x - x0)) / s);
//	    int r = (int) Math.round((-1.0/3 * (x - x0) + Math.sqrt(3)/3 * (y - y0)) / s);
//	    if (q >= 0 && q <= 9 && r >= 0 && r <= 9) {
//	        System.out.println(q);
//	        System.out.println(r);
//	    }
	}

}
