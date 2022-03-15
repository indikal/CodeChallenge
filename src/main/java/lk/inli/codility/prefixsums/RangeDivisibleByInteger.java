package lk.inli.codility.prefixsums;

import java.util.stream.IntStream;

/*
Difficulty = Medium

Write a function:

    class Solution { public int solution(int A, int B, int K); }

that, given three integers A, B and K, returns the number of integers within the range [A..B]
that are divisible by K, i.e.:

    { i : A ≤ i ≤ B, i mod K = 0 }

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are
three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

Write an efficient algorithm for the following assumptions:

        A and B are integers within the range [0..2,000,000,000];
        K is an integer within the range [1..2,000,000,000];
        A ≤ B.
 */
public class RangeDivisibleByInteger {
  public int solution1(int A, int B, int K) {
    // write your code in Java SE 11
    return (int) IntStream.rangeClosed(A, B)
        .parallel()
        .filter(x -> (x % K) == 0)
        .count();
  }

  public int solution_best(int A, int B, int K) {
    // write your code in Java SE 11

    //special case when either A or B becomes zero
    int zeroDivisibles = (A == 0 || B == 0) ? 1 : 0;
    //all divisibles upto A (excluding A)
    int divsUptoA = (A == 0) ? 0 : ((A - 1) / K);
    //all divisibles upto B (including B)
    int divsUptoB = B / K;

    return zeroDivisibles + (divsUptoB  - divsUptoA);
  }
}
