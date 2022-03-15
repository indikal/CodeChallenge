package lk.inli.codility.curb;

import org.junit.Assert;
import org.junit.Test;

public class AssignmentTrialTest {
  private final AssignmentTrial assignmentTrial = new AssignmentTrial();

  @Test
  public void testSolution1() {
    Assert.assertEquals(5, assignmentTrial.solution(new int[]{1, 3, 6, 4, 1, 2}));
  }
}
