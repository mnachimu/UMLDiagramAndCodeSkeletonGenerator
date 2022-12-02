import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Darshan Navadiya
 */
public class MenuBar {
    JMenuBar menuBar;
    JMenu fileMenu, helpMenu;
    JMenuItem newItem, saveItem, loadItem;
    MenuBar(){
         this.menuBar = new JMenuBar();
         this.fileMenu = new JMenu("File");
         this.helpMenu = new JMenu("Help");

         newItem = new JMenuItem("New");
         saveItem = new JMenuItem("Save");
         loadItem = new JMenuItem("Load");

        fileMenu.add(newItem);
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);


        this.menuBar.add(fileMenu);
        this.menuBar.add(helpMenu);
    }


    public JMenuBar getJMenuBar() {
        return this.menuBar;
    }
}