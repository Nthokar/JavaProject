package Course;

import java.util.HashMap;

public class Theme
    implements CollectionOfExercise{
//    public Theme(String name, int value) {
//        super(name, value);
//    }

    HashMap<String, Exercise> collection = new HashMap<String, Task>();
    Exercise task = new Task("123", 89);

    public void setCollection(HashMap<String, Exercise> coll){
        collection = new HashMap<String, Task>();
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
