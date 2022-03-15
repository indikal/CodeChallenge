package lk.inli.codility.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciNumbersTest {
  private final FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();

  @Test
  public void fibonacci_withZero() {
    Assert.assertEquals(0, fibonacciNumbers.fibonacci(0));
  }

  @Test
  public void fibonacci_withOne() {
    Assert.assertEquals(1, fibonacciNumbers.fibonacci(1));
  }

  @Test
  public void fibonacci_withTwo() {
    Assert.assertEquals(1, fibonacciNumbers.fibonacci(2));
  }

  @Test
  public void fibonacci_withThree() {
    Assert.assertEquals(2, fibonacciNumbers.fibonacci(3));
  }

  @Test
  public void testSolution_with100000() {
    Assert.assertTrue(fibonacciNumbers.fibonacci(100000) > 1);
  }

  @Test
  public void testSolution_with1000000000() {
    Assert.assertTrue(fibonacciNumbers.fibonacci(1000000000) > 1);
  }
}
