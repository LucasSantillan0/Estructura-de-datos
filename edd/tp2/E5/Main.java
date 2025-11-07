package edd.tp2.E5;

import java.util.ArrayList;

import edd.common.Input;
import edd.tp1.Common.Menu;

public class Main {

  public static void main(String[] args) {
    ArrayList<String> options = new ArrayList<>();
    options.add("Ejecutar el programa");

    Menu.showMenu(options, (_) -> {

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

      System.out.println("Introduzca la fecha de fabricacion");
      Integer manufacturingDate = Input.ReadNumber();

      Car car = new Car(price, brand, model, year, doors, trunkCapacity, fuelType);
      System.out.println(car.getBasicDescription());
      System.out.println("Edad del auto" + car.getAge(manufacturingDate));
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
      System.out.println("Cilindrada: " + motorbike.getCyllinderClassification());
      System.out.println("Ingrese el precio del camión:");
      float truckPrice = Input.ReadNumber();

      System.out.println("Ingrese la marca del camión:");
      String truckBrand = Input.ReadLine();

      System.out.println("Ingrese el modelo del camión:");
      String truckModel = Input.ReadLine();

      System.out.println("Ingrese el año del camión:");
      int truckYear = Input.ReadNumber();

      System.out.println("Ingrese la capacidad de carga (kg):");
      int cargoCapacity = Input.ReadNumber();

      System.out.println("Ingrese la cantidad de ejes:");
      int axles = Input.ReadNumber();

      System.out.println("Ingrese el tipo de caja (Volquete, Caja seca, etc):");
      String bedType = Input.ReadLine();

      Truck truck = new Truck(truckPrice, truckBrand, truckModel, truckYear, cargoCapacity, axles, bedType);
      System.out.println("¿Requiere licencia especial? " + (truck.requireSpecialLicence() ? "Sí" : "No"));
      System.out.println("Capacidades especiales: " + truck.describeSpecialCapacities());

    });
  }
}
