package lk.inli.codility;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Assert;
import org.junit.Test;

public class OddOccurrencesInArrayTest {
  private final OddOccurrencesInArray inArray = new OddOccurrencesInArray();

  @Test
  public void testSolution_1Elem() {
    Assert.assertEquals(1, inArray.solution(new int[]{1}));
  }

  @Test
  public void testSolution_3Elem() {
    Assert.assertEquals(1, inArray.solution(new int[]{1,1,1}));
  }

  @Test
  public void testSolution_7Elem() {
    Assert.assertEquals(7, inArray.solution(new int[]{9, 3, 9, 3, 9, 7, 9}));
  }

  @Test
  public void testSolution_MaxElem() {
    List<Integer> list = IntStream.rangeClosed((1000000000 - 500001), 1000000000).boxed()
        .collect(Collectors.toList());
    list.addAll(list);
    list.add(1000000000);
    int[] A = list.stream().mapToInt(i->i).toArray();
    Assert.assertEquals(1000000000, inArray.solution(A));
    Assert.assertNotEquals(1000499999, inArray.solution(A));
  }
}
