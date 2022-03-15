package lk.inli.codility.primary;

/*
A positive integer D is a factor of a positive integer N if there exists an integer M such that
N = D * M.

For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).

Write a function:

    class Solution { public int solution(int N); }

that, given a positive integer N, returns the number of its factors.

For example, given N = 24, the function should return 8, because 24 has 8 factors,
namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..2,147,483,647].
 */
public class CountFactors {
  public int solution(int N) {
    int noOfDivisors = (N > 1) ? 2 : 1; //divide by 1 and N itself
    int i = 2;

    while ((i * i) <= N) {
      if (N % i == 0) {
        //divide by i and also divide by N/i (ie N % (N/i) == 0)
        noOfDivisors += ((i * i) == N) ? 1 : 2;
      }
      i += 1;
    }

    return noOfDivisors;
  }

  public int solution_new(int N) {
    if (N == 2) {
      return 2;
    }

    int noOfDivisors = 0;
    double nSqrt = Math.sqrt(N);
    int counts = ((nSqrt - ((int) nSqrt)) > 0) ? ((int) nSqrt) + 1 : (int) nSqrt;

    for (int i=1; i<=counts; i++) {
      if ((N % i) == 0) {
        noOfDivisors++;
      }
    }

    noOfDivisors = ((nSqrt - ((int) nSqrt)) > 0) ? (2 * noOfDivisors) : (2 * (noOfDivisors - 1)) + 1;

    return noOfDivisors;
  }
}
