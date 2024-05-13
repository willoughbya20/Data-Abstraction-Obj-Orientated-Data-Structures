/**
 * Adam Willoughby
 * Calculator class that has all methods to convert an infix expression into
 * a post infix expression and then will evaluate that expression.
 */

package assg7_willoughbya20;

import java.util.*;


public class Calculator {
	private String infixExpre;
	private String solution = null;
	private String postFixExpre;
	
	/**
	 * default constructor
	 * @param infixExpre 
	 */
	public Calculator (String infixExpre)
	{
		this.infixExpre = infixExpre;
	}
	
	/**
	 * toString method to return the expression
	 */
	@Override
	public String toString()
	{
		return this.infixExpre;
	}
	
	/**
	 * Method that will convert the infix expression to the postinfix
	 * @return true
	 */
	public boolean convertPostfix()
	{
		Stack<Character> stack = new Stack<Character>();
		solution = new String("");
		char oper;
		
		for (int i = 0; i < infixExpre.length(); i++)
		{
			oper = infixExpre.charAt(i);
			
			if(Character.isDigit(oper))
			{
				solution += oper;
			}
			else if (oper =='(')
			{
				stack.push(oper);
			}
			else if (oper == ')')
			{
				while(!stack.isEmpty() && stack.peek() !='(')
				{
					solution += stack.pop();
				}
				stack.pop();
			}
			else
			{
				while(!stack.isEmpty() && precedence(oper) == precedence(stack.peek()))
				{
					solution += stack.pop();
				}
				stack.push(oper);
			}
		}
		
		while(!stack.isEmpty())
		{
			if(stack.peek() == '(')
			{
				throw new IllegalStateException("Invalid Expression");
				
			}
			else if(stack.peek() == ')')
			{
				throw new IllegalStateException("Invalid Expression");
			}
			solution += stack.pop();
		}
		postFixExpre = solution;
		return true;
		
		
	}
	
	
	/**
	 * Method that will return the converted expression if convertPostfix is true
	 * @return postFix expression
	 * @throws IllegalStateException if convertPostfix method is false or this method is called before it
	 */
	public String getPostfix() throws IllegalStateException
	{
		if(convertPostfix())
		{
			return postFixExpre;
		}
		else
		{
			throw new IllegalStateException("Expression not evaluated yet");
		}
	}
	/**
	 * Evaluate method that will evaluate the converted expression
	 * @return evaluated answer
	 * @throws IllegalStateException if convertPostfix method is false
	 */
	
	public int evaluate() throws IllegalStateException
	{
		if(convertPostfix() == false)
		{
			throw new IllegalStateException();
		}
		
		else
		{
			Stack<Integer> stack = new Stack<Integer>();
			StringTokenizer st1 = new StringTokenizer(postFixExpre," ");
			
			while(st1.hasMoreTokens())
			{
				String chr = st1.nextToken();
				if (chr.equals("+") || chr.equals("*") || chr.equals("-") || chr.equals("/"))
				{
					try
					{
						stack.push(Integer.valueOf(chr));
					}
					catch(NumberFormatException e)
					{
						System.out.println(e.getMessage());
					}
				}
				else
				{
					int num = stack.pop();
					int num2 = stack.pop();
					
					switch (chr)
					{
					case "+":
						stack.push(num2 + num);
						break;
					case "-":
						stack.push(num2 - num);
						break;
					case "/":
						stack.push(num2/num);
						break;
					case "*":
						stack.push(num2*num);
						break;
					}
				}
			}
			return stack.pop();
		}
	}
	
	/**
	 * Method that carries our precedences or operators
	 * @param c the operator
	 * @return a 1 or 2(higher precedence) or 0 for none
	 */
	static int precedence(char c)
	{
		switch(c)
		{
		case '+':
			return 1;
		case '-':
			return 1;
		case '*':
			return 2;
		case '/':
			return 2;
		}
		return 0;
	}
	

}
