package view.menu.Item;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JMenuItem;

import view.MazeFenetre;

public class PathBoxColorItem extends JMenuItem implements ActionListener{
private final MazeFenetre mazeFenetre;
	
	/**
	 * To change color of path box by using JColorChooser
	 * @param mazeFenetre
	 */
	public PathBoxColorItem(MazeFenetre mazeFenetre) {
		super("Path Box");
		
		this.mazeFenetre = mazeFenetre;
		// Add listener to this menu item
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Color newPathBoxColor = JColorChooser.showDialog(mazeFenetre,
				"Change empty box color",
				mazeFenetre.getMazeModel().getPathBoxColor() );
		//If no color is chosen, nothing is modified
		if(newPathBoxColor==null) {return;}
		// If user had chosen a color, set new color in maze model
		mazeFenetre.getMazeModel().setPathBoxColor(newPathBoxColor);
		
	}

}
