package view.menu.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import view.MazeFenetre;

public class SaveMenuItem extends JMenuItem implements ActionListener{
	private final MazeFenetre mazeFenetre;
	
	public SaveMenuItem(MazeFenetre mazeFenetre) {
		super("Save");
		
		this.mazeFenetre = mazeFenetre;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int input = JOptionPane.showConfirmDialog(null, "Are you sure to save this maze");
		if(input==1 || input==2){return;}
		else if(input==0) {
			String fileName = JOptionPane.showInputDialog( "Enter file name :" );
			fileName = fileName +".txt";
			try {
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
