/**
 * Adam Willoughby
 * Recursion methods used to replace certain characters in a string message
 */
package assg5_willoughbya20;

import java.util.*;

public class StringReplaceRecursion {

	public static void main(String[] args) 
	{
		String str = null;
		char chr = ' ';
		char newChar = ' ';
		Scanner keyboard = new Scanner(System.in);
		System.out.println("1. Test replace method\n2. Test replaceAll method\n3. Exit");
		int select = keyboard.nextInt();
		
		while(select > 0 && select < 4)
		{
			if(select == 1)
			{
				keyboard.nextLine();
				System.out.println("Enter a string: ");
				str = keyboard.nextLine();
				System.out.println("Enter a character you want to replace: ");
				chr = keyboard.next().charAt(0);
				System.out.println("Enter a character to replace that character with: ");
				newChar = keyboard.next().charAt(0);
				System.out.println("New String: " + replace(str, chr, newChar));
			}
			
			else if (select == 2)
			{
				keyboard.nextLine();
				System.out.println("Enter a string: ");
				str = keyboard.nextLine();
				System.out.println("Enter a character you want to replace: ");
				chr = keyboard.next().charAt(0);
				System.out.println("Enter a character to replace that character with: ");
				newChar = keyboard.next().charAt(0);
				System.out.println("New string: " + replaceAll(str, chr, newChar));
			}
			
			else if (select == 3)
			{
				System.exit(0);
			}
			
			System.out.println("\n1. Test replace method\n2. Test replaceAll method\n3. Exit");
			select = keyboard.nextInt();
		}
		keyboard.close();
	}
	
	/**
	 * Recursion method to replace a(one) character given
	 * @param str users message
	 * @param oldChar to be replaced
	 * @param newChar replacing old character
	 * @return new string
	 */
	public static String replace(String str, Character oldChar, Character newChar)
	{
		if (str.equals(null) || str.equals(" "))
		{
			return str;
		}
		
		else if (oldChar.equals(str.charAt(0)))
		{
			return newChar + str.substring(1);
		}
		
		else
		{
			return str.charAt(0) + replace(str.substring(1), oldChar, newChar);
		}
	}
	/**
	 * Recursion method that will replace all specified characters
	 * @param str users message
	 * @param oldChar to be replaced
	 * @param newChar replacing old character
	 * @return new string with all letters replaced
	 */
	public static String replaceAll(String str, Character oldChar, Character newChar)
	{
		int indexPosition = str.indexOf(oldChar);
		if(indexPosition < 1)
		{
			return str;
		}
		else
		{
			return str.substring(0, indexPosition) + newChar + replaceAll(str.substring(indexPosition + 1), oldChar, newChar);
		}
		
	}

}
