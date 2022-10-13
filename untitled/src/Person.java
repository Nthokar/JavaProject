import java.util.Date;

public class Person {
    private String firstname;
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    private String surname;
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    private String patronymic;
    public String getPatronymic() { return patronymic; }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    private int age;
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    private Date birthDate;
    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date age) { this.birthDate = birthDate; }

    @Override
    public String toString() { return super.toString(); }
}
