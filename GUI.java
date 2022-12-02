import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;


public class GUI extends JFrame implements ActionListener {

	public CanvasPanel canvas;
	public DisplayPanel display;

	public MenuBar menuBar;

	public StatusBar statusBar;

    public GUI(CanvasPanel canvasPanel, DisplayPanel displayPanel, MenuBar jmenuBar, StatusBar jStatusBar) {
        this.setTitle("CSE 564 Assignment Final");
        this.setSize(1050, 740);
	    this.setVisible(true);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Exit out of application on click
	    this.getContentPane().setBackground(Color.gray);


	    this.canvas = canvasPanel;
		this.display = displayPanel;
		this.menuBar = jmenuBar;
		this.statusBar = jStatusBar;
		// display = new DisplayPanel(20, 30);
		this.setJMenuBar(menuBar.getJMenuBar());
		this.add(canvas);
		this.add(display);
		this.add(statusBar.getjPanel());
//		this.pack();
		// this.setVisible(true);
	    this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
