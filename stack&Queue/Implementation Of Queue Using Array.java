public class ImplementationOfQueueUsingArray {
	int arr[]=new int[5];
	int front=0;
	int rear=0;
	public void enqueue(int n)
	{
		if(rear<5)
		{
			if(rear==-1)rear=0;
			arr[rear]=n;
			rear++;
		}
		else
		{
			System.out.println("Queue is full");
		}
	}
	public int dequeue()
	{
		int temp=-1;
		if(rear<=0)
		{
			System.out.println("Queue is empty");
		}
		else
		{
			temp=arr[0];
			
			for(int i=0;i<rear-1;i++)
				arr[i]=arr[i+1];
			
			arr[rear]=0;
			
			rear--;
			System.out.println(rear+"--rear");
		}
		return temp;
	}
	public int top()
	{
		int temp=-1;
		if(rear==-1)
		{
			System.out.println("Queue is empty");
		}
		else
		{
			temp=arr[0];
		}
		return temp;
	}
	public static void main(String args[])
	{
		ImplementationOfQueueUsingArray obj=new ImplementationOfQueueUsingArray();
		obj.enqueue(4);
		obj.enqueue(3);
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		obj.enqueue(5);
		
	}
}
