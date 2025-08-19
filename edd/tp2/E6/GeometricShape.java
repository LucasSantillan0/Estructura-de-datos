package edd.tp2.E6;

public class GeometricShape {
  public String color;
  public String name;

  public GeometricShape(String color, String name) {
    this.color = color;
    this.name = name;
  }

  public float getArea() {
    return 0;
  }

  public float getPerimeter() {
    return 0;
  }

  @Override
  public String toString() {
    return "GeometricShape{" +
        "color='" + color + '\'' +
        ", name='" + name + '\'' +
        '}';
  }

}
