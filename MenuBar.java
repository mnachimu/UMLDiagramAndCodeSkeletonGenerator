import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class implements menubar and different buttons
 * This class is part of VIEW in MVC.
 * @version 1.0
 */
public class MenuBar {
    private static String[] NAMES = new String[]{"Mugunth Nachimuthu", "Austin Kwon", "Darshan Navadiya", "Vashishtha Patel", "Janki Padiya", "Dhairya Dudhatra"};
    JMenuBar menuBar;
    JMenu fileMenu, helpMenu;
    JMenuItem newItem, saveItem, loadItem;
    JMenuItem[] names;

    /**
     * Adding MenuItems in the Menubar
     */
    MenuBar(){
        names = new JMenuItem[6];
        this.menuBar = new JMenuBar();
        this.fileMenu = new JMenu("File");
        this.helpMenu = new JMenu("Help");

        newItem = new JMenuItem("New");
        saveItem = new JMenuItem("Save");
        loadItem = new JMenuItem("Load");

        fileMenu.add(newItem);
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        for (int i=0 ; i< NAMES.length ; i++) {
            helpMenu.add(new JMenuItem(NAMES[i]));
        }

        this.menuBar.add(fileMenu);
        this.menuBar.add(helpMenu);
    }


    public JMenuBar getJMenuBar() {
        return this.menuBar;
    }
}
