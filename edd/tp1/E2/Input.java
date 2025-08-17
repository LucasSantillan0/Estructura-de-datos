package edd.tp1.E2;

import java.util.Scanner;

public class Input {
  private static Scanner scanner;

  public static int ReadNumber() {
    while (true) {
      try {
        if (scanner == null) {
          scanner = new Scanner(System.in);
        }
        int number = scanner.nextInt();
        return number;

      } catch (Exception e) {
        System.err.println("Ingrese un entero valido");
      }
    }
  }

  public static void closeScanner() {
    if (scanner != null) {
      scanner.close();
    }
  }
}
