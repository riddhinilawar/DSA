package basics;
class LL
{
	private Node start;
	private Node last;
	private class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data=data;
			this.next=null;
		}
	}
	public void add(int data)
	{
		Node node=new Node(data);
		if(start==null)
		{
			start=node;
		}
		else
		{
			Node temp=start;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=node;
		}
		//O(n) time complexity
	}
	public void add1(int data)
	{
		Node node=new Node(data);
		if(start==null)
		{
			start=node;
			last=node;
		}
		else
		{
			last.next =node;
			last=last.next;
		}
		//O(1) time complexity
	}
	public void add2(int pos,int data)
	{
		Node node=new Node(data);
		int count=0;
		if(pos==1)
		{
			Node temp=start;
			start=node;
			start.next=temp;
		}
		else
		{
			Node temp=start;
			while(temp!=null)
			{
				if(count==pos-2)
				{
					Node temp1=temp.next;
					temp.next=node;
					temp=temp.next;
					temp.next=temp1;
				}
				count++;
				temp=temp.next;
			}
		}
		//adding by position
	}
	public void add3(int pos,int data)
	{
		Node node=new Node(data);
		if(pos==1)
		{
			node.next=start;
			start=node;
		}
		else
		{
			Node temp=start;
			int flag=0;
			for(int i=1;i<pos-1;i++)
			{	
				try
				{
					temp=temp.next;
				}
				catch(NullPointerException e)
				{
					System.out.println("position is not presnt");
					flag=1;
					// instead of flag we can write
					//return;
					break;
				}
			}
			if(flag==0)
			{
			node.next=temp.next;
			temp.next=node;
			}
		}
		//adding by position
	}
	public boolean isempty()
	{
		if(start==null)
		{
			System.out.println("List is empty");
			return true;
		}
		else
			return false;
	}
	public void display()
	{
		if(this.isempty()==false)
		{
		Node temp=start;
		while(temp.next!=null)
		{
			System.out.println(temp.data);
			temp=temp.next;
		}
		System.out.println(temp.data);
		}
	}
	public void display1()
	{
		if(this.isempty()==false)
		{
		Node temp=start;
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp=temp.next;
		}
		}
	}
	public void search(int data)
	{
		if(this.isempty()==false)
		{
		Node temp=start;
		int flag=0;
		while(temp!=null)
		{
			if(temp.data==data)
			{
				System.out.println("data is present in the linkedlist");
				flag=1;
				break;
			}
			temp=temp.next;
		}
		if(flag==0)
		{
			System.out.println("data is not present in the linkedlist");
		}
		}
	}
	public void delete(int data)
	{
		if(this.isempty()==false)
		{
			Node temp=start;
			if((temp.data)==data)
			{
				start=temp.next;
			}
			else
			{
				Node prev=temp;
				int flag=0;
				while(temp!=null)
				{
					if(temp.data==data)
					{
						prev.next=temp.next;
						
						System.out.println("data got deleted from the linkedlist");
						flag=1;
						break;
					}
					prev=temp;
					temp=temp.next;
				}
				if(flag==0)
				{
					System.out.println("data is not present in the linkedlist");
				}
			}
		}
	}
}
public class LinkedList {
	public static void main(String args[])
	{
		LL ll=new LL();
		ll.add1(10);
		ll.add1(20);
		ll.add1(30);
		ll.add1(40);
		//ll.display();
		ll.display1();
		ll.search(40);
		ll.delete(20);
		ll.add2(2,5);
		ll.add3(1,500);
		ll.add3(5,500);
		ll.add3(7,1000);
		ll.display1();
	}
}
