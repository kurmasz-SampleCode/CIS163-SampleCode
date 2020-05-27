package gvsucis.interfaceExamples;

import javax.swing.*;
import java.awt.event.*;

public class OneFileCalculator {

  private JTextField num1;
  private JTextField num2;
  private JLabel op;
  private JTextField answer;

  // By including AddButtonListener inside OneFileCalculator,
  // this class has access to OneFileCalculator's private fields.
  class SubtractButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      int val1 = Integer.parseInt(num1.getText());
      int val2 = Integer.parseInt(num2.getText());
      op.setText("-");
      answer.setText(Integer.toString(val1 - val2));
    }
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
    JButton add = new JButton("Add");
    JButton subtract = new JButton("Subtract");
    JButton multiply = new JButton("Multiply");
    JButton divide = new JButton("Divide");

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

    //
    // Add the listeners
    //

    // uses external
    add.addActionListener(new AddButtonListener(num1, num2, op, answer));

    // uses internal class
    subtract.addActionListener(new SubtractButtonListener());

    // uses anonymous inner class
    multiply.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int val1 = Integer.parseInt(num1.getText());
        int val2 = Integer.parseInt(num2.getText());
        op.setText("*");
        answer.setText(Integer.toString(val1 * val2));
      }
    });

    // uses Java 8 lambda
    // Compiler automatically converts the concise syntax here into
    // the anonymous inner class above
    divide.addActionListener(e -> {
      int val1 = Integer.parseInt(num1.getText());
      int val2 = Integer.parseInt(num2.getText());
      op.setText("/");
      if (val2 == 0) {        
        answer.setText("Seriously?");
      } else {
        answer.setText(Integer.toString(val1 / val2));
      }
    });
  }

  public static void main(String[] args) {
    new OneFileCalculator();
  }

}