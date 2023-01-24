import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
	public MainPanel() {
		super();
		setBackground(Color.darkGray);
		setLayout(new BorderLayout());
		JCPanel jcp = new JCPanel();
        add(jcp, BorderLayout.CENTER);
        
        ButtonPanel p2 = new ButtonPanel();
        add(p2,BorderLayout.SOUTH);
        
	}
}
