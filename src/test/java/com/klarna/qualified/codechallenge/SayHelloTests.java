package com.klarna.qualified.codechallenge;

import org.junit.Test;
import static org.junit.Assert.*;

public class SayHelloTests {

  // These example test cases are editable, feel free to add
  // your own tests to debug your code.

  @Test
  public void shouldSayHello() {
    assertEquals("Hello, Qualified!", Challenge.sayHello("Qualified"));
  }

  @Test
  public void shouldSayHelloThere() {
    assertEquals("Hello there!", Challenge.sayHello(""));
  }

  @Test
  public void shouldNotSayHelloThere() {
    assertNotEquals("Greetings, there!", Challenge.sayHello(""));
  }
}