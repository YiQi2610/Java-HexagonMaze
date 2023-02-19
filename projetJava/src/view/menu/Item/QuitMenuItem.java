package view.menu.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import view.MazeFenetre;

public class QuitMenuItem extends JMenuItem implements ActionListener{
	
	private final MazeFenetre mazeFenetre;
	
	public QuitMenuItem(MazeFenetre mazeFenetre) {
		super("Quit");
		
		this.mazeFenetre = mazeFenetre;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(mazeFenetre.getMazeModel().isModified()) {
        	int input = JOptionPane.showInternalOptionDialog(this, "Drawing not saved. Save it?","Quit application", 
        				JOptionPane.YES_NO_CANCEL_OPTION,
        				JOptionPane.WARNING_MESSAGE,
        				null,null,null);
    		if(input==JOptionPane.NO_OPTION ){
    			System.exit(0);
    		}
    		else if(input==JOptionPane.CANCEL_OPTION ) {
    			return;
    		}
    		else if(input==JOptionPane.OK_OPTION) {
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
    	System.exit(0);
		
	}

}
