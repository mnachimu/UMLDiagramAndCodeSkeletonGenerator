import java.awt.*;

public interface ClassConnection {
    void handleConnection(Graphics g, ClassObject object1 , ClassObject object2, Relationship relationshipType);

    void handleConnectionForRelationship(Graphics g, Coordinates intersectionOfObject, Coordinates intersectionOfObject1, int slantAtInterSection, int slantAtInterSection1, Relationship relationshipType);
}
