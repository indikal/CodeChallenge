package lk.inli.codility;

import java.util.Arrays;

public class ParityDegree {
  public int solution(int N) {
    int pow = 0;
    int tmp = N;

    while ((tmp % 2) == 0) {
      pow++;
      tmp = tmp / 2;
    }

    if (N % (Math.pow(2, pow)) == 0) {
      return pow;
    }

    return 0;
  }

}
