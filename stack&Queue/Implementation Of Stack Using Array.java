
public class ImplementationOfStackUsingArray {
	int arr[]=new int[5];
	int index=-1;
	public void push(int n)
	{
		if(index>=5)
		{
			System.out.println("Stack overflow");
		}
		else
		{
			index++;
			arr[index]=n;
			
		}
	}
	public int pop()
	{
		int temp=-1;
		if(index<0)
		{
			System.out.println("Stack underflow");
		}
		else
		{
			temp=arr[index];
			index--;
		}
		return temp;
	}
	public int peek()
	{
		int temp=-1;
		if(index<0)
		{
			System.out.println("Stack underflow");
		}
		else
		{
			temp=arr[index];
		}
		return temp;
	}
	public static void main(String args[])
	{
		ImplementationOfStackUsingArray obj=new ImplementationOfStackUsingArray();
		obj.push(4);
		obj.push(3);
		System.out.println(obj.pop());
		System.out.println(obj.peek());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		obj.push(5);
		System.out.println(obj.pop());
		
	}
}
