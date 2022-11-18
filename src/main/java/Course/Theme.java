package Course;

import java.util.HashMap;

public class Theme extends AbstractCollectionOfExercise<Task>
    implements Exercise {
    public Theme(String name) {
        this.title = name;
    }
    public Integer semester;
    public Integer maxScoreActivities;
    public Integer maxScoreHomeWork;

    public void pullUp(){
        if (tasks.containsKey("Упр"))
        {
            value = tasks.get("Упр").getValue();
            //tasks.remove("Упр");
        }

        if (tasks.containsKey("Сем"))
        {
            semester = tasks.get("Сем").getValue();
            //tasks.remove("Сем");
        }

        if (tasks.containsKey("Акт"))
        {
            maxScoreActivities = tasks.get("Акт").getValue();
            //tasks.remove("Акт");
        }

        if (tasks.containsKey("ДЗ"))
        {
            maxScoreHomeWork = tasks.get("ДЗ").getValue();
            //tasks.remove("ДЗ");
        }
    }
    private final String title;
    @Override
    public String getTitle() {
        return title;
    }

    private int value;
    @Override
    public int getValue() {
        return value;
    }

    private HashMap<String, Task> tasks = new HashMap<>();
    public HashMap<String, Task> getTasks() {
        return tasks;
    }

    public void setThemes(HashMap<String, Task> themes) {
        this.tasks = themes;
    }
    public void put(Task task) {
        tasks.put(task.getTitle(), task);
    }

    public Task get(String name) {
        return tasks.get(name);
    }
    public HashMap<String, Task> getCollection() {
        return tasks;
    }

    public boolean containsKey(String name) {
        return tasks.containsKey(name);
    }
}
