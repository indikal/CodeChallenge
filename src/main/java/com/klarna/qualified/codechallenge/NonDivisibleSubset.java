package com.klarna.qualified.codechallenge;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Given a set of distinct integers, print the size of a maximal subset of S where the sum of any 2
 * numbers in S1 is not evenly divisible by k.
 * <p>
 * Example S = [19, 10, 12, 10, 24, 25, 22], k = 4 One of the arrays that can be created is S1 [0] =
 * [10, 12, 25]. Another is S1 [1] = [19, 22, 24]. After testing all permutations, the maximum
 * length solution array has 3
 * <p>
 * elements.
 * <p>
 * Function Description
 * <p>
 * Complete the nonDivisibleSubset function in the editor below.
 * <p>
 * nonDivisibleSubset has the following parameter(s):
 * <p>
 * int S[n]: an array of integers int k: the divisor
 * <p>
 * Returns
 * <p>
 * int: the length of the longest subset of S meeting the criteria
 * <p>
 * Input Format
 * <p>
 * The first line contains space-separated integers, and , the number of values in and the non
 * factor. The second line contains space-separated integers, each an
 * <p>
 * , the unique values of the set.
 * <p>
 * Constraints
 * <p>
 * All of the given numbers are distinct.
 * <p>
 * Sample Input
 * <p>
 * STDIN    Function -----    -------- 4 3      S[] size n = 4, k = 3 1 7 2 4  S = [1, 7, 2, 4]
 * <p>
 * Sample Output
 * <p>
 * 3
 * <p>
 * Explanation
 * <p>
 * The sums of all permutations of two elements from S1 = { 1, 7, 4 } are:
 * <p>
 * 1 + 7 = 8 1 + 2 = 3 1 + 4 = 5 7 + 2 = 9 7 + 4 = 11 2 + 4 = 6
 * <p>
 * Only S1 = { 1, 7, 4 } will not ever sum to a multiple of k = 3.
 */
public class NonDivisibleSubset {
  /*
   * Complete the 'nonDivisibleSubset' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. INTEGER_ARRAY s
   */

  public static int getSubset(int k, List<Integer> s) {
    // Write your code here
    List<Integer> nonDivisibles = new ArrayList<>();
    for (int i = 0; i < s.size(); i++) {
      int val_i = s.get(i);
      for (int j = i+1; j < s.size(); j++) {
        int val_j = s.get(j);
        int sum = val_i + val_j;

        if ((sum % k) > 0) {
          if (!nonDivisibles.contains(val_i)) {
            nonDivisibles.add(val_i);
          }
          if (!nonDivisibles.contains(val_j)) {
            nonDivisibles.add(val_j);
          }
        }
      }
    }

    return nonDivisibles.size();
  }

  public static void main(String[] args) throws IOException {
    System.out.println(NonDivisibleSubset.getSubset(3, List.of(1, 7, 2, 4)));
    System.out.println(NonDivisibleSubset.getSubset(7,
        List.of(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436)));
  }
}

