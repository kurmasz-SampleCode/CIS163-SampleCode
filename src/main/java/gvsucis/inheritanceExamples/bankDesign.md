
# BankAccount

  - name : String
  - balance : double 
  - acctNumber : int
 + deposit (amount: double) : void
   + withdraw (amount : double) : bool
   + transfer (amount : double, other : SavingsAccount) : bool
 + printMonthlyStatement() : void


# SavingsAccount


  - interest : double
   + applyInterest() : void
  



# CheckingAccount

   + cashCheck(amount : double) : bool


