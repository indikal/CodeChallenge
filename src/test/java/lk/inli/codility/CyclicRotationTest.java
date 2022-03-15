package lk.inli.codility;

import java.util.stream.IntStream;
import org.junit.Assert;
import org.junit.Test;

public class CyclicRotationTest {
  private CyclicRotation rotateArray = new CyclicRotation();

  @Test
  public void testSolution_emptyArray() {
    Assert.assertArrayEquals(new int[]{}, rotateArray.solution(new int[]{}, 0));
  }

  @Test
  public void testSolution_emptyArrayOneRotation() {
    Assert.assertArrayEquals(new int[]{}, rotateArray.solution(new int[]{}, 1));
  }

  @Test
  public void testSolution_4ElemArray3Rotations() {
    Assert.assertArrayEquals(new int[]{2,3,4,1}, rotateArray.solution(new int[]{1,2,3,4}, 3));
  }

  @Test
  public void testSolution_4ElemArray4Rotations() {
    Assert.assertArrayEquals(new int[]{1,2,3,4}, rotateArray.solution(new int[]{1,2,3,4}, 4));
  }

  @Test
  public void testSolution_4ElemArray6Rotations() {
    Assert.assertArrayEquals(new int[]{3,4,1,2}, rotateArray.solution(new int[]{1,2,3,4}, 6));
  }

  @Test
  public void testSolution_maxElemArrayMaxRotations() {
    int[] A = IntStream.range(-1000, -900).toArray();
    Assert.assertArrayEquals(A, rotateArray.solution(A, 100));
  }

  @Test
  public void testSolution_maxElemArrayMaxRotations2() {
    int[] A = IntStream.range(-50, 50).toArray();
    Assert.assertArrayEquals(A, rotateArray.solution(A, 100));
  }
}
