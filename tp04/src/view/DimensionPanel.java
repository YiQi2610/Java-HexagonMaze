package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DimensionPanel extends JPanel{
	private int width;
	private int height;
	
	private JTextField widthField;
	private JTextField heightField;
	
	private final JLabel widthLabel;
	private final JLabel heightLabel;
	private final JButton createMazeLabel;
	
	private final MazeFenetre mazeFenetre;
	
	public DimensionPanel(MazeFenetre mazeFenetre) {
		super();
		//setSize(new Dimension(300,300));
		setLayout(new GridLayout(4,1));
		setBackground(Color.lightGray);
		setVisible(true);
		
		this.mazeFenetre = mazeFenetre;
		this.width = mazeFenetre.getMazeModel().getLargeurMaze();
		this.height = mazeFenetre.getMazeModel().getLongueurMaze();
		
		this.widthLabel = new JLabel("Width : ");
		this.widthField = new JTextField();
		this.widthField.setPreferredSize(new Dimension(100,20));
		
		this.heightLabel = new JLabel("Height : ");
		this.heightField = new JTextField();
		this.heightField.setPreferredSize(new Dimension(100,20));
		
		JPanel widthPane = new JPanel();
		widthPane.add(widthLabel);
		widthPane.add(widthField);
		
		JPanel heightPane = new JPanel();
		heightPane.add(heightLabel);
		heightPane.add(heightField);
		
		JPanel okBtnPane = new JPanel();
		JButton okBtn = new JButton ("Create");
		okBtnPane.add(okBtn);
		okBtn.setPreferredSize(new Dimension(150, 40));
		okBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
            	int widthGiven = Integer.parseInt(widthField.getText());
            	int heightGiven = Integer.parseInt(heightField.getText());
            	mazeFenetre.getMazeModel().setDimension(widthGiven, heightGiven);
            	
            }
        });
		
		JPanel mazeLabelPane = new JPanel();
		this.createMazeLabel = new JButton("Create your Maze");
		mazeLabelPane.add(createMazeLabel);
		createMazeLabel.setPreferredSize(new Dimension(150, 40));
		mazeLabelPane.add(createMazeLabel);
		add(mazeLabelPane);
		
		//createMazeLabel.addActionListener(new ActionListener(){
			//public void actionPerformed(ActionEvent e) {
				//JPanel panelDimension = new JPanel(new GridLayout(3,1));
				add(widthPane);
				add(heightPane);
				add(okBtnPane);

			//}
			
		//});
	}

	public void notifyForUpdate() {
		// TODO Auto-generated method stub
		
	}
}
