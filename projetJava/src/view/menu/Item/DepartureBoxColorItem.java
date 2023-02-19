package view.menu.Item;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JMenuItem;

import view.MazeFenetre;

public class DepartureBoxColorItem extends JMenuItem implements ActionListener{
private final MazeFenetre mazeFenetre;
	
	public DepartureBoxColorItem(MazeFenetre mazeFenetre) {
		super("Departure Box");
		
		this.mazeFenetre = mazeFenetre;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Color newDepBoxColor = JColorChooser.showDialog(mazeFenetre,
				"Change departure box color",
				mazeFenetre.getMazeModel().getDepBoxColor() );
		mazeFenetre.getMazeModel().setDepBoxColor(newDepBoxColor);
		
	}

}
