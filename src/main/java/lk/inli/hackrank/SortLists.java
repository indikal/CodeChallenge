package lk.inli.hackrank;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortLists {
  public List<LocalTime> solution(List<LocalTime> A, List<LocalTime> B) {
    List<LocalTime> result = new ArrayList<>();
    result.addAll(A);
    result.addAll(B);

    return result.stream()
            .sorted((a, b) -> a.compareTo(b))
            .collect(Collectors.toList());
  }

}
