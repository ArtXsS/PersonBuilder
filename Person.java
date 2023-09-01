import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected Integer age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        if(age == null) {
            return false;
        }
        return true;
    }
    public boolean hasAddress() {
        if(address == null) {
            return false;
        }
        return true;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void happyBirthday() {
        if(age != null) {
            age++;
        }
    }

    @Override
    public String toString() {
        return "Имя - " +
                " " + name + '\n' +
                "Фамилия - " + surname + '\n' +
                "Возраст - " + age + '\n' +
                "Город - " + address + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(age, person.age) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder son = new PersonBuilder()
                .setName(name)
                .setSurname(this.surname)
                .setAge(age)
                .setAddress(this.address);
        return son;
    }

}
