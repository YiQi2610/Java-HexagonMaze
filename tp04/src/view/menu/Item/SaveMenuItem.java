package view.menu.Item;

import javax.swing.JMenuItem;

import view.MazeFenetre;

public class SaveMenuItem extends JMenuItem{
	private final MazeFenetre mazeFenetre;
	
	public SaveMenuItem(MazeFenetre mazeFenetre) {
		super("Save");
		
		this.mazeFenetre = mazeFenetre;
	}
}
