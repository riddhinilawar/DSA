public class ImplementationOfQueueUsingSLL {
	Node start;
	Node end;
	class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data=data;
			this.next=null;
		}
	}
	public void isempty()
	{
		if(this.start==null&&this.end==null)
			System.out.println("queue is empty");
		else
			System.out.println("queue is not empty");
	}
	public void enqueue(int data)
	{
		Node node=new Node(data);
		
		if(start==null&&end==null)
		{
			start=node;
			start.next=null;
			end=node;
		}
		else
		{
			node.next=end;
			end=node;
		}
	}
	public void dequeue()
	{
		if(start==end)
		{
			start=end=null;
			return;
		}
		Node temp=end;
		while(temp.next!=start)
		{
			temp=temp.next;
		}
		temp.next=null;
		start=temp;
	}
	public void display()
	{
		Node temp=end;
		while(temp.next!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.print(temp.data+" ");
		System.out.println();
	}
	public static void main(String args[])
	{
		ImplementationOfQueueUsingSLL q=new ImplementationOfQueueUsingSLL();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.display();
		q.dequeue();
		q.display();
		q.dequeue();
		q.display();
		q.enqueue(6);
		q.display();
		q.dequeue();
		q.display();
		q.dequeue();
		q.display();
		q.dequeue();
		q.display();
		q.dequeue();
		q.isempty();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.display();
		q.isempty();
	}
}
