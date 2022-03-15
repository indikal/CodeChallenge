package lk.inli.codility;

import java.util.Arrays;

/*
A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is
surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The
number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and
one of length 3. The number 20 has binary representation 10100 and contains one binary gap of
length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has
binary representation 100000 and has no binary gaps.

Write a function:

    class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. The function should
return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation
10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0,
because N has binary representation '100000' and thus no binary gaps.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..2,147,483,647]
 */
public class BinaryGap {
  //return max no of zeros between two ones
  //9 -> 1001 -> 2
  //15 -> 1111 -> 0
  //20 -> 10100 -> 1
  //32 -> 100000 -> 0
  //529 -> 1000010001 -> 4
  //1041 -> 10000010001 -> 5
  //n > 0 && 1 <= n <= 2,147,483,647
  public int solution(int n) {
    char[] binary = Integer.toBinaryString(n).toCharArray();
    System.out.println(Arrays.toString(binary));
    int maxZeroCount = 0;

    int tmpCount = 0;
    for (char c : binary) {
      if (c == '1') {
        maxZeroCount = Math.max(maxZeroCount, tmpCount);
        tmpCount = 0;
      } else {
        tmpCount++;
      }
    }

    return maxZeroCount;
  }

  //this should have higher memory complexity
  public int solution2(int n) {
    String binString = Integer.toBinaryString(n);
    System.out.println(binString);

    binString = binString.substring(0, binString.lastIndexOf('1') + 1);
    System.out.println(binString);
    String[] binGaps = binString.split("1");
    int maxBinGap = 0;

    int tmpBinGap = 0;
    for (String s : binGaps) {
      tmpBinGap = s.length();
      maxBinGap = Math.max(maxBinGap, tmpBinGap);
    }

    return maxBinGap;
  }
}
