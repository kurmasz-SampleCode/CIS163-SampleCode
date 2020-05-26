package gvsucis.interfaceExamples;

public class Dog implements Animal {

  private boolean expectTreat;

  public String speak() {
    return "Arf";
  }

  public void rollOver() {
    expectTreat = true;
  }

}