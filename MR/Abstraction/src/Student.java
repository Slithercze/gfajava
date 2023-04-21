public class Student extends Person {
  public Student(int age, String name) {
    super(age, name);
  }

  @Override
  public String getName() {
    return super.getName() + " the student";
  }

  @Override
  public void introduce() {
    System.out.println("Ahoj, ja jsem student " + getName());
  }

  @Override
  public String pickTeam(int playerCountA, int playerCountB) {
    if (playerCountA < playerCountB) {
      return "A";
    }
    return "B";
  }
}
