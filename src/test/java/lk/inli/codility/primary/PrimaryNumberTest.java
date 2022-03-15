package lk.inli.codility.primary;

import org.junit.Assert;
import org.junit.Test;

public class PrimaryNumberTest {
  private final PrimaryNumber primaryNumber = new PrimaryNumber();

  @Test
  public void testSolution_with2() {
    Assert.assertTrue(primaryNumber.isPrimary(2));
  }

  @Test
  public void testSolution_with3() {
    Assert.assertTrue(primaryNumber.isPrimary(3));
  }

  @Test
  public void testSolution_with4() {
    Assert.assertFalse(primaryNumber.isPrimary(4));
  }

  @Test
  public void testSolution_with5() {
    Assert.assertTrue(primaryNumber.isPrimary(5));
  }

  @Test
  public void testSolution_with6() {
    Assert.assertFalse(primaryNumber.isPrimary(6));
  }

  @Test
  public void testSolution_with7() {
    Assert.assertTrue(primaryNumber.isPrimary(7));
  }
}
