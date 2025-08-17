package edd.tp1.E3;

import java.util.ArrayList;
import java.util.function.Consumer;

import edd.tp1.E2.Input;

public class Menu {
  public static void showMenu(
      ArrayList<String> options, Consumer<Integer> onOptionSelected) {
    try {
      while (true) {
        System.out.println("Menu:");
        System.err.println("Seleccione una opcion");
        for (int i = 0; i < options.size(); i++) {
          System.out.println((i + 1) + ". " + options.get(i));
        }
        System.out.println((options.size() + 1) + ". Salir");
        Integer selectedOption = Input.ReadNumber();
        if (selectedOption < 1 || selectedOption > options.size() + 1) {
          System.err.println("Opcion invalida. Por favor seleccione una opcion valida.");
        } else if (selectedOption == options.size() + 1) {
          System.out.println("Saliendo del menu...");
          break;
        } else {
          onOptionSelected.accept(selectedOption);
        }
      }
    } catch (Exception e) {
      System.err.println("Error inesperado: ");
      e.printStackTrace();
    }

  }
}
