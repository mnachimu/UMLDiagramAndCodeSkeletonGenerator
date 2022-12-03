import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Status bar class and operations related to it.
 * @version 1.0
 */
public class StatusBar{
    JLabel statusBarTxt, statusTxt;
    String status;
    JPanel jPanel;

    public void setStatus(String status) {
        this.status = status;

    }

    /**
     * Class Constructor
     * Creates the panel of specific dimensions
     */
    StatusBar(){
        jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    }

    /**
     * Create the status bar of given dimensions and set the WHITE colour.
     * @param i1
     * @param i2
     * @param i3
     * @param i4
     */
    StatusBar(int i1, int i2, int i3, int i4){
        jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jPanel.setBounds(i1, i2, i3, i4);
        statusBarTxt = new JLabel("Status Bar", SwingConstants.LEFT);
        jPanel.setBackground(Color.WHITE);
        jPanel.add(statusBarTxt);
        statusTxt = new JLabel(status);
        jPanel.add(statusTxt);
    }

    public JPanel getjPanel(){
        return this.jPanel;
    }

}
