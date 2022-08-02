public class LineOfCredit extends BankAccount {
    private int creditLimit;
    private int dollarCreditLimit;

    String formattedCreditLimit;

    /**
     * public LineOfCredit(int accountNumberIn,int creditLimitIn)
     Constructs a LineOfCredit object given an account number and credit limit.
     * @param accountNumberIn - The given account number.
     * @param creditLimitIn - The given credit limit in pennies.
     */
    public LineOfCredit(int accountNumberIn, int creditLimitIn){
        super(accountNumberIn);
        setCreditLimit(creditLimitIn);
        dollarCreditLimit = creditLimit / 100;
        formattedCreditLimit = formatter.format(dollarCreditLimit);
    }

    /**
     * public LineOfCredit(int accountNumberIn,int creditLimitIn,int balanceIn)
     Constructs a LineOfCredit object given an account number, initial balance, and credit limit.
     The LineOfCredit object inherits the accountNumber and balance variables from the BankAccount class as it is an extension.
     * @param accountNumberIn - The given account number.
     * @param creditLimitIn - The given credit limit in pennies.
     * @param balanceIn - The initial balance in pennies.
     */
    public LineOfCredit(int accountNumberIn, int creditLimitIn, int balanceIn){
        super(accountNumberIn,balanceIn);
        setCreditLimit(creditLimitIn);
        dollarCreditLimit = creditLimit / 100;
        formattedCreditLimit = formatter.format(dollarCreditLimit);

    }

    /**
     * public void deposit(int depositAmount) throws OverpaymentException
     Deposits money into this account, which represents a payment on the amount owed. The deposit is
     performed only if the payment does not take the balance above $0.00.
     * @param depositAmount - The amount to be deposited in pennies.
     * @throws OverpaymentException - When the deposit attempts to increase the balance to be greater than
     $0.00
     */
    public void deposit(int depositAmount)throws OverpaymentException{
        if(getBalance() + depositAmount > 0) throw new OverpaymentException();
        setBalance(getBalance() + depositAmount);
    }

    /**
     * public int getCreditLimit()
     Accessor method for creditLimit.
     * @return - The credit limit in pennies.
     */
    public int getCreditLimit(){return creditLimit;}

    /**
     * public void setCreditLimit(int creditLimitIn)
     Mutator method for creditLimit.
     * @param creditLimitIn - The given credit limit in pennies.
     */
    public void setCreditLimit(int creditLimitIn){
        creditLimit = creditLimitIn;
    }

    /**
     * public String toString()
     Supplies the account number, balance and credit limit as a String.
     * @return - A String representation of the account number, balance, and credit limit for this LineOfCredit instance.
     The balance and credit limit are formatted in currency format.
     */
    public String toString(){
        return "**** Testing a line of credit ****\n\nBankAccount[accountNumber=" + getAccountNumber() + ",balance=" + formattedBalance + ",creditLimit=" + formattedCreditLimit + "]\n";
    }

    /**
     * public void withdraw(int withdrawalAmount) throws InsufficientFundsException
     Withdraws money from this account, which represents borrowing money from the line of credit. The
     withdrawal is performed only if the transaction does not take the balance below the credit limit.
     * @param withdrawAmount - The amount to be withdrawn in pennies.
     * @throws InsufficientFundsException - When the withdrawal attempts to reduce the balance below the
     * credit limit.
     */
    public void withdraw(int withdrawAmount)throws InsufficientFundsException{
        if(getBalance() - withdrawAmount < getCreditLimit()) throw new InsufficientFundsException();
        setBalance(getBalance() - withdrawAmount);
    }
}
