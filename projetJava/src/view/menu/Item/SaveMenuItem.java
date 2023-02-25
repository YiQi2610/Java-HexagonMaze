package view.menu.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import view.MazeFenetre;

public class SaveMenuItem extends JMenuItem implements ActionListener{
	private final MazeFenetre mazeFenetre;
	
	/**
	 * SaveMenuItem to save current labyrinth into a text file
	 * @param mazeFenetre
	 */
	public SaveMenuItem(MazeFenetre mazeFenetre) {
		super("Save");
		
		this.mazeFenetre = mazeFenetre;
		addActionListener(this);
	}

	@Override
	/**
	 * When user clicks on this menu item, a confirm dialog is shown to ask user for saving labyrinth
	 */
	public void actionPerformed(ActionEvent e) {
		int input = JOptionPane.showConfirmDialog(null, "Are you sure to save this maze?");
		
		//If user chooses "No" or "Cancel", labyrinth will not be saved and user back to interface
		if(input==1 || input==2){return;}
		
		//If user chooses "Yes" to save labyrinth
		else if(input==0) {
			
			//An input dialog is shown to ask user to enter file name
			String fileName = JOptionPane.showInputDialog( "Enter file name :" );
			
			//If user clicks cancel, labyrinth will not be saved and user back to interface, to detect if user has clicked "Cancel", we see if fileName is null
			if(fileName==null) {return;}
			fileName = "./projetJava/data/"+fileName +".txt";
			try {// If filename is not null, labyrinth will be saved in a text file with filename entered 
				mazeFenetre.getMazeModel().saveToTextFile(fileName);
				JOptionPane.showMessageDialog(null, "Your maze is saved as '" + fileName + " '.");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
	}
}
