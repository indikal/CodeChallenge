package lk.inli.codility.leader;

import org.junit.Assert;
import org.junit.Test;

public class EquiLeaderTest {
  private final EquiLeader equiLeader = new EquiLeader();

  @Test
  public void testSolution_with6Elems() {
    Assert.assertEquals(2, equiLeader.solution(new int[]{4,3,4,4,4,2}));
  }

  @Test
  public void testSolution_with7Elem() {
    Assert.assertEquals(0, equiLeader.solution(new int[]{6,8,4,6,8,6,6}));
  }

  @Test
  public void testSolution_with6Leaders_with5EquiLeaders() {
    Assert.assertEquals(5, equiLeader.solution(new int[]{6,8,6,6,8,6,6}));
  }

  @Test
  public void testSolution_with7Leaders_with2EquiLeaders() {
    Assert.assertEquals(3, equiLeader.solution(new int[]{6,8,6,6,8,6,6,4}));
  }

}
