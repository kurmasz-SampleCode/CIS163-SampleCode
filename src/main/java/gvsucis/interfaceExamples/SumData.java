package gvsucis.interfaceExamples;

import java.io.*;
import java.util.Scanner;

public class SumData {

  public static void sumData(InputStream input, PrintStream output) {

    Scanner s = new Scanner(input);

    int total = 0;
    while (s.hasNextDouble()) {
      total += s.nextDouble();
    }
    output.printf("The total is: %.2f\n", total);
  }

  public static void main(String[] args) {

    // If there are no parameters, then just use stdin and stdout
    if (args.length == 0) {
      sumData(System.in, System.out);
    }
    // else assume the first argument is a file name
    else {
      try {
        FileInputStream fis = new FileInputStream(args[0]);
        sumData(fis, System.out);
      } catch (FileNotFoundException e) {
        System.err.printf("Could not open %s.\n", args[0]);
      }
    }
  }
}