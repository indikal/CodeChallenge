package lk.inli.codility.prefixsums;

import java.util.Arrays;

/*
Difficulty = Medium

A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which
correspond to the types of successive nucleotides in the sequence. Each nucleotide has an
impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of
1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the
minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?

The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters.
There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers.
The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained
in the DNA sequence between positions P[K] and Q[K] (inclusive).

For example, consider string S = CAGCCTA and arrays P, Q such that:
    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6

The answers to these M = 3 queries are as follows:

        The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose
        impact factors are 3 and 2 respectively, so the answer is 2.
        The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4,
        so the answer is 4.
        The part between positions 0 and 6 (the whole string) contains all nucleotides,
        in particular nucleotide A whose impact factor is 1, so the answer is 1.

Write a function:

    class Solution { public int[] solution(String S, int[] P, int[] Q); }

that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q
consisting of M integers, returns an array consisting of M integers specifying the consecutive
answers to all queries.

Result array should be returned as an array of integers.

For example, given the string S = CAGCCTA and arrays P, Q such that:
    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6

the function should return the values [2, 4, 1], as explained above.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        M is an integer within the range [1..50,000];
        each element of arrays P, Q is an integer within the range [0..N − 1];
        P[K] ≤ Q[K], where 0 ≤ K < M;
        string S consists only of upper-case English letters A, C, G, T.
 */
public class GenomicRangeQuery {
  private final int A = 1;
  private final int C = 2;
  private final int G = 3;
  private final int T = 4;

  public int[] solution(String S, int[] P, int[] Q) {
    // write your code in Java SE 11
    int[] result = new int[P.length];
    Object[] prefixSum;
    char[] nucleotides = S.toCharArray();

    prefixSum = this.populatePrefixSums(nucleotides);

    for (int i=0; i<P.length; i++) {
      int l = P[i];
      int r = Q[i];
      int[] preSums = (l == 0) ? new int[4] : (int[]) prefixSum[l-1];
      result[i] = this.getMinimumImpactInRange(preSums, (int[]) prefixSum[r]);
    }

    /*StringBuffer sb = new StringBuffer(S);

    for (int i=0; i<P.length; i++) {
      String sub = sb.substring(P[i], Q[i] + 1);
      if (sub.contains("A")) {
        result[i] = 1;
      } else if (sub.contains("C")) {
        result[i] = 2;
      } else if (sub.contains("G")) {
        result[i] = 3;
      } else if (sub.contains("T")) {
        result[i] = 4;
      }

      /*char[] subNucleotides = Arrays.copyOfRange(nucleotides, P[i], (Q[i] + 1));
      Arrays.sort(subNucleotides);
      result[i] = this.getImpactFactor(subNucleotides[0]);*/
    //}

    return result;
  }

  private Object[] populatePrefixSums(char[] s) {
    Object[] prefixSum = new Object[s.length];
    prefixSum[0] = this.getImpactFactorSums(s[0], new int[4]);

    for (int i=1; i<s.length; i++) {
      prefixSum[i] = this.getImpactFactorSums(s[i], (int[]) prefixSum[i-1]);
    }

    return prefixSum;
  }

  private int[] getImpactFactorSums(char s, int[] preSums) {
    int[] sums = Arrays.copyOf(preSums, preSums.length);
    switch(s) {
      case 'A':
        sums[A-1] = preSums[A-1] + 1;
        break;
      case 'C':
        sums[C-1] = preSums[C-1] + 1;
        break;
      case 'G':
        sums[G-1] = preSums[G-1] + 1;
        break;
      case 'T':
        sums[T-1] = preSums[T-1] + 1;
        break;
      default:
        throw new InternalError("Undefined nucleotide!");
    }

    return sums;
  }

  private int getMinimumImpactInRange(int[] oneBeforeL, int[] atR) {
    if ((atR[0] - oneBeforeL[0]) > 0) {
      return A; //A is with in range
    } else if ((atR[1] - oneBeforeL[1]) > 0) {
      return C; //C is with in range
    } else if ((atR[2] - oneBeforeL[2]) > 0) {
      return G; //G is with in range
    } else {
      return T; //T is with in range
    }
  }
}
