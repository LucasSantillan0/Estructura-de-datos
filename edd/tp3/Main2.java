package edd.tp3;

import java.util.Random;
import java.util.Scanner;

import edd.common.Helper;

public class Main2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    int tamanio = Helper.validarEnteroNoNegativo(sc, "Escriba un numero entero no negativo, para designar tamanio; ");
    tamanio = tamanio - 1;
    int[] arreglo1 = new int[tamanio];

    for (int i = 0; i < tamanio; i++) {

      arreglo1[i] = random.nextInt(16);
    }
    Main2.mostarArreglo(arreglo1);
    System.out.println(Main2.ParesEImpares(arreglo1));
    System.out.println("Arreglo corrido una posicion a la derecha");
    int[] arreglo2 = Main2.unoDerecha(arreglo1);
    Main2.mostarArreglo(arreglo2);
    System.out.println("Arreglo invertido");
    Main2.inversa(arreglo1);

  }

  public static void mostarArreglo(int[] arreglo) {
    for (int i = 0; i < arreglo.length; i++) {
      System.out.println("Numero en la posicion " + (i + 1) + " es: " + arreglo[i]);
    }
  }

  public static String ParesEImpares(int[] arreglo) {
    int contPar = 0;
    int contImpar = 0;
    for (int i = 0; i < arreglo.length; i++) {
      if (arreglo[i] % 2 == 0) {
        contPar++;
      } else {
        contImpar++;
      }
    }
    return "La cantidad de numeros pares son: " + contPar + "\nLa cantidad de numeros impares son: " + contImpar;
  }

  public static int[] unoDerecha(int[] arreglo) {
    int[] arreglos2 = new int[arreglo.length];
    arreglos2[0] = arreglo[arreglo.length - 1];
    for (int i = 1; i < arreglo.length; i++) {
      arreglos2[i] = arreglo[i - 1];
    }
    return arreglos2;
  }

  public static void inversa(int[] arreglo) {
    int n = arreglo.length;
    int x = 0;
    for (int i = 0; i < n; i++) {
      x = arreglo[n - 1 - i];
      System.out.print(x + " ");
    }
  }
}
