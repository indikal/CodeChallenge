package lk.inli.codility.curb;

import org.junit.Assert;
import org.junit.Test;

public class Assignment2Test {
  private final Assignment2 assignment2 = new Assignment2();

  @Test
  public void testSolution1() {
    Assert.assertEquals(-2, assignment2.solution(new int[]{-1,-2,-1,1,3,0}));
  }

  @Test
  public void testSolution2() {
    Assert.assertEquals(0, assignment2.solution(new int[]{}));
  }

  @Test
  public void testSolution3() {
    Assert.assertEquals(0, assignment2.solution(new int[]{100,99,1000,10001, 1,0}));
  }
}
