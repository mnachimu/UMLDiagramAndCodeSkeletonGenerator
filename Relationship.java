/**
 * This enum maps the relation types with different integers.
 */
public enum Relationship {
    NO_RELATION(0),
    AGGREGATION(1),
    ASSOCIATION(2),
    INHERITANCE(3),
    ;

    private int x;
    Relationship(int x) {
        this.x = x;
    }
}
