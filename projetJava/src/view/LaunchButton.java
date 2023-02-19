package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

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
		if(mazeFenetre.getMazeModel().isModified()==false) {
			JOptionPane.showMessageDialog(mazeFenetre, "No shortest path exists!",
		               "Error!", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	public void notifyForUpfate() {
		// TODO Auto-generated method stub
		
	}
	

}
