package stack;
import java.util.Scanner;
import java.util.Stack;

public class PranthesisBalancing {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		sc.close();
		int flag=0;
		Stack stack=new Stack();
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='['||s.charAt(i)=='{'||s.charAt(i)=='(')
				stack.push(s.charAt(i));
			else
			{
				if(s.charAt(i)==']'||s.charAt(i)=='}'||s.charAt(i)==')')
				if(stack.isEmpty()==true)
				{
					flag=1;
				}
				else
				{
					stack.pop();
				}
			}
		}
		if(stack.isEmpty()==true&&flag==0)
		{
			System.out.println("Balanced");
		}
		else
		{
			System.out.println("Unbalanced");
		}
	}
}