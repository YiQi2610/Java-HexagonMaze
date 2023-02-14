package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel{
	private final MazeFenetre mazeFenetre;
	private final DepBoxButton selectDepBoxBtn ;
	private final ArrivalBoxButton selectArrBoxBtn;
	
	public ButtonPanel(MazeFenetre mazeFenetre) {
		this.mazeFenetre = mazeFenetre;
		this.selectDepBoxBtn = new DepBoxButton();
		this.selectArrBoxBtn = new ArrivalBoxButton();
		setVisible(true);
		
		add(selectDepBoxBtn);
		add(selectArrBoxBtn);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setSize(100,100);
		setVisible(true);
	}

	public void notifyForUpdate() {
		// TODO Auto-generated method stub
		
	}
}
