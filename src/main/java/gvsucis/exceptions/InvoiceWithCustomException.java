package gvsucis.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

// This code is broken into a series of simple methods to help motivate the benefit of exceptions.
// Imagine that a problem occurs at the end of the call chain in getNet.  Imagine how complex this 
// code would be if you had to propagate that error all the way up using return values.
public class InvoiceWithCustomException {

  public static class InvoiceException extends Exception {

    private static final long serialVersionUID = 1L;
    private int lineNumber;

    public InvoiceException(int line, String message) {
      super(String.format("Line %d: %s", line, message));
      this.lineNumber = line;
    }

    public int getLineNumber() {
      return lineNumber;
    }
  }

  public static void main(String[] args) {

    // Pretend the user selects this file using a file chooser.
    String filename = "data/brokenExample.invoices";
    if (args.length > 0) {
      filename = args[0];
    }

    try {
      double revenue = sumInvoicesFromFile(filename);
      System.out.printf("Sum From invoices: $%.2f\n", revenue);
    } catch (InvoiceException e) {
      System.err.println(e.getMessage());
    } catch (FileNotFoundException e2) {
      System.err.println(e2.getMessage());
    }
  }

  public static double sumInvoicesFromFile(String fileName) throws FileNotFoundException, InvoiceException {
    return sumInvoices(new FileInputStream(fileName));
  }

  public static double sumInvoices(InputStream input) throws InvoiceException {
    Scanner s = new Scanner(input);
    double sum = 0.0;
    int line = 0;
    while (s.hasNextLine()) {
      ++line;
      String nextLine = s.nextLine();
      sum += parseInvoice(line, nextLine);
    }
    s.close();
    return sum;
  }

  public static double parseInvoice(int line, String invoice) throws InvoiceException {
    String[] parts = invoice.split(";");
    if (parts.length < 4) {
      throw new InvoiceException(line, "Too few columns (saw " + parts.length + " expected 4.)");
    }
    try {
      return getNet(parts[2], parts[3]);
    } catch (NumberFormatException e) {
      throw new InvoiceException(line, "Invoice Amount not parsable " + e.getMessage());
    }
  }

  public static double getNet(String grossIn, String discountIn) {
    double gross = Double.parseDouble(grossIn);
    double discount = Double.parseDouble(discountIn);
    return gross - discount;
  }

}