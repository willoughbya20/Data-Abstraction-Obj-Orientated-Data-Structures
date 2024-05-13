package assg3_willoughbya20;

public class AccountTest {

	public static void main(String[] args) 
	{
		System.out.println("****ALL ACOUNT CLASS TESTING***\n");
		Account a1 = new Account("100");
		Account a2 = new Account("101", 1000);
		Account a3 = new Account ("100");
		System.out.println("Testing out our first constructor \n" + a1);
		System.out.println("\nTesting our second constructor \n" + a2);
		
		a1.setBalance(150);
		System.out.println("\nUsing setBalance method and getBalance method in Account Class: " + a1.getBalance());
		
		System.out.println("\nUsing getAcctNo method: " + a1.getAcctNo());
		
		a1.deposit(5000);
		System.out.println("\nUsing deposit method in Account class" + a1);
		System.out.println();
		a1.deposit(-150);
		
		a1.withdraw(150);
		System.out.println("\nWithdraw 150 out of account 100: " + a1.getBalance());
		System.out.println("\nTesting other cases in withdraw method:");
		a2.withdraw(10000);
		a2.withdraw(-2000);
		
		a1.transfer(a2, 1000);
		System.out.println("\nUsing transfer method, transfer 1000 from a1 to a2: " + a1.getBalance() + ", " + a2.getBalance());
		System.out.println("\nTesting other cases for transfer method:");
		a1.transfer(a2, 5000);
		a1.transfer(a2, -1000);
		
		System.out.println("\nDisplay info method: ");
		a1.displayInfo();
		
		System.out.println("\ntoString method:");
		System.out.println(a1.toString());
		
		System.out.println("\nEquals method testing:\n" + a1.equals(a2));
		System.out.println(a1.equals(a3));
		System.out.println(a1.equals(null));
		
		System.out.println("****ALL CheckingAccount CLASS TESTING***\n");
		CheckingAccount c1 = new CheckingAccount("101");
		CheckingAccount c2 = new CheckingAccount("102", 5000, 200);
		
		System.out.println("Testing out our first constructor \n" + c1);
		System.out.println("\nTesting our second constructor \n" + c2);
		
		c2.setOverdraft(300);
		System.out.println("\ngetOverdraft and setOverdraft method testing: " + c2.getOverdraft());
		
		c2.setFee(100);
		System.out.println("\nsetFee and getFee method testings: " + c2.getFee());
		
		System.out.println("\ntoString method testing:\n" + c2.toString());
		
		c2.withdraw(1000);
		System.out.println("\nTesting CheckingAccount withdraw method: \n" + c2.getBalance());
		c2.withdraw(5000);
		c2.withdraw(-500);
		
		System.out.println("\nCheckingAccount transfer method testing");
		c2.transfer(c1, -1000);
		c2.transfer(c1, 5000);
		c2.transfer(c1, 1000);
		System.out.println("Account after transferd amount: " + c1.getBalance());
		
		System.out.println("\ndisplayInfo method testing");
		c2.displayInfo();
		
		System.out.println("\n****ALL SavingsAccount CLASS TESTING***\n");
		SavingsAccount s1 = new SavingsAccount("101");
		SavingsAccount s2 = new SavingsAccount("102", 5000, .05);
		
		System.out.println("Testing out our first constructor \n" + s1);
		System.out.println("\nTesting our second constructor \n" + s2);
		
		s2.setInterestRate(.07);
		System.out.println("\nTesting get and set methods for interestRate: " + s2.getInterestRate());
		System.out.println();
		
		s2.addInterest(.01);
		System.out.println("Testing addInterest method: " + s2.getBalance() + "\n");
		
		System.out.println("Testing toString method\n" + s2.toString());
		System.out.println();
		
		s2.transfer(s1, 2000);
		System.out.println("Account balance after money transfered: " + s1.getBalance());
		s2.transfer(s1, -5);
		s2.transfer(s1, 6000);
		
		s2.displayInfo();
	}

}
