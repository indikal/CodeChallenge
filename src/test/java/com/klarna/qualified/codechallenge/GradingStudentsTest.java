package com.klarna.qualified.codechallenge;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;

public class GradingStudentsTest {

  @Test
  public void testGradingStudentsOneGradeFailling() {
    assertEquals(List.of(33), GradingStudents.gradingStudents(List.of(33)));
  }

  @Test
  public void testGradingStudentsOneGradeUp1() {
    assertEquals(List.of(75), GradingStudents.gradingStudents(List.of(73)));
  }

  @Test
  public void testGradingStudentsOneGradeUp2() {
    assertEquals(List.of(40), GradingStudents.gradingStudents(List.of(38)));
  }

  @Test
  public void testGradingStudentsOneGradeSame() {
    assertEquals(List.of(67), GradingStudents.gradingStudents(List.of(67)));
  }
}
