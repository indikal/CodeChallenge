package lk.inli.codility;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciNumbersTest {
  private final FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();

  //1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144

  @Test
  public void testSolution_with2() {
    Assert.assertEquals(1, fibonacciNumbers.fib(2));
  }

  @Test
  public void testSolution_with3() {
    Assert.assertEquals(2, fibonacciNumbers.fib(3));
  }

  @Test
  public void testSolution_with4() {
    Assert.assertEquals(3, fibonacciNumbers.fib(4));
  }

  @Test
  public void testSolution_with9() {
    Assert.assertEquals(34, fibonacciNumbers.fib(9));
  }

  @Test
  public void testSolution_with12() {
    Assert.assertEquals(144, fibonacciNumbers.fib(12));
  }

  @Test
  public void testSolution_with100000() {
    Assert.assertTrue(fibonacciNumbers.fib(100000) > 1);
  }
}
