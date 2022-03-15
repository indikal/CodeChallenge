package lk.inli.codility.mock;

import org.junit.Assert;
import org.junit.Test;

public class OnlineAssessmentTest {
  private final OnlineAssessment assessment = new OnlineAssessment();

  @Test
  public void testBuddyStrings_withS1() {
    Assert.assertFalse(assessment.buddyStrings("a", "aa"));
  }

  @Test
  public void testBuddyStrings_withS2_resultTrue1() {
    Assert.assertTrue(assessment.buddyStrings("aa", "aa"));
  }

  @Test
  public void testBuddyStrings_withS2_resultTrue2() {
    Assert.assertTrue(assessment.buddyStrings("ab", "ba"));
  }

  @Test
  public void testBuddyStrings_withS2_resultFalse() {
    Assert.assertFalse(assessment.buddyStrings("ab", "ab"));
  }

  @Test
  public void testBuddyStrings_withS8_resultTrue() {
    Assert.assertTrue(assessment.buddyStrings("aaaaaaabc", "aaaaaaacb"));
  }

  @Test
  public void testBuddyStrings_withS9_resultFalse() {
    Assert.assertFalse(assessment.buddyStrings("abcd", "abcd"));
  }

  @Test
  public void testDiagonalSort_with3x4Array() {
    //Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
    //Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
    Assert.assertArrayEquals(new int[][]{{1,1,1,1},{1,2,2,2},{1,2,3,3}},
        assessment.diagonalSort(new int[][]{{3,3,1,1},{2,2,1,2},{1,1,1,2}}));
  }
}
