import Course.StudentScore;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    public List<StudentScore> scores = new ArrayList<>();

    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public int hashCode() { return super.hashCode(); }

}
