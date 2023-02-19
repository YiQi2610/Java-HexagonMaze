package view.menu;

import javax.swing.*;

import view.MazeFenetre;

public class MenuBar extends JMenuBar{
	
	private final FileMenu fileMenu;
	private final ColorChooserMenu colorMenu;
	
	public MenuBar(MazeFenetre mazeFenetre) {
		super();
		
        add(fileMenu = new FileMenu(mazeFenetre));
        add(colorMenu = new ColorChooserMenu(mazeFenetre));
	}

}
