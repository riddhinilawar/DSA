package linkedlist;
//Delete middle of linkedlist
class LinkedList2
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
		Node prev=start;
		//System.out.println(onestep.data+" "+twostep.data);
		while(twostep!=null&&twostep.next!=null)
		{
			if(onestep!=start)
			{
				prev=prev.next;
			}
			onestep=onestep.next;
			twostep=(twostep.next).next;
			
			//System.out.println(onestep.data+" "+twostep.data);
		}
		System.out.println("middle element:"+onestep.data);
		System.out.println("prev of middle element:"+prev.data);
		prev.next=onestep.next;
		
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
public class Delete_middle_of_linkedlist {
	public static void main(String args[])
	{
		LinkedList2 l=new LinkedList2();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		l.add(60);
		l.fun1();
		l.display();
	}
}
