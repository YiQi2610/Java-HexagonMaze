package view;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class ConfigurationPanel extends JPanel{
	private final MazeFenetre mazeFenetre;
	private final DimensionPanel dimensionPanel;
	private final SelectionPanel selectionPanel;
	private final LaunchButton launchButton;
	
	public ConfigurationPanel(MazeFenetre mazeFenetre) {
		this.mazeFenetre = mazeFenetre;
		
		setLayout(new GridLayout(3,1));
		setSize(300,800);
		setVisible(true);
		
		add(dimensionPanel = new DimensionPanel(mazeFenetre));
		add(selectionPanel = new SelectionPanel(mazeFenetre));
		JPanel launchbtnPane = new JPanel();
		launchbtnPane.add(launchButton = new LaunchButton(mazeFenetre));
		add(launchbtnPane);
	}
	
	public void notifyForUpdate() {
		dimensionPanel.notifyForUpdate();
		selectionPanel.notifyForUpdate();
		launchButton.notifyForUpfate();
	}

}
