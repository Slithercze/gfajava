import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    int random = new Random().nextInt(3);
    Runnable run;

    Runnable druhyRun = () -> System.out.println("Jsem druhy run");

    switch (random) {
      case 0:
        run = () -> System.out.println("Ahoj!");
        break;
      case 1:
        run = () -> System.out.println(1 + 5);
        break;
      case 2:
        run = () -> System.out.println("Tohle je případ číslo 2");
        break;
      default:
        run = () -> System.out.println("Tohle je default");
        break;
    }

    doSomething(run);
    doSomethingElse(run);
    run.run();
  }

  public static void doSomething(Runnable somethingThatCanRun) {
    somethingThatCanRun.run();
  }

  public static void doSomethingElse(Runnable somethingElse) {
    System.out.println("Tady dělám něco hrozně jinýho hrozně jinde.");
    somethingElse.run();
  }
}
