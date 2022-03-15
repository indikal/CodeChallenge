package lk.inli.codility;

import org.junit.Assert;
import org.junit.Test;

public class MaxCounters2Test {
  private final MaxCounters2 maxCounters = new MaxCounters2();

  @Test
  public void testSolution_withN5() {
    Assert.assertArrayEquals(new int[]{3,2,2,4,2}, maxCounters.solution(5, new int[]{3,4,4,6,1,4,4}));
  }

  @Test
  public void testSolution_withA1() {
    Assert.assertArrayEquals(new int[]{1}, maxCounters.solution(1, new int[]{1}));
  }

  @Test
  public void testSolution_withA100000() {
    int[] result = maxCounters.solution(100000, new int[]{100000});
    Assert.assertEquals(1, result[99999]);
    Assert.assertEquals(0, result[0]);
    Assert.assertEquals(0, result[1]);
    Assert.assertEquals(0, result[99998]);
  }
}
