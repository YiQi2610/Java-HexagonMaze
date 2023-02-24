package view.menu.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import view.MazeFenetre;

public class QuitMenuItem extends JMenuItem implements ActionListener{
	
	private final MazeFenetre mazeFenetre;
	
	/**
	 * Quit Menu Item to quit the program
	 * @param mazeFenetre
	 */
	public QuitMenuItem(MazeFenetre mazeFenetre) {
		super("Quit");
		
		this.mazeFenetre = mazeFenetre;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * If the labyrinth is modified, it shows an option dialog to ask user if user wants to save labyrinth
		 * Provide yes, no, cancel options
		 */
		if(mazeFenetre.getMazeModel().isModified()) {
        	int input = JOptionPane.showInternalOptionDialog(this, "Labyrinth not saved. Save it?","Quit application", 
        				JOptionPane.YES_NO_CANCEL_OPTION,
        				JOptionPane.WARNING_MESSAGE,
        				null,null,null);
        	
        	// If user choose "No", the program will be closed directly
    		if(input==JOptionPane.NO_OPTION ){
    			System.exit(0);
    		}
    		
    		// If user choose "Cancel", the dialog will be closed and user back to interface
    		else if(input==JOptionPane.CANCEL_OPTION ) {
    			return;
    		}
    		
    		// If user choose "Ok", an input dialog is shown to ask user to type a file name to save labyrinth
    		else if(input==JOptionPane.OK_OPTION) {
    			String fileName = JOptionPane.showInputDialog( "Enter file name :" );
    			// Add extension ".txt" at the end of filename given
    			fileName = fileName +".txt";
    			try {
    				// call function saveToTextFile() from mazemodel to save current labyrinth into text file
    				mazeFenetre.getMazeModel().saveToTextFile(fileName);
    				// Show a message dialog for confirmation of saving 
    				JOptionPane.showMessageDialog(null, "Your maze is saved as '" + fileName + " '.");
    			} catch (FileNotFoundException e1) {
    				e1.printStackTrace();
    			} catch (Exception e1) {
    				e1.printStackTrace();
    			}
    		}
    	}
		
		//If labyrinth is not modified, interface will be closed directly
    	System.exit(0);
		
	}

}
