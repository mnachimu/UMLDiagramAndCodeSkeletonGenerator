import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CanvasPanel extends JPanel implements MouseListener, MouseMotionListener {
	
	public CanvasPanel(int x, int y) {
		this.setBackground(Color.white);
		this.setBounds(x, y, 500, 450);
    	this.setLayout(new BorderLayout());
    	this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    	
    	addMouseListener(this);
    	addMouseMotionListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse clicked at ("
				+ e.getX() + ", " + e.getY() + ")");
		ClassObject o = new ClassObject(e.getX(), e.getY());
		
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
