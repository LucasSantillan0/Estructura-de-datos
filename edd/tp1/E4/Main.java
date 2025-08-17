package edd.tp1.E4;

import java.util.ArrayList;

import edd.tp1.Common.Input;
import edd.tp1.Common.Menu;

public class Main {
  public static void main(String[] args) {
    Menu.showMenu(new ArrayList<String>() {
      {
        add("Suma");
        add("Resta");
        add("Multiplicacion");
        add("Division");
      }
    }, (option) -> {
      System.out.println("Opcion seleccionada: " + option);
      if (option == 1) {
        System.out.println("Ingrese el primer numero: ");
        int num1 = Input.ReadNumber();
        System.out.println("Ingrese el segundo numero: ");
        int num2 = Input.ReadNumber();
        System.out.println("Resultado: " + (num1 + num2));
      }
      if (option == 2) {
        System.out.println("Ingrese el primer numero: ");
        int num1 = Input.ReadNumber();
        System.out.println("Ingrese el segundo numero: ");
        int num2 = Input.ReadNumber();
        System.out.println("Resultado: " + (num1 - num2));
      }
      if (option == 3) {
        System.out.println("Ingrese el primer numero: ");
        int num1 = Input.ReadNumber();
        System.out.println("Ingrese el segundo numero: ");
        int num2 = Input.ReadNumber();
        System.out.println("Resultado: " + (num1 * num2));
      }
      if (option == 4) {
        System.out.println("Ingrese el primer numero: ");
        int num1 = Input.ReadNumber();
        System.out.println("Ingrese el segundo numero: ");
        int num2 = Input.ReadNumber();
        System.out.println("Resultado: " + (num1 / num2));
      }
    });
    Input.closeScanner();
  }
}
