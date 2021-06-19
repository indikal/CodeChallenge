package com.klarna.qualified.codechallenge;


import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class GradingStudents {

  private static final Integer FAILING_GRADE = 38;
  /*
   * Complete the 'gradingStudents' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY grades as parameter.
   */

  public static List<Integer> gradingStudents(List<Integer> grades) {
    // Write your code here
    return grades.stream()
        .map(GradingStudents::gradeUp)
        .collect(Collectors.toUnmodifiableList());
  }

  private static Integer nextMultipleOfFive(Integer marks) {
    int timesOfFives = Math.floorDiv(marks, 5);

    return Math.multiplyExact((timesOfFives + 1), 5);
  }

  private static Integer gradeUp(Integer marks) {
    if (marks < FAILING_GRADE) {
      return marks;
    } else {
      int nextMultiple = nextMultipleOfFive(marks);
      System.out.println("Next multiple: " + nextMultiple);
      return ((nextMultiple - marks) < 3) ? nextMultiple : marks;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter(System.getenv("OUTPUT_PATH")));

    int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
      try {
        return bufferedReader.readLine().replaceAll("\\s+$", "");
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    })
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> result = GradingStudents.gradingStudents(grades);

    bufferedWriter.write(
        result.stream()
            .map(Object::toString)
            .collect(joining("\n"))
            + "\n"
    );

    bufferedReader.close();
    bufferedWriter.close();
  }

}
