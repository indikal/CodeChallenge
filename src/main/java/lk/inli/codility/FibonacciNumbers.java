package lk.inli.codility;

public class FibonacciNumbers {

  public long fib(int n) {
    return (long) ((Math.pow(((1 + Math.sqrt(5)) / 2), n) - Math.pow(((1 - Math.sqrt(5)) / 2), n))
        / Math.sqrt(5));
  }
}
