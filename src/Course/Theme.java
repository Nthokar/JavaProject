package Course;

import java.util.HashMap;

public class Theme
    implements CollectionOfExercise, Exercise {
    public Theme(String name, int value) {

    }

    HashMap<String, Exercise> collection = new HashMap<String, Exercise>();

    public void setCollection(HashMap<String, Exercise> coll){
        collection = new HashMap<String, Exercise>();
    }
    @Override
    public void add(Exercise task) {
        collection.put(task.getName(), task);
    }

    @Override
    public Exercise get(String name) {
        return collection.get(name);
    }

    @Override
    public boolean containsKey(String name) {
        return collection.containsKey(name);
    }
}
