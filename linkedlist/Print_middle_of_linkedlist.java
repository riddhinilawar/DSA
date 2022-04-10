package linkedlist;
//Find the middle of the given linkedlist
class LinkedList1
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
		Node onestep=start;
		Node twostep=start;
		//System.out.println(onestep.data+" "+twostep.data);
		while(twostep!=null&&twostep.next!=null)
		{
			onestep=onestep.next;
			twostep=(twostep.next).next;
			//System.out.println(onestep.data+" "+twostep.data);
		}
		System.out.println("middle element:"+onestep.data);
	}
}
public class Print_middle_of_linkedlist {
	public static void main(String args[])
	{
		LinkedList1 l=new LinkedList1();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		l.add(60);
		l.fun1();
	}
}
