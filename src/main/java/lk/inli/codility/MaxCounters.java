package lk.inli.codility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxCounters {
  public int[] solution(int n, int[] m) {
    int[] counters = new int[n];
    int startCounter = 0;
    int maxCounter = 0;
    int index;

    for (int j : m) {
      index = j - 1;

      if (index >= n) {
        startCounter = maxCounter;
      } else if (counters[index] < startCounter) {
        counters[index] = startCounter + 1;
        maxCounter = Math.max(counters[index], maxCounter);
      } else {
        counters[index] = counters[index] + 1;
        maxCounter = Math.max(counters[index], maxCounter);
      }
    }

    int[] c = new int[n];
    for (int k=0; k<n; k++) {
      c[k] = (Math.max(counters[k], startCounter));
    }

    return c;
  }

  public static void main(String[] args) {
    MaxCounters maxCounters = new MaxCounters();
    System.out.println(Arrays.toString(maxCounters.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})));
  }
}
