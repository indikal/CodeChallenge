package lk.inli.codility.dynamicprogramming;

public class FibonacciNumbers {
  public int fibonacci(int n) {
    int[] fib = new int[n+2];
    fib[0] = 0;
    fib[1] = 1;

    for (int i=2; i<n+1; i++) {
      fib[i] = fib[i-1] + fib[i-2];
    }

    System.out.println(fib[n]);
    return fib[n];
  }
}
