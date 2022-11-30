import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.ArrayList;

public class CanvasPanel extends JPanel implements MouseListener, MouseMotionListener {

	public List<ClassObject> objects;	// Maybe we can put this in the DataSource model?

	private static final int width = 625;
	private static final int height = 600;
		
	private int mouseX, mouseY;
	
	public CanvasPanel(int x, int y) {
		
		objects = new ArrayList<ClassObject>();
		
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
		 
		for (int i = 0; i < objects.size(); i++) {
			objects.get(i).draw(g);
		}

	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse clicked at ("
				+ e.getX() + ", " + e.getY() + ")");
		ClassObject o = new ClassObject(e.getX(), e.getY());
		String name = (String)JOptionPane.showInputDialog(
				e.getComponent(),
				"Enter the new class name",
				"Class Name",
				JOptionPane.PLAIN_MESSAGE,
				null,
				null,
				"Default");
		objects.add(o);

		if ((name != null) && (name.length() > 0)) {
			o.setName(name);
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
	
}
