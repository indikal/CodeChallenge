package lk.inli.codility.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MoneyChanger {

  public Map<Integer, Integer> solution(int[] coins, int amount) {
    Arrays.sort(coins);
    Map<Integer, Integer> result = new HashMap<>();

    for (int i = coins.length - 1; i >= 0; i--) {
      result.put(coins[i], amount / coins[i]);
      amount = amount % coins[i];
    }

    System.out.println(result.toString());
    return result;
  }
}
