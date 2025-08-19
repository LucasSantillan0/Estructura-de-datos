package edd.tp1.Common;

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
        scanner.nextLine();
        return number;

      } catch (Exception e) {
        System.err.println("Ingrese un entero valido");
        scanner.nextLine();
      }
    }
  }

  public static String ReadLine() {
    while (true) {
      try {
        if (scanner == null) {
          scanner = new Scanner(System.in);
          System.out.println("Se genero un nuevo scanner");
        }
        String line = scanner.nextLine();
        line = line.trim();
        return line;

      } catch (Exception e) {
        System.err.println("Ingrese string valido");
      }
    }
  }

  public static void closeScanner() {
    if (scanner != null) {
      scanner.close();
    }
  }

}
