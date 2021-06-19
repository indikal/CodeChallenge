package com.klarna.qualified.codechallenge;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmoothieTest {
  @Test
  public void classicSmoothieWithTwoAllergies () {
    assertEquals("banana,honey,mango,peach,pineapple",
        Smoothie.ingredients("Classic,-strawberry,-peanut"));
  }
  @Test
  public void classicSmoothie() {
    assertEquals("banana,honey,mango,peach,pineapple,strawberry",
        Smoothie.ingredients("Classic"));
  }

  @Test
  public void classicSmoothieWithoutStrawberry() {
    assertEquals("banana,honey,mango,peach,pineapple",
        Smoothie.ingredients("Classic,-strawberry"));
  }
}
