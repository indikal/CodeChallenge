package lk.inli.codility.caterpillar;

import org.junit.Assert;
import org.junit.Test;

public class ContiguousSubsequenceTest {
  private final ContiguousSubsequence subsequence = new ContiguousSubsequence();

  @Test
  public void testSolution_withS12() {
    Assert.assertTrue(subsequence.solution(new int[]{6,2,7,4,1,3,6}, 12));
  }
}
