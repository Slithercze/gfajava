package com.gfa.exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeeklyFeedbackEvaluator {

  public static Map<String, Double> evaluateFeedback(String filePath) {
    Map<String, Double> result = new HashMap<>();
    result.put("matReview", 0.0);
    result.put("presSkills", 0.0);
    result.put("helpfulness", 0.0);
    result.put("explanations", 0.0);

    if (filePath == null) {
      return result;
    }

    Path path = Paths.get(filePath);
    try {
      List<String> lines = Files.readAllLines(path);
      if (!lines.isEmpty()) {
        double[] sum = new double[4];

        for (String line : lines) {
          String[] data = line.split(" ");
          for (int i = 0; i < 4; i++) {
            sum[i] += Double.parseDouble(data[i]);
          }
        }

        result.put("matReview", sum[0] / lines.size());
        result.put("presSkills", sum[1] / lines.size());
        result.put("helpfulness", sum[2] / lines.size());
        result.put("explanations", sum[3] / lines.size());
      }
    } catch (IOException e) {
      System.out.println("File not found: " + path.getFileName());
    }

    return result;
  }
}
