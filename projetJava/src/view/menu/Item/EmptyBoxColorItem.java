package view.menu.Item;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JMenuItem;

import view.MazeFenetre;

public class EmptyBoxColorItem extends JMenuItem implements ActionListener{
private final MazeFenetre mazeFenetre;
	
	/**
	 * To change color of empty box by using JColorChooser
	 * @param mazeFenetre
	 */
	public EmptyBoxColorItem(MazeFenetre mazeFenetre) {
		super("Empty Box");
		
		this.mazeFenetre = mazeFenetre;
		// Add listener to this menu item
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Color newEmptyBoxColor = JColorChooser.showDialog(mazeFenetre,
				"Change empty box color",
				mazeFenetre.getMazeModel().getEmptyBoxColor() );
		//If no color is chosen, nothing is modified
		if(newEmptyBoxColor==null) {return;}
		// If user had chosen a color, set new color in maze model
		mazeFenetre.getMazeModel().setEmptyBoxColor(newEmptyBoxColor);
		
	}
}
