import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue2 {
	Queue<Integer> q1=new LinkedList<Integer>();
	
	public void push(int n)
	{
		q1.add(n);
		
		if(q1.size()>1)
		{
			int count=q1.size()-1;
			while(count!=0)
			{
				int temp=q1.remove();
				q1.add(temp);
				count--;
			}
		}
		
		
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
		ImplementStackUsingQueue2  obj= new ImplementStackUsingQueue2 ();
		
		obj.push(3);
		obj.push(4);
		obj.push(2);
		obj.push(1);
		obj.push(5);
		System.out.println(obj.peek());
		obj.pop();
		System.out.println(obj.peek());
	}
}
