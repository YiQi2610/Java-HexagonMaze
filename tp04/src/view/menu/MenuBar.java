package view.menu;

import javax.swing.*;

import view.MazeFenetre;

public class MenuBar extends JMenuBar{
	
	private final FileMenu fileMenu;
	
	public MenuBar(MazeFenetre mazeFenetre) {
		super();
		
        add(fileMenu = new FileMenu(mazeFenetre));
	}

}
