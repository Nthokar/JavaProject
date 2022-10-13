package Course;

import java.util.HashMap;
import java.util.HashSet;

public interface CollectionOfExercise extends Exercise {
    HashMap<String, Exercise> collection = null;

    default void add(Exercise exercise){ collection.put(exercise.getName(), exercise); }

    default Exercise get(Exercise exercise) { return  collection.get(exercise.getName()); }
    default Exercise get(String name) { return  collection.get(name); }

    default boolean containsKey(Exercise exercise) { return  collection.containsKey(exercise.getName()); }
    default boolean containsKey(String name) { return  collection.containsKey(name); }
}
