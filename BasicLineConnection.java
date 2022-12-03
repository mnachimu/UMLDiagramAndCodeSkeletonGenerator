import java.awt.*;
import java.awt.geom.Line2D;

public class BasicLineConnection implements ClassConnection {
    protected static int TOP = 0;
    protected static int LEFT = 1;
    protected static int BOTTOM = 2;
    protected static int RIGHT = 3;
    protected ClassConnection nextConnection;
    protected Point linePoint1;
    protected Point linePoint2;

    public BasicLineConnection(ClassConnection connection) {
        nextConnection = connection;
    }

    @Override
    public void handleConnection(Graphics g, ClassObject object1, ClassObject object2, Relationship relationshipType) {
        // code to draw line
        linePoint1 = new Point(object1.getX(), object1.getY());
        linePoint2 = new Point(object2.getX(), object2.getY());
        g.setColor(new Color(0, 0, 0));
        g.drawLine(linePoint1.x, linePoint1.y, linePoint2.x, linePoint2.y);
        handleConnectionForRelationship(g, getIntersectionOfObject(object1), getIntersectionOfObject(object2), getSlantAtInterSection(object1), getSlantAtInterSection(object2), relationshipType);
    }

    @Override
    public void handleConnectionForRelationship(Graphics g, Coordinates intersectionOfObject, Coordinates intersectionOfObject1, int slantAtInterSection, int slantAtInterSection1, Relationship relationshipType) {
        if (nextConnection != null) {
            nextConnection.handleConnectionForRelationship(g, intersectionOfObject, intersectionOfObject1, slantAtInterSection, slantAtInterSection1, relationshipType);
        }
    }

    public Coordinates getIntersectionOfObject(ClassObject object) {
        int slant = getSlantAtInterSection(object);
        if (slant == -1)
            return null;
        Coordinates a, b;
        if (slant == TOP) {
            a = new Coordinates( object.getBounds().getX(), object.getBounds().getY());
            b = new Coordinates(object.getBounds().getX() + object.getBounds().getWidth(), object.getBounds().getY());
        } else if (slant == LEFT) {
            a = new Coordinates( object.getBounds().getX(), object.getBounds().getY());
            b = new Coordinates(object.getBounds().getX(), object.getBounds().getY() + object.getBounds().getHeight());
        } else if (slant == BOTTOM) {
            a = new Coordinates( object.getBounds().getX(), object.getBounds().getY() + object.getBounds().getHeight());
            b = new Coordinates(object.getBounds().getX() + object.getBounds().getWidth(), object.getBounds().getY() + object.getBounds().getHeight());
        } else {
            a = new Coordinates( object.getBounds().getX() + object.getBounds().getWidth(), object.getBounds().getY());
            b = new Coordinates(object.getBounds().getX() + object.getBounds().getWidth(), object.getBounds().getY() + object.getBounds().getHeight());
        }
        double a1 = b.y - a.y;
        double b1 = a.x - b.x;
        double c1 = a1*(a.x) + b1*(a.y);

        double a2 = linePoint2.y - linePoint1.y;
        double b2 = linePoint1.x - linePoint2.x;
        double c2 = a2*(linePoint1.x)+ b2*(linePoint1.y);

        double determinant = a1*b2 - a2*b1;

        if (determinant == 0)
        {
            return new Coordinates(Double.MAX_VALUE, Double.MAX_VALUE);
        }
        else
        {
            double x = (b2*c1 - b1*c2)/determinant;
            double y = (a1*c2 - a2*c1)/determinant;
            return new Coordinates(x, y);
        }
    }

    public int getSlantAtInterSection(ClassObject object) {
        double ox1 = object.getBounds().getX();
        double oy1 = object.getBounds().getX();
        if (Line2D.linesIntersect(
                linePoint1.getX(), linePoint1.getY(),
                linePoint2.getX(), linePoint2.getY(),
                object.getBounds().getX() + object.getBounds().getWidth(), object.getBounds().getY() + object.getBounds().getHeight(),
                object.getBounds().getX(), object.getBounds().getY() + object.getBounds().getHeight())) {
            return BOTTOM;
        } else if (Line2D.linesIntersect(
                linePoint1.getX(), linePoint1.getY(),
                linePoint2.getX(), linePoint2.getY(),
                object.getBounds().getX(), object.getBounds().getY(),
                object.getBounds().getX()+ object.getBounds().getWidth(), object.getBounds().getY())) {
            return TOP;
        } else if (Line2D.linesIntersect(
                linePoint1.getX(), linePoint1.getY(),
                linePoint2.getX(), linePoint2.getY(),
                object.getBounds().getX() + object.getBounds().getWidth(), object.getBounds().getY() + object.getBounds().getHeight(),
                object.getBounds().getX() + object.getBounds().getWidth(), object.getBounds().getY())) {
            return RIGHT;
        }else if (Line2D.linesIntersect(
                linePoint1.getX(), linePoint1.getY(),
                linePoint2.getX(), linePoint2.getY(),
                object.getBounds().getX(), object.getBounds().getY(),
                object.getBounds().getWidth(), object.getBounds().getY() + object.getBounds().getHeight())) {
            return LEFT;
        } else {
            return -1;
        }
    }
}
