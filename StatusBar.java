import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Status bar class and operations related to it.
 * @version 1.0
 */
public class StatusBar extends JScrollPane{
    public static JTextArea statusArea;
    private static final int width = 1005;
	private static final int height =  30;
  
    String status;

    public void setStatus(String status) {
        this.status = status;
        // System.out.println("got the status "+status);
        JTextArea temp = getStatusArea();
        temp.setText(status);
        
    }
    
    public StatusBar(){
    }

    public String getStatus(){ return status;}

    /**
     * Class Constructor
     * Creates the panel of specific dimensions
     */
    public StatusBar(int x, int y){

        statusArea = new JTextArea();
        statusArea.setText("Welcome aboard!!");
        statusArea.setEnabled(false);
        statusArea.setLineWrap(true);
        statusArea.setWrapStyleWord(true);
        statusArea.setFont(new Font("Courier", Font.BOLD, 15));
        statusArea.setForeground(Color.BLACK);
        this.setViewportView(statusArea);
        this.setBounds(x,y, width, height);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    }

    

    public JTextArea getStatusArea() {
        return statusArea;
    }

}
