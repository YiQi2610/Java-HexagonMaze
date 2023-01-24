package view.menu;

import javax.swing.JMenu;

import view.MazeFenetre;
import view.menu.Item.QuitMenuItem;
import view.menu.Item.SaveMenuItem;

public class FileMenu extends JMenu {
	
	private final QuitMenuItem quitMenuItem;
	private final SaveMenuItem saveMenuItem;
	
	public FileMenu(MazeFenetre mazeFenetre) {
		super("File");
		
		add(quitMenuItem = new QuitMenuItem(mazeFenetre));
		add(saveMenuItem = new SaveMenuItem(mazeFenetre));
	}
}
