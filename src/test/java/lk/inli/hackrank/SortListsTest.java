package lk.inli.hackrank;

import java.time.LocalTime;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class SortListsTest {
  private final SortLists sortLists = new SortLists();

  @Test
  public void testSolution1() {
    List<LocalTime> A = List.of(LocalTime.of(5, 0, 0),
        LocalTime.of(7, 0, 0),
        LocalTime.of(9, 0, 0),
        LocalTime.of(11, 0, 0),
        LocalTime.of(13, 0, 0));
    List<LocalTime> B = List.of(LocalTime.of(4, 0, 0),
        LocalTime.of(6, 0, 0),
        LocalTime.of(8, 0, 0),
        LocalTime.of(10, 0, 0),
        LocalTime.of(12, 0, 0));

    List<LocalTime> localTimes = sortLists.solution(A, B);
    System.out.println(localTimes);

    Assert.assertTrue(localTimes.get(0).isBefore(localTimes.get(1)));
  }

  @Test
  public void testSolution2() {
    List<LocalTime> A = List.of(LocalTime.of(5, 0, 1),
        LocalTime.of(5, 0, 2),
        LocalTime.of(5, 0, 3),
        LocalTime.of(5, 0, 4),
        LocalTime.of(5, 0, 5));
    List<LocalTime> B = List.of(LocalTime.of(4, 0, 0),
        LocalTime.of(5, 0, 10),
        LocalTime.of(5, 0, 20),
        LocalTime.of(5, 0, 30),
        LocalTime.of(5, 0, 40));

    List<LocalTime> localTimes = sortLists.solution(A, B);
    System.out.println(localTimes);

    Assert.assertTrue(localTimes.get(0).isBefore(localTimes.get(1)));
  }

  @Test
  public void testSolution3() {
    List<LocalTime> A = List.of(LocalTime.of(5, 0, 1),
        LocalTime.of(5, 0, 2),
        LocalTime.of(5, 0, 3),
        LocalTime.of(5, 0, 4),
        LocalTime.of(5, 0, 5));

    List<LocalTime> localTimes = sortLists.solution(A, A);
    System.out.println(localTimes);

    Assert.assertEquals(0, localTimes.get(0).compareTo(localTimes.get(1)));
  }
}
