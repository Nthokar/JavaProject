package Course;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
public class StudentScore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public StudentScore(Course course){
        themesScore = course.getThemes();
    }
    public String studentName;
    public String studentGroup;

    @OneToMany
    public List<Theme> themesScore = new ArrayList<>();

    public StudentScore() {

    }
}
