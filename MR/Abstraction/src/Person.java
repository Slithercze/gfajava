import java.util.Objects;

public abstract class Person implements CanPlayTableFootball, Comparable<Person> {

  private int age;

  private String name;

  public Person(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public abstract void introduce();

  @Override
  public void playTableFootball() {
    System.out.println("Im playing table football with my hands");
  }

  public int compareTo(Person person) {
    return this.age - person.age;
  }

}
