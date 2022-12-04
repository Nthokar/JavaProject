package Course;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
public class Theme extends AbstractCollectionOfExercise<Task>
    implements Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Theme(String name) {
        this.title = name;
    }
    public Integer semester;
    public Integer maxScoreActivities;
    public Integer maxScoreHomeWork;

    public Theme() {

    }

    public void pullUp(){
//        if (tasks.containsKey("Упр"))
//        {
//            value = tasks.get("Упр").getValue();
//            //tasks.remove("Упр");
//        }
//
//        if (tasks.containsKey("Сем"))
//        {
//            semester = tasks.get("Сем").getValue();
//            //tasks.remove("Сем");
//        }
//
//        if (tasks.containsKey("Акт"))
//        {
//            maxScoreActivities = tasks.get("Акт").getValue();
//            //tasks.remove("Акт");
//        }
//
//        if (tasks.containsKey("ДЗ"))
//        {
//            maxScoreHomeWork = tasks.get("ДЗ").getValue();
//            //tasks.remove("ДЗ");
//        }
    }
    private String title;
    @Override
    public String getTitle() {
        return title;
    }

    private int value;
    @Override
    public int getValue() {
        return value;
    }

    @OneToMany
    private List<Task> tasks = new ArrayList<Task>();
    public List<Task> getTasks() {
        return tasks;
    }

    public void setThemes(List<Task> themes) {
        this.tasks = themes;
    }
    public void put(Task task) {
        tasks.add(task);
    }
}
