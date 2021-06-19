package com.klarna.qualified.codechallenge;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

public class DiskSpace2Test {

  @Test
  public void testOneSectorUnoccupied() {
    assertTrue(DiskSpace2.isWritable(1, 1, new HashSet<>()));
  }

  @Test
  public void testOneSectorOccupied() {
    assertFalse(DiskSpace2.isWritable(1, 1, new HashSet<>(Collections.singletonList(1))));
  }

  @Test
  public void testWhileBlockOccupied() {
    assertTrue(DiskSpace2.isWritable(4, 2, new HashSet<>(Arrays.asList(1, 4))));
  }

  @Test
  public void testFileLargerThanBlock() {
    assertFalse(DiskSpace2.isWritable(1, 2, new HashSet<>()));
  }

  @Test
  public void testLargeFileFitToTheEnd() {
    assertTrue(DiskSpace2.isWritable(1000000, (1000000 - 2), new HashSet<>(1, 2)));
  }

  @Test
  public void testTwoSectorFileFitToLastTwoSectors() {
    assertTrue(DiskSpace2.isWritable(1000000, 2,
        IntStream.rangeClosed(1, 999998)
            .boxed()
            .collect(Collectors.toCollection(HashSet::new))));
  }

  @Test
  public void testOneSectorFileFitToLastSector() {
    assertTrue(DiskSpace2.isWritable(1000000, 1,
        IntStream.rangeClosed(1, 999999)
            .boxed()
            .collect(Collectors.toCollection(HashSet::new))));
  }

  @Test
  public void testTwoSectorFileFitToFirstTwoSectors() {
    assertTrue(DiskSpace2.isWritable(1000000, 2,
        IntStream.rangeClosed(3, 1000000)
            .boxed()
            .collect(Collectors.toCollection(HashSet::new))));
  }

  @Test
  public void testOneSectorFileFitToFirstSector() {
    assertTrue(DiskSpace2.isWritable(1000000, 1,
        IntStream.rangeClosed(2, 1000000)
            .boxed()
            .collect(Collectors.toCollection(HashSet::new))));
  }

  @Test
  public void testTwoSectorsFileWithNoEnoughSpace() {
    assertFalse(DiskSpace2.isWritable(1000000, 2,
        IntStream.rangeClosed(2, 999999)
            .boxed()
            .collect(Collectors.toCollection(HashSet::new))));
  }

  @Test
  public void testLargeFileFitToTheBeginning() {
    assertTrue(DiskSpace2.isWritable(1000000, (1000000 - 2), new HashSet<>(999999, 1000000)));
  }

  @Test
  public void testFourSectorsFileWithNoEnoughSpaceAtTheEnd() {
    assertFalse(DiskSpace2.isWritable(1000000, 4,
        IntStream.rangeClosed(1, 999998)
            .boxed()
            .collect(Collectors.toCollection(HashSet::new))));
  }

  @Test
  public void testFourSectorsFileWithNoEnoughSpaceAtStart() {
    assertFalse(DiskSpace2.isWritable(100000, 4,
        IntStream.rangeClosed(3, 100000)
            .boxed()
            .collect(Collectors.toCollection(HashSet::new))));
  }

}
