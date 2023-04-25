package mentors;

public class Bootcamp {
  public static void main(String[] args) {
    mentors.Mentor mentor = new mentors.Mentor("Aleš", 15, mentors.MentorLevel.SENIOR);
    mentors.Student student = new mentors.Student("Alfons", 50, mentors.Course.PROGRAMMING);
    mentor.teaching();
    student.learning(mentor);
  }
}
