package edd.tp2.E6;

public class Rectangle extends GeometricShape {
  public float width;
  public float height;

  public Rectangle(String color, String name, float width, float height) {
    super(color, name);
    this.width = width;
    this.height = height;
  }

  @Override
  public float getArea() {
    return width * height;
  }

  @Override
  public float getPerimeter() {
    return 2 * (width + height);
  }

}
