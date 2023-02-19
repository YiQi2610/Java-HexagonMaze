package view;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class ConfigurationPanel extends JPanel{
	private final MazeFenetre mazeFenetre;
	private final DimensionPanel dimensionPanel;
	private final SelectionPanel selectionPanel;
	private final LaunchButton launchButton;
	private final ColorPanel colorPanel;
	
	public ConfigurationPanel(MazeFenetre mazeFenetre) {
		this.mazeFenetre = mazeFenetre;

		setLayout(new GridLayout(4,1));
		setSize(300,800);
		setVisible(true);
		
		add(dimensionPanel = new DimensionPanel(mazeFenetre));
		add(selectionPanel = new SelectionPanel(mazeFenetre));
		JPanel launchbtnPane = new JPanel();
		launchbtnPane.add(launchButton = new LaunchButton(mazeFenetre));
		add(launchbtnPane);
		add(colorPanel = new ColorPanel(mazeFenetre));
	}
	
	public void notifyForUpdate() {
		dimensionPanel.notifyForUpdate();
		selectionPanel.notifyForUpdate();
		launchButton.notifyForUpfate();
		colorPanel.notifyForUpdate();
	}

}
