package linkedlist;

class LL3 {
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
	public void fun1(int m,int n)
	{
		Node temp=start;
		while(n!=1)
		{
			temp=temp.next;
			n--;
		}
		Node temp1=temp;
		while(m!=0)
		{
			temp1=temp1.next;
			m--;
		}
		temp.next=temp1.next;
		
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
public class Delete_m_nodes_after_n_nodes_of_linkedlist {
	public static void main(String args[])
	{
		LL3 l=new LL3();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		l.add(60);
		l.add(70);
		l.add(80);
		l.fun1(2,3);
		l.display();
	}
}

