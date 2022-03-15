package lk.inli.codility;

import org.junit.Assert;
import org.junit.Test;

public class FrogJumpTest {
  private final FrogJump frogJump = new FrogJump();

  @Test
  public void testSolution_withZeroDistance() {
    Assert.assertEquals(0, this.frogJump.solution(10,10,10));
  }

  @Test
  public void testSolution_withDistanceShorterThanJump() {
    Assert.assertEquals(1, this.frogJump.solution(10,15,10));
  }

  @Test
  public void testSolution_withDistanceEqJump() {
    Assert.assertEquals(1, this.frogJump.solution(10,20,10));
  }

  @Test
  public void testSolution_withDistanceFor3Jumps() {
    Assert.assertEquals(3, this.frogJump.solution(10,85,30));
  }

  @Test
  public void testSolution_withEdgeCase1() {
    Assert.assertEquals(1, this.frogJump.solution(1,1000000000,1000000000));
  }

  @Test
  public void testSolution_withEdgeCase2() {
    Assert.assertEquals(999999999, this.frogJump.solution(1,1000000000,1));
  }

  @Test
  public void testSolution_withEdgeCase3() {
    Assert.assertEquals(0, this.frogJump.solution(1000000000,1000000000,1));
  }
}
