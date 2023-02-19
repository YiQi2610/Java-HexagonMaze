package view;

import javax.swing.* ;
import java.awt.*;
import java.io.IOException;

public class WindowPanel extends JPanel {

	private final MazePanel mazePanel ;
	private final ConfigurationPanel configurationPanel;

	public WindowPanel(MazeFenetre mazeFenetre) {
		setLayout(new BorderLayout()) ;

		add(mazePanel = new MazePanel(mazeFenetre), BorderLayout.CENTER) ;
		add(configurationPanel = new ConfigurationPanel(mazeFenetre),BorderLayout.EAST);
	}

	public void notifyForUpdate() throws Exception {
		
		mazePanel.notifyForUpdate();
		configurationPanel.notifyForUpdate();

	}
}