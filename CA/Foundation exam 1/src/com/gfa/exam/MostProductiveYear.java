package com.gfa.exam;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostProductiveYear {
  public String mostProductiveYear(String path) {
    List<String> lines;
    try {
      lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
    } catch (IOException e) {

      String studio = Paths.get(path).getFileName().toString().split("\\.")[0];
      return "Cannot find studio " + studio + ", please try again later.";
    }

    Map<String, Integer> counts = new HashMap<>();
    for (String line : lines) {
      String year = line.split(",")[1];
      if (!counts.containsKey(year)) {
        counts.put(year, 1);
      } else {
        counts.put(year, counts.get(year) + 1);
      }
    }

    int maxCount = -1;
    String maxYear = "";

    for (Map.Entry<String, Integer> entry : counts.entrySet()) {
      if (entry.getValue() > maxCount) {
        maxCount = entry.getValue();
        maxYear = entry.getKey();
      }
    }
    return maxYear;
  }

  public static void main(String[] args) {
    String res = new MostProductiveYear().mostProductiveYear("assets/marvel.csv");
    System.out.println(res);
  }
}
