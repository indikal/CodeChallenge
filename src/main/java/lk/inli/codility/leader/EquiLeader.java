package lk.inli.codility.leader;

import java.util.List;
import java.util.Map;
import java.util.Stack;

/*
A non-empty array A consisting of N integers is given.

The leader of this array is the value that occurs in more than half of the elements of A.

An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and
A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.

For example, given array A such that:
    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2

we can find two equi leaders:

        0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
        2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.

The goal is to count the number of equi leaders.

Write a function:

    class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the number of equi leaders.

For example, given:
    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2

the function should return 2, as explained above.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [−1,000,000,000..1,000,000,000]
 */
public class EquiLeader {
  public int solution(int[] A) {
    // write your code in Java SE 11
    List<Object> leaderSums = this.getLeader(A);

    if (null == leaderSums) {
      return 0;
    }

    int leader = (int) leaderSums.get(0);
    int maxLeaderCount = (int) leaderSums.get(1);
    int[] pfsums = (int[]) leaderSums.get(2);

    int noOfEquiLeaders = 0;
    for (int i=0; i<pfsums.length-1; i++) {
      if (pfsums[i] > 0) {
        int noSeq1Leaders = pfsums[i];
        int noSeq2Leaders = maxLeaderCount - pfsums[i];

        if (noSeq1Leaders > (i+1)/2 && noSeq2Leaders > (pfsums.length - (i+1))/2) {
          noOfEquiLeaders++;
        }
      }
    }

    return noOfEquiLeaders;
  }

  private List<Object> getLeader(int[] A) {
    Stack<Integer> stack = new Stack<>();

    for (int a : A) {
      if (stack.empty()) {
        stack.push(a);
      } else if (a != stack.peek()) {
        stack.pop();
      } else {
        stack.push(a);
      }
    }

    if (stack.empty()) {
      return null;
    }

    int candidate = stack.peek();
    int count = 0;
    int[] pfsums = new int[A.length];
    for (int i=0; i<A.length; i++) {
      if (A[i] == candidate) {
        count = count + 1;
      }
      pfsums[i] = count;
    }

    return (count > (A.length/2)) ? List.of(candidate, count, pfsums) : null;
  }
}
