import java.util.Date;

public class Person {
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    private String patronymic;
    public String getPatronymic() { return patronymic; }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    private int age;
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    private Date birthDate;
    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    private String homeTown;

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) { this.homeTown = homeTown; }

    @Override
    public String toString() { return super.toString(); }

    @Override
    public int hashCode() { return super.hashCode(); }
}
