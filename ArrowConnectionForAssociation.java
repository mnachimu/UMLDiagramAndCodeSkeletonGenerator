import java.awt.*;

public class ArrowConnectionForAssociation extends BasicLineConnection {

    public ArrowConnectionForAssociation(ClassConnection nextConnection) {
        super(nextConnection);
    }

    public void handleConnectionForRelationship(Graphics g, Coordinates c1, Coordinates c2, int slant1, int slant2, Relationship relationshipType) {
        // code for writing the arrow head connection
        if (relationshipType.equals(Relationship.ASSOCIATION)) {
            // use c2 and slant2 to draw the arrow
        } else {
            nextConnection.handleConnectionForRelationship(g, c1, c2, slant1, slant2, relationshipType);
        }
//        nextConnection.handleConnectionForRelationship(g, c1, c2, slant1, slant2, relationshipType);
    }
}
