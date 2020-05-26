package gvsucis.mvcCalculator;

public class CalculatorModel {

  private double currentAnswer;
  private String currentOperation;

  public double currentAnswer() {
    return currentAnswer;
  }

  public String currentOperation() {
    return currentOperation;
  }

  public void add(double num1, double num2) {
    currentOperation = "+";
    currentAnswer = num1 + num2;
  }

  public void subtract(double num1, double num2) {
    currentOperation = "-";
    currentAnswer = num1 - num2;
  }

  public void multiply(double num1, double num2) {
    currentOperation = "*";
    currentAnswer = num1 * num2;
  }

  public void divide(double num1, double num2) {
    currentOperation = "/";
    currentAnswer = num1 / num2;
  }
}