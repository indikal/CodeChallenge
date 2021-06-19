package com.klarna.qualified.codechallenge;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;

public class NonDivisibleSubsetTest {
  @Test
  public void testGetSubsetInput1() {
    assertEquals(3, NonDivisibleSubset.getSubset(3, List.of(1, 7, 2, 4)));
  }

  @Test
  public void testGetSubsetInput2() {
    assertEquals(11, NonDivisibleSubset.getSubset(7,
        List.of(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436)));
  }
}
