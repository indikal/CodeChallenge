package lk.inli.codility.stackqueue;

import java.util.Stack;

public class StoneWall {
  public int solution(int[] H) {
    // write your code in Java SE 11
    Stack<Integer> wall = new Stack<>();

    int heightInStack = 0;
    int totalBricks = 0;
    for (int h : H) {
      if (heightInStack < h) {
        wall.push(h - heightInStack);
        heightInStack += (h - heightInStack);
      } else if (heightInStack > h) {
        while (heightInStack > h) {
          int lastBrick = wall.pop();
          totalBricks++;
          heightInStack -= lastBrick;
        }

        if (heightInStack < h) {
          wall.push(h - heightInStack);
          heightInStack += (h - heightInStack);
        }
      }
    }

    return totalBricks + wall.size();
  }
}
