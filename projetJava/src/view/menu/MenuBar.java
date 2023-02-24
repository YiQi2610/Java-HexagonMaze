package view.menu;

import javax.swing.*;

import view.MazeFenetre;

public class MenuBar extends JMenuBar{
	
	private final FileMenu fileMenu;
	private final ColorChooserMenu colorMenu;
	
	/**
	 * MenuBar contains two menu:
	 * - FileMenu : Save labyrinthe, import labyrinth and quit the program
	 * - ColorChooserMenu : Configure color of differen type of maze boxes
	 * @param mazeFenetre
	 */
	public MenuBar(MazeFenetre mazeFenetre) {
		super();
		
		//Create FileMenu and ColorChooserMenu and add them into MenuBar
        add(fileMenu = new FileMenu(mazeFenetre));
        add(colorMenu = new ColorChooserMenu(mazeFenetre));
	}

}
