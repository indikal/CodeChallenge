package lk.inli.codility.mock;

import org.junit.Assert;
import org.junit.Test;

public class LogReorderTest {
  private final LogReorder logReorder = new LogReorder();

  @Test
  public void testReorderLogFiles1() {
    Assert.assertArrayEquals(new String[]{"let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"},
        logReorder.reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"}));
  }

  @Test
  public void testReorderLogFiles2() {
    Assert.assertArrayEquals(new String[]{"let3 art zero","let1 art zero can","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"},
        logReorder.reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art zero can","dig2 3 6","let2 own kit dig","let3 art zero"}));
  }
}
