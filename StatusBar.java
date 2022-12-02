import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Darshan Navadiya
 */
public class StatusBar{
    JLabel statusBarTxt, statusTxt;


    String status;
    JPanel jPanel;

    public void setStatus(String status) {
        this.status = status;

    }
    StatusBar(){
        jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    }
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
