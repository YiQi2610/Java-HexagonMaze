package view.menu.Item;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JMenuItem;

import view.MazeFenetre;

public class DepartureBoxColorItem extends JMenuItem implements ActionListener{
private final MazeFenetre mazeFenetre;
	
	/**
	 * To change color of departure box by using JColorChooser
	 * @param mazeFenetre
	 */
	public DepartureBoxColorItem(MazeFenetre mazeFenetre) {
		super("Departure Box");
		
		this.mazeFenetre = mazeFenetre;
		// Add listener to this menu item
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Color newDepBoxColor = JColorChooser.showDialog(mazeFenetre,
				"Change departure box color",
				mazeFenetre.getMazeModel().getDepBoxColor() );
		//If no color is chosen, nothing is modified
		if(newDepBoxColor==null) {return;}
		// If user had chosen a color, set new color in maze model
		mazeFenetre.getMazeModel().setDepBoxColor(newDepBoxColor);
		
	}

}
