package view;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class ConfigurationPanel extends JPanel{
	private final DimensionPanel dimensionPanel;
	private final ButtonPanel buttonPanel;
	
	public ConfigurationPanel(MazeFenetre mazeFenetre) {
		setLayout(new GridLayout(2,1));
		
		add(dimensionPanel = new DimensionPanel(mazeFenetre));
		add(buttonPanel = new ButtonPanel(mazeFenetre));
	}
	
	public void notifyForUpdate() {
		dimensionPanel.notifyForUpdate();
		buttonPanel.notifyForUpdate();
	}

}
