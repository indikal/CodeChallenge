package lk.inli.codility.curb;

import java.util.Arrays;

public class Assignment2 {
  public int solution(int[] A) {
    // write your code in Java SE 11

    int tmp = 0;
    for (int i=0; i<A.length; i++) {
      if (tmp > A[i]) {
        tmp = A[i];
      }
    }
    return tmp;
  }
}
