package lk.inli.codility.prefixsums;

import java.util.Arrays;
import lk.inli.codility.prefixsums.GenomicRangeQuery;
import org.junit.Assert;
import org.junit.Test;

public class GenomicRangeQueryTest {
  private final GenomicRangeQuery query = new GenomicRangeQuery();

  @Test
  public void testSolution_withCAGCCTA_3() {
    Assert.assertArrayEquals(new int[]{2, 4, 1},
        query.solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
  }

  @Test
  public void testSolution_withAllA_3() {
    Assert.assertArrayEquals(new int[]{1,1,1},
        query.solution("AAAAAAA", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
  }

  @Test
  public void testSolution_withMaxAs_MaxM() {
    char[] chars = new char[100000];
    Arrays.fill(chars, 'G');
    String S = new String(chars);
    int[] P = new int[50000];
    //Arrays.fill(P, 1);
    int[] Q = new int[50000];
    Arrays.fill(Q, 99999);

    long start = System.currentTimeMillis();
    int[] result = query.solution(S, P, Q);
    Assert.assertEquals(3, result[0]);
    Assert.assertEquals(3, result[49999]);
    long end = System.currentTimeMillis();
    System.out.printf("Time taken (ms): " + (end - start));
  }
}
