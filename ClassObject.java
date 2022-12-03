import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Class for the representation of class rectangle in the canvas panel.
 * This class is a part of VIEW in MVC.
 * @version 1.0
 */
public class ClassObject {

    private String className;
    private Coordinates coordinates;
    private Rectangle bounds;
    private final static int FIXED_WIDTH = 120;
    private final static int FIXED_HEIGHT = 30;

    /**
     * Class Constructor
     * @param x Initial x-coordinate of class rectangle
     * @param y Initial y-coordinate of class rectangle
     */
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

    /**
     * Changing the coordinates of rectangle to given point
     * @param x X-coordinate where you want to place rectangle
     * @param y Y-coordinate where you want to place rectangle
     */
    public void resetCoordinates(int x, int y) {
        coordinates.setX(x);
        coordinates.setY(y);
        bounds.setBounds(x - FIXED_WIDTH, y - FIXED_HEIGHT, FIXED_WIDTH*2, FIXED_HEIGHT*2);
    }

    /**
     * Get the X-coordinate of given class object
     * @return
     */
    public int getX() {
        return (int)coordinates.getX();
    }

    /**
     * Get the Y-coordinate of given class object
     * @return
     */
    public int getY() {
        return (int)coordinates.getY();
    }

    public boolean checkIfWithinBounds(int x, int y) {
        return bounds.contains(x, y);
    }

    /**
     * Displays class name in the rectangle in the canvas panel.
     * THis class is a part of MODEL in MVC.
     * @param g
     */
    public void displayName(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Courier", Font.BOLD, 14));
        if (className == null || className.equals(""))
            className = "Default";
        g.drawString(className, bounds.x + 30, bounds.y + 20);

    }

    /**
     * Draws a rectangle with specific colour on the canvas panel.
     * @param g
     */
    public void draw(Graphics g) {
        g.setColor(new Color(242, 213, 145));
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        displayName(g);
    }

    /**
     * Visual representation of how class rectangle should look alike when it's selected.
     * @param g
     */
    public void selectedState(Graphics g) {
        g.setColor(new Color(255, 255, 10));
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        g.setColor(new Color(242, 213, 145));
    }

    /**
     * Visual representation of how class rectangle should look alike when it's not selected.
     * @param g
     */
    public void unselectedState(Graphics g) {
        g.setColor(new Color(242, 213, 145));
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }


    public Rectangle getBounds() {
        return this.bounds;
    }

    /**
     * Gives the center point of the class rectangle
     * @return (x,y) coordinate
     */
    private Point center() { // can be removed
        return new Point((bounds.x + bounds.width) / 2, (bounds.y + bounds.height / 2));
    }
}
