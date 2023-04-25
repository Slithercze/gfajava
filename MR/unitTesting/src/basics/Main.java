package basics;

public class Main {
  public static int sum(int a, int b) {
    return a + b;
  }

  public static int divide(int base, int divider) {
    if (divider == 0) {
      return 0;
    }
    return base / divider;
  }
}
