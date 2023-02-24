package view;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import maze.Maze;
import view.menu.MenuBar;

public class MazeFenetre extends JFrame implements ChangeListener {
	
	private final MenuBar menuBar; 
	private final WindowPanel windowPanel;
	private Maze mazeModel = new Maze();
	
	
	public MazeFenetre() {
		super("Find the shortest path!");
		//Window contains menu bar and window panel 
		setJMenuBar(menuBar = new MenuBar(this));
		setContentPane(windowPanel = new WindowPanel(this));
		
		//add this window as observer of our maze model
		mazeModel.addObserver(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//To adapt the size of window based on screen size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setSize(screenSize.width, screenSize.height);
		setVisible(true);
	}
		
	public Maze getMazeModel() {
		return mazeModel;
	}

	public void setMazeModel(Maze mazeModel) {
		this.mazeModel = mazeModel;
	}

	@Override
	/**
	 * Send message to our window panel for update when there is modification in maze model
	 */
	public void stateChanged(ChangeEvent e) {
		try {
			windowPanel.notifyForUpdate();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
		
}


