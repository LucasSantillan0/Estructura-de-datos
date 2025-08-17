package edd.tp1.E1;

public class MetricSystem {

  public double meters;
  public double centimeters;

  public static MetricSystem fromMeters(double meters) {
    MetricSystem ms = new MetricSystem();
    ms.meters = meters;
    ms.centimeters = meters * 100;
    return ms;
  }

  public static MetricSystem fromCentimeters(double centimeters) {
    MetricSystem ms = new MetricSystem();
    ms.centimeters = centimeters;
    ms.meters = centimeters / 100;
    return ms;
  }
}
