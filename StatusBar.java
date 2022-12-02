import javax.swing.*;
import java.awt.*;

/**
 * @author Darshan Navadiya
 */
public class StatusBar {
    JLabel statusBarTxt, statusTxt;
    public void setStatus(String status) {
        this.status = status;
    }

    String status="hello";
    JPanel jPanel;
    StatusBar(){

    }
    StatusBar(int i1, int i2, int i3, int i4){
        jPanel = new JPanel();
        jPanel.setBounds(i1, i2, i3, i4);
        statusBarTxt = new JLabel("Status Bar");
        jPanel.setBackground(Color.CYAN);
        statusTxt = new JLabel(status);
        jPanel.add(statusBarTxt);
        jPanel.add(statusTxt);
    }
    public JPanel getjPanel(){
        return this.jPanel;
    }

}
