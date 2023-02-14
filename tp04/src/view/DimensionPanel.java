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
	private final JLabel createMazeLabel;
	
	private final MazeFenetre mazeFenetre;
	
	public DimensionPanel(MazeFenetre mazeFenetre) {
		super();
		setSize(new Dimension(300,300));
		setBackground(Color.lightGray);
		setVisible(true);
		
		this.mazeFenetre = mazeFenetre;
		this.width = mazeFenetre.getMazeModel().getLargeurMaze();
		this.height = mazeFenetre.getMazeModel().getLongueurMaze();
		
		this.widthLabel = new JLabel("Width : ");
		this.widthField = new JTextField();
		this.widthField.setPreferredSize(new Dimension(100,20));
		
		this.createMazeLabel = new JLabel("Create your Maze here!");
		this.heightLabel = new JLabel("Height : ");
		this.heightField = new JTextField();
		this.heightField.setPreferredSize(new Dimension(100,20));
		
		JPanel labelPane = new JPanel(new GridLayout(0,1));
		labelPane.add(widthLabel);
		labelPane.add(heightLabel);
		
		JPanel fieldPane = new JPanel(new GridLayout(0,1));
		fieldPane.add(widthField);
		fieldPane.add(heightField);
		
		JButton okBtn = new JButton ("Create");
		okBtn.setBounds(100,140,100,40);
		okBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
            	int widthGiven = Integer.parseInt(widthField.getText());
            	int heightGiven = Integer.parseInt(heightField.getText());
            	mazeFenetre.getMazeModel().setDimension(widthGiven, heightGiven);
            }
        });
		add(createMazeLabel,BorderLayout.NORTH);
		add(labelPane, BorderLayout.CENTER);
		add(fieldPane, BorderLayout.EAST);
		add(okBtn, BorderLayout.SOUTH);

	}

	public void notifyForUpdate() {
		// TODO Auto-generated method stub
		
	}
}
