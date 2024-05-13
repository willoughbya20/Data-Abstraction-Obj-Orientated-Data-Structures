package assg3_willoughbya20;

public class SavingsAccount extends Account
{
	private double interestRate;
	
	/**
	 * Default constructor given...
	 * @param acctNo 
	 * and interest rate set to 0
	 */
	public SavingsAccount(String acctNo)
	{
		super(acctNo);
		interestRate = 0;
	}
	
	/**
	 * Constructor given...
	 * @param acctNo
	 * @param balance
	 * @param interestRate
	 */
	public SavingsAccount(String acctNo, double balance, double interestRate)
	{
		super(acctNo, balance);
		this.interestRate = interestRate;
	}
	
	/**
	 * Method that gets the interest rate
	 * @return the interest rate
	 */
	public double getInterestRate()
	{
		return interestRate;
	}
	
	/**
	 * Method that modifies the interest rate
	 * @param newInterest is the new interest rate
	 */
	public void setInterestRate(double newInterest)
	{
		interestRate = newInterest;
	}
	
	/**
	 * Method that adds the interest rate to the balance
	 * @param addInterestRate given
	 */
	public void addInterest(double addInterestRate)
	{
		setBalance((1 + interestRate)*getBalance());
	}
	
	/**
	 * Prints out the account number
	 * balance
	 * and interest rate using toString
	 */
	@Override
	public String toString()
	{
		return "Account number: " + getAcctNo() + "\nCurrent balance: " + getBalance() + "\nInterest rate: " + getInterestRate();
	}
	
	/**
	 * Displays the account number
	 * balance
	 * and interest rate
	 */
	public void displayInfo()
	{
		System.out.println("\nAccount number: " + getAcctNo());
		System.out.println("Current balance: " + getBalance());
		System.out.println("Interest rate: " + getInterestRate());
	}
}
