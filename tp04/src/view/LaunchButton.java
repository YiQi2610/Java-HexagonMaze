package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class LaunchButton extends JButton implements ActionListener{
	private final MazeFenetre mazeFenetre;

	public LaunchButton(MazeFenetre mazeFenetre) {
		super("Launch");
		this.mazeFenetre = mazeFenetre;
		setVisible(true);
		setPreferredSize(new Dimension(150, 40));
		addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		mazeFenetre.getMazeModel().showShortestPath();
		
	}
	public void notifyForUpfate() {
		// TODO Auto-generated method stub
		
	}
	

}
