package assg1_willoughbya20;

import java.util.Scanner;

public class CountFamilies 
{

	public static void main(String[] args) 
	{
		System.out.println("Enter number of families: ");
		Scanner keyboard = new Scanner(System.in);
		
		//Get user input for how many families there are.
		int numOfFamilies= keyboard.nextInt();
		//Declare array for Family incomes
		int incomeArray[];
		//Initialize the array with the size/how big it will be
		incomeArray = new int[numOfFamilies];
		
		//For loop that takes families income values and puts them into the array. Stops whenever it reaches # of families
		for (int i = 0; i < numOfFamilies; i++ )
		{
			System.out.println("Enter an income: ");
			incomeArray[i] = keyboard.nextInt();
		}
		//Set maxIncome to first position in array because that is your highest amount at first
		int maxIncome = incomeArray[0];
		//For loop that reads each of the arrays values and sees if its greater than the value before it.
		for (int i = 1; i < numOfFamilies; i++)
		{
			if (incomeArray[i] > maxIncome)
			{
				maxIncome = incomeArray[i];
			}
			
		}
		//Output to show the max income
		System.out.println("The maximum income is: " + maxIncome);
		
		//Need a counter for how many families are less than 10% of the maximum
		int count = 0;
		System.out.println("The incomes of families making less than 10% of the maximum are: ");
		//Find the value that is 10% of the max income
		maxIncome = maxIncome/10;
		//For loop that goes through each of the arrays values and compares to find the incomes that are making less than 10% of the max
		for (int i = 0; i < numOfFamilies; i++)
		{
			if(incomeArray[i] < maxIncome)
			{
				count++;
				System.out.println(incomeArray[i]);
			}
		}
		
		//Output
		System.out.println("for a total of " + count + " families");
		
		keyboard.close();
	}

}
