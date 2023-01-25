package view;

import java.awt.Dimension;


import javax.swing.*;

import view.menu.MenuBar;

public class MazeFenetre extends JFrame {
	
	private final MenuBar menuBar;
	private final WindowPanel windowPanel;
	
	public MazeFenetre() {
		super("Find the shortest path!");
		
		setJMenuBar(menuBar = new MenuBar(this));
		setContentPane(windowPanel = new WindowPanel(this));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1500,1500));
   
		pack();
		setVisible(true);
	}
}
