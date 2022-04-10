package basics;
class LinkedListL
{
	private Node start;
	private Node last;
	Node onestep;
	Node twostep;
	private class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data=data;
		}
	}
	public void add(int data)
	{
		Node node=new Node(data);
		if(start==null)
		{
			start=node;
			last=node;
			node.next=null;
		}
		else
		{
			last.next=node;
			node.next=null;
			last=node;
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
	public void makeloop()
	{
		Node temp=(start.next).next;
		//System.out.println(temp.data);
		last.next=temp;
	}
	public void detectloop()
	{
		onestep=start;
		twostep=start.next;
		int flag=0;
		System.out.println(onestep.data+" "+twostep.data);
		while(onestep!=twostep)
		{
			onestep=onestep.next;
			twostep=(twostep.next).next;
			System.out.println(onestep.data+" "+twostep.data);
			
			if(onestep.next==null || twostep.next==null)
			{
				System.out.println("loop is not detected in the linkedlist");
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("loop is detected in the linkedlist");
		}
	}
	public void removeloop()
	{
		//System.out.println(onestep.data+" "+twostep.data);
		Node ptr1 = onestep;
        Node ptr2 = onestep;
 
        // Count the number of nodes in loop
        int k = 1, i;
        while (ptr1.next != ptr2) {
            ptr1 = ptr1.next;
            k++;
        }
 
        // Fix one pointer to head
        ptr1 = start;
        //System.out.println(ptr1.data);
 
        // And the other pointer to k nodes after head
        ptr2 = start;
        for (i = 0; i < k; i++) {
            ptr2 = ptr2.next;
        }
        //System.out.println(ptr2.data);
        /*  Move both pointers at the same pace,
         they will meet at loop starting node */
        while (ptr2 != ptr1) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        System.out.println(ptr2.data);
        // Get pointer to the last node
        while (ptr2.next != ptr1) {
            ptr2 = ptr2.next;
        }
 
        /* Set the next node of the loop ending node
         to fix the loop */
        ptr2.next = null;
	}
}
public class LoppDetectionInLinkedList {
	public static void main(String args[])
	{
		LinkedListL ll=new LinkedListL();
		ll.add(10);
		ll.add(20);
		ll.add(30);
		ll.add(40);
		ll.add(50);
		ll.add(60);
		ll.makeloop();
		//ll.display();
		ll.detectloop();
		ll.removeloop();
		ll.display();
	}
}
