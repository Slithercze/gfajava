package mentors;

public class Student extends mentors.Person {

  private mentors.Course course;

  public Student(String name, int age, mentors.Course course) {
    super(name, age);
    this.course = course;
  }

  public void learning(mentors.Mentor mentor) {
    mentor.teaching();
    System.out.println("Im learning " + course + " !");
  }
}
