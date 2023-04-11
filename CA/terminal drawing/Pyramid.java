public class Pyramid {
  public static void main(String[] args) {
    int totalRows = 4;
    int totalColumns = (totalRows * 2) - 1;
    int middle = totalColumns / 2;

    for (int row = 0; row < totalRows; row++) {
      for (int column = 0; column < totalColumns; column++) {

        int lowerBound = middle - row;
        int upperBound = middle + row;

        if (column >= lowerBound && column <= upperBound) {
          System.out.print("*");
        } else if (column < lowerBound) {
          System.out.print("0");
        }
      }
      System.out.println();
    }
  }
}
