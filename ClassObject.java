import java.awt.*;

public class ClassObject {

	private Rectangle bounds;
	private final static int FIXED_WIDTH = 120;
	private final static int FIXED_HEIGHT = 30;
	private String name;

	public ClassObject(int x, int y) {
		
		bounds = new Rectangle(x, y, FIXED_WIDTH, FIXED_HEIGHT);
		
		System.out.println("New ClassObject created at (" + getX() + ", " + getY() + ")");
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName(String name) {
		return name;
	}
	
	public int getX() {
		return bounds.x;
	}
	
	public int getY() {
		return bounds.y;
	}
	
	public void displayName(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("Courier", Font.BOLD, 14));
		g.drawString(name, bounds.x + 30, bounds.y + 20);
		
	}
	
	public void draw(Graphics g) {
		g.setColor(new Color(242, 213, 145));
		g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
		displayName(g);
	}
	

	private Point center() {
		return new Point((bounds.x + bounds.width) / 2, (bounds.y + bounds.height / 2));
	}
	
}
