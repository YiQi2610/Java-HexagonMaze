package view.menu;

import javax.swing.JMenu;

import view.MazeFenetre;
import view.menu.Item.ImportMenuItem;
import view.menu.Item.QuitMenuItem;
import view.menu.Item.SaveMenuItem;

public class FileMenu extends JMenu {
	
	private final QuitMenuItem quitMenuItem;
	private final SaveMenuItem saveMenuItem;
	private final ImportMenuItem importMenuItem;
	
	/**
	 * FileMenu contains three menu items:
	 * - QuitMenuItem
	 * - ImportMenuItem
	 * - SaveMenuItem
	 * @param mazeFenetre
	 */
	public FileMenu(MazeFenetre mazeFenetre) {
		super("File");
		
		//Create three menu items and add them into file menu
		add(quitMenuItem = new QuitMenuItem(mazeFenetre));
		add(importMenuItem = new ImportMenuItem(mazeFenetre));
		add(saveMenuItem = new SaveMenuItem(mazeFenetre));
	}
}
