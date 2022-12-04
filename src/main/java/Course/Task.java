package Course;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public final class Task implements Exercise{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    public Task(String name, int value){
        this.name = name;
        this.value = value;
    }
    private String name;

    public Task() {

    }

    public String getTitle() { return name; }

    private int value;
    public int getValue() { return value; }

    @Override
    public String toString() { return super.toString(); }
}
