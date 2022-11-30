import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

public class DataSource extends Observable {
    static DataSource instance;
    List<ClassObject> classObjectsLists = new ArrayList<>();
    HashMap<String, Integer> classObjectNameIndex = new HashMap<>();

    int selectedObject = -1;

    Relationship[][] relationships = new Relationship[100][100];
    private DataSource() {
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public int isOnClassObject(int x, int y) {
        for (int i=0 ; i<classObjectsLists.size() ; i++) {
            if (classObjectsLists.get(i).checkIfWithinBounds(x, y))
                return i;
        }
        return -1;
    }

    public void addClassObject(ClassObject o) {
        classObjectNameIndex.put(o.getClassName(), classObjectsLists.size());
        classObjectsLists.add(o);
        setChanged();
        notifyObservers();
    }

    public void addRelationship(Relationship type, String a, String b) {
        addRelationship(type, classObjectNameIndex.get(a), classObjectNameIndex.get(b));
    }

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
