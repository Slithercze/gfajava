package com.gfa.exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostCommonCharacters {

  public static Map<Character, Integer> getTwoMostCommonCharacters(String filename) throws IOException {
    Path path = Paths.get(filename);
    Map<Character, Integer> results = new HashMap<>();

    try {
      List<String> content = Files.readAllLines(path);
      Map<Character, Integer> occurrences = new HashMap<>();

      for (String line : content) {
        char[] characters = line.toCharArray();
        for (char ch : characters) {
          if (occurrences.containsKey(ch)) {
            occurrences.put(ch, occurrences.get(ch) + 1);
          } else {
            occurrences.put(ch, 1);
          }
        }
      }

      int iterationMax = Math.min(2, occurrences.size());

      for (int i = 0; i < iterationMax; i++) {
        Map.Entry<Character, Integer> mostCommon = null;

        for (Map.Entry<Character, Integer> entry : occurrences.entrySet()) {
          if (mostCommon == null || entry.getValue() > mostCommon.getValue()) {
            mostCommon = entry;
          }
        }

        results.put(mostCommon.getKey(), mostCommon.getValue());
        occurrences.remove(mostCommon.getKey());
      }

    } catch (IOException exeption) {
      throw new IOException("File does not exist!");
    }
    return results;
  }
}
