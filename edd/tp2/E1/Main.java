package edd.tp2.E1;

import java.util.ArrayList;

import edd.tp1.Common.Input;
import edd.tp1.Common.Menu;

public class Main {

  public static void main(String[] args) {
    ArrayList<String> menuItems = new ArrayList<>();
    menuItems.add("Calcular area y perimetro de un rectangulo");
    Menu.showMenu(menuItems, (_) -> {
      System.out.println("Introduzca el ancho del rectangulo");
      Integer width = Input.ReadNumber();
      if (width <= 0) {
        System.out.println("El ancho debe ser un número positivo.");
      }
      System.out.println("Introduzca la altura del rectangulo");
      Integer height = Input.ReadNumber();
      if (height <= 0) {
        System.out.println("La altura debe ser un número positivo.");
      }
      Rectangle rect = new Rectangle(width, height);
      System.out.println("Area: " + rect.getArea());
      System.out.println("Perimeter: " + rect.getPerimeter());
    });

  }

}
