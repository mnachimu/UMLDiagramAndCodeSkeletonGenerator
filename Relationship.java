public enum Relationship {
    AGGREGATION(1),
    ASSOCIATION(2),
    INHERITANCE(3),
    ;

    private int x;
    Relationship(int x) {
        this.x = x;
    }
}
