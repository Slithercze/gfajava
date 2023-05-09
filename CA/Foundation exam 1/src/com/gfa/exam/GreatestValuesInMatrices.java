package com.gfa.exam;

public class GreatestValuesInMatrices {
  public int[][] mergeMatrix(int[][] matrixA, int[][] matrixB) {
    validateMatrices(matrixA, matrixB);

    int[][] result = new int[matrixA.length][];

    for (int i = 0; i < matrixA.length; i++) {
      int[] row = new int[matrixA.length];
      for (int j = 0; j < matrixA.length; j++) {
        if (matrixA[i][j] > matrixB[i][j]) {
          row[j] = matrixA[i][j];
        } else {
          row[j] = matrixB[i][j];
        }
      }
      result[i] = row;
    }
    return result;
  }

  private static void validateMatrices(int[][] matrixA, int[][] matrixB) {
    if (matrixA == null || matrixB == null) {
      throw new IllegalArgumentException();
    }
    if (matrixA.length != matrixB.length) {
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < matrixA.length; i++) {
      if (matrixA[i].length != matrixA.length || matrixB[i].length != matrixB.length) {
        throw new IllegalArgumentException();
      }
    }
  }
}
