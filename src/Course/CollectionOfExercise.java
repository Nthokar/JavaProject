package Course;

import java.util.HashMap;

public interface CollectionOfExercise{
    HashMap<String, Exercise> collection = null;
    void setCollection(HashMap<String, Exercise> collection);


     void add(Exercise exercise);
    Exercise get(String name);
    boolean containsKey(String name);
}
