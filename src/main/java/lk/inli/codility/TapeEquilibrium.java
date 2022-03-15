package lk.inli.codility;

import java.util.Arrays;
import java.util.Stack;

/*
A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.

Any integer P, such that 0 < P < N, splits this tape into two non-empty parts:
A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

The difference between the two parts is the value of:
|(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

For example, consider array A such that:
  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3

We can split this tape in four places:

        P = 1, difference = |3 − 10| = 7
        P = 2, difference = |4 − 9| = 5
        P = 3, difference = |6 − 7| = 1
        P = 4, difference = |10 − 3| = 7

Write a function:

    class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.

For example, given:
  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3

the function should return 1, as explained above.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [2..100,000];
        each element of array A is an integer within the range [−1,000..1,000].
 */
public class TapeEquilibrium {
  public int solution(int[] A) {
    // write your code in Java SE 11
    int n = A.length;
    int len1 = A[0];
    int len2 = Arrays.stream(Arrays.copyOfRange(A, 1, n)).sum();
    int minDiff = Math.abs(len1 - len2);

    for (int i=1; i<n-1; i++) {
      len1 += A[i];
      len2 -= A[i];
      minDiff = Math.min(minDiff, Math.abs(len1 - len2));
    }

    return minDiff;

    /*int[] prefixSums = new int[A.length];
    prefixSums[0] = A[0];

    for (int i=1; i<A.length; i++) {
      prefixSums[i] = prefixSums[i-1] + A[i];
    }

    int prevDiff = Math.abs(prefixSums[0] - (prefixSums[A.length - 1] - prefixSums[0]));
    for (int i=1; i<(A.length - 1); i++) {
      int newDiff = Math.abs(prefixSums[i] - (prefixSums[A.length - 1] - prefixSums[i]));

      if (prevDiff < newDiff) {
        return prevDiff;
      }

      prevDiff = newDiff;
    }

    return prevDiff;*/

    /*int totalSum = Arrays.stream(A).parallel().sum();
    float halfSum = Math.abs(totalSum/2);

    int subTotal = 0;
    for (int p=0; p<(A.length-1); p++) {
      subTotal += A[p];

      if ((halfSum == 0 && Math.abs(subTotal) == 0) || (halfSum != 0 && halfSum <= Math.abs(subTotal))) {
        return Math.abs(totalSum - (2 * subTotal));
      }
    }
    return Math.abs(subTotal - (totalSum - subTotal));*/
  }

  /*public int solution(int[] A) {
    // write your code in Java SE 11
    if (A.length == 2) {
      return Math.abs(A[0] - A[1]);
    }

    int totalSum = Arrays.stream(A).sum();
    int firstPieceSum = 0;
    int secondPieceSum;
    int diff = Math.abs(totalSum);
    int tmp;

    for (int p=0; p<(A.length-1); p++) {
      firstPieceSum += A[p];
      secondPieceSum = (totalSum - firstPieceSum);
      tmp = Math.abs(firstPieceSum - secondPieceSum);

      if (diff > tmp) {
        diff = tmp;
      } else {
        return diff;
      }
    }

    return diff;
  }*/
}
