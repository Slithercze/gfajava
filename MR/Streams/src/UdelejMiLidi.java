import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.Collectors;

public class UdelejMiLidi {
  private static List<String> staticNames =
      List.of("Lukáš", "David", "Aleš", "Míra", "Alex", "Michal");

  public static void main(String[] args) {
    List<Person> people = staticNames.stream()
        .map(name -> new Person(name))
        .toList();

    people.forEach(person -> person.setAge(new Random().nextInt(10, 50)));

    List<Person> adults = people.stream()
        .filter(p -> p.getAge() > 18)
        .collect(Collectors.toList());

    Optional<Person> someone = adults.stream()
        .findAny();

    someone.ifPresent(value -> System.out.println(value));

    OptionalDouble average = people.stream()
        .map(Person::getAge)
        .mapToInt(Integer::intValue)
        .average();


    System.out.println("Pruměrný věk lidí je:");
    average.ifPresent(System.out::println);

    someone.ifPresent(System.out::println);


  }
}
