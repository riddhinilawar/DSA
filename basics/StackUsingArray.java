package basics;
class Stackuarray
{
	private int top=-1;
	private int stack[]=new int[5];
	public void push(int data)
	{
		if(top<4)
		{
			top++;
			stack[top]=data;
		}
		else
		{
			System.out.println("Stack overflow");
		}
	}
	public int pop()
	{
		int temp=-1;
		if(top>-1)
		{
			temp=stack[top];
			top--;
		}
		else
		{
			System.out.println("Stack Underflow");
		}
		return temp;
	}
	public void peek()
	{
		if(top>-1)
		{
			System.out.println("peek:"+stack[top]);
		}
		else
		{
			System.out.println("Stack Underflow");
		}
	}
	public boolean isempty()
	{
		if(top<=-1)
			return true;
		else
			return false;
	}
}
public class StackUsingArray {
	public static void main(String args[])
	{
		Stackuarray s=new Stackuarray();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.isempty());
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		System.out.println(s.pop());
		s.peek();
	}
}
