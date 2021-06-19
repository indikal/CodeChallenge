package com.klarna.qualified.codechallenge;

class Challenge {
  // Complete this function to return either
  // "Hello, [name]!" or "Hello there!"
  // based on the input

  public static String sayHello(String name) {
    // You can print to STDOUT for debugging if you need to:
    //System.out.print(name);
    StringBuilder greeting = new StringBuilder();
    greeting = (null == name || name.isBlank())
        ? greeting.append("Hello there")
        : greeting.append("Hello, ").append(name);

    greeting.append("!");

    // but you need to return the correct value in order to pass the challenge
    return greeting.toString(); // TODO: return the correct value
  }
}
