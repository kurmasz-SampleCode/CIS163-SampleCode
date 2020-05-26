package gvsucis.mvcCalculator;

public class CalculatorController {

  public CalculatorController(CalculatorView view, CalculatorModel model) {

    view.addAddListener(e -> {
      model.add(view.getNum1(), view.getNum2());
      view.update(model);
    });

    view.addSubtractListener(e -> {
      model.subtract(view.getNum1(), view.getNum2());
      view.update(model);
    });

    view.addMultiplyListener(e -> {
      model.multiply(view.getNum1(), view.getNum2());
      view.update(model);
    });

    view.addDivideListener(e -> {
      model.divide(view.getNum1(), view.getNum2());
      view.update(model);
    });
  }

  public static void main(String[] args) {
    new CalculatorController(new CalculatorView(), new CalculatorModel());
  }


}