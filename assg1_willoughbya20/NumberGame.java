package assg1_willoughbya20;

import java.util.Scanner;
import java.util.Random;

public class NumberGame 
{

	public static void main(String[] args) 
	{
		//Random number generate
		int secret;
		int count = 1;
		Random generator = new Random(); 
		secret = generator.nextInt(100);
		
		//Gets user input for their number guess
		System.out.println("Guess the random number chosen: ");
		Scanner keyboard = new Scanner(System.in);
		int userChoice= keyboard.nextInt();
		//A while loop that will continue to run until the user guesses the right number
		while (userChoice != secret)
		{
			//Count adds on for each guess
			count++;
			System.out.println("Guess again: ");
			userChoice= keyboard.nextInt();
			
		}
		
		//If the user guesses the right number it will print out this statement.
		if (userChoice == secret)
		{
			System.out.println("Number guessed correctly. It took you " + count + " guess(es)");
		}
		
		keyboard.close();

	}

}
