package edd.tp1.E1;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("Escriba U para el conversor de unidades");
      System.out.println("Escriba T para el conversor de temperaturas");
      System.err.println("Escriba exit para salir");
      String response = scanner.nextLine();
      if (response.equals("exit")) {
        System.out.println("Saliendo del programa...");
        scanner.close();
        break;
      }
      if (response.equals("U") || response.equals("T")) {
        program(response, scanner);
      } else {

        System.err.println("La opcion es invalida");
      }
    }
    scanner.close();

  }

  static void program(String response, Scanner scanner) {

    try {

      if (!response.equals("U") && !response.equals("T")) {
        System.err.println("Se ha ingresado una opción invalida");
      }

      if (response.equals("T")) {
        System.out.println("Conversor de temperatura");
        System.out.println("Ingrese la cantidad a convertir, con la unidad correspondiente (C o F):");
        String recordedTemperature = scanner.nextLine();
        String[] parts = recordedTemperature.split("(?<=\\d)(?=\\D)");
        String valuePart = parts[0];
        String unitPart = parts.length > 1 ? parts[1] : "";
        if (!unitPart.equals("C") && !unitPart.equals("F")) {
          System.err.println("Unidad de temperatura no válida");
          return;
        }
        double value = Double.parseDouble(valuePart);
        Temperature temperature;
        if (unitPart.equals("C")) {
          temperature = Temperature.fromCelsius(value);
          System.out.println("Resultado: " + temperature.toFahrenheit() + "F");
        } else {
          temperature = Temperature.fromFahrenheit(value);
          System.out.println("Resultado: " + temperature.toCelsius() + "C");
        }
      }

      if (response.equals("U")) {
        System.out.println("Conversor de unidades");
        System.out.println("Ingrese la cantidad a convertir, con la unidad correspondiente (M o CM):");
        String length = scanner.nextLine();
        String[] parts = length.split("(?<=\\d)(?=\\D)");
        String valuePart = parts[0];
        String unitPart = parts.length > 1 ? parts[1] : "";

        if (!unitPart.equals("M") && !unitPart.equals("CM")) {
          System.err.println("Unidad de longitud no válida");
          return;
        }
        double value = Double.parseDouble(valuePart);
        MetricSystem metric;
        if (unitPart.equals("M")) {
          metric = MetricSystem.fromMeters(value);
          System.out.println("Resultado: " + metric.centimeters + "CM");
        } else {
          metric = MetricSystem.fromCentimeters(value);
          System.out.println("Resultado: " + metric.meters + "M");
        }
      }

    } catch (Exception e) {
      if (e instanceof NoSuchElementException) {
        System.err.println("Entrada no válida");
      } else {
        System.err.println("Error inesperado");
      }
    }
  }
}
