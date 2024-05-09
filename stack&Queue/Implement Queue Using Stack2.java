import java.util.Stack;
//tc: O(1) -->amatised ,sc: 0(2N)
public class ImplementQueueUsingStack2 {
	
	Stack<Integer> input=new Stack<Integer>();
	Stack<Integer> output=new Stack<Integer>();
	
	public void Enqueue(int n)
	{
		
		input.push(n);
		System.out.println(n+" -push");
	}
	public int Dequeue()
	{
		if(output.isEmpty()==false)
		{
			return output.pop();
		}
		else
		{
			if(input.size()==0)
			{
				return -1;
			}
			else
			{
				while(input.isEmpty()==false)
				{
					int temp=input.pop();
					output.push(temp);
				}
				return output.pop();
			}
		}
	}
	public int topForQueue()
	{
		
		if(output.isEmpty()==false)
		{
			return output.peek();
		}
		else
		{
			if(input.size()==0)
			{
				return -1;
			}
			else
			{
				while(input.isEmpty()==false)
				{
					int temp=input.pop();
					output.push(temp);
				}
				return output.peek();
			}
		}
	}
	
	public static void main(String args[])
	{
		ImplementQueueUsingStack2 obj= new ImplementQueueUsingStack2();
		obj.Enqueue(2);
		obj.Enqueue(5);
		obj.Enqueue(3);
		System.out.println(obj.topForQueue()+"--top");
		System.out.println(obj.Dequeue()+"--pop");
		obj.Enqueue(6);
		System.out.println(obj.Dequeue()+"--pop");
		System.out.println(obj.Dequeue()+"--pop");
		System.out.println(obj.topForQueue()+"--top");
		obj.Enqueue(7);
		System.out.println(obj.Dequeue()+"--pop");
		System.out.println(obj.topForQueue()+"--top");
		System.out.println(obj.Dequeue()+"--pop");
		
		
	}
}


===========================================through recursion get the last value and return==============================================

public class QueueUsingSingleStack {
 
    Stack<Integer> stack = new Stack<>();
 
    private void enqueue(int i) {
        stack.push(i);
    }
 
    private int dequeue() throws Exception {
        if (stack.size() == 0)
            throw new Exception("Queue is Empty");
 
        if (stack.size() == 1)
            return stack.pop();
 
        int data = stack.pop();
        int retVal = dequeue();
        stack.push(data);
        return retVal;
    }
 
    public static void main(String[] args) throws Exception {
        QueueUsingSingleStack queue = new QueueUsingSingleStack();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
 
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
 
    }
 
}
has context menu
=======================================using single stack==========================
However, note that removing elements from the middle of a stack (removeElementAt(0))
is less efficient than using two stacks for queue operations. 
This optimization sacrifices some efficiency for space savings.
	
import java.util.Stack;

class MyQueue {
    private Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<>();
    }

    public void enqueue(int x) {
        stack.push(x);
    }

    public int dequeue() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int front = peek();
        stack.removeElementAt(0); // Remove the element at index 0 (top of the stack)
        return front;
    }

    public int peek() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return stack.get(0); // Get the element at index 0 (top of the stack)
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

