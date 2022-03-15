package lk.inli.codility.prefixsums;

import org.junit.Assert;
import org.junit.Test;

public class RangeDivisibleByIntegerTest {
  private final RangeDivisibleByInteger divisible = new RangeDivisibleByInteger();

  @Test
  public void testSolution_with_0_0_1() {
    Assert.assertEquals(1, this.divisible.solution_best(0,0,1));
  }

  @Test
  public void testSolution_with_0_1_1() {
    Assert.assertEquals(2, this.divisible.solution_best(0,1,1));
  }

  @Test
  public void testSolution_with_0_1_2() {
    Assert.assertEquals(1, this.divisible.solution_best(0,1,2));
  }

  @Test
  public void testSolution_with_0_max_max() {
    Assert.assertEquals(2, this.divisible.solution_best(0,2000000000,2000000000));
  }

  @Test
  public void testSolution_with_6_11_2() {
    Assert.assertEquals(3, this.divisible.solution_best(6,11,2));
  }
}
