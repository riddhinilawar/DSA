import java.util.*;

public class ImplementStackUsingQueue1 {
	Queue<Integer> q1=new LinkedList<Integer>();
	Queue<Integer> q2=new LinkedList<Integer>();
	
	public void push(int n)
	{
		q2.add(n);
		
		if(q1.size()!=0)
		{
			while(q1.size()!=0)
			{
				int temp=q1.remove();
				q2.add(temp);
			}
		}
		
		Queue<Integer> t=q1;
		q1=q2;
		q2=t;
		
	}
	public int pop()
	{
		return q1.remove();
	}
	public int peek()
	{
		return q1.peek();
	}
	
	public static void main(String args[])
	{
		ImplementStackUsingQueue1 obj= new ImplementStackUsingQueue1();
		
		obj.push(3);
		obj.push(4);
		obj.push(2);
		obj.push(1);
		System.out.println(obj.peek());
		obj.pop();
		System.out.println(obj.peek());
	}
}
