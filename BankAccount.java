import java.text.NumberFormat;
public class BankAccount {
    public int accountNumber;
    private int balance;
    String formattedBalance;
    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    /**
     * public BankAccount(int accountNumberIn)
     Constructs a BankAccount object given the account number. The initial balance for the account is set to 0 pennies, which is equal to $0,00.
     * @param accountNumberIn - The given account number.
     */
    public BankAccount(int accountNumberIn){
        accountNumber = accountNumberIn;
        int dollarBalance = balance / 100;
        formattedBalance = formatter.format(dollarBalance);

    }
    /**
     * public BankAccount(int accountNumberIn,int balanceIn)
     Constructs a BankAccount object given the account number and an initial balance.
     * @param accountNumberIn - The given account number.
     * @param balanceIn - The initial balance in pennies.
     */
    public BankAccount(int accountNumberIn,int balanceIn) {
        accountNumber = accountNumberIn;
        balance = balanceIn;
        int dollarBalance = balance / 100;
        formattedBalance = formatter.format(dollarBalance);
    }

    /**
     * public void deposit(int depositAmount) throws OverpaymentException
     Deposits money into this account.
     * @param depositAmount - The amount to be deposited in pennies.
     * @throws OverpaymentException - Included here only to be consistent with the overridden 'deposit' method
     in the child LineOfCredit class.
     */
    public void deposit(int depositAmount)throws OverpaymentException{
        setBalance(getBalance() + depositAmount);
    }

    /**
     * public int getAccountNumber()
     Accessor method for accountNumber.
     * @return - The account number.
     */
    public int getAccountNumber(){return accountNumber;}

    /**
     * public int getBalance()
     Accessor method for balance.
     * @return - The balance in pennies.
     */
    public int getBalance(){return balance;}

    /**
     * public void setBalance(int balanceIn)
     Mutator method for balance.
     * @param balanceIn - The new balance in pennies.
     */
    public void setBalance(int balanceIn){
        balance = balanceIn;
    }

    /**
     * public String toString()
     Supplies the account number and balance as a String.
     * @return - A String representation of the account number and balance for this BankAccount instance. The balance
     is formatted in currency format.
     */
    public String toString(){
        return "**** Testing a bank account ****\n\nBankAccount[accountNumber=" + getAccountNumber() + ",balance=" + formattedBalance + "]\n";
    }

    /**
     * public void withdraw(int withdrawalAmount) throws InsufficientFundsException
     Withdraws money from this account.
     * @param withdrawAmount - The amount to be withdrawn in pennies.
     * @throws InsufficientFundsException - When the withdrawal attempts to reduce the balance below $0.00.
     */
    public void withdraw(int withdrawAmount)throws InsufficientFundsException{
        if(getBalance() - withdrawAmount < 0) throw new InsufficientFundsException();
        setBalance(getBalance() - withdrawAmount);
    }
}
