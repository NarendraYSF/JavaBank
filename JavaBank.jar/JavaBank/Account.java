
public class Account {

	// class variables
	String accountName;
	int accountNum;
	int balance;
	    
	//default constructor for Account
	Account()
	{
	  	this.accountName="EMPTY";
	   	this.accountNum=0;
	   	this.balance=0;
	}//end constructor
	    
	//overloaded constructor for Account
	Account(String name, int num,int amt)
	{
	    accountName=name;
	    accountNum=num;
	    balance=amt;
	}//end constructor
	
	//make a deposit to the balance
	public void deposit(int amt)
	{
	    balance=balance+amt;
	}//end method deposit
	
	//make a withdrawal from the balance
	public void withdraw(int amt)
	{
	    balance=balance-amt;
	}//end method withdraw
	
	//modifier to set the accountName
	public void setAccountName(String name)
	{
	    accountName = name;
	}//end method setAccountName
	
	//modifier to set the accountNumber
	public void setAccountNum(int num)
	{
	    accountNum = num;
	}//end method setAccountNum
	
	//modifier to set the balance
	public void setBalance(int num)
	{
	    balance = num;
	}//end method setBalance
	
	//accessor to get the accountName
	public String getAccountName ( ) 
	{
    	return accountName;
    }//end method getAccountName
	    
    //accessor to get the accountNumber
	public int getAccountNum ( ) 
	{
    	return accountNum;
    }//end method getAccountNum

	//accessor to get the account balance
	public int getBalance ( ) 
	{
    	return balance;
    }//end method getBalance
	    
    //print method 
    public void print() 
    {
        System.out.println(accountName + " " + accountNum + " " + balance);
    }//end method print
    
}//end class Account
