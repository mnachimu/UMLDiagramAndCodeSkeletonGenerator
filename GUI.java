import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;


public class GUI extends JFrame implements ActionListener {
	
	public CanvasPanel canvas;

    public GUI() {
        this.setTitle("CSE 564 Assignment Final");
        this.setSize(1050, 700);
	    this.setVisible(true);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Exit out of application on click
	    this.getContentPane().setBackground(Color.gray);
	    
	    canvas = new CanvasPanel(400, 30);
	    
	    this.add(canvas);
	    
	    this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
