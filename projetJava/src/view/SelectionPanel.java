package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

public class SelectionPanel extends JPanel{
	
	private final MazeFenetre mazeFenetre;
	private final JButton modifyBtn;
	private final JRadioButton selectDepBoxBtn;
	private final JRadioButton selectArrBoxBtn;
	private final JRadioButton selectWallBoxBtn;
	private final JRadioButton deselectWallBoxBtn;
	
	public SelectionPanel(MazeFenetre mazeFenetre) {
		this.mazeFenetre = mazeFenetre;
		setLayout(new GridLayout(5,1));
				
		modifyBtn = new JButton("Modify");
		modifyBtn.setPreferredSize(new Dimension(150, 35));
		JPanel modifyBtnPane = new JPanel();
		modifyBtnPane.add(modifyBtn);
					
		selectDepBoxBtn = new JRadioButton("Select Departure Box");
		selectArrBoxBtn = new JRadioButton("Select Arrival Box");
		selectWallBoxBtn = new JRadioButton("Select Wall Box");
		deselectWallBoxBtn = new JRadioButton("Deselect Box");
		
		JPanel radioButtons = new JPanel();
		ButtonGroup group = new ButtonGroup();
		group.add(selectDepBoxBtn);
		group.add(selectArrBoxBtn);
		group.add(selectWallBoxBtn);
		group.add(deselectWallBoxBtn);
		radioButtons.add(selectDepBoxBtn);
		radioButtons.add(selectArrBoxBtn);
		radioButtons.add(selectWallBoxBtn);
		radioButtons.add(deselectWallBoxBtn);
		selectArrBoxBtn.setVisible(false);
		selectDepBoxBtn.setVisible(false);
		selectWallBoxBtn.setVisible(false);
		deselectWallBoxBtn.setVisible(false);
		
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
		
		deselectWallBoxBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mazeFenetre.getMazeModel().setSelectedTypeHexagon('E');				
			}
		});
		
		add(modifyBtnPane);
		modifyBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!selectArrBoxBtn.isVisible()) {
					selectArrBoxBtn.setVisible(true);	
					selectDepBoxBtn.setVisible(true);
					selectWallBoxBtn.setVisible(true);
					deselectWallBoxBtn.setVisible(true);	
				}
				else {
					selectArrBoxBtn.setVisible(false);	
					selectDepBoxBtn.setVisible(false);
					selectWallBoxBtn.setVisible(false);
					deselectWallBoxBtn.setVisible(false);
				}
			}
		});
			
		add(selectDepBoxBtn);
		add(selectArrBoxBtn);
		add(selectWallBoxBtn);
		add(deselectWallBoxBtn);
	}

	public void notifyForUpdate() {
				
	}

}
