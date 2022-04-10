package stack;
import java.util.*;
public class CheckPalindrome {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		sc.close();
		Stack stack=new Stack();
		for(int i=0;i<s.length();i++)
		{
			stack.push(s.charAt(i));
		}
		String rev="";
		while(stack.isEmpty()==false)
		{
			rev=rev+stack.pop();
		}
		//System.out.println(rev);
		if(rev.equals(s))
		{
			System.out.println("palindrome");
		}
		else
		{
			System.out.println("not palindrome");
		}
	}
}
