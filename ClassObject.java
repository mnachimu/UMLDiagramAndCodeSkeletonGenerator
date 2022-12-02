import java.awt.*;

public class ClassObject {

    private String className;
    private Coordinates coordinates;
    private Rectangle bounds;
    private final static int FIXED_WIDTH = 120;
    private final static int FIXED_HEIGHT = 30;

    public ClassObject(int x, int y) {

        bounds = new Rectangle(x - FIXED_WIDTH, y - FIXED_HEIGHT, FIXED_WIDTH*2, FIXED_HEIGHT*2);
        coordinates = new Coordinates(x, y);
        System.out.println("New ClassObject created at (" + getX() + ", " + getY() + ")");

    }

    public void setClassName(String name) {
        this.className = name;
    }

    public String getClassName() {
        return this.className;
    }

    public void resetCoordinates(int x, int y) {
        coordinates.setX(x);
        coordinates.setY(y);
        bounds.setBounds(x - FIXED_WIDTH, y - FIXED_HEIGHT, FIXED_WIDTH*2, FIXED_HEIGHT*2);
    }

    public int getX() {
        System.out.println("The coordinates.x and bounds.x " + coordinates.getX() + " " + bounds.x);
        return coordinates.getX();
    }

    public int getY() {
        System.out.println("The coordinates.x and bounds.x " + coordinates.getY() + " " + bounds.y);
        return coordinates.getY();
    }

    public boolean checkIfWithinBounds(int x, int y) {
        return bounds.contains(x, y);
    }

    public void displayName(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Courier", Font.BOLD, 14));
        if (className == null || className.equals(""))
            className = "Default";
        g.drawString(className, bounds.x + 30, bounds.y + 20);

    }

    public void draw(Graphics g) {
        g.setColor(new Color(242, 213, 145));
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        displayName(g);
    }

    public void selectedState(Graphics g) {
        g.setColor(new Color(255, 255, 10));
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        g.setColor(new Color(242, 213, 145));
    }

    public void unselectedState(Graphics g) {
        g.setColor(new Color(242, 213, 145));
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    private Point center() { // can be removed
        return new Point((bounds.x + bounds.width) / 2, (bounds.y + bounds.height / 2));
    }
}
