package view.menu.Item;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JMenuItem;

import view.MazeFenetre;

public class ArrivalBoxColorItem extends JMenuItem implements ActionListener{
private final MazeFenetre mazeFenetre;
	
	public ArrivalBoxColorItem(MazeFenetre mazeFenetre) {
		super("Arrival Box");
		
		this.mazeFenetre = mazeFenetre;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Color newArrBoxColor = JColorChooser.showDialog(mazeFenetre,
				"Change arrival box color",
				mazeFenetre.getMazeModel().getArrBoxColor() );
		mazeFenetre.getMazeModel().setArrBoxColor(newArrBoxColor);
		
	}

}
