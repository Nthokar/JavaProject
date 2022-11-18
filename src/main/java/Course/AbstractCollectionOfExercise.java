package Course;

import java.util.HashMap;

public abstract class AbstractCollectionOfExercise<T extends Exercise>{
    private HashMap<String, T> collection;
    public void setThemes(HashMap<String, T> themes){
        this.collection = themes;
    }

    public void put(T exercise){
//        collection.put(T.getName(), T);
    }
    public T get(String name){
        return collection.get(name);
    }
    public boolean containsKey(String name){
        return collection.containsKey(name);
    }
}
