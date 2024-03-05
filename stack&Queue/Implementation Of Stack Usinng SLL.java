public class ImplementationOfStackUsinngSLL {
	Node top=null;
	int noofnode=0;
	class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data=data;
			this.next=null;
		}
	}
	public void push(int data)
	{
		if(noofnode>9)
		{
			System.out.println("stack overflow");
		}
		else
		{
		Node node=new Node(data);
		if(top==null)
		{
			node.next=null;
			top=node;
			noofnode=noofnode+1;
			System.out.println("noofnode: "+noofnode);
		}
		else
		{
			node.next=top;
			top=node;
			noofnode=noofnode+1;
			System.out.println("noofnode: "+noofnode);
		}
		}
	}
	public int pop()
	{
		if(top==null)
		{
			System.out.print("Stack underflow: ");
			return -1;
		}
		else
		{
			System.out.println("noofnode: "+noofnode);
			int data=top.data;
			top=top.next;
			noofnode=noofnode-1;
			
			return data; 
		}
	}
	public int peek()
	{
		return top.data;
	}
	public boolean isempty()
	{
		return top==null;
	}
	public void display()
	{
		Node temp=top;
		System.out.print("Display: ");
		while(temp!=null)
		{
			System.out.print(temp.data);
			temp=temp.next;
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		ImplementationOfStackUsinngSLL s=new ImplementationOfStackUsinngSLL();
		s.push(0);
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.pop()+" is poped");
		System.out.println(s.peek()+" is peek");
		s.push(4);
		s.push(5);
		System.out.println(s.peek()+" is peek");
		System.out.println(s.pop()+" is poped");
		System.out.println(s.pop()+" is poped");
		System.out.println(s.pop()+" is poped");
		System.out.println(s.pop()+" is poped");
		System.out.println(s.pop()+" is poped");
		System.out.println(s.pop()+" is poped");
		s.push(0);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.push(7);
		s.push(8);
		s.push(9);
		s.push(11);
		s.push(12);
		s.display();
		System.out.println(s.pop()+" is poped");
		System.out.println(s.pop()+" is poped");
		System.out.println(s.pop()+" is poped");
		s.display();
	}
}
