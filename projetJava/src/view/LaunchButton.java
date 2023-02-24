package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class LaunchButton extends JButton implements ActionListener{
	private final MazeFenetre mazeFenetre;
	
	/**
	 * LaunchButton is used to launch dijsktra algorith to show shortest path from starting point to exit point
	 * @param mazeFenetre
	 */
	public LaunchButton(MazeFenetre mazeFenetre) {
		super("Launch");
		this.mazeFenetre = mazeFenetre;
		setVisible(true);
		setPreferredSize(new Dimension(150, 40));
		addActionListener(this);
	}
	
	/**
	 * When button is clicked, call function showShortestPath() from maze model to calculate the shortest path
	 * Attribut of maze, isModified will be set to true if a shortest path is found
	 * If there is no shortest path exist, isModified = false and a message will be shown, telling no shortest path exists
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		mazeFenetre.getMazeModel().showShortestPath();
		if(mazeFenetre.getMazeModel().isModified()==false) {
			JOptionPane.showMessageDialog(mazeFenetre, "No shortest path exists!",
		               "Error!", JOptionPane.WARNING_MESSAGE);
		}		
	}
	
	/**
	 * Receive message from ConfigurationPanel when there is modification in maze model and get updated
	 */
	public void notifyForUpfate() {
		// TODO Auto-generated method stub
		
	}
	

}
