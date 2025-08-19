package edd.tp2.E2;

public class Product {
  public String name;
  public float price;
  public int stock;

  public Product(String name, float price, int stock) {
    this.name = name;
    this.price = price;
    this.stock = stock;
  }

  public Product() {
    this.name = "Unknown";
    this.price = 0.0f;
    this.stock = 0;
  }

  public Integer sell() {
    if (stock > 0) {
      stock--;
      System.out.println(this.toString());
      return 1;
    }
    System.err.println("No hay stock disponible para vender " + name);
    return 0;
  }

  public void restock(int quantity) {
    if (quantity > 0) {
      stock += quantity;
      System.out.println(this.toString());
      return;
    }
    System.err.println("Cantidad de reposición no válida");
  }

  @Override
  public String toString() {
    return name + " - $" + price + " (" + stock + " en stock)";
  }
}
