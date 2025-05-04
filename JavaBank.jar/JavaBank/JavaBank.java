import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class JavaBank extends JFrame {

    private static final long serialVersionUID = 1L;
    // Make these variables publicly available
    public String name;
    public int accountNum;
    public int balance;

    // Company color constant
    public static final Color COMPANY_COLOR = new Color(173, 216, 230); // Light Blue

    // JPanel for user inputs
    private JPanel inputDetailJPanel;

    // JLabel and JTextField for account name
    private JLabel nameJLabel;
    private JTextField nameJTextField;

    // JLabel and JTextField for account number
    private JLabel accountNumJLabel;
    private JTextField accountNumJTextField;

    // JLabel and JTextField for balance
    private JLabel balanceJLabel;
    private JTextField balanceJTextField;

    // JLabel and JTextField for withdraw
    private JLabel depositJLabel;
    private JTextField depositJTextField;

    // JLabel and JTextField for Withdraw
    private JLabel withdrawJLabel;
    private JTextField withdrawJTextField;

    // JButton to create account
    private JButton createAccountJButton;

    // JButton to delete account
    private JButton deleteAccountJButton;

    // JButton to make transaction
    private JButton transactionJButton;

    // JButton to display account
    private JButton displayJButton;

    // JLabel and JTextArea to display account details
    private JLabel displayJLabel;
    private static JTextArea displayJTextArea;


    // constants
    //public  final static Maximum Accounts that can be created;
    public final static int MAXACCOUNTS = 10;


    // one-dimensional array to store Account names as Empty or Used
    static String accountNames[] = new String[MAXACCOUNTS];

    // array to store Account details - updated to use AbstractBankAccount as base class
    static AbstractBankAccount myAccounts[]  = new AbstractBankAccount[MAXACCOUNTS];

    static int noAccounts = 0;

    // constructor
    public JavaBank() {
        for (int i=0; i <10; i++)  {
            accountNames[i] = "EMPTY";
            //System.out.println(AccountNames[i]);
        }//ENDFOR
        createUserInterface();
    }//end constructor


    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // Set the background color of the content pane
        contentPane.setBackground(COMPANY_COLOR);

        // set up inputDetailJPanel
        inputDetailJPanel = new JPanel();
        inputDetailJPanel.setBounds(16, 16, 208, 250);
        inputDetailJPanel.setBorder(new TitledBorder("Input Details"));
        inputDetailJPanel.setLayout(null);
        inputDetailJPanel.setBackground(COMPANY_COLOR);
        contentPane.add(inputDetailJPanel);

        // set up NameJLabel
        nameJLabel = new JLabel();
        nameJLabel.setBounds(8, 32, 90, 23);
        nameJLabel.setText("Name:");
        inputDetailJPanel.add(nameJLabel);

        // set up NameJTextField
        nameJTextField = new JTextField();
        nameJTextField.setBounds(112, 32, 80, 21);
        nameJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputDetailJPanel.add(nameJTextField);

        // set up AccountnumJLabel
        accountNumJLabel = new JLabel();
        accountNumJLabel.setBounds(8, 56, 100, 23);
        accountNumJLabel.setText("Account Number:");
        inputDetailJPanel.add(accountNumJLabel);

        // set up AccountnumTextField
        accountNumJTextField = new JTextField();
        accountNumJTextField.setBounds(112, 56, 80, 21);
        accountNumJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputDetailJPanel.add(accountNumJTextField);

        // set up BalanceJLabel
        balanceJLabel = new JLabel();
        balanceJLabel.setBounds(8, 80, 60, 23);
        balanceJLabel.setText("Balance:");
        inputDetailJPanel.add(balanceJLabel);

        // set up BalanceTextField
        balanceJTextField = new JTextField();
        balanceJTextField.setBounds(112, 80, 80, 21);
        balanceJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputDetailJPanel.add(balanceJTextField);

        // set up DepositJLabel
        depositJLabel = new JLabel();
        depositJLabel.setBounds(8, 104, 80, 23);
        depositJLabel.setText("Deposit:");
        inputDetailJPanel.add(depositJLabel);

        // set up DepositJTextField
        depositJTextField = new JTextField();
        depositJTextField.setBounds(112, 104, 80, 21);
        depositJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputDetailJPanel.add(depositJTextField);

        // set up WithdrawJLabel
        withdrawJLabel = new JLabel();
        withdrawJLabel.setBounds(8, 128, 60, 23);
        withdrawJLabel.setText("Withdraw:");
        inputDetailJPanel.add(withdrawJLabel);

        // set up WithdrawJTextField
        withdrawJTextField = new JTextField();
        withdrawJTextField.setBounds(112, 128, 80, 21);
        withdrawJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputDetailJPanel.add(withdrawJTextField);

        // set up CreateAccountButton
        createAccountJButton = new JButton();
        createAccountJButton.setBounds(112, 152, 80, 24);
        createAccountJButton.setText("Create");
        createAccountJButton.setBackground(COMPANY_COLOR);
        inputDetailJPanel.add(createAccountJButton);
        createAccountJButton.addActionListener(
                new ActionListener() {
                    // event handler called when CreateAccountJButton
                    // is clicked
                    public void actionPerformed(ActionEvent event) {
                        try {
                            createAccountJButtonActionPerformed(event);
                        } catch (MyException ex) {
                            JOptionPane.showMessageDialog(null,
                                    ex.getMessage(),
                                    "Account Creation Error",
                                    JOptionPane.ERROR_MESSAGE);
                            displayJTextArea.setText(ex.getMessage());
                            ex.printStackTrace();
                        }
                    }//end method actionPerformed
                }//end method ActionListener
        ); //end call to createAccountJButton ActionListener

        // set up DeleteAccountButton
        deleteAccountJButton = new JButton();
        deleteAccountJButton.setBounds(16, 152, 80, 24);
        deleteAccountJButton.setText("Delete");
        deleteAccountJButton.setBackground(COMPANY_COLOR);
        inputDetailJPanel.add(deleteAccountJButton);
        deleteAccountJButton.addActionListener(
                new ActionListener() // anonymous inner class
                {
                    // event handler called when DeleteAccountJButton
                    // is clicked
                    public void actionPerformed(ActionEvent event) {
                        try {
                            deleteAccountJButtonActionPerformed(event);
                        } catch (MyException ex) {
                            JOptionPane.showMessageDialog(null,
                                    ex.getMessage(),
                                    "Account Deletion Error",
                                    JOptionPane.ERROR_MESSAGE);
                            displayJTextArea.setText(ex.getMessage());
                            ex.printStackTrace();
                        }
                    }//end method actionPerformed
                }//end method ActionListener
        ); //end call to deleteAccountJButton ActionListener

        // set up TransactionJButton
        transactionJButton = new JButton();
        transactionJButton.setBounds(16, 180, 176, 24);
        transactionJButton.setText("Make Transaction");
        transactionJButton.setBackground(COMPANY_COLOR);
        inputDetailJPanel.add(transactionJButton);
        transactionJButton.addActionListener(
                new ActionListener() // anonymous inner class
                {
                    // event handler called when TransactionJButton
                    // is clicked
                    public void actionPerformed(ActionEvent event) {
                        try {
                            transactionJButtonActionPerformed(event);
                        } catch (MyException ex) {
                            JOptionPane.showMessageDialog(null,
                                    ex.getMessage(),
                                    "Transaction Error",
                                    JOptionPane.ERROR_MESSAGE);
                            displayJTextArea.setText(ex.getMessage());
                            ex.printStackTrace();
                        }
                    }//end method actionPerformed
                }//end method ActionListener
        ); //end call to transactionJButton ActionListener

        // set up DisplayJButton
        displayJButton = new JButton();
        displayJButton.setBounds(16, 208, 176, 24);
        displayJButton.setText("Display Accounts");
        displayJButton.setBackground(COMPANY_COLOR);
        inputDetailJPanel.add(displayJButton);
        displayJButton.addActionListener(
                new ActionListener() // anonymous inner class
                {
                    // event handler called when TransactionJButton
                    // is clicked
                    public void actionPerformed(ActionEvent event) {
                        try {
                            displayJButtonActionPerformed(event);
                        } catch (MyException ex) {
                            JOptionPane.showMessageDialog(null,
                                    ex.getMessage(),
                                    "Display Error",
                                    JOptionPane.ERROR_MESSAGE);
                            displayJTextArea.setText(ex.getMessage());
                            ex.printStackTrace();
                        }
                    }//end method actionPerformed
                }//end method ActionListener
        ); //end call to displayJButton ActionListener


        // set up displayJLabel
        displayJLabel = new JLabel();
        displayJLabel.setBounds(240, 16, 150, 23);
        displayJLabel.setText("Account Details:");
        contentPane.add(displayJLabel);

        // set up displayJTextArea
        displayJTextArea = new JTextArea();
        displayJTextArea.setBackground(COMPANY_COLOR);
        JScrollPane scrollPane = new JScrollPane(displayJTextArea);
        scrollPane.setBounds(240, 48, 402, 184);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getViewport().setBackground(COMPANY_COLOR);
        contentPane.add(scrollPane);
        displayJTextArea.setText("Welcome to Java Bank - There are currently no Accounts created");

        // clear other JTextFields for new data
        nameJTextField.setText(" ");
        accountNumJTextField.setText("0");
        balanceJTextField.setText("0");
        depositJTextField.setText("0");
        withdrawJTextField.setText("0");

        // set properties of application's window
        setTitle("Java Bank"); // set title bar string
        setSize(670, 308); // set window size
        setVisible(true); // display window
    } // end method createUserInterface


    private void createAccountJButtonActionPerformed(ActionEvent event) throws MyException {
        try {
            displayJTextArea.setText("");
            name = "";

            //Get name from Text Field
            name = nameJTextField.getText();

            //Get accountNum from Text Field and convert to int unless blank then set to 0
            if (accountNumJTextField.getText() == "0") {
                accountNum = 0;
            }
            else {
                accountNum = Integer.parseInt(accountNumJTextField.getText());
            }//endif

            //Get Balance from Text Field and convert to int unless blank then set to 0
            if (balanceJTextField.getText() == "0") {
                balance = 0;
            }
            else {
                balance = Integer.parseInt(balanceJTextField.getText());
            }//endif

            //int emptyAccount = 11;

            if ((noAccounts <= 9) & (name != "") & (accountNum != 0))  {
                myAccounts[noAccounts] = new Account(name, accountNum, balance);
                accountNames[noAccounts] = "USED";
                //System.out.println(myAccounts[noAccounts].getAccountName());
                //emptyAccount = i;

                // Using toString() method to display account details
                displayJTextArea.setText(myAccounts[noAccounts].toString());

                noAccounts ++;
                System.out.println(noAccounts);
            }
            else {
                displayJTextArea.setText("Both the Name field and Account Number must be completed");
            }

            if (noAccounts == 10) {
                // Once account 10 is created. All accounts full.
                displayJTextArea.setText("All Accounts Full!");
            }
        } catch (Exception e) {
            MyException newExc = new MyException("An unhandled error occurred!!");
            throw newExc;
        } finally {
            // clear other JTextFields for new data
            nameJTextField.setText(" ");
            accountNumJTextField.setText("0");
            balanceJTextField.setText("0");
            depositJTextField.setText("0");
            withdrawJTextField.setText("0");
        }
    }//end method CreateAccountJButtonActionPerformed


    private void deleteAccountJButtonActionPerformed(ActionEvent event) throws MyException {
        try {
            displayJTextArea.setText("Oops this isnt coded in this version!");
            //Name = NameJTextField.getText();
            //System.out.println("Delete Account: " + Name);

            // Enter code to delete here
        } catch (Exception e) {
            MyException newExc = new MyException("An unhandled error occurred!!");
            throw newExc;
        } finally {
            // clear JTextFields for new data
            nameJTextField.setText(" ");
            accountNumJTextField.setText("0");
            balanceJTextField.setText("0");
            depositJTextField.setText("0");
            withdrawJTextField.setText("0");
        }
    }//end method DeleteAccountJButtonActionPerformed


    private void transactionJButtonActionPerformed(ActionEvent event) throws MyException {
        displayJTextArea.setText("");

        if (noAccounts == 0) {
            displayJTextArea.setText("No Accounts currently created");
            return;
        }

        try {
            // Get account number from TextField
            int accountNum;
            try {
                accountNum = Integer.parseInt(accountNumJTextField.getText());
            } catch (NumberFormatException e) {
                MyException newExc = new MyException("Invalid account number format. Please enter a valid number.");
                throw newExc;
            }

            // Get deposit and withdraw amounts
            int deposit = 0;
            int withdraw = 0;

            try {
                if (!depositJTextField.getText().isEmpty() && !depositJTextField.getText().equals("0")) {
                    deposit = Integer.parseInt(depositJTextField.getText());
                    if (deposit < 0) {
                        MyException newExc = new MyException("Deposit amount cannot be negative.");
                        throw newExc;
                    }
                }
            } catch (NumberFormatException e) {
                MyException newExc = new MyException("Invalid deposit amount format. Please enter a valid number.");
                throw newExc;
            }

            try {
                if (!withdrawJTextField.getText().isEmpty() && !withdrawJTextField.getText().equals("0")) {
                    withdraw = Integer.parseInt(withdrawJTextField.getText());
                    if (withdraw < 0) {
                        MyException newExc = new MyException("Withdraw amount cannot be negative.");
                        throw newExc;
                    }
                }
            } catch (NumberFormatException e) {
                MyException newExc = new MyException("Invalid withdraw amount format. Please enter a valid number.");
                throw newExc;
            }

            // Check if both deposit and withdraw are zero
            if (deposit == 0 && withdraw == 0) {
                MyException newExc = new MyException("Please enter either a deposit or withdraw amount.");
                throw newExc;
            }

            // Find the account and perform transaction
            boolean accountFound = false;
            for (int i = 0; i < noAccounts; i++) {
                if (myAccounts[i].getAccountNum() == accountNum) {
                    accountFound = true;

                    // Handle deposit
                    if (deposit > 0) {
                        myAccounts[i].setBalance(myAccounts[i].getBalance() + deposit);
                        displayJTextArea.setText("Deposit successful.\n" + myAccounts[i].toString());
                    }

                    // Handle withdraw
                    if (withdraw > 0) {
                        // Check if sufficient balance
                        if (myAccounts[i].getBalance() >= withdraw) {
                            myAccounts[i].setBalance(myAccounts[i].getBalance() - withdraw);
                            displayJTextArea.setText("Withdrawal successful.\n" + myAccounts[i].toString());
                        } else {
                            MyException newExc = new MyException("Insufficient funds for withdrawal.\nAccount balance: $" +
                                    myAccounts[i].getBalance() +
                                    "\nWithdrawal amount: $" + withdraw);
                            throw newExc;
                        }
                    }

                    break;
                }
            }

            if (!accountFound) {
                MyException newExc = new MyException("Account number " + accountNum + " not found.");
                throw newExc;
            }
        } catch (MyException e) {
            // Re-throw the MyException to be caught by the ActionListener
            throw e;
        } catch (Exception e) {
            // Create a new MyException for any other unexpected errors
            MyException newExc = new MyException("An unhandled error occurred: " + e.getMessage());
            throw newExc;
        } finally {
            // Clear input fields
            nameJTextField.setText(" ");
            accountNumJTextField.setText("0");
            balanceJTextField.setText("0");
            depositJTextField.setText("0");
            withdrawJTextField.setText("0");
        }
    }//end method TransactionJButtonActionPerformed


    private void displayJButtonActionPerformed(ActionEvent event) throws MyException {
        try {
            name = nameJTextField.getText();
            displayJTextArea.setText("");

            if (noAccounts == 0) {
                displayJTextArea.setText("No Accounts currently created");
            } else {
                for (int i=0; i<noAccounts; i++) {
                    // Using displayAccountDetails method to display account details
                    displayAccountDetails(myAccounts[i]);
                }//endfor
            }//endif
        } catch (Exception e) {
            MyException newExc = new MyException("An unhandled error occurred!!");
            throw newExc;
        } finally {
            // clear other JTextFields for new data
            nameJTextField.setText(" ");
            accountNumJTextField.setText("0");
            balanceJTextField.setText("0");
            depositJTextField.setText("0");
            withdrawJTextField.setText("0");
        }
    }//end method displayJButtonActionPerformed

    private void displayAccountDetails(AbstractBankAccount account) {
        displayJTextArea.append(account.toString() + "\n");
    }//end method displayAccountDetails

    public static void main(String[] args) {
        // Populate arrays with the word EMPTY
        // so we can check to see if the values are empty later
        JavaBank application = new JavaBank();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set look and feel to system default
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(application);
        } catch (Exception e) {
            try {
                MyException newExc = new MyException("An unhandled error occurred!!");
                JOptionPane.showMessageDialog(null,
                        newExc.getMessage(),
                        "Look and Feel Error",
                        JOptionPane.ERROR_MESSAGE);
                System.err.println(newExc.getMessage());
                e.printStackTrace();
            } catch (Exception ex) {
                System.err.println("Error displaying error message: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }//end method main

}//end class JavaBank