package edd.tp2.E6;

import java.util.ArrayList;

import edd.tp1.Common.Input;
import edd.tp1.Common.Menu;

public class Main {
  public static void main(String[] args) {
    ArrayList<String> options = new ArrayList<>();
    options.add("Crear un circulo");
    options.add("Crear un rectangulo");
    Menu.showMenu(options, (choice) -> {
      switch (choice) {
        case 1:
          System.out.println("Ingrese el radio");
          float radius = Input.ReadNumber();
          System.out.println("Ingrese el color");
          String color = Input.ReadLine();
          Circle circle = new Circle(color, "Círculo", radius);
          System.out.println(circle);
          System.out.println("Area: " + circle.getArea());
          System.out.println("Perímetro: " + circle.getPerimeter());
          break;
        case 2:
          System.out.println("Ingrese el ancho");
          float width = Input.ReadNumber();
          System.out.println("Ingrese la altura");
          float height = Input.ReadNumber();
          System.out.println("Ingrese el color");
          String rectangleColor = Input.ReadLine();
          Rectangle rectangle = new Rectangle(rectangleColor, "Rectángulo", width, height);
          System.out.println(rectangle);
          System.out.println("Área: " + rectangle.getArea());
          System.out.println("Perímetro: " + rectangle.getPerimeter());
          break;
      }
    });
  }
}
