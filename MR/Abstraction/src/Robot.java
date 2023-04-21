import java.util.List;

public class Robot implements CanTeach, CanPlayTableFootball {
  @Override
  public void teach(List<Student> studentList) {
    System.out.println("Robot is teaching");
    // todo robot teaching stuff
  }

  @Override
  public void playTableFootball() {
    System.out.println("im playing table football using screwdrivers");
  }

  @Override
  public String pickTeam(int teamACount, int teamBCount) {
    return "B";
  }

}
