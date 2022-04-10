package linkedlist;
//remove duplicate elements from sorted linkedlist.
class LL1 {
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
			last=node;
		}
		else
		{
			last.next=node;
			last=node;
		}
	}
	public void fun1()
	{
		{
			Node temp1=start;
			Node temp2=temp1.next;
			while(temp2!=null)
			{
				if(temp1.data==temp2.data)
				{
					temp1.next=temp2.next;
					temp2=temp2.next;
				}
				else
				{
					temp1=temp1.next;
					temp2=temp2.next;
				}
				
			}
			
		}
	}
	public void display()
	{
		Node temp=start;
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp=temp.next;
			
		}
	}
}
public class Remove_duplicate_elements_from_sorted_linkedlist {
	public static void main(String args[])
	{
		LL1 l=new LL1();
		l.add(10);
		l.add(10);
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(30);
		l.fun1();
		l.display();
	}
}
