package linkedlist;
class LL
{
	private Node start;
	private Node last;
	private class Node
	{
		int c_data;
		int p_data;
		Node next;
		Node(int c_data,int p_data)
		{
			this.c_data=c_data;
			this.p_data=p_data;
			this.next=null;
		}
	}
	public void add(int c_data,int p_data)
	{
		Node node=new Node(c_data,p_data);
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
			System.out.println("Expression:");
		Node temp=start;
		while(temp!=null)
		{
			if(temp.next!=null)
				System.out.print(temp.c_data+"pow"+temp.p_data+" + ");
			else
				System.out.print(temp.c_data+"pow"+temp.p_data);
			temp=temp.next;
		}
		System.out.println();
		}
	}
	public void add_polynomial(LL expression1, LL expression2,LL expression3) {
		Node temp1=expression1.start;
		Node temp2=expression2.start;
		while(temp1!=null||temp2!=null)
		{
			int temp=0;
			if(temp1.p_data==temp2.p_data)
			{
				temp=temp1.c_data+temp2.c_data;
				if(temp1.next!=null&&temp2.next!=null)
				{
					System.out.print(temp+"pow"+temp1.p_data+" + ");
					expression3.add(temp,temp1.p_data);
				}
				else
				{
					System.out.print(temp+"pow"+temp1.p_data);
					expression3.add(temp,temp1.p_data);
				}
				temp1=temp1.next;
				temp2=temp2.next;
			}
			else if(temp1.p_data>temp2.p_data)
			{
				temp=temp1.c_data;
				if(temp1.next!=null)
				{
					System.out.print(temp+"pow"+temp1.p_data+" + ");
					expression3.add(temp,temp1.p_data);
				}
				else
				{
					System.out.print(temp+"pow"+temp1.p_data);
					expression3.add(temp,temp1.p_data);
				}
				temp1=temp1.next;
			}
			else
			{
				temp=temp2.c_data;
				if(temp2.next!=null)
				{
					System.out.print(temp+"pow"+temp2.p_data+" + ");
					expression3.add(temp,temp2.p_data);
				}
				else
				{
					System.out.print(temp+"pow"+temp2.p_data);
					expression3.add(temp,temp2.p_data);
				}
				temp2=temp2.next;
			}
		}
	}
}
public class Polynomial_Addition {
	public static void main(String args[])
	{
		LL expression1=new LL();
		expression1.add(5,3);
		expression1.add(7,2);
		expression1.add(4,1);
		expression1.add(9,0);
		expression1.display();
		
		LL expression2=new LL();
		expression2.add(8,4);
		expression2.add(8,3);
		expression2.add(5,2);
		expression2.add(3,0);
		expression2.display();
		
		LL expression3=new LL();
		expression3.add_polynomial(expression1,expression2,expression3);
		System.out.println();
		expression3.display();
	}
}