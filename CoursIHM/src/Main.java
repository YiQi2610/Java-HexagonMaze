import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    public static void main(String[] args) {
        new Main();
    }
    
    public Main(){
        
        super("title of the window");
         
        //Dimension s = Toolkit.getDefaultToolkit().getScreenSize();
        //panel.setPreferredSize(s);
        
        MainPanel panel = new MainPanel();
        
        setContentPane(panel); //panel will be the main panel of my frame
        
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        JMenu menu = new JMenu("File");
        mb.add(menu);
        JMenuItem menuItem = new JMenuItem("Quit");
        menu.add(menuItem);
        
        menuItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
            	System.exit(0);
            }
        });
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000,600));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true); //
        pack();
        setVisible(true);
    }
}