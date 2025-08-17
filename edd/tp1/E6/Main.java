package edd.tp1.E6;

import java.util.ArrayList;

import edd.tp1.Common.Input;
import edd.tp1.Common.Menu;

public class Main {
  public static void main(String[] args) {
    Menu.showMenu(new ArrayList<>() {
      {
        add("Comparar palabras");
      }
    }, (_) -> {
      System.out.println("Escribir la primer palabra:");
      String firstWord = Input.ReadLine();
      System.out.println("Escribir la segunda palabra:");
      String secondWord = Input.ReadLine();
      System.out.println("Comparando palabras...");
      System.out.println("La palabra 1 tiene " + firstWord.length() + " caracteres.");
      System.out.println("La palabra 2 tiene " + secondWord.length() + " caracteres.");
      if (firstWord.equals(secondWord)) {
        System.out.println("Las palabras son iguales.");
      } else {
        System.out.println("Las palabras son diferentes.");
      }
      if (firstWord.contains("la")) {
        System.err.println("La primer palabra contiene `la`");
      }
      System.out.println("La primer palabra en mayusculas es " + firstWord.toUpperCase());
      System.out.println("La segunda palabra en mayusculas es " + secondWord.toUpperCase());

      System.out.println("Las palabras fueron: " + firstWord + " " + secondWord);
    });
  }
}
