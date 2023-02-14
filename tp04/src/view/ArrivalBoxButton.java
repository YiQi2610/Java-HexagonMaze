package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ArrivalBoxButton extends JButton implements ActionListener{

	public ArrivalBoxButton() {
		super("Select Arrival Box");
		addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
