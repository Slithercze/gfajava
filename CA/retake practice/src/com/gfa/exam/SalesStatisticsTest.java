package com.gfa.exam;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

class SalesStatisticsTest {

  @Test
  void shouldReturnNullForEmptyFile() throws FileNotFoundException {
    assertNull(SalesStatistics.calculateSalesStats("emptyFile"));
  }

  @Test
  void shouldThrowExceptionThatFileDoesNotExist() {
    assertThrows(FileNotFoundException.class, () -> SalesStatistics.calculateSalesStats("FileThatDoesNotExist"));
  }

  @Test
  void shouldReturnCorrectMap() throws FileNotFoundException {
    // arrange
    Map<String, Double> expected = new HashMap<>();
    expected.put("totalRevenue", 2500d);
    expected.put("totalUnits", 20d);
    expected.put("averageSalesPerProduct", 625d);
    expected.put("averageUnitsPerProduct", 5d);
    // act
    Map<String, Double> actual = SalesStatistics.calculateSalesStats("data");
    // assert
    assertTrue(expected.equals(actual));
    }
}
