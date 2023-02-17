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
		int x = e.getX()-10;
	    int y = e.getY();
	    
	    int radius = mazeFenetre.getMazeModel().getRadiusHexagon();
	    int row = (int)(y/(radius*1.5));
	    int column = (int) ((x+radius-((row%2)*radius*Math.sqrt(3)/2))/(Math.sqrt(3)*radius));
	    
	    //int row = (int)(y-radius/2)/(radius*3);
	    //int column = (int)((x-Math.sqrt(3)*radius*(row%2))/(Math.sqrt(3)*2*radius));
	    //System.out.println(radius);
	    System.out.println(row);
	    System.out.println(column);

	}

}
