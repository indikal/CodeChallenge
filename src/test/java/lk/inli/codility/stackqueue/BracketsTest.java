package lk.inli.codility.stackqueue;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class BracketsTest {
  private final Brackets brackets = new Brackets();

  @Test
  public void testSolution_withEmptyS() {
    Assert.assertEquals(1, brackets.solution(""));
  }

  @Test
  public void testSolution_withProperlyNested() {
    Assert.assertEquals(1, brackets.solution("{[()()]}"));
  }

  @Test
  public void testSolution_withImproperlyNested() {
    Assert.assertEquals(0, brackets.solution("([)()]"));
  }

  @Test
  public void testSolution_withEdgeCase1() {
    char[] C = new char[200000];
    Arrays.fill(C, 0, 100000, '[');
    Arrays.fill(C, 100000, 200000, ']');
    Assert.assertEquals(1, brackets.solution(new String(C)));
  }

  @Test
  public void testSolution_withEdgeCase2() {
    char[] C = new char[200000];
    Arrays.fill(C, 0, 100000, '[');
    Arrays.fill(C, 100000, 199999, ']');
    C[199999] = '(';
    Assert.assertEquals(0, brackets.solution(new String(C)));
  }

  @Test
  public void testSolution_withEdgeCase3() {
    char[] C = new char[200000];
    Arrays.fill(C, 0, 200000, '[');
    Assert.assertEquals(0, brackets.solution(new String(C)));
  }
}
