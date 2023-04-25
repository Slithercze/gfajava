package basics;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  @DisplayName("Sum of two positive numbers")
  void sum() {
    //Arrange
    int a = new Random().nextInt();
    int b = new Random().nextInt();
    int expected = a + b;
    // Act
    int actual = Main.sum(a, b);
    // Assert
    assertEquals(expected, actual);
  }


  @Test
  void twoStringsShouldBeEqual() {
    assertEquals("text", "ext");
  }

  @Test
  @DisplayName("Divide by 0 - should return 0")
  void divideByZero() {
    // A
    int base = 6;
    int divider = 0;
    int expected = 0;
    // act + assert
    assertEquals(Main.divide(base, divider), expected);
  }
}
