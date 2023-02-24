package view;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class ConfigurationPanel extends JPanel{
	/**
	 * Configuration panel consist of four panels:
	 * - DimensionPanel : To create an empty maze by giving width and height
	 * - SelectionPanel : To modify types of hexagon mazeboxes
	 * - LaunchButton : To launch Dijkstra and show shortest path
	 * - ColorPanel : To show colors of different types of maze boxes
	 */
	private final MazeFenetre mazeFenetre;
	private final DimensionPanel dimensionPanel;
	private final SelectionPanel selectionPanel;
	private final LaunchButton launchButton;
	private final ColorPanel colorPanel;
	
	public ConfigurationPanel(MazeFenetre mazeFenetre) {
		this.mazeFenetre = mazeFenetre;
		//Use grid layout of 4x1 to have a vertical panel
		setLayout(new GridLayout(4,1));
		setSize(300,800);
		setVisible(true);
		
		add(dimensionPanel = new DimensionPanel(mazeFenetre));
		add(selectionPanel = new SelectionPanel(mazeFenetre));
		//Add launch button to a panel so that the button will not get the whole size of grid (it will be too big)
		JPanel launchbtnPane = new JPanel();
		launchbtnPane.add(launchButton = new LaunchButton(mazeFenetre));
		add(launchbtnPane);
		add(colorPanel = new ColorPanel(mazeFenetre));
	}
	
	/**
	 * Send message to these for panels when there is modification in maze model, to remind them to get updated
	 */
	public void notifyForUpdate() {
		dimensionPanel.notifyForUpdate();
		selectionPanel.notifyForUpdate();
		launchButton.notifyForUpfate();
		colorPanel.notifyForUpdate();
	}

}
