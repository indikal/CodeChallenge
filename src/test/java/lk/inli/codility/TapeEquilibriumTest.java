package lk.inli.codility;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class TapeEquilibriumTest {
  private final TapeEquilibrium equilibrium = new TapeEquilibrium();

  @Test
  public void testSolution_with2Zeros() {
    Assert.assertEquals(0, this.equilibrium.solution(new int[]{0,0}));
  }

  @Test
  public void testSolution_with3Zeros() {
    Assert.assertEquals(20, this.equilibrium.solution(new int[]{0,0,20}));
  }

  @Test
  public void testSolution_with5Elem() {
    Assert.assertEquals(1, this.equilibrium.solution(new int[]{3,1,2,4,3}));
  }

  @Test
  public void testSolution_with5NegElem() {
    Assert.assertEquals(1, this.equilibrium.solution(new int[]{-3,-1,-2,-4,-3}));
  }

  @Test
  public void testSolution_with5NegPosElem() {
    Assert.assertEquals(1, this.equilibrium.solution(new int[]{-3,-1,-2,4,-3}));
  }

  @Test
  public void testSolution_withEdgeCase1() {
    Assert.assertEquals(2000, this.equilibrium.solution(new int[]{-1000,1000}));
  }

  @Test
  public void testSolution_withEdgeCase2() {
    Assert.assertEquals(0, this.equilibrium.solution(new int[]{-1000,-1000}));
  }

  @Test
  public void testSolution_withAllNegative() {
    Assert.assertEquals(1, this.equilibrium.solution(new int[]{-1,-1,-1,-1,-1}));
  }

  @Test
  public void testSolution_withMixNegative() {
    Assert.assertEquals(4, this.equilibrium.solution(new int[]{3,-5,-1,5,-2}));
  }

  @Test
  public void testSolution_withLargeA() {
    int[] A = new int[100000];
    Arrays.fill(A, 1);
    Assert.assertEquals(0, this.equilibrium.solution(A));
  }

}
