package lk.inli.codility;

import org.junit.Assert;
import org.junit.Test;

public class BinaryGapTest {
  private BinaryGap binaryGap = new BinaryGap();

  @Test
  public void testSolution1041() {
    Assert.assertEquals(5, binaryGap.solution(1041));
  }

  @Test
  public void testSolution32() {
    Assert.assertEquals(0, binaryGap.solution(32));
  }

  @Test
  public void testSolution9() {
    Assert.assertEquals(2, binaryGap.solution(9));
  }

  @Test
  public void testSolution15() {
    Assert.assertEquals(0, binaryGap.solution(15));
  }

  @Test
  public void testSolution20() {
    Assert.assertEquals(1, binaryGap.solution(20));
  }

  @Test
  public void testSolution529() {
    Assert.assertEquals(4, binaryGap.solution(529));
  }

  @Test
  public void testSolution1() {
    Assert.assertEquals(0, binaryGap.solution(1));
  }

  @Test
  public void testSolution0() {
    Assert.assertEquals(0, binaryGap.solution(0));
  }

  @Test
  public void testSolution2147483647() {
    Assert.assertEquals(0, binaryGap.solution(2147483647));
  }

  @Test
  public void testSolution1073741825() {
    Assert.assertEquals(29, binaryGap.solution(1073741825));
  }
}
