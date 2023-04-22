import java.util.*;

public class FibAndDataStructures {
    public static void main(String[] args) {
        System.out.println("=== Fibonacci");

        // fibonacci with object Long caching – dynamic programming
        System.out.println(fibonacciArrLong(10, null));
        // fibonacci with primitive long caching – dynamic programming
        System.out.println(fibonacciArrlong(10, null));
        // fibonacci with Map caching – dynamic programming
        System.out.println(fibonacciMap(10, null));

        System.out.println("=== pole");

        int a = 12;
        int[] pole = {1, 3}; // shorthand
        int[] pole2 = new int[] {1, 3}; // long version
        int[] pole3 = new int[2]; // init empty array (contains 0 for primitive numerical values, false for boolean, null for objects)

        System.out.println(pole3); // toString() implementation returns just an address
        System.out.println(Arrays.toString(pole3)); // handy helper static method that converts arrays to string nicely

        System.out.println("=============");

        System.out.println("=== ArrayList");
        ArrayList<Boolean> list = new ArrayList<>();

        list.add(true);
        list.add(false);
        list.add(true);
        list.add(false);

        // remove by index
        list.remove(0);

        System.out.println(list);

        list.addAll(List.of(true, true, true, true));

        System.out.println(list);

        // remove by value
        list.remove(true);

        // ArrayList implements toString() nicely – can print directly
        System.out.println(list);

        System.out.println("=============");

        System.out.println("=== HashMap");

        HashMap<String, Integer> iq = new HashMap<>();

        iq.put("ales", 90);
        iq.put("Denys", 190);
        iq.put("Nicole", 190);

        iq.putAll(Map.of("key", -1, "Lukas", 350));

        // HashMap implements toString() nicely – can print directly
        System.out.println(iq);

        System.out.println(iq.keySet()); // all keys
        System.out.println(iq.values()); // all values

        // access value by key
        System.out.println(iq.get("ales"));

        ArrayList<String> toBeRemoved = new ArrayList<>();

        // iterate through all keys, get value for each and if too smart put them in list of keys to be removed
        for (String key : iq.keySet()) {
            if (iq.get(key) > 150) {
                toBeRemoved.add(key);
            }
        }

        // we can't iterate over Collection and add/remove from/to it at the same time
        // that's why it's two-step process!
        for (String key : toBeRemoved) {
            iq.remove(key);
        }

        System.out.println(iq.keySet());
        System.out.println(iq);

        System.out.println("=============");


        System.out.println("=== playground");

        System.out.println("= primitives -- default value");

        boolean[] poleBool = new boolean[3]; // empty array of booleans
        System.out.println(Arrays.toString(poleBool));

        System.out.println("= objects -- default value");

        Boolean[] poleBoolObject = new Boolean[3]; // empty array of Booleans
        System.out.println(Arrays.toString(poleBoolObject));

        System.out.println("= playground");

        String[] poleStringu = {"ahoj", "cau", "nazdar"};
        System.out.println(poleStringu); // again, array can't be printed directly

        String[] poleStr = new String[10];
        System.out.println(Arrays.toString(poleStr)); // using helper method

        for (String s : poleStringu) {
            System.out.println(s);
        }

        for (int i = 0; i < poleStringu.length; i++) {
            StringBuilder padding = new StringBuilder();
            for (int j = 0; j < i; j++) {
                padding.append(" ");
            }
            // I whish that we could use " ".repeat(i), but we can't since we have to adhere to Java 8!

            System.out.println(i + 1 + ". ".concat(padding.toString()).concat(poleStringu[i]));
            // questions?
        }
    }

    static long fibonacciArrLong(int index, Long[] memory) {
        if (memory == null) {
            memory = new Long[index+1];
            memory[0] = 0L;
            memory[1] = 1L;
        }

        if (memory[index] != null) {
            return memory[index];
        }

        memory[index] = fibonacciArrLong(index - 1, memory) + fibonacciArrLong(index - 2, memory);

        System.out.println(Arrays.toString(memory));

        return memory[index];
    }

    static long fibonacciArrlong(int index, long[] memory) {
        if (memory == null) {
            memory = new long[index+1];
            memory[0] = 0;
            memory[1] = 1;
        }

        // with primitive long, impossible to know if 0 is not computed yet or an actual value
        // that's why the if is more complex
        if (index == 0 || memory[index] != 0) {
            return memory[index];
        }

        memory[index] = fibonacciArrlong(index - 1, memory) + fibonacciArrlong(index - 2, memory);

        System.out.println(Arrays.toString(memory));

        return memory[index];
    }

    static long fibonacciMap(int index, Map<Integer, Long> map) {
        //if (index < 2) return index;
        if (map == null) {
            map = new HashMap<>();
            map.putAll(Map.of(0, 0L, 1, 1L));
        }

        if (map.get(index) != null) {
            return map.get(index);
        }

        map.put(index, fibonacciMap(index - 1, map) + fibonacciMap(index - 2, map));

        System.out.println(map);

        return map.get(index);
    }
}
