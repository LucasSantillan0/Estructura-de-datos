package edd.tp2.E5;

public class Truck extends Vehicle {
  public int cargoCapacity;
  public int axles;
  public String bedType;

  public Truck(float price, String brand, String model, int year, int cargoCapacity, int axles, String bedType) {
    super(price, brand, model, year);
    this.cargoCapacity = cargoCapacity;
    this.axles = axles;
    this.bedType = bedType;
  }

  public boolean requireSpecialLicence() {
    return axles > 2;
  }

  public String describeSpecialCapacities() {
    if (bedType.equals("Volquete"))
      return "Ideal para movimiento de tierras";
    if (bedType.equals("Caja seca"))
      return "Ideal para transporte de mercancia protegida";
    return "Util para todo tipo de carga";
  }
}
