import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;


public class GUI extends JFrame implements ActionListener {

    public GUI() {
        this.setTitle("CSE 564 Assignment Final");
        this.setSize(1050, 700);
	    this.setVisible(true);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Exit out of application on click
	    this.getContentPane().setBackground(Color.gray);
	    
	    CanvasPanel canvas = new CanvasPanel(150, 30);
	    
	    this.add(canvas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
