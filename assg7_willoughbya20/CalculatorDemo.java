/**
 * Adam Willoughby
 * Main method that will test out our calculator class
 */
package assg7_willoughbya20;

import java.util.Scanner;

public class CalculatorDemo {

	public static void main(String[] args) {
		
		String input = "";
		System.out.println("Type 'stop' to exit. \n");
		Scanner keyboard = new Scanner(System.in);
		do
		{
			System.out.println("Enter an infix expression (no spaces): ");
			input = keyboard.nextLine();
			Calculator calc = new Calculator(input);
			try {
				calc.convertPostfix();
				System.out.println("Conversion to postFix expression: " + calc.getPostfix() + "\n");
				System.out.println("Evaluation: " + calc.evaluate() + "\n");
			}
			catch (IllegalStateException e)
			{
				System.out.println(e.getMessage());
			}
		} while(!input.equals("stop"));
		
		System.exit(1);
		
		keyboard.close();

	}

}
