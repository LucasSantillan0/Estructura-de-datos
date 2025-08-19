package edd.tp2.E5;

import java.util.Calendar;

public class Vehicle {
  public float price;
  public String brand;
  public String model;
  public int year;

  public Vehicle(float price, String brand, String model, int year) {
    this.price = price;
    this.brand = brand;
    this.model = model;
    this.year = year;
  }

  public String getBasicDescription() {
    return "Vehículo: " + brand + " " + model + ", Año: " + year + ", Precio: $" + price;
  }

  public int getAge(int fabricationYear) {
    int currentYear = Calendar.getInstance().get(java.util.Calendar.YEAR);
    return currentYear - fabricationYear;
  }

}
