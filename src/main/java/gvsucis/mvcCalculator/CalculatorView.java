package gvsucis.mvcCalculator;

import javax.swing.*;
import java.awt.event.*;

public class CalculatorView {
  private JTextField num1;
  private JTextField num2;
  private JLabel op;
  private JTextField answer;

  private JButton add, subtract, multiply, divide;

  public CalculatorView() {

    //
    // Set up the UI
    //
    JPanel top = new JPanel();
    num1 = new JTextField();
    num1.setColumns(8);
    op = new JLabel("?");
    num2 = new JTextField();
    num2.setColumns(8);
    JLabel equals = new JLabel("=");
    answer = new JTextField();
    answer.setColumns(15);

    top.add(num1);
    top.add(op);
    top.add(num2);
    top.add(equals);
    top.add(answer);

    JPanel bottom = new JPanel();
    add = new JButton("Add");
    subtract = new JButton("Subtract");
    multiply = new JButton("Multiply");
    divide = new JButton("Divide");

    bottom.add(add);
    bottom.add(subtract);
    bottom.add(multiply);
    bottom.add(divide);

    JPanel main = new JPanel();
    main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
    main.add(top);
    main.add(bottom);

    JFrame frame = new JFrame("Calculator");
    frame.setContentPane(main);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  public double getNum1() {
    return Double.parseDouble(num1.getText());
  }

  public double getNum2() {
    return Double.parseDouble(num2.getText());
  }

  public void addAddListener(ActionListener l) {
    add.addActionListener(l);
  }

  public void addSubtractListener(ActionListener l) {
    subtract.addActionListener(l);
  }

  public void addMultiplyListener(ActionListener l) {
    multiply.addActionListener(l);
  }

  public void addDivideListener(ActionListener l) {
    divide.addActionListener(l);
  }

  public void update(CalculatorModel model) {
    answer.setText(Double.toString(model.currentAnswer()));
    op.setText(model.currentOperation());
  }

}