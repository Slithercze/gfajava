import java.util.Random;

public class Person {
  private String name;
  private int age;
  private boolean isSmart;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
    this.isSmart = new Random().nextBoolean();
  }

  public Person(String name) {
    this.name = name;
    this.isSmart = new Random().nextBoolean();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public boolean isSmart() {
    return isSmart;
  }

  public void setSmart(boolean smart) {
    isSmart = smart;
  }
}
