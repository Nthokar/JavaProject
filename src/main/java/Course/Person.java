package Course;

import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.base.Sex;
import com.vk.api.sdk.queries.EnumParam;

import java.time.LocalDate;
import java.util.Date;

public class Person {
    private String name;
    private Long id;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    private String patronymic;
    public String getPatronymic() { return patronymic; }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    private Sex sex;
    public Sex getSex() { return sex; }
    public void setSex(Sex sex) { this.sex = sex; }
    private int age;
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    private LocalDate birthDate;
    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

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
