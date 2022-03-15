package lk.inli.codility;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Assert;
import org.junit.Test;

public class ArrListLenTest {
  private ArrListLen arrListLen = new ArrListLen();

  @Test
  public void test_with5Element_return4() {
    Assert.assertEquals(4, arrListLen.solution(new int[]{1,4,-1,3,2}));
  }

  @Test
  public void test_with1Element_return1() {
    Assert.assertEquals(1, arrListLen.solution(new int[]{-1}));
  }

  @Test
  public void test_with2Element_return2() {
    Assert.assertEquals(2, arrListLen.solution(new int[]{1,-1}));
  }

  @Test
  public void test_with5Element_return2() {
    Assert.assertEquals(2, arrListLen.solution(new int[]{1,-1,2,3,4}));
  }

  @Test
  public void test_withMaxElement_return200000() {
    List<Integer> y = IntStream.range(1,200000)
        .boxed()
        .collect(Collectors.toList());
    y.add(-1);

    Assert.assertEquals(200000, arrListLen.solution(y.stream().mapToInt(i->i).toArray()));
  }

  @Test
  public void test_withMaxElementsReversed_return200000() {
    List<Integer> y = IntStream.range(1,200000)
        .boxed()
        .collect(Collectors.toList());
    Collections.reverse(y);
    y.add(100000,-1);

    Assert.assertEquals(200000, arrListLen.solution(y.stream().mapToInt(i->i).toArray()));
  }

  @Test
  public void test_withMaxElementsReversed_return1() {
    List<Integer> y = IntStream.range(1,200000)
        .boxed()
        .collect(Collectors.toList());
    y.add(-1);
    Collections.reverse(y);

    Assert.assertEquals(1, arrListLen.solution(y.stream().mapToInt(i->i).toArray()));
  }
}
