package lk.inli.codility.leader;

import org.junit.Assert;
import org.junit.Test;

public class GoldenLeaderTest {
  private final GoldenLeader leader = new GoldenLeader();

  @Test
  public void testSolution_with7Elem() {
    Assert.assertEquals(6, leader.solution(new int[]{6,8,4,6,8,6,6}));
  }

  @Test
  public void testSolution_withNoLeader() {
    Assert.assertEquals(-1, leader.solution(new int[]{6,8,4,6,8,6,6,4}));
  }
}
