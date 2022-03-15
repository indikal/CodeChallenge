package lk.inli.codility.curb;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/*

 */
public class Assignment1 {
  public int solution(String A, String B) {
    // write your code in Java SE 11
    String[] startA = A.split(":");
    String[] endB = B.split(":");

    LocalTime start = LocalTime.of(Integer.parseInt(startA[0]), Integer.parseInt(startA[1]));
    LocalTime end = LocalTime.of(Integer.parseInt(endB[0]), Integer.parseInt(endB[1]));

    LocalTime startFullRound = this.getStartFullRoundTime(start);
    LocalTime endFullRound = this.getEndFullRoundTime(end);

    long totalMins = 0;
    if (endFullRound.isAfter(startFullRound)) {
      totalMins = startFullRound.until(endFullRound, ChronoUnit.MINUTES);

    } else if (endFullRound.isBefore(startFullRound)) {
      LocalTime midNight = LocalTime.of(0, 0);
      long midNight_to_start = midNight.until(startFullRound, ChronoUnit.MINUTES);
      totalMins = ((24 * 60) - midNight_to_start)  +
          midNight.until(endFullRound, ChronoUnit.MINUTES);
    }

    return (int) totalMins / 15;
  }

  private LocalTime getStartFullRoundTime(LocalTime time) {
    int mins = time.getMinute();


    if ((mins % 15) > 0) {
      return time.plusMinutes(15 - (mins % 15));
    }

    return time;
  }

  private LocalTime getEndFullRoundTime(LocalTime time) {
    int mins = time.getMinute();

    if ((mins % 15) > 0) {
      return time.minusMinutes(mins % 15);
    }

    return time;
  }
}
