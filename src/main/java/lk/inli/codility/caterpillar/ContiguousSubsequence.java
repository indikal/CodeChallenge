package lk.inli.codility.caterpillar;

/*
Let’s check whether a sequence a0,a1,...,an−1 (1 <= ai <= 10^9) contains a contiguous
subsequence whose sum of elements equals s. For example, in the following sequence we are looking
for a subsequence whose total equals s = 12.

a0 a1 a2 a3 a4 a5 a6
6  2  7  4  1  3  6

Each position of the caterpillar will represent a different contiguous subsequence in which
the total of the elements is not greater than s. Let’s initially set the caterpillar on the first
element. Next we will perform the following steps:
•if we can, we move the right end (front) forward and increase the size of the caterpillar;
•otherwise, we move the left end (back) forward and decrease the size of the caterpillar.
 */
public class ContiguousSubsequence {
  public boolean solution(int[] A, int s) {
    int total = 0;
    int front = 0;
    int n = A.length;

    for (int back : A) {
      while (front < n && (A[front] + total) <= s) {
        total += A[front];
        front++;
      }

      if (total == s) {
        return true;
      }

      total -= back;
    }

    return false;
  }
}
