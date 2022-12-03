import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.*;


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
            currentRelationshipType = (Relationship) JOptionPane.showInputDialog(
                    e.getComponent(),
                    "The type of relation between the classes",
                    "Relationship Type",
                    JOptionPane.OK_OPTION,
                    null,
                    Relationship.values(),
                    currentRelationshipType);
            dataSource.addRelationship(currentRelationshipType, dataSource.selectedObject, click);
            dataSource.selectedObject = -1;
            dataSource.setSelectedObject(-1);
            // todo: remove this - set the currentRelationshipType to a different relationship
            if (currentRelationshipType.equals(Relationship.AGGREGATION))
                currentRelationshipType = Relationship.ASSOCIATION;
            else if (currentRelationshipType.equals(Relationship.ASSOCIATION))
                currentRelationshipType = Relationship.INHERITANCE;
            else
                currentRelationshipType = Relationship.AGGREGATION;
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
            RecordStatus.getInstance().Record("Class "+name +" created.");
            dataSource.addClassObject(o);
            

        } else {
            dataSource.setSelectedObject(click);
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
