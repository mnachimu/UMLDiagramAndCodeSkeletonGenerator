import java.awt.*;

public class PolygonConnection extends BasicLineConnection {
    private int polygonHeight = 10;
    private int polygonHalfWidth = 6;

    public PolygonConnection(ClassConnection nextConnection) {
        super(nextConnection);
    }

    public void handleConnectionForRelationship(Graphics g, Coordinates c1, Coordinates c2, int slant1, int slant2, Relationship relationshipType) {
        System.out.println("IN polygon draw");
        if (relationshipType.equals(Relationship.AGGREGATION)) {
            //code for drawing polygon
            int x = (int) c1.getX();
            int y = (int) c1.getY();
            g.setColor(new Color(0, 100, 250));
            if (slant1 == TOP) {
                g.drawPolygon(new int[]{x, x-polygonHalfWidth, x+polygonHalfWidth, x},
                        new int[]{y,y-polygonHalfWidth, y-polygonHalfWidth, y-polygonHeight}, 4);
            } else if (slant1 == RIGHT) {
                g.drawPolygon(new int[]{x, x+polygonHalfWidth, x+polygonHalfWidth, x+polygonHeight},
                        new int[]{y, y-polygonHalfWidth, y+polygonHalfWidth, y+polygonHeight}, 4);
            } else if (slant1 == BOTTOM) {
                g.drawPolygon(new int[]{x, x-polygonHalfWidth, x+polygonHalfWidth, x},
                        new int[]{y,y+polygonHalfWidth, y+polygonHalfWidth, y+polygonHeight}, 4);
            } else if (slant1 == LEFT) {
                g.drawPolygon(new int[]{x, x-polygonHalfWidth, x-polygonHalfWidth, x-polygonHeight},
                        new int[]{y,y-polygonHalfWidth, y+polygonHalfWidth, y-polygonHeight}, 4);
            }
        } else {
            nextConnection.handleConnectionForRelationship(g, c1, c2, slant1, slant2, relationshipType);
        }
//        nextConnection.handleConnectionForRelationship(g, c1, c2, slant1, slant2, relationshipType);
    }
}
