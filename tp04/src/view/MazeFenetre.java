package view;

import java.awt.Dimension;


import javax.swing.*;

public class MazeFenetre extends JFrame {
	
	private final Menu menu;
	
	public static void main(String[] args) {
	        new MazeFenetre();
	}
	
	public MazeFenetre() {
		super("Find the shortest path!");
		
		setJMenuBar(menu = new Menu(this));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1000,1000));
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setUndecorated(true); //
		pack();
		setVisible(true);
	}
}
