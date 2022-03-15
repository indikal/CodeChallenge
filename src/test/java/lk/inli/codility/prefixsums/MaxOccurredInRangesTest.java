package lk.inli.codility.prefixsums;

import org.junit.Assert;
import org.junit.Test;

public class MaxOccurredInRangesTest {
  private final MaxOccurredInRanges maxOccurredInRanges = new MaxOccurredInRanges();

  @Test
  public void testSolution_withL4() {
    Assert.assertEquals(4,
        maxOccurredInRanges.solution(new int[]{1, 4, 3, 1}, new int[]{15, 8, 5, 4}, 1000000));
  }

  @Test
  public void testSolution_withL5() {
    Assert.assertEquals(5,
        maxOccurredInRanges.solution(new int[]{1,5,9,13,21}, new int[]{15,8,12,20,30}, 1000000));
  }
}
