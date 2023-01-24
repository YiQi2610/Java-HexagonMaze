package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar{

	public Menu(MazeFenetre mazeFenetre) {
		super();
		
        JMenu menuFile = new JMenu("File");
        add(menuFile);
        JMenuItem menuItemSave = new JMenuItem("Save");
        menuFile.add(menuItemSave);
        JMenuItem menuItemQuit = new JMenuItem("Quit");
        menuFile.add(menuItemQuit);
                
        menuItemQuit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
            	System.exit(0);
            }
        });
	}

}
