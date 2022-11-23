import java.awt.*;

public class ClassObject {

	private Rectangle bounds;
	private final static int FIXED_WIDTH = 10;
	private final static int FIXED_HEIGHT = 10;

	public ClassObject(int x, int y) {
		
		bounds = new Rectangle(x, y, FIXED_WIDTH, FIXED_HEIGHT);
	}
	
	public int getX() {
		return bounds.x;
	}
	
	public int getY() {
		return bounds.y;
	}
	
	public void draw(Graphics g) {		
		g.setColor(Color.red);
		g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
	}
	
}
