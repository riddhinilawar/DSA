Given an array, print the Next Greater Element (NGE) for every element. 

The Next greater Element for an element x is the first greater element on the right side of x in the array. Elements for which no greater element exist, consider the next greater element as -1. 

Example: 

Input: arr[] = [ 4 , 5 , 2 , 25 ]
Output:        [ 5, 25, 25, -1]
Explanation: except 25 every element has an element greater than them present on the right side

Input: arr[] = [ 13 , 7, 6 , 12 ]
Output:        [-1 , 12, 12, -1]
Explanation: 13 and 12 don’t have any element greater than them present on the right side

  
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterElement {
	public static void main(String args[])
	{
		int arr[]= {4,12,5,3,1,2,5,3,1,2,4,6};
		Stack<Integer> s=new Stack<Integer>();
		ArrayList a=new ArrayList<>();
		for(int i=arr.length-1;i>=0;i--)
		{
			if(s.isEmpty()==true)
			{
				s.push(arr[i]);
				a.add(-1);
			}
			else
			{
				if(arr[i]<s.peek())
				{
					a.add(s.peek());
					s.push(arr[i]);
				}
				else if(arr[i]>s.peek())
				{
					while(s.isEmpty()==false)
					{
						if(arr[i]<s.peek())
						{
							break;
						}
						s.pop();
					}
					if(s.isEmpty()==false)a.add(s.peek());else a.add(-1);
					s.push(arr[i]);
				}
			}
		}
		Collections.reverse(a);
		System.out.println(a);
	}
}


import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterElement {
	public static void main(String args[])
	{
		int arr[]= {4,12,5,3,1,2,5,3,1,2,4,6};
		Stack<Integer> s=new Stack<Integer>();
		ArrayList a=new ArrayList<>();
		for(int i=arr.length-1;i>=0;i--)
		{
			if(s.isEmpty()==true)
			{
				s.push(arr[i]);
				a.add(-1);
			}
			else
			{
				if(arr[i]<s.peek())
				{
					a.add(s.peek());
					s.push(arr[i]);
				}
				else if(arr[i]>s.peek())
				{
					while(s.isEmpty()==false)
					{
						if(arr[i]<s.peek())
						{
							break;
						}
						s.pop();
					}
					if(s.isEmpty()==false)a.add(s.peek());else a.add(-1);
					s.push(arr[i]);
				}
			}
		}
		Collections.reverse(a);
		System.out.println(a);
	}
}
