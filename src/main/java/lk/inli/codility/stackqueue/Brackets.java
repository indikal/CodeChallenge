package lk.inli.codility.stackqueue;

import java.util.Stack;

/*
A string S consisting of N characters is considered to be properly nested if any of the following
conditions is true:

        S is empty;
        S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
        S has the form "VW" where V and W are properly nested strings.

For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

    class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the
function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..200,000];
        string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 */
public class Brackets {
  public int solution(String S) {
    //check for empty string
    if (S.isEmpty()) {
      return 1;
    }

    char[] brackets = S.toCharArray();
    Stack<Character> stack = new Stack<>();

    //{[()()]}
    char previous = (stack.empty()) ? 0 : stack.peek();
    for (char c : brackets) {
      if (isMatchingBracket(previous, c) == 0) {
        stack.push(c);
        previous = c;
      } else {
        stack.pop();
        previous = (stack.empty()) ? 0 : stack.peek();
      }
    }

    if (stack.size() > 0) {
      return 0;
    } else {
      return 1;
    }
  }

  private int isMatchingBracket(char previous, char c) {
    if (previous == '(' && c == ')') {
      return 1;
    } else if (previous == '{' && c == '}') {
      return 1;
    } else if (previous == '[' && c == ']') {
      return 1;
    } else {
      return 0;
    }
  }
}
