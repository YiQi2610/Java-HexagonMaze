package view.menu.Item;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JMenuItem;

import view.MazeFenetre;

public class EmptyBoxColorItem extends JMenuItem implements ActionListener{
private final MazeFenetre mazeFenetre;
	
	public EmptyBoxColorItem(MazeFenetre mazeFenetre) {
		super("Empty Box");
		
		this.mazeFenetre = mazeFenetre;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Color newEmptyBoxColor = JColorChooser.showDialog(mazeFenetre,
				"Change empty box color",
				mazeFenetre.getMazeModel().getEmptyBoxColor() );
		mazeFenetre.getMazeModel().setEmptyBoxColor(newEmptyBoxColor);
		
	}
}
