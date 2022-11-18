package Course;
import java.util.HashMap;

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
    private HashMap<String, Theme> themes = new HashMap<>();

    public HashMap<String, Theme> getThemes() {
        return themes;
    }

    public void setThemes(HashMap<String, Theme> themes) {
        this.themes = themes;
    }
    public void put(Theme theme) {
        themes.put(theme.getTitle(), theme);
    }

    public Theme get(String name) {
        return themes.get(name);
    }

    public boolean containsKey(String name) {
        return themes.containsKey(name);
    }
}
