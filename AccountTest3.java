import java.text.NumberFormat;

public class AccountTest3 {
    public static void main(String[] args) {
        String type;
        char[] transactionType = {'d', 'd', 'w', 'w'};
        int[] transactionAmount = {5000, 5000, 15000, 10000};
        BankAccount account = new BankAccount(1000, 0);

        System.out.println(account);
        System.out.println(" Type     Amount  Balance ");
        System.out.println("======== ======== ========");

        for (int i = 0; i < transactionType.length; i++) {
            if (transactionType[i] == 'd') {
                type = "Deposit";
                System.out.print(padLeft(type, 7));
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                int amount = transactionAmount[i] / 100;
                int balance = account.getBalance() / 100;
                String formattedAmount = formatter.format(amount);
                System.out.print(padLeft(formattedAmount, 8));
                try {
                    account.deposit(transactionAmount[i]);
                    String formattedBalance = formatter.format(balance + amount);
                    System.out.print(padLeft(formattedBalance, 11) + "\n");
                } catch (OverpaymentException e) {
                    System.out.print(padLeft("(" + e.getMessage(),16) + "(" + "\n");
                }

            } else if (transactionType[i] == 'w') {
                type = "Withdraw";
                System.out.print(padLeft(type, 7));
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                int amount = transactionAmount[i] / 100;
                int balance = account.getBalance() / 100;
                String formattedAmount = formatter.format(amount);
                System.out.print(padLeft(formattedAmount, 8));
                try {
                    account.withdraw(transactionAmount[i]);
                    String formattedBalance = formatter.format(balance - amount);
                    System.out.print(padLeft(formattedBalance, 10) + "\n");
                } catch (InsufficientFundsException e) {
                    System.out.print(padLeft("(" + e.getMessage(),22) + ")" + "\n");
                }

            } else {
                System.out.println("Invalid transaction type.");
            }
        }
        LineOfCredit creditLine = new LineOfCredit(1000, -20000, -7500);
        System.out.println("\n" + creditLine);
        System.out.println(" Type     Amount  Balance ");
        System.out.println("======== ======== ========");
        for (int i = 0; i < transactionType.length; i++) {
            if (transactionType[i] == 'd') {
                type = "Deposit";
                System.out.print(padLeft(type, 7));
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                int amount = transactionAmount[i] / 100;
                int balance = creditLine.getBalance() / 100;
                String formattedAmount = formatter.format(amount);
                System.out.print(padLeft(formattedAmount, 8));
                try{
                    creditLine.deposit(transactionAmount[i]);
                    String formattedBalance = formatter.format(balance + amount);
                    System.out.print(padLeft(formattedBalance, 11) + "\n");
                } catch (OverpaymentException e){
                    System.out.print(padLeft("(" + e.getMessage(),16) + ")" + "\n");
                }
            }
            else if (transactionType[i] == 'w') {
                type = "Withdraw";
                System.out.print(padLeft(type, 7));
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                int amount = transactionAmount[i] / 100;
                int balance = creditLine.getBalance() / 100;
                String formattedAmount = formatter.format(amount);
                System.out.print(padLeft(formattedAmount, 8));
                try {
                    creditLine.withdraw(transactionAmount[i]);
                    String formattedBalance = formatter.format(balance - amount);
                    System.out.print(padLeft(formattedBalance, 10) + "\n");
                } catch (InsufficientFundsException e){
                    System.out.print(padLeft("(" + e.getMessage(),22) + ")" + "\n");
                }
            }
            else {
                System.out.println("Invalid transaction type.");
            }
        }
    }


        public static String padLeft (String s,int width)
        {
            String r = s;
            while (r.length() < width)
                r = " " + r;
            return r;
        }

}
