package com.gfa.exam;

public class SumOfOddRows {
  public static int sumOddRows(int[][] matrix) {
    if (matrix == null) {
      throw new IllegalArgumentException();
    }

    int sum = 0;

    for (int row = 0; row < matrix.length; row++) {
      for (int column = 0; column < matrix[row].length; column++) {
//        if ((row + column) % 2 != 0) {
//          sum += matrix[row][column];
//        }
        if (row % 2 != 0) {
          sum += matrix[row][column];
        }
      }
    }

    return sum;
  }
}
