import java.util.Stack;
//tc: O(1) -->amatised ,sc: 0(2N)
public class ImplementQueueUsingStack2 {
	
	Stack<Integer> input=new Stack<Integer>();
	Stack<Integer> output=new Stack<Integer>();
	
	public void Enqueue(int n)
	{
		
		input.push(n);
		System.out.println(n+" -push");
	}
	public int Dequeue()
	{
		if(output.isEmpty()==false)
		{
			return output.pop();
		}
		else
		{
			if(input.size()==0)
			{
				return -1;
			}
			else
			{
				while(input.isEmpty()==false)
				{
					int temp=input.pop();
					output.push(temp);
				}
				return output.pop();
			}
		}
	}
	public int topForQueue()
	{
		
		if(output.isEmpty()==false)
		{
			return output.peek();
		}
		else
		{
			if(input.size()==0)
			{
				return -1;
			}
			else
			{
				while(input.isEmpty()==false)
				{
					int temp=input.pop();
					output.push(temp);
				}
				return output.peek();
			}
		}
	}
	
	public static void main(String args[])
	{
		ImplementQueueUsingStack2 obj= new ImplementQueueUsingStack2();
		obj.Enqueue(2);
		obj.Enqueue(5);
		obj.Enqueue(3);
		System.out.println(obj.topForQueue()+"--top");
		System.out.println(obj.Dequeue()+"--pop");
		obj.Enqueue(6);
		System.out.println(obj.Dequeue()+"--pop");
		System.out.println(obj.Dequeue()+"--pop");
		System.out.println(obj.topForQueue()+"--top");
		obj.Enqueue(7);
		System.out.println(obj.Dequeue()+"--pop");
		System.out.println(obj.topForQueue()+"--top");
		System.out.println(obj.Dequeue()+"--pop");
		
		
	}
}
