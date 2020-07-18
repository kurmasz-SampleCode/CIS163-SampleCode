package gvsucis.inheritanceExamples;

public class BankExample {

  public static abstract class BankAccount {

    protected String name;
    protected double balance;
    protected int accountNumber;

    public BankAccount(String name, int actNum) {
      this.name = name;
      this.accountNumber = actNum;
      balance = 0;
    }

    public String getName() {
      return name;
    }

    public void deposit(double amount) {
      balance += amount;
    }

    public void printStatement() {
      System.out.println("Name: " + name);
      System.out.println("Balance:" + balance);
    }

    abstract public void mystery();

  }

  public static class SavingsAccount extends BankAccount {

    private double interest;
    private double monthlyInterest;

    public SavingsAccount(String name, int actNum, double interestRate) {
      super(name, actNum);
      this.interest = interestRate;
    }

    public void payInterest() {
      monthlyInterest = (1 + (interest / 12.0));
      balance = balance + monthlyInterest;
    }

    @Override
    public void printStatement() {
      super.printStatement();
      System.out.println("Interest paid this month " + monthlyInterest);
    }

    @Override
    public void mystery() {
      return;
    }
  }

  public static class CheckingAccount extends BankAccount {

    public CheckingAccount(String name, int actNum) {
      super(name, actNum);
    }

    @Override
    public void printStatement() {
      super.printStatement();
      // Print out check ledger
    }

    @Override
    public void mystery() {
      return;
    }

  }

  public static void main(String[] args) {

    BankAccount sa = new SavingsAccount("Bob Smith", 348343, 0.005);
    sa.deposit(500);
    sa.printStatement();

    BankAccount[] accounts = { new SavingsAccount("Bob Smith", 348343, 0.005),
        new CheckingAccount("Steve Smith", 34083), new SavingsAccount("Tom Haas", 343435, 0.01) };

    // Polymorphism: Method called is based on the object *not* the variable
    for (BankAccount act : accounts) {
      act.mystery();
    }

  }

}
