package lk.inli.codility.prefixsums;

public class MaxOccurredInRanges {

  public int solution(int[] L, int[] R, int N) {
    int[] pfsums = new int[N];

    for (int i = 0; i < L.length; i++) {
      pfsums[L[i]] += 1;
      pfsums[R[i] + 1] -= 1;
    }

    int previousVal = pfsums[0];
    int maxIndex = 0;
    int max = pfsums[0];
    for (int j = 1; j < N; j++) {
      if (pfsums[j] != 0) {
        pfsums[j] = pfsums[j] + previousVal;
        previousVal = pfsums[j];
      } else {
        pfsums[j] = previousVal;
      }

      if (max < pfsums[j]) {
        max = pfsums[j];
        maxIndex = j;
      }
    }

    return maxIndex;
  }
}
