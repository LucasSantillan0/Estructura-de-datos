package edd.tp2.E5;

public class Motorbike extends Vehicle {
  public String handlebarType;
  public int cillynders;

  public Motorbike(float price, String brand, String model, int year, int cillynders, String handlebarType) {
    super(price, brand, model, year);
    this.handlebarType = handlebarType;
    this.cillynders = cillynders;
  }

  public String getCyllinderClassification() {
    if (cillynders < 250) {
      return "Baja";
    }
    if (cillynders > 250 && cillynders < 600) {
      return "Media";
    }
    return "Alta";
  }
}
