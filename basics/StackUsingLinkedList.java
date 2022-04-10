package basics;
class Stack1
{
	private Node top;
	private class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data=data;
		}
	}
	public void push(int data)
	{
		Node node=new Node(data);
		if(top==null)
		{
			top=node;
			top.next=null;
		}
		else
		{
			node.next=top;
			top=node;
		}
	}
	public int pop()
	{
		int temp=-1;
		if(top==null)
		{
			System.out.println("Stack underflow");
		}
		else
		{
			temp=top.data;
			top=top.next;
		}
		return temp;
	}
	public void isempty()
	{
		if(top==null)
		{
			System.out.println("Stack is empty");
		}
	}
	public void peek()
	{
		if(top==null)
		{
			System.out.println("Stack is empty");
		}
		else
		{
			System.out.println(top.data);
		}
	}
	public void display()
	{
		if(top==null)
		{
			System.out.println("Stack is empty");
		}
		else
		{
			Node temp=top;
			while(temp!=null)
			{
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
			System.out.println();
		}
	}
}
public class StackUsingLinkedList {
	public static void main(String args[])
	{
		Stack1 stack=new Stack1();
		System.out.println(stack.pop());
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.display();
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push(60);
		System.out.println(stack.pop());
		
	}
}
