package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DimensionPanel extends JPanel{

	private JTextField widthField;
	private JTextField heightField;
	
	private final JLabel widthLabel;
	private final JLabel heightLabel;
	private final JButton createMazeLabel;
	
	private final MazeFenetre mazeFenetre;
	
	/**
	 * Dimension panel consist of a four sub panel:
	 * - mazeLabelPane : user must click this button to show subpanels to type width and height
	 * - widthPane : subpanel containing a label and textfield for width
	 * - heightPane : subpanel containg a label and textfield for height
	 * - okBtnPane : button to click to create an empty maze
	 * @param mazeFenetre
	 */
	public DimensionPanel(MazeFenetre mazeFenetre) {
		super();
		//Grid of 4x1 to show four subpanels vertically 
		setLayout(new GridLayout(4,1));
		setVisible(true);
		
		this.mazeFenetre = mazeFenetre;
		
		//Create a JLabel and JTextField for width
		this.widthLabel = new JLabel("Width : ");
		this.widthField = new JTextField();
		this.widthField.setPreferredSize(new Dimension(100,20));
		
		//Create a JLabel and JTextField for height
		this.heightLabel = new JLabel("Height : ");
		this.heightField = new JTextField();
		this.heightField.setPreferredSize(new Dimension(100,20));
		
		// Add widthLabel and widthField to widthPane, this is to avoid that the label and textfield take too all space in grid
		// widthPane and heightPane are only visible when "Create your maze" button is clicked
		JPanel widthPane = new JPanel();
		widthPane.add(widthLabel);
		widthPane.add(widthField);
		widthPane.setVisible(false);
		
		// Add heightLabel and heightField to heightPane
		JPanel heightPane = new JPanel();
		heightPane.add(heightLabel);
		heightPane.add(heightField);
		heightPane.setVisible(false);
		
		// Create a Jbutton to create maze, call setDimension function in maze model when itis clicked
		JPanel okBtnPane = new JPanel();
		JButton okBtn = new JButton ("Create");
		okBtnPane.add(okBtn);
		okBtnPane.setVisible(false);
		okBtn.setPreferredSize(new Dimension(80, 30));
		okBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	try {
            		//get width and height typed in textfields and change their values to Integer value
	            	int widthGiven = Integer.parseInt(widthField.getText());
	            	int heightGiven = Integer.parseInt(heightField.getText());
	            	//Call maze model to create a maze by passing width and height given to function setDimension
	            	mazeFenetre.getMazeModel().setDimension(widthGiven, heightGiven);
            	}catch(NumberFormatException e){// If values of height and width given are not numercial value, a warning message will pop up
            		JOptionPane.showMessageDialog(mazeFenetre, "Height and width must be integer!",
     		               "Error!", JOptionPane.WARNING_MESSAGE);
            	}        	
            }
        });
		
		//Create a JButton for createMazeLabel and add it to a panel
		JPanel mazeLabelPane = new JPanel();
		this.createMazeLabel = new JButton("Create your Maze");
		createMazeLabel.setPreferredSize(new Dimension(150, 40));
		mazeLabelPane.add(createMazeLabel);
		//add mazeLabelPane to this panel
		add(mazeLabelPane);
		
		createMazeLabel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//If createMaze button is clicked and all the subpanels is invisble ,it will set all the panels visible
				if(!widthPane.isVisible()) {
					widthPane.setVisible(true);
					heightPane.setVisible(true);
					okBtnPane.setVisible(true);
				}
				else {//If createMaze button is clicked and all the subpanels is visble ,it will set all the panels invisible, to hide all the panels
					widthPane.setVisible(false);
					heightPane.setVisible(false);
					okBtnPane.setVisible(false);
				}
			}	
		});
		
		// Add the rest three subpanels into this panel
		add(widthPane);
		add(heightPane);
		add(okBtnPane);
	}
	
	/**
	 * Receive messages from configuration panel when there is modification in maze model
	 */
	public void notifyForUpdate() {
		// TODO Auto-generated method stub
		
	}
}
