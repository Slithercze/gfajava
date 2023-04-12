import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String a = "Ahoj ho ho ho";

        //a.replace();
        String[] arr = a.split(" ", 2);
        System.out.println(Arrays.toString(arr));
        System.out.println(a);

        String[] colors = {"blue", "black"};
        String[] numbers = {"1", "2"};

        String joinedArray = String.join(" | ", colors);
        String joinedNumbers = String.join(" | ", numbers);

        System.out.println(joinedArray);
        System.out.println(joinedNumbers);

        druhaCastMR(); // funkce, predavani hodnoty vs. reference
        tretiCastMR(); // ArrayList
        ctvrtaCastMR(); // HashMap
    }

    static void druhaCastMR() {
        int number = 2;
        function(number);
        System.out.println(number);

        int[] arr = {1, 2};
        function2(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void function2(int[] i) {
        i[0] = 10000000;
        System.out.println("---function2");
        System.out.println(Arrays.toString(i));
    }

    static void function(int i) {
        i = 100000000;
        System.out.println("---function");
        System.out.println(i);
    }

    static void tretiCastMR() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Lukas");
        names.add("David");

        System.out.println(names);
        System.out.println(names.get(0));

        // 🧁 bounty hunters -- can you find a neater (/shorter) way how to initialize ArrayList with values?
        ArrayList<String> kewl = new ArrayList<>(Arrays.asList("ahoj", "cau"));

        ArrayList<ArrayList<String>> ahoj2d = new ArrayList<>();

        ArrayList<String> ahoj1d = new ArrayList<>();

        ahoj1d.add("ahoj");

        ahoj2d.add(ahoj1d);
        ahoj2d.add(ahoj1d);

        //ahoj2d.get(0).get(0);
        ArrayList<String> inner1d = ahoj2d.get(0);
        String innerInnerString = inner1d.get(0);

        System.out.println(ahoj2d.get(0).get(0) == innerInnerString);

        System.out.println(innerInnerString);
    }

    static void ctvrtaCastMR() {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "ahoj");
        map.put(100000, "sparse!");
    }
}