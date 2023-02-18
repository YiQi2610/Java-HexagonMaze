package view.menu.Item;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JMenuItem;

import view.MazeFenetre;

public class WallBoxColorItem extends JMenuItem implements ActionListener{
private final MazeFenetre mazeFenetre;
	
	public WallBoxColorItem(MazeFenetre mazeFenetre) {
		super("Wall Box");
		
		this.mazeFenetre = mazeFenetre;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Color newWallBoxColor = JColorChooser.showDialog(mazeFenetre,
				"Change wall box color",
				mazeFenetre.getMazeModel().getWallBoxColor() );
		mazeFenetre.getMazeModel().setWallBoxColor(newWallBoxColor);
		
	}

}
