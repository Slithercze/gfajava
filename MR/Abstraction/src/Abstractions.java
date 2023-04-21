import java.util.ArrayList;
import java.util.List;

public class Abstractions {
  public static void main(String[] args) {
    List<CanTeach> teachers = new ArrayList<>();

    teachers.add(new Robot());
    teachers.add(new Mentor(30, "Vasek"));


    for (CanTeach teacher : teachers) {
      teacher.teach(new ArrayList<>());
    }

    for (int i = 0; i < teachers.size(); i++) {
      CanTeach teacher = teachers.get(i);

      teacher.teach(new ArrayList<>());
    }

    List<CanPlayTableFootball> footballPlayers = new ArrayList<>();

    footballPlayers.add(new Student(20, "Tomas"));
    footballPlayers.add(new Student(20, "Mojimir"));
    footballPlayers.add(new Mentor(18, "ales"));
    footballPlayers.add(new Robot());

    List<CanPlayTableFootball> teamA = new ArrayList<>();
    List<CanPlayTableFootball> teamB = new ArrayList<>();
    for (CanPlayTableFootball player : footballPlayers) {
      if (player.pickTeam(teamA.size(), teamB.size()).equals("A")) {
        teamA.add(player);
      } else {
        teamB.add(player);
      }
    }

    Person a = new Student(20, "aaa");
    Person b = new Student(19, "aaa");
    System.out.println(a.compareTo(b));

  }
}