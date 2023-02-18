package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	    int column = 0;
	    int radius = mazeFenetre.getMazeModel().getRadiusHexagon();
	    int row = (int) (y/(radius*1.35));
	    if(row%2==0) {
	    	column = (int)((x+(radius*0.7)-((row%2)*radius*Math.sqrt(3)/2))/(Math.sqrt(3)*radius));
	    }
	    else {
	    	column = (int)((x+(radius*0.7)-((row%2)*radius*Math.sqrt(3)/2))/(Math.sqrt(3)*radius));
	    }
	    
	    
	    //int row = (int)(y-radius)/(radius*(2*3));
	    //int column = (int)((x-Math.sqrt(3)*2*radius*(row%2))/(Math.sqrt(3)*4*radius));
	    //System.out.println(radius);
	    //System.out.println(x);
	    //System.out.println(y);
	    System.out.println(row);
	    System.out.println(column);
	    
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
                                                                                            