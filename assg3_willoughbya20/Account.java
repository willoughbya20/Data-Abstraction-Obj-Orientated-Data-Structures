/**
 * Adam Willoughby 
 * Represents a bank account that can be used to deposit, withdraw, and transfer money.
 */
package assg3_willoughbya20;

public class Account 
{
	private String acctNo;
	private double balance;
	
	/**
	 * default constructor
	 * @param acctNo given
	 * Setting balance to 0
	 */
	public Account(String acctNo)
	{
		this.acctNo = acctNo;
		balance = 0;
	}
	
	/**
	 * Constructor given 
	 * @param acctNo
	 * @param balance
	 */
	public Account(String acctNo, double balance)
	{
		this.acctNo = acctNo;
		if (balance > 0)
		{
			this.balance = balance;
		}
		else
		{
			this.balance = 0;
		}
	}
	
	/**
	 * Method that gets Account number
	 * @return acctNo
	 */
	public String getAcctNo()
	{
		return acctNo;
	}
	
	/**
	 * Method that gets the account balance
	 * @return balance
	 */
	public double getBalance()
	{
		return balance;
	}
	
	/**
	 * Modifying the balance
	 * @param newBal is the new balance
	 */
	public void setBalance(double newBal)
	{
		balance = newBal;
	}
	
	/**
	 * Method for depositing money
	 * @param amountDeposit for amount to be deposited into the account
	 */
	public void deposit(double amountDeposit)
	{
		if (amountDeposit > 0)
		{
			balance = amountDeposit + balance;
		}
		else
		{
			System.out.println("Amount deposited was not positive.");
		}
	}
	
	/**
	 * Method withdrawing funds from an account
	 * @param amountWithdraw amount being withdrawn
	 */
	public void withdraw(double amountWithdraw)
	{
		if (amountWithdraw > 0 && amountWithdraw < balance)
		{
			balance = balance - amountWithdraw;
		}
		else if (amountWithdraw > balance)
		{
			System.out.println("Balance is too low to withdraw that amount.");
		}
		else
		{
			System.out.println("Amount wanting to be withdrawn is not positive.");
		}
	}
	
	/**
	 * Method that can transfer money from one account to another
	 * @param acctNo2 account that is being transfered to
	 * @param amountTransfer amount being transfered
	 */
	public void transfer(Account acctNo2, double amountTransfer)
	{
		if (amountTransfer > 0 && amountTransfer < balance)
		{
			balance = this.balance - amountTransfer;
			acctNo2.balance = acctNo2.balance + amountTransfer;
		}
		
		else if (amountTransfer > balance)
		{
			System.out.println("Not enough in balance to transfer.");
		}
		
		else
		{
			System.out.println("Invalid amount.");
		}
	}
	
	/**
	 * Method that displays the account number and balance
	 */
	public void displayInfo()
	{
		System.out.println("Account number: " + acctNo + "\n" + "Current balance: " + balance);
	}
	
	/**
	 * Method that prints out the account number and balance using return statement
	 */
	@Override
	public String  toString()
	{
		return "Account number: " + acctNo + " \n" + "Current balance: " + balance;
	}
	
	/**
	 * Equals method that returns true if 2 accounts are equal to each other 
	 * and false if they are not
	 * @param Obj with object data type 
	 */
	public boolean equals(Object Obj)
	{
		if (Obj == null)
		{
			return false;
		}
		
		else if (Obj instanceof Account)
		{
			Account temp = (Account)Obj;
			return (this.acctNo.equals(temp.getAcctNo()));
		}
		
		else
		{
			return false;
		}
	}
}
