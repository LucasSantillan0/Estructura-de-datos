package edd.tp1.E5;

import java.util.ArrayList;
import java.util.Random;

import edd.tp1.Common.Input;
import edd.tp1.Common.Menu;

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
      Integer secondNumber = firstNumber + generator.nextInt(100);
      Integer thirdNumber = secondNumber + generator.nextInt(100);
      System.out.println("Números generados: " + firstNumber + ", " + secondNumber + ", " + thirdNumber);
    });
    Input.closeScanner();
  }
}