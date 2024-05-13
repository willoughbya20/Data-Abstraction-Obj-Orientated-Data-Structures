/**
 * Adam Willoughby
 * Subclass of Account
 * does the same things as it but has extra variables like
 * fee and overdraft
 */

package assg3_willoughbya20;

public class CheckingAccount extends Account
{
	private double overdraft;
	static double fee;
	
	/**
	 * Default constructor given account number
	 * @param acctNo
	 */
	public CheckingAccount(String acctNo)
	{
		super(acctNo);
		setBalance(0);
		overdraft = 0;
	}
	
	/**
	 * Constructor given..
	 * @param acctNo
	 * @param balance
	 * @param overdraft
	 */
	public CheckingAccount(String acctNo, double balance, double overdraft)
	{
		super(acctNo, balance);
		this.overdraft = overdraft;
	}
	
	/**
	 * Method to get overdraft
	 * @return overdraft
	 */
	public double getOverdraft()
	{
		return overdraft;
	}
	
	/**
	 * Method modifying the overdraft
	 * @param newOverdraft is the new overdraft
	 */
	public void setOverdraft(double newOverdraft)
	{
		overdraft = newOverdraft;
	}
	
	/**
	 * Method that gets the fee
	 * @return fee
	 */
	public double getFee()
	{
		return fee;
	}
	
	/**
	 * Method modifying the fee
	 * @param newFee is the new fee
	 */
	public void setFee(double newFee)
	{
		fee = newFee;
	}
	
	/**
	 * Method that prints the 
	 * Account number
	 * Balance
	 * and overdraft using toString
	 */
	@Override
	public String toString()
	{
		return "Account number: " + getAcctNo() + "\nCurrent balance: " + getBalance() + "\nOverdraft amount: " + getOverdraft();
	}
	
	/**
	 * Method that withdraws money from a certain account 
	 * with a fee and overdraft
	 * @param amountWithdraw is the amount being withdrawn
	 */
	@Override
	public void withdraw(double amountWithdraw)
	{
		if (amountWithdraw < 0 )
		{
			System.out.println("Invalid withdraw amount.");
		}
		else if (amountWithdraw > getBalance() - fee - getOverdraft())
		{
			System.out.println("Can not withdraw due insufficient balance.");
		}
		else
		{
			setBalance(getBalance() - fee - amountWithdraw);
		}
	}
	
	/**
	 * Method that transfers money from one account to another
	 * @param amountTransfer being the amount to transfer
	 * @param acctNo2 the account it is transfering to 
	 */
	@Override
	public void transfer(Account acctNo2, double amountTransfer)
	{
		if (amountTransfer < 0)
		{
			System.out.println("Can not transfer a negative amount.");
		}
			
		else if (amountTransfer > getBalance())
		{
			if (getOverdraft() > getBalance() - fee - amountTransfer)
			{
				System.out.println("Can not transfer due to overdraft and fees.");
			}
			else
			{
				setBalance(getBalance() - amountTransfer - fee);
				acctNo2.setBalance( acctNo2.getBalance() + amountTransfer);
			}
		}
		
		else
		{
			setBalance(getBalance() - amountTransfer);
			acctNo2.setBalance( acctNo2.getBalance() + amountTransfer);
		}
		
	}
	
	/**
	 * Method that displays the account number
	 * current balance
	 * and overdraft of an account
	 */
	@Override
	public void displayInfo()
	{
		System.out.println("Account number: " + getAcctNo());
		System.out.println("Current balance: " + getBalance());
		System.out.println("Overdraft amount: " + getOverdraft());
	}

}
