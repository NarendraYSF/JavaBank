/**
 * Account class
 * Extends AbstractBankAccount class
 */
public class Account extends AbstractBankAccount {

	/**
	 * Default constructor
	 */
	public Account() {
		super();
	}

	/**
	 * Constructor with parameters
	 * @param name The account name
	 * @param num The account number
	 * @param bal The initial balance
	 */
	public Account(String name, int num, int bal) {
		super(name, num, bal);
	}

	/**
	 * String representation of the Account
	 * This method can be customized for Account-specific formatting
	 * @return A string representation of the Account
	 */
	@Override
	public String toString() {
		return "Regular Account | " + super.toString();
	}

	/**
	 * Print the account details to the console
	 * Required by TestCreditAccount class
	 */
	public void print() {
		System.out.println(toString());
	}
}