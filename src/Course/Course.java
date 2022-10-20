package Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Course implements
    CollectionOfExercise,
    Exercise {

    List<Theme> themes = new ArrayList<Theme>();

    @Override
    public void setCollection(HashMap<String, Exercise> collection) {

    }
}
