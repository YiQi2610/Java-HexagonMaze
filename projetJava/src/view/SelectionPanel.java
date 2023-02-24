package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SelectionPanel extends JPanel{
	
	private final MazeFenetre mazeFenetre;
	private final JButton modifyBtn;
	private final JRadioButton selectDepBoxBtn;
	private final JRadioButton selectArrBoxBtn;
	private final JRadioButton selectWallBoxBtn;
	private final JRadioButton deselectBoxBtn;
	
	/**
	 * Selection panel consist of one button and four radio buttons:
	 * - modifyButton : Show radio buttons onece we click on it
	 * - selectDepBoxBtn : If user choose this radio button, every maze box that we click will turn to departure box, but we can only choose one departure box
	 * - selectArrBoxBtn : If user choose this radio button, every maze box that we click will turn to arrival box, but we can only choose one arrival box
	 * - selectWallBoxBtn : If user choose this radio button, every maze box that we click will turn to wall box
	 * - deselectBoxBtn : If user choose this radio button, every maze box that we click will turn to empty box
	 * @param mazeFenetre
	 */
	public SelectionPanel(MazeFenetre mazeFenetre) {
		this.mazeFenetre = mazeFenetre;
		//Set layout with grid of 5x1 to show five buttons vertically
		setLayout(new GridLayout(5,1));
		
		//Create a JButton and add it into a modifyBtnPane to limit the size of button
		modifyBtn = new JButton("Modify");
		modifyBtn.setPreferredSize(new Dimension(150, 35));
		JPanel modifyBtnPane = new JPanel();
		modifyBtnPane.add(modifyBtn);
		
		//Create four JRadioButton for four types of selection
		selectDepBoxBtn = new JRadioButton("Select Departure Box");
		selectArrBoxBtn = new JRadioButton("Select Arrival Box");
		selectWallBoxBtn = new JRadioButton("Select Wall Box");
		deselectBoxBtn = new JRadioButton("Deselect Box");
		
		//Create a ButtoGroup to add all four radiobuttons, so that we only can select one radiobutton at a time
		ButtonGroup group = new ButtonGroup();
		group.add(selectDepBoxBtn);
		group.add(selectArrBoxBtn);
		group.add(selectWallBoxBtn);
		group.add(deselectBoxBtn);
		
		// All the radio buttons are invisible by default, they will only be visible by clciking the modifyButton
		selectArrBoxBtn.setVisible(false);
		selectDepBoxBtn.setVisible(false);
		selectWallBoxBtn.setVisible(false);
		deselectBoxBtn.setVisible(false);
		
		/**
		 * All radio buttons are implemented with actionlistener
		 * When one of them is selected, it will set attribut "selectedHexagon" in maze panel with type of mazebox selected
		 * All the mazeboxes clicked on the labyrinth will change their type based on the option selected
		 */
		selectDepBoxBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mazeFenetre.getMazeModel().setSelectedTypeHexagon('D');
			}
		});
		
		selectArrBoxBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mazeFenetre.getMazeModel().setSelectedTypeHexagon('A');			
			}
		});
		
		selectWallBoxBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mazeFenetre.getMazeModel().setSelectedTypeHexagon('W');				
			}
		});
		
		deselectBoxBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mazeFenetre.getMazeModel().setSelectedTypeHexagon('E');				
			}
		});
		
		// Add modifyBtnPane into this panel
		add(modifyBtnPane);
		/**
		 * When this button is clicked and all the radiobuttons are invisible, it will set all radio buttons to become visible
		 * When this button is clicked and all the radiobuttons are visible, it will set all radio buttons to become invisible
		 * I made this to avoid too much of elements apprearing at the same time on configuration panel as it may become complicated to use
		 */
		modifyBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!selectArrBoxBtn.isVisible()) {
					selectArrBoxBtn.setVisible(true);	
					selectDepBoxBtn.setVisible(true);
					selectWallBoxBtn.setVisible(true);
					deselectBoxBtn.setVisible(true);	
				}
				else {
					selectArrBoxBtn.setVisible(false);	
					selectDepBoxBtn.setVisible(false);
					selectWallBoxBtn.setVisible(false);
					deselectBoxBtn.setVisible(false);
				}
			}
		});
		
		//Add teh four radio buttons into this selection panel
		add(selectDepBoxBtn);
		add(selectArrBoxBtn);
		add(selectWallBoxBtn);
		add(deselectBoxBtn);
	}
	
	/**
	 * Receive messages from ConfigurationPanel when there is modification in maze model and get updated 
	 */
	public void notifyForUpdate() {
				
	}

}
