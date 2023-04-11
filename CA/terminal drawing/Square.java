public class Square {
  public static void main(String[] args) {
    int size = 5;
    for (int row = 0; row < size; row++) {
      for (int column = 0; column < size; column++) {

        boolean isBorder = row == 0 || row == size - 1 || column == 0 || column == size - 1;
        boolean isDiagonal = row == column || row + column == size - 1;

        if (isBorder || isDiagonal) {
          System.out.print("% ");
        } else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }
  }
}
