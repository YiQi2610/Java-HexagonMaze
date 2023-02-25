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
	
	/**
	 * When user clicks on one of the mazeboxes in labyrinth, it identifies the coordinates of mazebox clicked
	 * Change type of mazebox by calling function setTypeBox() from maze model
	 */
	public final void mouseClicked(MouseEvent e) {
		// Get coordinates of cursor clicked on labyrinth
		int x = e.getX();
	    int y = e.getY();
	    int column = 0;
	    
	    // Get radius of hexagon for calculation of row and column
	    int radius = mazeFenetre.getMazeModel().getRadiusHexagon();
	    
	    // Find the row of maze box clicked with y coordinate of cursor
	    int row = (int) (y/(radius*1.25));
	    
	    // If the row found is even, find the column 
	    // I tried using exact calculation but it doesn't work well so I multiply it with 0.88
	    if(row%2==0) {
	    	column = (int) (x/(0.88*(radius*Math.sqrt(3))));
	    }
	    // If the row found is odd, find the column with substracting radius*sqrt(3)/2
	    else {
	    	column = (int) ((x-0.5*radius*Math.sqrt(3))/(0.88*(radius*Math.sqrt(3))));
	    }
	    
	    //If the row and column found is greater than dimension of labyrinth, nothing will be modified
	    if(row>mazeFenetre.getMazeModel().getLongueurMaze()-1 || column>mazeFenetre.getMazeModel().getLargeurMaze()-1) {
	    	return;
	    }
	    
	    // Get the option selected in selection panel
	    char type = mazeFenetre.getMazeModel().getSelectedTypeHexagon();
	    	    
	    // Show error message when option selected is arrival box but arrival box has already existed
	    // This is to avoid selecting more than one arrival box
	    if(type=='A' && mazeFenetre.getMazeModel().getEndBox()!=null) {
	    	JOptionPane.showMessageDialog(mazeFenetre, "You have already selected Arrival Box!",
		               "Error!", JOptionPane.WARNING_MESSAGE);
	    }
	    
	    // Show error message when option selected is departure box but departure box has already existed
	    // This is to avoid selecting more than one departure box
	    else if(type=='D' && mazeFenetre.getMazeModel().getStartBox()!=null) {
	    	JOptionPane.showMessageDialog(mazeFenetre, "You have already selected Departure Box!",
		               "Error!", JOptionPane.WARNING_MESSAGE);
	    }
	    
	    //Change the type of mazebox clicked by calling setTypeBox() with parameters row, column and type
	    else {mazeFenetre.getMazeModel().setTypeBox(row, column, type);}

	}
	
	

}
                                                                                            