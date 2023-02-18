package view.menu.Item;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JMenuItem;

import view.MazeFenetre;

public class PathBoxColorItem extends JMenuItem implements ActionListener{
private final MazeFenetre mazeFenetre;
	
	public PathBoxColorItem(MazeFenetre mazeFenetre) {
		super("Path Box");
		
		this.mazeFenetre = mazeFenetre;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Color newPathBoxColor = JColorChooser.showDialog(mazeFenetre,
				"Change empty box color",
				mazeFenetre.getMazeModel().getPathBoxColor() );
		mazeFenetre.getMazeModel().setPathBoxColor(newPathBoxColor);
		
	}

}
