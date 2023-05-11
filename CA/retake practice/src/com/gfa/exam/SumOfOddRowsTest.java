package com.gfa.exam;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SumOfOddRowsTest {

  @org.junit.jupiter.api.Test
  void sumOddRows() {
    // arrange
    int[][] matrix = {
        {1, 2},
        {3, 4},
        {5, 6}
    };
    int expected = 7;
    // act
    int actual = SumOfOddRows.sumOddRows(matrix);
    // assert
    assertEquals(expected, actual);
  }

  @Test
  void shouldThrowException() {
    assertThrows(IllegalArgumentException.class, () -> SumOfOddRows.sumOddRows(null));
  }
}
