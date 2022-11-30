import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class CanvasPanelController implements MouseListener, MouseMotionListener {

    CanvasPanel canvasPanel;

    Relationship currentRelationshipType = Relationship.AGGREGATION;
    DataSource dataSource;

    CanvasPanelController(CanvasPanel canvasPanel) {
        this.canvasPanel = canvasPanel;
        this.dataSource = DataSource.getInstance();
        canvasPanel.addMouseListener(this);
        canvasPanel.addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Mouse clicked at ("
                + e.getX() + ", " + e.getY() + ")");
        int click = dataSource.isOnClassObject(e.getX(), e.getY());
        if (dataSource.selectedObject != -1 && click != -1) {
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

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

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
