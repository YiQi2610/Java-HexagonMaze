import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel{
	public ButtonPanel() {
		super();
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(500,100));
		setBackground(Color.yellow);
		
        
        JButton jb1 = new JButton("action");
        add(jb1, BorderLayout.WEST);
        jb1.setPreferredSize(new Dimension(300,100));
        JButton jb2 = new JButton("action2");
        add(jb2, BorderLayout.CENTER);
        jb2.setPreferredSize(new Dimension(300,100));
        JButton jb3 = new JButton("action3");
        add(jb3, BorderLayout.EAST);
        jb3.setPreferredSize(new Dimension(300,100));
        jb3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
            	System.exit(0);
            }
        });
	}
}
