package edd.tp2.E5;

import java.util.ArrayList;

import edd.tp1.Common.Input;
import edd.tp1.Common.Menu;

public class Main {

  public static void main(String[] args) {
    Menu.showMenu(new ArrayList<>() {
      {
        add("Ejecutar el prgrama");
      }
    }, (_) -> {

      System.out.println("Ingrese el precio del auto:");
      float price = Float.parseFloat(Input.ReadLine());

      System.out.println("Ingrese la marca del auto:");
      String brand = Input.ReadLine();

      System.out.println("Ingrese el modelo del auto:");
      String model = Input.ReadLine();

      System.out.println("Ingrese el año del auto:");
      int year = Input.ReadNumber();

      System.out.println("Ingrese la cantidad de puertas:");
      int doors = Input.ReadNumber();

      System.out.println("Ingrese la capacidad del baúl:");
      int trunkCapacity = Input.ReadNumber();

      System.out.println("Ingrese el tipo de combustible (Electrico, Hibrido, Nafta, Diesel, etc):");
      String fuelType = Input.ReadLine();

      Car car = new Car(price, brand, model, year, doors, trunkCapacity, fuelType);
      System.out.println(car.getBasicDescription());
      System.out.println("¿Es un auto familiar? " + (car.isForFamilies() ? "Sí" : "No"));
      System.out.println("¿Es un auto ecológico? " + (car.isEcoFriendly() ? "Sí" : "No"));

      System.out.println("Ingrese el precio de la moto:");
      float bikePrice = Input.ReadNumber();

      System.out.println("Ingrese la marca de la moto:");
      String bikeBrand = Input.ReadLine();

      System.out.println("Ingrese el modelo de la moto:");
      String bikeModel = Input.ReadLine();

      System.out.println("Ingrese el año de la moto:");
      int bikeYear = Input.ReadNumber();

      System.out.println("Ingrese la cilindrada de la moto:");
      int displacement = Input.ReadNumber();

      System.out.println("Ingrese el tipo de combustible de la moto:");
      String bikeFuelType = Input.ReadLine();

      Motorbike motorbike = new Motorbike(bikePrice, bikeBrand, bikeModel, bikeYear, displacement, bikeFuelType);
      System.out.println(motorbike.getBasicDescription());

    });
  }
}
