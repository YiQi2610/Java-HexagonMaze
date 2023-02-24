package view.menu;

import javax.swing.JMenu;

import view.MazeFenetre;
import view.menu.Item.ArrivalBoxColorItem;
import view.menu.Item.DepartureBoxColorItem;
import view.menu.Item.EmptyBoxColorItem;
import view.menu.Item.PathBoxColorItem;
import view.menu.Item.WallBoxColorItem;

public class ColorChooserMenu extends JMenu {
	private final EmptyBoxColorItem emptyBoxColorItem;
	private final WallBoxColorItem wallBoxColorItem;
	private final ArrivalBoxColorItem arrBoxColorItem;
	private final DepartureBoxColorItem depBoxColorItem;
	private final PathBoxColorItem pathBoxColorItem;
	
	/**
	 * Color chooser menu to add five color chooser item for five types of mazeboxes
	 * - EmptyBoxColorItem
	 * - WallBoxColorItem
	 * - ArrivalBoxColorItem
	 * - DepartureBoxColorItem
	 * - PathBoxColorItem
	 * @param mazeFenetre
	 */
	public ColorChooserMenu(MazeFenetre mazeFenetre) {
		super("Configuration");
		
		//Create five color chooser item and add them into this menu
		add(emptyBoxColorItem = new EmptyBoxColorItem(mazeFenetre));
		add(wallBoxColorItem = new WallBoxColorItem(mazeFenetre));
		add(arrBoxColorItem = new ArrivalBoxColorItem(mazeFenetre));
		add(depBoxColorItem = new DepartureBoxColorItem(mazeFenetre));
		add(pathBoxColorItem = new PathBoxColorItem(mazeFenetre));
	}

}
