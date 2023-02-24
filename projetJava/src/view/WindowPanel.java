package view;

import javax.swing.* ;
import java.awt.*;

public class WindowPanel extends JPanel {
	
	//Window panel consist of maze panel and configuration panel
	private final MazePanel mazePanel ;//Panel where labyrinth is drawn
	private final ConfigurationPanel configurationPanel;// Panel where we can modify or create labyrinth

	public WindowPanel(MazeFenetre mazeFenetre) {
		setLayout(new BorderLayout()) ;
		//Add these two panels to window panel with their border layout
		add(mazePanel = new MazePanel(mazeFenetre), BorderLayout.CENTER) ;
		add(configurationPanel = new ConfigurationPanel(mazeFenetre),BorderLayout.EAST);
	}

	/**
	 * Send notification to maze panel and configuration panel when there is modification in maze model
	 * @throws Exception
	 */
	public void notifyForUpdate() throws Exception {	
		mazePanel.notifyForUpdate();
		configurationPanel.notifyForUpdate();
	}
}