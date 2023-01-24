package view.menu.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import view.MazeFenetre;

public class QuitMenuItem extends JMenuItem{
	
	private final MazeFenetre mazeFenetre;
	
	public QuitMenuItem(MazeFenetre mazeFenetre) {
		super("Quit");
		
		this.mazeFenetre = mazeFenetre;
		
		addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent ae) {
	        	System.exit(0);
	        }
	    });
	}

}
