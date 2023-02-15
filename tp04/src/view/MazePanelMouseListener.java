package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

public class MazePanelMouseListener extends MouseAdapter implements MouseListener{
	
	private final MazeFenetre mazeFenetre;
	
	public MazePanelMouseListener(MazeFenetre mazeFenetre) {
		super();
		this.mazeFenetre = mazeFenetre;		
	}

}
