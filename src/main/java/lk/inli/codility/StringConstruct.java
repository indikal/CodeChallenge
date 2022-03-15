package lk.inli.codility;

import java.util.Arrays;

/*
Write a function solution that, given two integers A and B, returns a string containing exactly
A letters 'a' and exactly B letters 'b' with no three consecutive letters being the same
(in other words, neither "aaa" nor "bbb" may occur in the returned string).

Examples:

1. Given A = 5 and B = 3, your function may return "aabaabab". Note that "abaabbaa" would also be a
correct answer. Your function may return any correct answer.

2. Given A = 3 and B = 3, your function should return "ababab", "aababb", "abaabb" or any of several
other strings.

3. Given A = 1 and B = 4, your function should return "bbabb", which is the only correct answer in
this case.

Assume that:

        A and B are integers within the range [0..100];
        at least one solution exists for the given A and B.

In your solution, focus on correctness. The performance of your solution will not be the focus of
the assessment.
 */
public class StringConstruct {

  public String solution_wrong(int A, int B) {
    // write your code in Java SE 11

    int nA = A / 2 + A % 2;
    int nB = B / 2 + B % 2;
    StringBuilder sb = new StringBuilder();
    String[] S = new String[nA + nB];

    String start = (nA == 1 && (A % 2) > 0) ? "a" : "aa";
    String next = (nB == 1 && (B % 2) > 0) ? "b" : "bb";
    int leadCharCount = nA;
    int nextCharCount = nB;
    int leadChar = A;
    int nextChar = B;
    if (A < B) {
      start = (nB == 1 && (B % 2) > 0) ? "b" : "bb";
      next = (nA == 1 && (A % 2) > 0) ? "a" : "aa";
      leadCharCount = nB;
      nextCharCount = nA;
      leadChar = B;
      nextChar = A;
    }

    int i;
    int tmp = leadCharCount;
    for (i = 0; i < leadCharCount; i++) {
      S[i * 2] = start;
      tmp--;

      if (tmp == 1 && (leadChar % 2) > 0) {
        start = start.substring(0, 1);
      }
    }

    tmp = nextCharCount;
    for (i = 0; i < nextCharCount; i++) {
      S[(i * 2) + 1] = next;
      tmp--;

      if (tmp == 1 && (nextChar % 2) > 0) {
        next = next.substring(0, 1);
      }
    }

    return String.join("", S);
  }

  public String solution(int A, int B) {
    // write your code in Java SE 11
    int nA = A / 2 + A % 2;
    int nB = B / 2 + B % 2;

    String start = "aa";
    String next = "bb";
    int leadCharCount = nA;
    int nextCharCount = nB;
    int leadChar = A;
    int nextChar = B;
    if (A < B) {
      start = "bb";
      next = "aa";
      leadCharCount = nB;
      nextCharCount = nA;
      leadChar = B;
      nextChar = A;
    }

    String[] leadChars = new String[leadCharCount];
    Arrays.fill(leadChars, start);
    if ((leadChar % 2) > 0) {
      leadChars[leadCharCount - 1] = start.substring(0, 1);
    }

    String[] nextChars = new String[Math.max(nextCharCount, (leadCharCount - 1))];
    Arrays.fill(nextChars, next.substring(0, 1));
    if (nextChar > nextChars.length) {
      for (int j = 0; j < (nextChar - nextChars.length); j++) {
        nextChars[j] = next;
      }
    }

    StringBuilder sb = new StringBuilder();
    int i;
    for (i = 0; i < nextChars.length; i++) {
      sb.append(leadChars[i]).append(nextChars[i]);
    }

    if (i < leadChars.length) {
      sb.append(leadChars[i]);
    }

    return sb.toString();
  }
}
