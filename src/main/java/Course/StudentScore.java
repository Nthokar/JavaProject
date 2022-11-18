package Course;

import java.util.HashMap;

public class StudentScore {
    public StudentScore(Course course){
        themesScore = course.getThemes();
    }
    public String studentName;
    public String studentGroup;

    public HashMap<String, Theme> themesScore = new HashMap<>();
}
