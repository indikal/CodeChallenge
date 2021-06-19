package com.klarna.qualified.codechallenge;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

public class DiskSpaceTest {

  @Test
  public void test1() {
    assertTrue(DiskSpace.isWritable(1, 1, new HashSet<>()));
  }

  @Test
  public void test2() {
    assertFalse(DiskSpace.isWritable(1, 1, new HashSet<>(Arrays.asList(1))));
  }

  @Test
  public void test3() {
    assertTrue(DiskSpace.isWritable(4, 2, new HashSet<>(Arrays.asList(1, 4))));
  }

  @Test
  public void test4() {
    assertFalse(DiskSpace.isWritable(1, 2, new HashSet<>()));
  }

  @Test
  public void test5() {
    assertTrue(DiskSpace.isWritable(1000000, (1000000 - 2), new HashSet<>(1,2)));
  }

  @Test
  public void test6() {
    assertTrue(DiskSpace.isWritable(1000000, 2,
        IntStream.rangeClosed(1,999998)
            .boxed()
            .collect(Collectors.toCollection(HashSet::new))));
  }

  @Test
  public void test7() {
    assertTrue(DiskSpace.isWritable(1000000, (1000000 - 2), new HashSet<>(999999,1000000)));
  }

  @Test
  public void test8() {
    assertFalse(DiskSpace.isWritable(1000000, 4,
        IntStream.rangeClosed(1,999998)
            .boxed()
            .collect(Collectors.toCollection(HashSet::new))));
  }

  @Test
  public void test9() {
    assertFalse(DiskSpace.isWritable(100000, 4,
        IntStream.rangeClosed(1,99998)
            .boxed()
            .collect(Collectors.toCollection(HashSet::new))));
  }

}
