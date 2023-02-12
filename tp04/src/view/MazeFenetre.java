package view;

import java.awt.Dimension;
import java.awt.Point;


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
		
		setJMenuBar(menuBar = new MenuBar(this));
		setContentPane(windowPanel = new WindowPanel(this));
		mazeModel.addObserver(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1500,800));		
		pack();
		setVisible(true);
	}
		
	public Maze getMazeModel() {
		return mazeModel;
	}

	public void setMazeModel(Maze mazeModel) {
		this.mazeModel = mazeModel;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		try {
			windowPanel.notifyForUpdate();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
		
}


