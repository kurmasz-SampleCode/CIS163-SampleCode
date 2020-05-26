package gvsucis.enumAndLambda;

import java.util.function.BinaryOperator;

public enum CalculatorOperations {

  Add("Add", "+", (a, b) -> a + b), Subtract("Subtract", "-", (a, b) -> a + b),
  Multiply("Multiply", "*", (a, b) -> a * b), Divide("Divide", "/", (a, b) -> a / b);

  private String label;
  private String symbol;
  private BinaryOperator<Integer> operator;

  private CalculatorOperations(String label, String symbol, BinaryOperator<Integer> op) {
    this.label = label;
    this.symbol = symbol;
    this.operator = op;
  }

  public int operate(int a, int b) {
    return operator.apply(a, b);
  }

  public String symbol() {
    return symbol;
  }

  public String label() {
    return label;
  }
}