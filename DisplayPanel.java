import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;


public class DisplayPanel extends JScrollPane implements Observer {
    
    private JTextArea outputArea;

	private static final int width = 350;
	private static final int height = 600;

    private String code;
    DataSource dataSource;

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

    public String getCode() {
        return code;
    }

    // public void print() {
    //     outputArea.setText(getCode());
    // }

    @Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
        // code += "test() " + "{\n"
        //         + "\t" + "testStuff();\n"
        //         + "}\n";
	}

    @Override
	public void update(Observable o, Object arg) {
        System.out.println("DisplayPanel update() called!");

        setCode();
        outputArea.setText(getCode());
        repaint();
	}
}
