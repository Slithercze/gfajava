package com.gfa.exam;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TextFromMatrixTest {

  @org.junit.jupiter.api.Test
  void textFromMatrix() {
    String[][] input = {
        {"h", "p", "e"},
        {"k", "l", "a"},
        {"l", "m", "o"}
    };
    String expected = "hello";
    String actual = TextFromMatrix.textFromMatrix(input);

    assertEquals(expected, actual);
  }

  @Test
  void shouldThrowException() {
    assertThrows(IllegalArgumentException.class, () -> TextFromMatrix.textFromMatrix(null));
  }
}
