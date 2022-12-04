package Course;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Course extends AbstractCollectionOfExercise<Theme>
        implements Exercise {
    public Course(String name) {
        this.name = name;
    }
    private String name;
    @Override
    public String getTitle() {
        return name;
    }

    private int value;
    @Override
    public int getValue() {
        return value;
    }
    private List<Theme> themes = new ArrayList<>();

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }
    public void put(Theme theme) {
        themes.add(theme);
    }
}
