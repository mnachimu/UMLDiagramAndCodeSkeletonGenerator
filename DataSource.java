import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

public class DataSource extends Observable {
    List<ClassObject> classObjectsLists = new ArrayList<>();
    HashMap<String, Integer> classObjectNameIndex = new HashMap<>();

    Relationship[][] relationships = new Relationship[100][100];
    public DataSource() {
    }

    public void addClassObject(ClassObject o) {
        classObjectNameIndex.put(o.getClassName(), classObjectsLists.size());
        classObjectsLists.add(o);
        setChanged();
        notifyObservers();
    }

    public void addRelationship(Relationship type, String a, String b) {
        relationships[classObjectNameIndex.get(a)][classObjectNameIndex.get(b)] = type;
        setChanged();
        notifyObservers();
    }

}
