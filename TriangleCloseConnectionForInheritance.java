import java.awt.*;

public class TriangleCloseConnectionForInheritance extends BasicLineConnection {

    private int triangleHeight = 12;
    private int triangleHalfWidth = 8;

    public TriangleCloseConnectionForInheritance(ClassConnection connection) {
        super(connection);
    }

    public void handleConnectionForRelationship(Graphics g, Coordinates c1, Coordinates c2, int slant1, int slant2, Relationship relationshipType) {
        if (relationshipType.equals(Relationship.INHERITANCE)) {
            // use c2 and slant2 to draw the triangle
            int x = (int) c2.getX();
            int y = (int) c2.getY();
            g.setColor(new Color(5, 250, 5));
            if (slant2 == TOP) {
                g.drawPolygon(new int[]{x, x-triangleHalfWidth, x+triangleHalfWidth},
                        new int[]{y,y-triangleHeight, y-triangleHeight}, 3);
            } else if (slant2 == RIGHT) {
                g.drawPolygon(new int[]{x, x+triangleHeight, x+triangleHeight},
                        new int[]{y, y-triangleHalfWidth, y+triangleHalfWidth}, 3);
            } else if (slant2 == BOTTOM) {
                g.drawPolygon(new int[]{x, x-triangleHalfWidth, x+triangleHalfWidth},
                        new int[]{y,y+triangleHeight, y+triangleHeight}, 3);
            } else if (slant2 == LEFT) {
                g.drawPolygon(new int[]{x, x-triangleHeight, x-triangleHeight},
                        new int[]{y,y-triangleHalfWidth, y+triangleHalfWidth}, 3);
            }
        } else {
            nextConnection.handleConnectionForRelationship(g, c1, c2, slant1, slant2, relationshipType);
        }
    }
}
