package lk.inli.codility.greedy;

import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class MoneyChangerTest {
  private final MoneyChanger changer = new MoneyChanger();
  private final int[] COINS = new int[]{1,2,5,10,20,50,100,500,1000,5000};

  @Test
  public void testSolution_with0() {
    Assert.assertEquals(Integer.valueOf(0), changer.solution(COINS, 0).get(1));
  }

  @Test
  public void testSolution_with1() {
    Assert.assertEquals(Integer.valueOf(1), changer.solution(COINS, 1).get(1));
  }

  @Test
  public void testSolution_with9() {
    Map<Integer, Integer> result = changer.solution(COINS, 9);

    Assert.assertNotNull(result);
    Assert.assertEquals(Integer.valueOf(1), result.get(5));
    Assert.assertEquals(Integer.valueOf(2), result.get(2));
  }

  @Test
  public void testSolution_withLargeAmount() {
    Map<Integer, Integer> result = changer.solution(COINS, (int) Math.pow(10, 6));

    Assert.assertNotNull(result);
    Assert.assertEquals(Integer.valueOf(0), result.get(5));
    Assert.assertEquals(Integer.valueOf(0), result.get(2));
    Assert.assertEquals(Integer.valueOf(((int) Math.pow(10, 6))/5000), result.get(5000));
  }
}
