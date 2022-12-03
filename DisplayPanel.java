import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

/**
 * This class is for the left side panel which is Display panel which generates the code of class diagram.
 * This is a part of VIEW in MVC.
 * This class implements the Observer pattern.
 * @version 1.0
 */
public class DisplayPanel extends JScrollPane implements Observer {

    
    private JTextArea outputArea;

	private static final int width = 350;
	private static final int height = 600;

    private String code;
    DataSource dataSource;

    /**
     * Class Constructor
     * @param x
     * @param y
     */
    public DisplayPanel(int x, int y) {
        this.dataSource = DataSource.getInstance();

        outputArea = new JTextArea();

        outputArea.setEnabled(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setFont(new Font("Courier", Font.PLAIN, 14));

        this.setViewportView(outputArea);
        this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.setBounds(x, y, width,height);
		this.setForeground(Color.black);
    	this.setBackground(Color.white);
    	this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    }


    public JTextArea getOutputArea() {
        return outputArea;
    }

    /**
     * Generate the code of newly created class and relationship
     */
    public void setCode() {
        code = "";

        // For testing        
        // code += "test() " + "{\n"
        //         + "\t" + "testStuff();\n"
        //         + "}\n";

        // Expected behavior
        if (dataSource.classObjectsLists.size() > 0) {
            for (int i = 0; i < dataSource.classObjectsLists.size(); i++) {
                code += dataSource.classObjectsLists.get(i).getClassName() + "{\n"
                        + "}\n\n";
            }
        }
    }

    /**
     * Return the code
     * @return
     */
    public String getCode() {
        return code;

    }

    @Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

    /**
     * Observer pattern update() method
     * @param o
     * @param arg
     */
    @Override
	public void update(Observable o, Object arg) {
        System.out.println("DisplayPanel update() called!");

        setCode();
        outputArea.setText(getCode());
        repaint();
	}
}
