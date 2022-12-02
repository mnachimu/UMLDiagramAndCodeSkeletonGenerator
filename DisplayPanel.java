import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;


public class DisplayPanel extends JScrollPane implements Observer {

    public JTextArea outputArea;

	private static final int width = 350;
	private static final int height = 600;

    public DisplayPanel(int x, int y) {
        outputArea = new JTextArea();

        outputArea.setEnabled(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setFont(new Font("Courier", Font.PLAIN, 14));

        this.add(outputArea);
        this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.setBounds(x, y, width,height);
		this.setForeground(Color.black);
    	this.setBackground(Color.white);
    	this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    }

    public void print() {

    }

    @Override
	public void update(Observable o, Object arg) {
	}
}
