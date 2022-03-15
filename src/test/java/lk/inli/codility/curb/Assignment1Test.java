package lk.inli.codility.curb;

import org.junit.Assert;
import org.junit.Test;

public class Assignment1Test {
  private final Assignment1 assignment1 = new Assignment1();

  @Test
  public void testSolution_with6_6() {
    Assert.assertEquals(0, assignment1.solution("6:00", "6:00"));
  }

  @Test
  public void testSolution_with20_6() {
    Assert.assertEquals(40, assignment1.solution("20:00", "6:00"));
  }

  @Test
  public void testSolution_with6_20() {
    Assert.assertEquals(56, assignment1.solution("06:00", "20:00"));
  }

  @Test
  public void testSolution_with614_2015() {
    Assert.assertEquals(54, assignment1.solution("06:14", "19:46"));
  }
}
