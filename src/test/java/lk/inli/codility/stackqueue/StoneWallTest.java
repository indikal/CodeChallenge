package lk.inli.codility.stackqueue;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class StoneWallTest {
  private final StoneWall wall = new StoneWall();

  @Test
  public void testSolution_withN1() {
    Assert.assertEquals(1, wall.solution(new int[]{8}));
  }

  @Test
  public void testSolution_withN9() {
    Assert.assertEquals(7, wall.solution(new int[]{8,8,5,7,9,8,7,4,8}));
  }

  @Test
  public void testSolution_withMaxHeight() {
    Assert.assertEquals(2, wall.solution(new int[]{1, 1000000000}));
  }

  @Test
  public void testSolution_withMaxN() {
    int[] H = new int[100000];
    Arrays.fill(H, 0, 50000, 1);
    Arrays.fill(H, 50000, 100000, 1000000000);
    Assert.assertEquals(2, wall.solution(new int[]{1, 1000000000}));
  }
}
