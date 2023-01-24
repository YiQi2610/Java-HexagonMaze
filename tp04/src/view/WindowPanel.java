package view;

import javax.swing.* ;
import java.awt.*;

public class WindowPanel extends JPanel {

   private final MazePanel mazePanel ;
    
   public WindowPanel(MazeFenetre mazeFenetre) {
      setLayout(new BorderLayout()) ;
		
      add(mazePanel = new MazePanel(mazeFenetre), BorderLayout.CENTER) ;
   }
}