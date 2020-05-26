package gvsucis.interfaceExamples;

import javax.swing.*;
import java.awt.event.*;

public class AddButtonListener implements ActionListener {

  private JTextField num1, num2, answer;
  private JLabel op;

  public AddButtonListener(JTextField input1, JTextField input2, JLabel op, JTextField answer) {
    this.num1 = input1;
    this.num2 = input2;
    this.op = op;
    this.answer = answer;
  }

  public void actionPerformed(ActionEvent e) {
    int val1 = Integer.parseInt(num1.getText());
    int val2 = Integer.parseInt(num2.getText());
    op.setText("+");
    answer.setText(Integer.toString(val1 + val2));
  }
}