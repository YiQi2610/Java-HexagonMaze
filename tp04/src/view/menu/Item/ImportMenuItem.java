package view.menu.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import view.MazeFenetre;

public class ImportMenuItem extends JMenuItem implements ActionListener{
	private final MazeFenetre mazeFenetre;
	
	public ImportMenuItem(MazeFenetre mazeFenetre) {
		super("Import");
		
		this.mazeFenetre = mazeFenetre;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		File folder = new File("data");
		File[] listOfFiles = folder.listFiles();
		ArrayList<String> allMazeFiles = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
		    allMazeFiles.add(listOfFiles[i].getName());
		  }
		}
		
		String input = (String)JOptionPane.showInputDialog(null, "Choose a Maze File",
		        "Import your maze", JOptionPane.QUESTION_MESSAGE, null,listOfFiles,listOfFiles[0]);
		
		try {
			mazeFenetre.getMazeModel().initFromTextFile("data/"+input);
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
