package gvsucis.interfaceExamples;

public class Cow implements Animal {

  private double milkAvailable = 105.3;

  public String speak() {
    return "Moo";
  }

  public double milk() {
    double answer = milkAvailable;
    milkAvailable = 0;
    return answer;
  }
  
}