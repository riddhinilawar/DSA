package basics;
class DLL
{
	private Node start;
	private Node last;
	private class Node
	{
		int data;
		Node prev;
		Node next;
		Node(int data)
		{
			this.data=data;
		}
	}
	public boolean isempty()
	{
		if(start==null)
		{
			System.out.println("Doubly LinkedList is empty");
			return true;
		}
		else
			return false;
	}
	public void add(int data)
	{
		Node node=new Node(data);
		if(start==null)
		{
			start=node;
			last=node;
		}
		else
		{
			last.next=node;
			node.prev=last;
			node.next=null;
			last=node;
		}
	}

	public void add_position(int pos,int data)
	{
		Node node=new Node(data);
		if(pos==1)
		{
			node.prev=null;
			node.next=start;
			start=node;
		}
		else
		{
			Node temp;
			int flag=0;
			int count=1;
			for(temp=start;temp!=null;temp=temp.next)
			{
				if(count==pos)
				{
					break;
				}
				count++;
			}
			if(temp.next!=null)
			{
				Node temp1=temp.next;
				temp.next=node;
				node.prev=temp;
				node.next=temp1;
				temp1.prev=node;
			}
			else
			{
				node.prev=last;
				last.next=node;
				node.next=null;
				last=node;
			}
			if(flag==0)
				System.out.println("The "+pos+" was not found in the doubly linkedlist.");
		}
	}
	public void delete(int data)
	{
		if(isempty()==false)
		{
			if(start.data==data)
			{
				start=start.next;
				start.prev=null;
			}
			else
			{
				Node temp;
				int flag=0;
				for(temp=start;temp!=null;temp=temp.next)
				{
					if(temp.data==data)
					{
						flag=1;
						break;
					}
				}
				if(temp.next!=null)
				{
					Node temp1=temp.prev;
					temp1.next=temp.next;
					Node temp2=temp.next;
					temp2.prev=temp.prev;
				}
				else
				{
					last=last.prev;
					last.next=null;
				}
				if(flag==0)
					System.out.println("The "+data+" was not found in the doubly linkedlist.");
			}
		}
	}
	public void delete_position(int pos)
	{
		if(isempty()==false)
		{
			if(pos==1)
			{
				start=start.next;
				start.prev=null;
			}
			else
			{
				Node temp;
				int flag=0;
				int count=1;
				for(temp=start;temp!=null;temp=temp.next)
				{
					if(count==pos)
					{
						break;
					}
					count++;
				}
				if(temp.next!=null)
				{
					Node temp1=temp.prev;
					temp1.next=temp.next;
					Node temp2=temp.next;
					temp2.prev=temp.prev;
				}
				else
				{
					last=last.prev;
					last.next=null;
				}


				if(flag==0)
					System.out.println("The "+pos+" was not found in the doubly linkedlist.");
			}
		}
	}
	public void search(int data)
	{
		if(isempty()==false)
		{
			int count=1;
			int flag=0;
			for(Node temp=start;temp!=null;temp=temp.next)
			{
				if(temp.data==data)
				{
					System.out.println("The "+data+" found at "+count+" node.");
					flag=1;
				}
				count++;
			}
			if(flag==0)
				System.out.println("The "+data+" was not found in the doubly linkedlist.");
		}
	}
	public void display()
	{
		System.out.println("testing next:");
		Node temp=start;
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp=temp.next;
		}

		System.out.println("testing prev:");
		Node temp1=last;
		while(temp1!=null)
		{
			System.out.println(temp1.data);
			temp1=temp1.prev;
		}
	}
}
public class DoublyLinkedList {
	public static void main(String args[])
	{
		DLL dll=new DLL();
		dll.add(10);
		dll.add(20);
		dll.add(30);
		dll.add(40);
		dll.add(50);
		dll.search(20);
		dll.delete(50);
		dll.display();
		dll.add(60);
		dll.add(70);
		dll.delete_position(1);
		dll.display();
		dll.add_position(3, 100);
		dll.display();
		dll.add_position(5, 101);
		dll.display();
	}
}
