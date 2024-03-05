import java.util.Stack;
//tc: O(N) sc: 0(2N)
public class ImplementQueueUsingStack1 {
	
	Stack<Integer> s1=new Stack<Integer>();
	Stack<Integer> s2=new Stack<Integer>();
	
	public void Enqueue(int n)
	{
		
		while(s1.isEmpty()==false)
		{
			int temp=s1.pop();
			s2.push(temp);
		}
		
		s1.push(n);
		
		while(s2.isEmpty()==false)
		{
			int temp=s2.pop();
			s1.push(temp);
		}
		
	}
	public int Dequeue()
	{
		if(s1.isEmpty()==false)
		{
			return s1.pop();
		}
		else
			return -1;
	}
	public int topForQueue()
	{
		if(s1.isEmpty()==false)
		{
			return s1.peek();
		}
		else
			return -1;
	}
	
	public static void main(String args[])
	{
		ImplementQueueUsingStack1 obj= new ImplementQueueUsingStack1();
		obj.Enqueue(4);
		obj.Enqueue(3);
		obj.Enqueue(2);
		System.out.println(obj.topForQueue());
		obj.Dequeue();
		System.out.println(obj.topForQueue());
		obj.Dequeue();
		System.out.println(obj.topForQueue());
		
		
	}
}
