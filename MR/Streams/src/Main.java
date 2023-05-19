import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
  private static List<String> staticNames =
      List.of("Lukáš", "David", "Aleš", "Míra", "Alex", "Michal");

  public static void main(String[] args) {
    Predicate<Integer> jeDelitelneDvemi = c -> c % 2 == 0;

    List<String> namesStartWithM = new ArrayList<>();

    for (String name : staticNames) {
      if (name != null && name.toLowerCase().startsWith("m")) {
        namesStartWithM.add(name);
      }
    }

    System.out.println(namesStartWithM);

    Optional<String> nameWithA = Optional.empty();

    for (String name : staticNames) {
      if (name != null && name.toLowerCase().startsWith("a")) {
        nameWithA = Optional.of(name);
        break;
      }
    }
    System.out.println("S LOOOPOOOOU");
    if (nameWithA.isPresent()) {
      String realName = nameWithA.get();
      System.out.println(realName);
    } else {
      System.out.println("Nic tam neni");
    }

    System.out.println("JAKO LAMBDA");

    Function<Integer, String> prevedNaString = cislo -> {

      if (jeDelitelneDvemi.test(cislo)) {
        return String.valueOf(cislo);
      }
      return "neni delitelne dvěma";
    };

    jeDelitelneDvemi.test(59);



    String vysledek = prevedNaString.apply(3);
    System.out.println("Vysledek funkce prevedNaString");
    System.out.println(vysledek);

    Consumer<String> vytiskniMiJmeno = jmeno -> System.out.println(jmeno);
    vytiskniMiJmeno.accept("ahoj");

    Runnable nicTamNeni = () -> System.out.println("Nic tam neni");
    nicTamNeni.run();

    nameWithA.ifPresentOrElse(vytiskniMiJmeno, nicTamNeni);




  }
  public static boolean jeDelitelneDvemi (Integer cislo) {
    return cislo % 2 == 0;
  }
}

