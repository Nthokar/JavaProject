package Course;

public interface Exercise {
    final String name = null;

    default String getName() { return name; }
    final Integer value = null;

    default int getValue() { return value; }
}
