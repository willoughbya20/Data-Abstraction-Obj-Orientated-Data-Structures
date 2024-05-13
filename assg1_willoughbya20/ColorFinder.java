package assg1_willoughbya20;

import java.util.Scanner;

public class ColorFinder 
{

	public static void main(String[] args) 
	{
		//Gets the users sentence for input
		System.out.println("Enter a sentence: ");
		Scanner keyboard = new Scanner(System.in);
		String  userSentence= keyboard.nextLine().toLowerCase();
		
		//If the string contains any of these words it will print out the statement. 
		//This is also the dominant sentence no matter if any subtractive colors are in the sentence.
		if (userSentence.contains("red") || userSentence.contains("green") || userSentence.contains("blue"))
		{
			System.out.println("Additive primary color found");
		}
		
		//If none of the letters above are found and there is one of these words in the sentence it will print the statement
		else if (userSentence.contains("magnenta") || userSentence.contains("yellow") || userSentence.contains("cyan"))
		{
			System.out.println("Subtractive primary color found");
		}
		
		//Else statement if NONE of the words above are found
		else
		{
			System.out.println("No primary colors found");
		}
		
		keyboard.close();
	}

}
