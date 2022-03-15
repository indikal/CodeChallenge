package lk.inli.codility.leader;

import java.util.Stack;

public class GoldenLeader {
  public int solution(int[] A) {
    Stack<Integer> stack = new Stack<>();

    for (int a : A) {
      if (stack.empty()) {
        stack.push(a);
      } else if (a != stack.peek()) {
        stack.pop();
      } else {
        stack.push(a);
      }
    }

    if (stack.empty()) {
      return -1;
    }

    int candidate = stack.peek();
    int count = 0;
    for (int a : A) {
      if (a == candidate) {
        count++;
      }
    }

    return (count > (A.length/2)) ? candidate : -1;
  }

}
