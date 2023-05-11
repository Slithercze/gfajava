package com.gfa.exam;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesStatistics {
  public static Map<String, Double> calculateSalesStats(String filePath)
      throws FileNotFoundException {
    Path path = Paths.get(filePath);
    try {
      List<String> lines = Files.readAllLines(path);
      if (lines.size() < 1) {
        return null;
      }

      Map<String, Double> result = new HashMap<>();
      result.put("totalRevenue", 0d);
      result.put("totalUnits", 0d);

      for (String line : lines) {
        String[] data = line.split(",");
        result.put("totalRevenue", result.get("totalRevenue") + Double.parseDouble(data[2]));
        result.put("totalUnits", result.get("totalUnits") + Double.parseDouble(data[1]));
      }

      return result;
    } catch (IOException exception) {
      throw new FileNotFoundException("File not found: " + path.getFileName().toString());
    }
  }
}
