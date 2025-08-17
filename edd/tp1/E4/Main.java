package edd.tp1.E4;

import java.util.ArrayList;
import java.util.Random;

import edd.tp1.E2.Input;
import edd.tp1.E3.Menu;

public class Main {
  public static void main(String[] args) {
    Menu.showMenu(new ArrayList<String>() {
      {
        add("Generar números aleatorios");
      }
    }, (option) -> {
      System.out.println("Opcion seleccionada: " + option);
      Random generator = new Random();
      Integer firstNumber = generator.nextInt(100);
      Integer secondNumber = generator.nextInt(firstNumber + 1);
      Integer thirdNumber = generator.nextInt(secondNumber + 1);
      System.out.println("Números generados: " + firstNumber + ", " + secondNumber + ", " + thirdNumber);
    });
    Input.closeScanner();
  }
}