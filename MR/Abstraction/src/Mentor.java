import java.util.List;

public class Mentor extends Person implements CanTeach {
  public Mentor(int age, String name) {
    super(age, name);
  }

  @Override
  public void introduce() {
    System.out.println("Ahoj, ja jsem mentor " + getName());
  }

  @Override
  public void teach(List<Student> studentList) {
    System.out.println("Mentor is teaching");
    // todo add code later
  }

  @Override
  public void playTableFootball() {
    System.out.println("im playing table football with one hand");
  }

  @Override
  public String pickTeam(int playerCountA, int playerCountB) {
    return "A";
  }
}
