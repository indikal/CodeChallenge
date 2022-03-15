package lk.inli.codility;

import java.util.stream.IntStream;
import org.junit.Assert;
import org.junit.Test;

public class PermutationMissingElementTest {
  private final PermutationMissingElement missingElement = new PermutationMissingElement();

  @Test
  public void testSolution_withEmptyA() {
    Assert.assertEquals(1, this.missingElement.solution(new int[]{}));
  }

  @Test
  public void testSolution_withOneElemA() {
    Assert.assertEquals(2, this.missingElement.solution(new int[]{1}));
  }

  @Test
  public void testSolution_with4ElemA() {
    Assert.assertEquals(4, this.missingElement.solution(new int[]{2,3,1,5}));
  }

  @Test
  public void testSolution_withMaxElemInOrderA() {
    int[] A = IntStream.range(1, 100000).toArray();
    Assert.assertEquals(100000, this.missingElement.solution(A));
  }

  @Test
  public void testSolution_withMaxElemShuffledA() {
    int[] A = IntStream.range(1, 100000).unordered().toArray();
    Assert.assertEquals(100000, this.missingElement.solution(A));
  }
}
