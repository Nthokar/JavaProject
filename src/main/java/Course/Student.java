package Course;

import Course.Person;
import Course.StudentScore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    @OneToMany
//    public List<StudentScore> scores = new ArrayList<>();

    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public int hashCode() { return super.hashCode(); }

}
