package lk.inli.codility;

import org.junit.Assert;
import org.junit.Test;

public class StringConstructTest {
  private final StringConstruct stringConstruct = new StringConstruct();

  @Test
  public void testSolution1() {
    Assert.assertEquals("aabbaaba", stringConstruct.solution(5,3));
  }

  @Test
  public void testSolution2() {
    Assert.assertEquals("aabbab", stringConstruct.solution(3,3));
  }

  @Test
  public void testSolution3() {
    Assert.assertEquals("bbabb", stringConstruct.solution(1,4));
  }

  @Test
  public void testSolution4() {
    Assert.assertEquals("aabbaabbaa", stringConstruct.solution(6,4));
  }

  @Test
  public void testSolution5() {
    Assert.assertEquals("aabaaba", stringConstruct.solution(5,2));
  }
}
