package gvsucis.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

// This code is broken into a series of simple methods to help motivate the benefit of exceptions.
// Imagine that a problem occurs at the end of the call chain in getNet.  Imagine how complex this 
// code would be if you had to propagate that error all the way up using return values.
public class MotivateException2 {

  public static void main(String[] args) throws FileNotFoundException {

    // Pretend the user selects this file using a file chooser.
    String filename = "data/example1.invoices";
    if (args.length > 0) {
      filename = args[0];
    }

    double revenue = sumInvoicesFromFile(filename);
    System.out.printf("Sum From invoices: $%.2f\n", revenue);
  }


  public static double sumInvoicesFromFile(String fileName) throws FileNotFoundException {
    return sumInvoices(new FileInputStream(fileName));
  }


  public static double sumInvoices(InputStream input) {
    Scanner s = new Scanner(input);
    double sum = 0.0;
    while (s.hasNextLine()) {
      String nextLine = s.nextLine();
      sum += parseInvoice(nextLine);
    }
    s.close();
    return sum;
  }

  public static double parseInvoice(String invoice) {
    String[] parts = invoice.split(";");
    return getNet(parts[2], parts[3]);
  }

  public static double getNet(String grossIn, String discountIn) {

  
    double gross = Double.parseDouble(grossIn);
    double discount = Double.parseDouble(discountIn);
    return gross-discount;
  }
  
}