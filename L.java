// 1. Base class for accounts that ONLY allow deposits
abstract class DepositOnlyAccount {
    protected int bal = 0;

    abstract void deposit(int amount);
}

// 2. Subclass for accounts that allow BOTH deposits and withdrawals
abstract class WithdrawableAccount extends DepositOnlyAccount {
    // Inherits 'bal' and 'deposit' automatically from parent
    abstract void withdraw(int amount); 
}

// 3. Savings Account implements both deposit and withdrawal
class Savings extends WithdrawableAccount {
    @Override
    void deposit(int amount) {
        bal += amount;
        System.out.println("Savings: Deposited " + amount + ". Current Balance: " + bal);
    }

    @Override
    void withdraw(int amount) {
        if (amount <= bal) {
            bal -= amount;
            System.out.println("Savings: Withdrew " + amount + ". Remaining Balance: " + bal);
        } else {
            System.out.println("Savings: Failed to withdraw " + amount + ". Insufficient funds! (Balance: " + bal + ")");
        }
    }
}

// 4. Fixed Deposit Account only implements deposit
class FixedDeposit extends DepositOnlyAccount {
    @Override
    void deposit(int amount) {
        bal += amount;
        System.out.println("Fixed Deposit: Deposited " + amount + ". Current Balance: " + bal);
    }
}

// 5. The Bank Client handles objects individually and securely without 'if' checks
class BankClient {
    //this is HAS-A relationship like BankClient has a wAccount or daccount.
    private WithdrawableAccount wAccount;
    private DepositOnlyAccount dAccount;

    // Constructor maps the objects cleanly to their designated slots
    public BankClient(WithdrawableAccount wAccount, DepositOnlyAccount dAccount) {
        this.wAccount = wAccount;
        this.dAccount = dAccount;
    }

    // Accepts custom transaction numbers directly from main
    public void processTransactions(int savingsDeposit, int savingsWithdraw, int fdDeposit) {
        System.out.println("--- Processing Transactions ---");
        
        // Safe to call deposit and withdraw because wAccount guarantees both behaviors
        wAccount.deposit(savingsDeposit);
        wAccount.withdraw(savingsWithdraw);

        // Safe to call deposit only
        dAccount.deposit(fdDeposit);
        
        System.out.println("--------------------------------");
    }
}

// 6. Main Execution Class
public class L {
    public static void main(String[] args) {
        // Step 1: Create your specific account instances
        WithdrawableAccount mySavings = new Savings();
        DepositOnlyAccount myFD = new FixedDeposit();

        // Step 2: Inject the accounts into the BankClient constructor
        BankClient bc = new BankClient(mySavings, myFD);

        // Step 3: Pass custom numbers directly from main!
        // Format: processTransactions(savingsDeposit, savingsWithdraw, fdDeposit)
        bc.processTransactions(3000, 1200, 7500);

        // Testing what happens if a withdrawal exceeds the balance
        bc.processTransactions(500, 4000, 2000);
    }
}
