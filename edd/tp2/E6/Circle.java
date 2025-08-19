package edd.tp2.E6;

public class Circle extends GeometricShape {
  public float radius;

  public Circle(String color, String name, float radius) {
    super(color, name);
    this.radius = radius;
  }

  @Override
  public float getArea() {
    return (float) (Math.PI * radius * radius);
  }

  @Override
  public float getPerimeter() {
    return (float) (2 * Math.PI * radius);
  }

}
