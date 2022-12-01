import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class CanvasPanel extends JPanel implements MouseListener, MouseMotionListener, Observer {
	
//	List<ClassObject> objects;
	Relationship currentRelationshipType = Relationship.AGGREGATION;
	DataSource dataSource;
	private static final int width = 625;
	private static final int height = 600;
	
	public BufferedImage canvas;
	
	int mouseX, mouseY;

	public CanvasPanel(int x, int y) {
		canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
//		objects = new ArrayList<ClassObject>();
		dataSource = DataSource.getInstance();

		this.setBackground(Color.white);
		this.setBounds(x, y, width, height);
    	this.setLayout(new BorderLayout());
    	this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    	
    	addMouseListener(this);
    	addMouseMotionListener(this);
    	
	}
	
	@Override
	public void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 
		 g.setColor(new Color(242, 213, 145));
		 
		 // FIXME: Exception when uncommented

		for (int i = 0; i < dataSource.classObjectsLists.size(); i++) {
			System.out.println("Checking " + dataSource.classObjectsLists.get(i).getClassName());
			dataSource.classObjectsLists.get(i).draw(g);
		}
		if (dataSource.selectedObject != -1) {
			dataSource.classObjectsLists.get(dataSource.selectedObject).selectedState(g);
		}
		Relationship[][] rels = dataSource.relationships;
		for (int i=0 ; i< rels.length; i++) {
			for (int j=0 ; j<rels[0].length ; j++) {
				if (!( rels[i][j] == null || rels[i][j] == Relationship.NO_RELATION)) {
					System.out.println(rels[i][j].name());
					g.drawLine(dataSource.classObjectsLists.get(i).getX(),
							dataSource.classObjectsLists.get(i).getY(),
							dataSource.classObjectsLists.get(j).getX(),
							dataSource.classObjectsLists.get(j).getY());
					switch (rels[i][j]) { // change it to arrows
						case AGGREGATION -> System.out.println("Aggregation between " + i + " and " + j);
						case ASSOCIATION -> System.out.println("Association between " + i + " and " + j);
						case INHERITANCE -> System.out.println("Inheritance between " + i + " and " + j);
					}
				}
			}
		}
		for (int ix=0 ; ix< rels.length ; ix++) {
			for (int j=0 ; j<rels[0].length ; j++) {
				if (rels[ix][j] != null)
					System.out.println(rels[ix][j].name());
			}
		}
			 
//		g.drawImage(canvas, 0, 0, this);
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
		} else if (click == -1) {
			ClassObject o = new ClassObject(e.getX(), e.getY());
			String name = (String)JOptionPane.showInputDialog(
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
			dataSource.selectedObject = click;
		}
		
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		repaint();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		repaint();

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

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
}
