package edd.tp1.E3;

import edd.tp1.Common.Input;

public class Main {

  public static void main(String[] args) {
    while (true) {
      System.err.println("Calculadora de eficiencia de combustible");
      System.out.println("Ingrese los kilometros");
      int kilometers = Input.ReadNumber();
      System.out.println("Ingrese el combustible gastado");
      int fuel = Input.ReadNumber();
      double eficiency = (double) kilometers / fuel;
      if (eficiency >= 15) {
        System.out.println("Eficiencia Excelente");
      } else if (eficiency >= 10) {
        System.out.println("Eficiencia Buena");
      } else if (eficiency >= 5) {
        System.out.println("Eficiencia Regular");
      } else {
        System.out.println("Eficiencia Baja");
      }
    }
  }
}
