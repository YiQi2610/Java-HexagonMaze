package view.menu.Item;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JMenuItem;

import view.MazeFenetre;

public class WallBoxColorItem extends JMenuItem implements ActionListener{
private final MazeFenetre mazeFenetre;
	
	/**
	 * To change color of wall box by using JColorChooser
	 * @param mazeFenetre
	 */
	public WallBoxColorItem(MazeFenetre mazeFenetre) {
		super("Wall Box");
		
		this.mazeFenetre = mazeFenetre;
		// Add listener to this menu item
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Color newWallBoxColor = JColorChooser.showDialog(mazeFenetre,
				"Change wall box color",
				mazeFenetre.getMazeModel().getWallBoxColor() );
		//If no color is chosen, nothing is modified
		if(newWallBoxColor==null) {return;}
		// If user had chosen a color, set new color in maze model
		mazeFenetre.getMazeModel().setWallBoxColor(newWallBoxColor);
		
	}

}
