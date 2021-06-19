package com.klarna.qualified.codechallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Smoothie2 {

  private enum CURRENTLY_SERVED_MENUS {
    CLASSIC, FREEZIE, GREENIE, JUST_DESSERTS
  }

  private enum CLASSIC {
    strawberry, banana, pineapple, mango, peach, honey
  }

  private enum FREEZIE {
    blackberry, blueberry, black_currant, grape_juice, frozen_yogurt
  }

  private enum GREENIE {
    green_apple, lime, avocado, spinach, ice, apple_juice
  }

  private enum JUST_DESSERTS {
    banana, ice_cream, chocolate, peanut, cherry
  }

  public static void main(String[] args) {
    Smoothie2.ingredients("Classic,-strawberry,-peanut");
  }

  public static String ingredients(String order) {
    String[] arrOrder = order.split(",");
    String menu = arrOrder[0];

    Arrays.asList(CLASSIC.values()).forEach(System.out::println);

    /*String smoothie = getMenuIngredientsFromOrder(arrOrder)
        .filter(ingredient -> {
          System.out.println(ingredient);
          if (getMenuIngredients(menu).contains(ingredient)) {
            return true;
          } else if (ingredient.startsWith("-") && getMenuIngredients(menu)
              .contains(ingredient.replaceAll("-", ""))) {
            return "";
          } else {
            throw new IllegalArgumentException("Additional items not supported");
          }
        })
        .sorted()
        .collect(Collectors.joining(","));*/

    /*List<String> ingredients = new ArrayList<>();
    Arrays.asList(getMenuIngredientsFromOrder(arrOrder)).forEach(ingredient -> {
      System.out.println(ingredient);
      if (getMenuIngredients(menu).contains(ingredient)) {
        ingredients.add(ingredient);
      } else if (ingredient.startsWith("-") && getMenuIngredients(menu)
          .contains(ingredient.replaceAll("-", ""))) {
        System.out.println("Allergy found");
      } else {
        throw new IllegalArgumentException("Additional items not supported");
      }
    });

    if (ingredients.isEmpty()) {
      throw new IllegalArgumentException("No ingredients to create the smoothie");
    } else {
      return String.join(",", ingredients);
    }*/

    return "";
  }

  private static boolean isEqual(String s1, String s2) {
    return s1.replaceAll(" ", "_").equalsIgnoreCase(s2.replaceAll(" ", "_"));
  }

  private static boolean isMenuCurrentlyServed(String menu) {
    return false;
  }

  /**
   * Get the ingredients for the selected menu
   * @param arr order array
   * @return ingredients as an array
   */
  private static String[] getMenuIngredientsFromOrder(String[] arr) {
    return Arrays.copyOfRange(arr, 1, arr.length + 1);
  }

  /**
   * Gives the ingredients for the 4 menus
   * @param menu selected menu
   * @return a list of ingredients
   */
  private static List<String> getMenuIngredients(String menu) {
    switch (menu.trim().toUpperCase()) {
      case "CLASSIC":
        return Arrays.asList("strawberry", "banana", "pineapple", "mango", "peach", "honey");
      case "FREEZIE":
        return Arrays.asList("blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt");
      case "GREENIE":
        return Arrays.asList("green apple", "lime", "avocado", "spinach", "ice", "apple juice");
      case "JUST_DESSERTS":
        return Arrays.asList("banana", "ice cream", "chocolate", "peanut", "cherry");
      default:
        throw new IllegalArgumentException("Invalid menu");
    }
  }
}