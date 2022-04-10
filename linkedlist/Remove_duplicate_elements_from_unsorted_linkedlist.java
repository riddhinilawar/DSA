package linkedlist;

//remove duplicate elements from unsorted linkedlist.
class LL2 {
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
			for(Node t1=start;t1!=null;t1=t1.next)
			{
				for(Node t2=t1.next;t2!=null;t2=t2.next)
				{
					//System.out.println(t1.data+" "+t2.data);
					if(t1.data==t2.data)
					{
						t1.next=t2.next;	
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
public class Remove_duplicate_elements_from_unsorted_linkedlist {
	public static void main(String args[])
	{
		LL2 l=new LL2();
		l.add(60);
		l.add(60);
		l.add(10);
		l.add(20);
		l.add(60);
		l.add(50);
		l.add(50);
		l.add(50);
		l.add(50);
		l.add(70);
		l.add(20);
		l.add(20);
		l.add(10);
		l.add(10);
		
		l.fun1();
		l.display();
	}
}
