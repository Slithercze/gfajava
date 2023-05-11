package com.gfa.exam;

public class TextFromMatrix {
  public static String textFromMatrix(String[][] matrix) {
    if (matrix == null) {
      throw new IllegalArgumentException();
    }

    String result = "";
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
          result = result.concat(matrix[i][j]);
        }
      }
    }
    return result;
  }
}
