package gvsucis.enumAndLambda;

import javax.swing.*;

public class OneFileCalculator {

  private JTextField num1;
  private JTextField num2;
  private JLabel op;
  private JTextField answer;

  private void buttonListener(CalculatorModel operator) {
    int val1 = Integer.parseInt(num1.getText());
    int val2 = Integer.parseInt(num2.getText());
    op.setText(operator.symbol());
    answer.setText(Integer.toString(operator.operate(val1, val2)));
  }

  public OneFileCalculator() {

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

    for (CalculatorModel m : CalculatorModel.values()) {
      JButton operator = new JButton(m.label());
      bottom.add(operator);
      operator.addActionListener(e -> buttonListener(m));
    }

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

  public static void main(String[] args) {
    new OneFileCalculator();
  }

}