import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


/**
 * This class implements CONTROLLER from MVC.
 * This class has methods which acts as an interfaces to MODEL.
 * @version 1.0
 */

public class CanvasPanelController implements MouseListener, MouseMotionListener {

    CanvasPanel canvasPanel;

    Relationship currentRelationshipType = Relationship.AGGREGATION;
    DataSource dataSource;

    /**
     * This is Class Constructor
     * @param canvasPanel
     */
    CanvasPanelController(CanvasPanel canvasPanel) {
        this.canvasPanel = canvasPanel;
        this.dataSource = DataSource.getInstance();
        canvasPanel.addMouseListener(this);
        canvasPanel.addMouseMotionListener(this);
    }

    /**
     * If clicked in a canvas panel somewhere collects information about classes
     * and passes it to the model.
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Mouse clicked at ("
                + e.getX() + ", " + e.getY() + ")");
        int click = dataSource.isOnClassObject(e.getX(), e.getY());
        if (dataSource.selectedObject != -1 && click != -1) {
            RecordStatus.getInstance().record(
                    "New Relationship between classes"
                            + dataSource.classObjectsLists.get(dataSource.selectedObject).getClassName()
                            + "and " + dataSource.classObjectsLists.get(click).getClassName()
                            +  "are being created ");
            currentRelationshipType = (Relationship) JOptionPane.showInputDialog(
                    e.getComponent(),
                    "The type of relation between the classes",
                    "Relationship Type",
                    JOptionPane.OK_OPTION,
                    null,
                    Relationship.values(),
                    currentRelationshipType);
            RecordStatus.getInstance().record(currentRelationshipType.name()
                    + " is added between " + dataSource.classObjectsLists.get(dataSource.selectedObject)
                    + " and " + dataSource.classObjectsLists.get(click));
            dataSource.addRelationship(currentRelationshipType, dataSource.selectedObject, click);
            dataSource.selectedObject = -1;
            dataSource.setSelectedObject(-1);
        } else if (click == -1) {
            ClassObject o = new ClassObject(e.getX(), e.getY());
            String name = (String) JOptionPane.showInputDialog(
                    e.getComponent(),
                    "Enter the new class name",
                    "Class Name",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "Default");
            if ((name != null) && (name.length() > 0))
                o.setClassName(name);
            RecordStatus.getInstance().record("Class " + name +" created");
            dataSource.addClassObject(o);
            

        } else {
            dataSource.setSelectedObject(click);
            if (click != -1)
                RecordStatus.getInstance().record(dataSource.classObjectsLists.get(click).getClassName() + " is selected");
        }

//        canvasPanel.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
//        canvasPanel.repaint();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
//        canvasPanel.repaint();

    }

    /**
     * Change the position of class object according to the drag position.
     * @param e
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        ClassObject o = dataSource.getClassObjectForPoint(e.getX(), e.getY());
        if (o != null) {
            o.resetCoordinates(e.getX(), e.getY());
            canvasPanel.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
