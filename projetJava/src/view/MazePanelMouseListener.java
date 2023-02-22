package view;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;

public class MazePanelMouseListener extends MouseAdapter implements MouseListener{

	private final MazeFenetre mazeFenetre;
	
	public MazePanelMouseListener(MazeFenetre mazeFenetre) {
		super();
		this.mazeFenetre = mazeFenetre;		
	}
	
	public final void mouseClicked(MouseEvent e) {
		int x = e.getX();
	    int y = e.getY();
	    System.out.println(x);
	    System.out.println(y);
	    int column = 0;
	    int radius = mazeFenetre.getMazeModel().getRadiusHexagon();
	    int row = (int) (y/(radius*1.35));
	    if(row%2==0) {
	    	column = (int) (x/(0.88*(radius*Math.sqrt(3))));
	    }
	    else {
	    	column = (int) ((x-0.5*radius*Math.sqrt(3))/(0.88*(radius*Math.sqrt(3))));
	    }

	    System.out.println(row);
	    System.out.println(column);
	    
	    if(row>mazeFenetre.getMazeModel().getLongueurMaze()-1 || column>mazeFenetre.getMazeModel().getLargeurMaze()-1) {
	    	return;
	    }
	    char type = mazeFenetre.getMazeModel().getSelectedTypeHexagon();
	    if(type=='A' && mazeFenetre.getMazeModel().getEndBox()!=null) {
	    	JOptionPane.showMessageDialog(mazeFenetre, "You have already selected Arrival Box!",
		               "Error!", JOptionPane.WARNING_MESSAGE);
	    }
	    else if(type=='D' && mazeFenetre.getMazeModel().getStartBox()!=null) {
	    	JOptionPane.showMessageDialog(mazeFenetre, "You have already selected Departure Box!",
		               "Error!", JOptionPane.WARNING_MESSAGE);
	    }
	    else {mazeFenetre.getMazeModel().setTypeBox(row, column, type);}

	}
	
	

}
                                                                                            