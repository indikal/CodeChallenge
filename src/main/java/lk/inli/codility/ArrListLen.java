package lk.inli.codility;

/**
 * A non-empty array A consisting of N integers is given.
 *
 * Array A represents a linked list. A list is constructed from this array as follows:
 *
 *         the first node (the head) is located at index 0;
 *         the value of a node located at index K is A[K];
 *         if the value of a node is −1 then it is the last node of the list;
 *         otherwise, the successor of a node located at index K is located at index A[K]
 *         (you can assume that A[K] is a valid index, that is 0 ≤ A[K] < N).
 *
 * For example, for array A such that:
 *   A[0] =  1
 *   A[1] =  4
 *   A[2] = -1
 *   A[3] =  3
 *   A[4] =  2
 *
 * the following list is constructed:
 *
 *         the first node (the head) is located at index 0 and has a value of 1;
 *         the second node is located at index 1 and has a value of 4;
 *         the third node is located at index 4 and has a value of 2;
 *         the fourth node is located at index 2 and has a value of −1.
 */
public class ArrListLen {

  public int solution(int[] A) {
    // write your code in Java SE 8
    int length = 0;

    int val = A[0];
    while (val >= 0) {
      length++;

      val = A[val];
    }

    return ++length;
  }
}