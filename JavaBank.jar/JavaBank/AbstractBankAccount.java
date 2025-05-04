/**
 * AbstractBankAccount class
 * Base class for all bank account types
 */
public abstract class AbstractBankAccount {
    // Common attributes for all bank accounts
    protected String accountName;
    protected int accountNum;
    protected int balance;

    /**
     * Default constructor
     */
    public AbstractBankAccount() {
        accountName = "";
        accountNum = 0;
        balance = 0;
    }

    /**
     * Constructor with parameters
     * @param name The account name
     * @param num The account number
     * @param bal The initial balance
     */
    public AbstractBankAccount(String name, int num, int bal) {
        accountName = name;
        accountNum = num;
        balance = bal;
    }

    /**
     * Get the account name
     * @return The account name
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Set the account name
     * @param name The new account name
     */
    public void setAccountName(String name) {
        accountName = name;
    }

    /**
     * Get the account number
     * @return The account number
     */
    public int getAccountNum() {
        return accountNum;
    }

    /**
     * Set the account number
     * @param num The new account number
     */
    public void setAccountNum(int num) {
        accountNum = num;
    }

    /**
     * Get the account balance
     * @return The account balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Set the account balance
     * @param bal The new account balance
     */
    public void setBalance(int bal) {
        balance = bal;
    }

    /**
     * String representation of the bank account
     * @return A string representation of the bank account
     */
    @Override
    public String toString() {
        return "Account Name: " + accountName +
                " | Account Number: " + accountNum +
                " | Balance: $" + balance;
    }
}