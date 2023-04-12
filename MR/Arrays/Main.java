import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    // (primitive) structure = structure data - tools (...)
    int[] numbers = new int[3];

    System.out.println(numbers[0]);
    System.out.println(numbers[1]);
    System.out.println(numbers[2]);

    System.out.println(numbers.length);
    // prints the address in a memory ("hash")
    System.out.println(numbers);

    // set value of each element of numbers to index X 2
    // array[index] => read / set value of an element at index
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = i * 2;
    }

    // Arrays class => convert array to readable form (string), formatted
    // sout(Arrays.toString(array)); => print readable form to terminal
    // toString() = convention => method that return readable form of an object
    System.out.println(Arrays.toString(numbers));

    // read every element of an array to terminal without any other formatting
    for (int i = 0; i < numbers.length; i++) {
      System.out.print(numbers[i]);
    }
    System.out.println();


//    String name = "Lukáš";
//    System.out.println(name.length());

    int groupAmount = 3;
    String[][] names = new String[groupAmount][];

    names[0] = new String[] {"Lukáš", "Aleš", "Dávid", "Luky dvě", "Matěj"};
    names[1] = new String[] {"Tomáš", "Max", "Otakar"};
//    names[0] = new String[] {"někdo", "jiný", "v jiným poli"};

    String[][] defaultNames = {
        {"Lukáš", "Aleš", "Dávid", "Luky dvě", "Matěj"},
        {"Tomáš", "Max", "Otakar"}
    };

    System.out.println(names[0][1]);

    System.out.println("Find Max");

    for (int i = 0; i < names.length; i++) {
      if (names[i] != null) {
        for (int j = 0; j < names[i].length; j++) {
          if (names[i][j].equals("Max")) {
            System.out.println(true);
            System.out.println("[" + i + ", " + j + "]");
          }
        }
      }
    }

  }
}
