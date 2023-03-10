import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

/**
 * This class is a part of MODEL in MVC.
 * Singleton Pattern is used to implement this class.
 * @version  1.0
 */
public class DataSource extends Observable {
    static DataSource instance;
    List<ClassObject> classObjectsLists = new ArrayList<>();
    HashMap<String, Integer> classObjectNameIndex = new HashMap<>();

    int selectedObject = -1;

    Relationship[][] relationships = new Relationship[100][100];

    /**
     * Private Constructor
     */
    private DataSource() {
    }

    /**
     * Public getter of the Singleton class.
     * @return
     */
    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }


    /**
     * THis method return the class int if the given coordinate falls into the rectangle area.
     * @param x
     * @param y
     * @return
     */
    public int isOnClassObject(int x, int y) {
        for (int i=0 ; i<classObjectsLists.size() ; i++) {
            if (classObjectsLists.get(i).checkIfWithinBounds(x, y))
                return i;
        }
        return -1;
    }

    /**
     * Return the class if given coordinates fall into its area.
     * @param x X co-ordinate of the point
     * @param y Y co-ordinate of the point
     * @return
     */
    public ClassObject getClassObjectForPoint(int x, int y) {
        for (int i=0 ; i<classObjectsLists.size() ; i++) {
            if (classObjectsLists.get(i).checkIfWithinBounds(x, y))
                return classObjectsLists.get(i);
        }
        return null;
    }

    /**
     * Adds class into the canvas panel.
     * @param o
     */
    public void addClassObject(ClassObject o) {
        classObjectNameIndex.put(o.getClassName(), classObjectsLists.size());
        classObjectsLists.add(o);
        setChanged();
        notifyObservers();
    }

    /**
     * Adds relationships between classes
     * @param type Relation type .1)AGGREGATION 2)INHERITANCE 3)COMPOSITION
     * @param a
     * @param b
     */
    public void addRelationship(Relationship type, String a, String b) {
        addRelationship(type, classObjectNameIndex.get(a), classObjectNameIndex.get(b));
    }

    /**
     * Notify the observers of the canvas panel about changes.
     * @param type
     * @param a
     * @param b
     */
    public void addRelationship(Relationship type, int a, int b) {
        relationships[a][b] = type;
        setChanged();
        notifyObservers();
    }

    public void setSelectedObject(int i) {
        selectedObject = i;
        setChanged();
        notifyObservers();
    }

    public int getSelectedObject() {
        return this.selectedObject;
    }

}
