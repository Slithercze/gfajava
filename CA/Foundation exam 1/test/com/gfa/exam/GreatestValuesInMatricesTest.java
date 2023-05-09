package com.gfa.exam;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GreatestValuesInMatricesTest {

  @org.junit.jupiter.api.Test
  void mergeMatrixTest() {
    GreatestValuesInMatrices g = new GreatestValuesInMatrices();
    int[][] a = new int[][] {
        new int[] {2, 1},
        new int[] {0, 1}
    };
    int[][] b = new int[][] {
        new int[] {0, 3},
        new int[] {-1, 1}
    };
    int[][] expected = new int[][] {
        new int[] {2, 3},
        new int[] {0, 1}
    };


    int[][] res = g.mergeMatrix(a, b);

    assertArrayEquals(expected, res);
  }

  @Test()
  void mergeMatrixNullTest() {
    GreatestValuesInMatrices g = new GreatestValuesInMatrices();
    assertThrows(IllegalArgumentException.class, () -> {
      g.mergeMatrix(new int[0][], null);
    });
  }
}