package edd.tp2.E5;

public class Car extends Vehicle {
  public int doors;
  public String fuelType;
  public int trunkCapacity;

  public Car(float price, String brand, String model, int year, int doors, int trunkCapacity, String fuelType) {
    super(price, brand, model, year);
    this.doors = doors;
    this.trunkCapacity = trunkCapacity;
    this.fuelType = fuelType;
  }

  public boolean isForFamilies() {
    return doors > 4;
  }

  public boolean isEcoFriendly() {
    return fuelType.equals("Electrico") || fuelType.equals("Hibrido");
  }

  @Override
  public String getBasicDescription() {
    return super.getBasicDescription() + " - " + doors + " doors";
  }

}
