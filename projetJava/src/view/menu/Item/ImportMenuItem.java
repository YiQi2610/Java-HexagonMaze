package view.menu.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import view.MazeFenetre;

public class ImportMenuItem extends JMenuItem implements ActionListener{
	private final MazeFenetre mazeFenetre;
	
	/**
	 * ImportMenuItem to choose a labyrinth file to import from a list of files in folder "data", read and draw the labyrinth
	 * @param mazeFenetre
	 */
	public ImportMenuItem(MazeFenetre mazeFenetre) {
		super("Import");
		
		this.mazeFenetre = mazeFenetre;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Open folder "data" which contains all labyrinth text files saved
		File folder = new File("data");
		// Get a list of labyrinth files in this folder
		File[] listOfFiles = folder.listFiles();
		// Get number of labyrinth files
		int nbOfFiles = listOfFiles.length;
		String[] allMazeFiles = new String[nbOfFiles];
		
		// Loop to get the name of all labyrinth files with total number of files found above
		for (int i = 0; i < nbOfFiles; i++) {
		  if (listOfFiles[i].isFile()) {
		    allMazeFiles[i]=listOfFiles[i].getName();
		  }
		}
		
		//Show an input dialog to provide a rolling list of options of labyrinth file to import
		String input = (String)JOptionPane.showInputDialog(null, "Choose a Maze File",
		        "Import your maze", JOptionPane.QUESTION_MESSAGE, null,allMazeFiles,null);
		
		//If no file is choosen, nothing is imported
		if(input==null) {return;}
		else {
			try {
				//Get the file chosen and call function initFromTextFile from maze model to read and draw labyrinth
				mazeFenetre.getMazeModel().initFromTextFile("data/"+input);							
			}catch(FileNotFoundException e1) {
				e1.printStackTrace();
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
