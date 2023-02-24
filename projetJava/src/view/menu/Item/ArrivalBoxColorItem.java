package view.menu.Item;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JMenuItem;

import view.MazeFenetre;

public class ArrivalBoxColorItem extends JMenuItem implements ActionListener{
private final MazeFenetre mazeFenetre;
	
	/**
	 * To change color of arrival box by using JColorChooser
	 * @param mazeFenetre
	 */
	public ArrivalBoxColorItem(MazeFenetre mazeFenetre) {
		super("Arrival Box");
		
		this.mazeFenetre = mazeFenetre;
		// Add listener to this menu item
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		Color newArrBoxColor = JColorChooser.showDialog(mazeFenetre,
				"Change arrival box color",
				mazeFenetre.getMazeModel().getArrBoxColor() );
		//If no color is chosen, nothing is modified
		if(newArrBoxColor==null) {return;}
		// If user had chosen a color, set new color in maze model
		mazeFenetre.getMazeModel().setArrBoxColor(newArrBoxColor);
		
	}

}
