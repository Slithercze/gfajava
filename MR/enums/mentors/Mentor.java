package mentors;

public class Mentor extends mentors.Person {

  private mentors.MentorLevel level;

  public Mentor(String name, int age, mentors.MentorLevel level) {
    super(name, age);
    this.level = level;
  }

  public void teaching() {
    System.out.println("I am mentor at level " + level + " and I like to teach.");
  }
}
