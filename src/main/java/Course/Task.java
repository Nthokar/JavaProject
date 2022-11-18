package Course;

public final class Task implements Exercise{
    public Task(String name, int value){
        this.name = name;
        this.value = value;
    }
    private final String name;
    public String getTitle() { return name; }

    private final int value;
    public int getValue() { return value; }

    @Override
    public String toString() { return super.toString(); }
}
