package lk.inli.codility;

import org.junit.Assert;
import org.junit.Test;

public class MaxCountersTest {
  private MaxCounters maxCounters = new MaxCounters();

  @Test
  public void testSolution() {
    Assert.assertArrayEquals(new int[]{3, 2, 2, 4, 2},
        maxCounters.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4}));
  }

  @Test
  public void testSolutionN1() {
    Assert.assertArrayEquals(new int[]{5},
        maxCounters.solution(1, new int[]{1,1,1,3,1,1}));
  }

  @Test
  public void testSolutionN10() {
    int[] m = new int[]{};
    int[] out = maxCounters.solution(10, m);
    Assert.assertEquals(0, out[0]);
    Assert.assertEquals(0, out[9]);
  }

  @Test
  public void testSolutionN100000() {
    int[] m = new int[]{1,1,1,100001,1,1};
    int[] out = maxCounters.solution(100000, m);
    Assert.assertEquals(5, out[0]);
    Assert.assertEquals(3, out[100000-1]);
  }
}
