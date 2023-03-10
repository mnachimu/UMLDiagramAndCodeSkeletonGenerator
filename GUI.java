import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

/**
 * GUI class is responsible for displaying overall GUI .
 * This class is part of VIEW in MVC.
 * @version 1.0
 */
public class GUI extends JFrame implements ActionListener {

	public CanvasPanel canvas;
	public DisplayPanel display;

	public MenuBar menuBar;

	public StatusBar statusBar;

	/**
	 * Class Constructor which creates the JFrame and has two panels and a Statusbar.
	 * @param canvasPanel
	 * @param displayPanel
	 * @param jmenuBar
	 * @param jStatusBar
	 */
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
		this.add(statusBar);
//		this.pack();
		// this.setVisible(true);
	    this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
