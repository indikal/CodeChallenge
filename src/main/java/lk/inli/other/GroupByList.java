package lk.inli.other;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByList {
  public static void main(String[] args) {
    List<String> list = List.of("a1", "b2", "c1", "c2", "a1","a1", "b2", "c1", "c2", "b1");

    Map<String, Long> result = list.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    result.forEach((k, v) -> System.out.println(k + ": " + v));

    int intVal = Integer.parseInt("2147483647");

    System.out.println(average().orElse(-1));
  }

  private static OptionalDouble average() {
    List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

    return list.stream()
            .mapToDouble(a -> a)
            .average();
  }
}
