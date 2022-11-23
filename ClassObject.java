public class ClassObject {
    String className;
    Coordinates coordinates;

    public ClassObject() {

    }

    public ClassObject(double x, double y) {
        coordinates = new Coordinates(x,y);
    }

    public void setClassName(String name) {
        this.className = name;
    }

    public String getClassName() {
        return this.className;
    }

    public void resetCoordinates(double x, double y) {
        coordinates.setX(x);
        coordinates.setY(y);
    }
}
