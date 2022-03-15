package lk.inli.codility.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnlineAssessment {

  /*
  Given two strings s and goal, return true if you can swap two letters in s so the result is equal
  to goal, otherwise, return false.

  Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and
  swapping the characters at s[i] and s[j].

      For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

  Example 1:

  Input: s = "ab", goal = "ba"
  Output: true
  Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.

  Example 2:

  Input: s = "ab", goal = "ab"
  Output: false
  Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.

  Example 3:

  Input: s = "aa", goal = "aa"
  Output: true
  Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.

  Example 4:

  Input: s = "aaaaaaabc", goal = "aaaaaaacb"
  Output: true

  Constraints:

      1 <= s.length, goal.length <= 2 * 104
      s and goal consist of lowercase letters.
   */
  public boolean buddyStrings(String s, String goal) {
    //sanity check
    if (s.length() == 1 || s.length() != goal.length()) {
      return false;
    }

    int front = 1;
    int end = 0;

    for (int i=end; i<s.length()-1; i++) {
      for (int j=front; j<s.length(); j++) {
        if (goal.equals(swapChars(s, i, j))) {
          return true;
        }
      }
      front++;
    }

    return false;
  }

  private String swapChars(String st, int front, int end) {
    char[] S = st.toCharArray();
    char c = S[front];
    S[front] = S[end];
    S[end] = c;

    return new String(S);
  }

  /*
  A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row
  or leftmost column and going in the bottom-right direction until reaching the matrix's end.
  For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix,
  includes cells mat[2][0], mat[3][1], and mat[4][2].

  Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return
  the resulting matrix.

   | 3  3  1  1 |
   | 2  2  1  2 |
   | 1  1  1  2 |

  Example 1:

  Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
  Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]

  Example 2:

  Input: mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]
  Output: [[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]



  Constraints:

      m == mat.length
      n == mat[i].length
      1 <= m, n <= 100
      1 <= mat[i][j] <= 100
   */
  public int[][] diagonalSort(int[][] mat) {
    //Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
    //Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]

    int[][] sortedMatrix = new int[mat.length][mat[0].length];
    for (int i=mat.length-1; i>=0; i--) {
      int[] diaArr = getSortedDiagonalArray(mat, i, 0);
      this.setDiagonalArray(sortedMatrix, diaArr, i, 0);
    }
    for (int j=0; j<mat[0].length; j++) {
      int[] diaArr = getSortedDiagonalArray(mat, 0, j);
      this.setDiagonalArray(sortedMatrix, diaArr, 0, j);
    }

    System.out.println(Arrays.deepToString(sortedMatrix));
    return sortedMatrix;
  }

  private int[] getSortedDiagonalArray(int[][] mat, int i1, int i2) {
    List<Integer> arr = new ArrayList<>();
    while (i1 < mat.length && i2 < mat[0].length) {
      arr.add(mat[i1][i2]);
      i1++;
      i2++;
    }

    return arr.stream().mapToInt(a -> a).sorted().toArray();
  }

  private void setDiagonalArray(int[][] sortedMatrix, int[] diaArr, int i1, int i2) {
    for (int val : diaArr) {
      sortedMatrix[i1][i2] = val;
      i1++;
      i2++;
    }
  }
}
