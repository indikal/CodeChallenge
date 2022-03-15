package lk.inli.codility.primary;

import org.junit.Assert;
import org.junit.Test;

public class CountFactorsTest {
  private final CountFactors countFactors = new CountFactors();

  @Test
  public void testSolution_with1() {
    Assert.assertEquals(1, countFactors.solution_new(1));
  }

  @Test
  public void testSolution_with2() {
    Assert.assertEquals(2, countFactors.solution_new(2));
  }

  @Test
  public void testSolution_with4() {
    Assert.assertEquals(3, countFactors.solution_new(4));
  }

  @Test
  public void testSolution_with24() {
    Assert.assertEquals(8, countFactors.solution_new(24));
  }

  @Test
  public void testSolution_withMaxInt() {
    Assert.assertNotEquals(8, countFactors.solution_new(2147483647)); //timeouts
  }
}
