package basics;
class CircularLL
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
		}
	}
	public void add(int data)
	{
		Node node=new Node(data);
		if(start==null)
		{
			start=node;
			last=node;
			node.next=start;
		}
		else
		{
			last.next=node;
			node.next=start;
			last=node;
		}
	}
	public void add(int pos,int data)
	{
		Node node=new Node(data);
		int flag=0;
		int count=1;
		if(start==null&&pos==1)
		{
			start=node;
			last=node;
			last.next=start;
			flag=1;
		}
		else if(start!=null&&pos==1)
		{
			node.next=start;
			start=node;
			last.next=start;
			flag=1;
		}
		else
		{
			Node temp=start;
			Node prev=start;
			do
			{
				if(count==pos)
				{
					prev.next=node;
					node.next=temp;
					flag=1;
				}
				prev=temp;
				temp=temp.next;
				count++;
				if(count==pos&&prev==last)
				{
					flag=1;
					prev.next=node;
					node.next=start;
					last=node;
				}
			}while(temp!=start);
		}
		if(flag==0)
		{
			System.out.println("data was not found");
		}
	}
	public boolean search(int data)
	{
		if(isempty()==false)
		{
			Node temp=start;
			do
			{
				if(temp.data==data)
					return true;
				temp=temp.next;
			}while(temp!=start);
		}
		return false;
	}
	public void delete(int data)
	{
		if(isempty()==false)
		{
			int flag=0;
			if(start.next==start&&start.data==data)
			{
				start=null;
				last=null;
				flag=1;
			}
			else
			{
				Node temp=start;
				Node prev=start;
				do
				{
					if(temp.data==data)
					{
						flag=1;
						if(data==start.data)
						{
							start=start.next;
							last.next=start;
						}
						else if(data==last.data)
						{
							last=prev;
							last.next=start;
						}
						else
						{
							prev.next=temp.next;
						}
					}
					prev=temp;
					temp=temp.next;
				}while(temp!=start);
			}
			if(flag==0)
			{
				System.out.println("data was not found");
			}
		}
	}
	public void display()
	{
		if(isempty()==false)
		{
			Node temp=start;
			do
			{
				System.out.println(temp.data);
				temp=temp.next;
			}while(temp!=start);
		}
	}
	public boolean isempty()
	{
		if(start==null)
		{
			System.out.println("Circular LinkedList is empty.");
			return true;
		}
		else
			return false;
	}
}
public class CircularLinkedList
{
	public static void main(String args[])
	{
		CircularLL cll=new CircularLL();
		cll.add(10);
		cll.add(20);
		cll.add(30);
		cll.add(40);
		cll.add(1,5);
		cll.add(6,2);
		cll.display();
		cll.add(70);
		cll.add(7,3);
		cll.add(9,4);
		cll.delete(4);
		cll.display();
	}
}