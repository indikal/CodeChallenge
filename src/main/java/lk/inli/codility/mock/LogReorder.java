package lk.inli.codility.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LogReorder {
  private static Pattern p = Pattern.compile("(^ *[0-9][0-9 ]*$)");

  public String[] reorderLogFiles(String[] logs) {
    Map<String, List<String>> letter_logs = new HashMap<>();
    List<String> digit_logs = new ArrayList<>();

    for (String log : logs) {
      String identifier = log.substring(0, log.indexOf(' '));
      String words = log.substring(log.indexOf(' ') + 1);

      if (isDigitalLog(words)) {
        digit_logs.add(log);
      } else {
        if (null != letter_logs.get(words)) {
          List<String> sameLogs = letter_logs.get(words);
          sameLogs.add(log);
          letter_logs.put(words, sameLogs);
        } else {
          List<String> sameLogs = new ArrayList<>();
          sameLogs.add(log);
          letter_logs.put(words, sameLogs);
        }
      }
    }

    Set<String> letter_words = letter_logs.keySet();
    List<String> list = letter_words.stream().sorted().collect(Collectors.toList());

    List<String> result = new ArrayList<>();
    for (String log : list) {
      List<String> same_letter_logs = letter_logs.get(log);

      if (same_letter_logs.size() > 1) {
        Collections.sort(same_letter_logs);
      }
      result.addAll(same_letter_logs);
    }

    result.addAll(digit_logs);

    return result.toArray(new String[]{});
  }

  private boolean isDigitalLog(String log) {
    Matcher m = p.matcher(log);
    return m.matches();
  }
}
