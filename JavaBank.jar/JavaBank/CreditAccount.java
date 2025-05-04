
public class CreditAccount extends Account{

	int creditLimit;
	
	//default constructor for CreditAccount
	CreditAccount()
    {
    	super();
    	this.creditLimit=100;
    }//end constructor
	
	//overloaded constructor for CreditAccount
	CreditAccount(String name, int num,int amt,int credit)
    {
        super(name,num,amt);
        this.creditLimit=credit;
    }//end constructor
	
	//modifier to set the account creditLimit
	public void setCreditLimit(int num)
	{
	    creditLimit = num;
	}//end method setCreditLimit
	
	//accessor to get the account creditLimit
	public int getCreditLimit ( ) 
	{
    	return creditLimit;
    }//end method getCreditLimit

	//print method 
	public void print() 
	{
	    System.out.println(accountName + " " + accountNum + " " + balance + " " + creditLimit);
	}//end method print
	
}//end class CreditAccount
