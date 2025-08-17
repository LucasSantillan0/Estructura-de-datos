package edd.tp1.E1;

public class Temperature {
  private double celsius;
  private double fahrenheit;
  private double kelvin;

  public static Temperature fromCelsius(double celsius) {
    Temperature temp = new Temperature();
    temp.celsius = celsius;
    temp.fahrenheit = celsius * 9 / 5 + 32;
    temp.kelvin = celsius + 273.15;
    return temp;
  }

  public static Temperature fromFahrenheit(double fahrenheit) {
    Temperature temp = new Temperature();
    temp.fahrenheit = fahrenheit;
    temp.celsius = (fahrenheit - 32) * 5 / 9;
    temp.kelvin = temp.celsius + 273.15;
    return temp;
  }

  public static Temperature fromKelvin(double kelvin) {
    Temperature temp = new Temperature();
    temp.kelvin = kelvin;
    temp.celsius = kelvin - 273.15;
    temp.fahrenheit = temp.celsius * 9 / 5 + 32;
    return temp;
  }

  public double toFahrenheit() {
    return fahrenheit;
  }

  public double toKelvin() {
    return kelvin;
  }

  public double toCelsius() {
    return celsius;
  }
}
