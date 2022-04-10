package basics;
class Queue1
{
	private Node front;
	private Node rear;
	private class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data=data;
		}
	}
	public void enqueue(int data)
	{
		Node node=new Node(data);
		if(front==null&&rear==null)
		{
			front=rear=node;
			node.next=null;
		}
		else
		{
			node.next=rear;
			rear=node;
		}
	}
	public void dequeue()
	{
		if(front==null&&rear==null)
		{
			System.out.println("Queue is empty");
		}
		else if(front==rear)
		{
			front=rear=null;
		}
		else
		{
			rear=rear.next;
		}
	}
	public void disp()
	{
		if(front==null&&rear==null)
		{
			System.out.println("Queue is empty");
		}
		else
		System.out.println(front.data+" "+rear.data);
	}
}
public class QueueUsingLinkedList {
	public static void main(String args[])
	{
		Queue1 queue=new Queue1();
		queue.dequeue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.dequeue();
		queue.disp();
		queue.enqueue(40);
		queue.disp();
		queue.dequeue();
		queue.disp();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.dequeue();
		queue.disp();
	}
}
