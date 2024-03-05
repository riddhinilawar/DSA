Given a stack, the task is to sort it such that the top of the stack has the greatest element.

Example 1:

Input:
Stack: 3 2 1
Output: 3 2 1
Example 2:

Input:
Stack: 11 2 32 3 41
Output: 41 32 11 3 2
Your Task: 
You don't have to read input or print anything. Your task is to complete the function sort() which sorts the elements present in the given stack. (The sorted stack is printed by the driver's code by popping the elements of the stack.)

Expected Time Complexity: O(N*N)
Expected Auxilliary Space: O(N) recursive.

Constraints:
1<=N<=100



class GfG{
	public Stack<Integer> sort(Stack<Integer> s){
	    Stack<Integer> temp = new Stack<>();
		helper(s,temp);
		return s;
	}
	public void helper(Stack<Integer> s,Stack<Integer> temp){
	    if(s.size()==0)return;
	    int curr=s.pop();
	    helper(s,temp);
	    
	    while(!s.isEmpty() && s.peek()>curr){
	        temp.push(s.pop());
	    }
	    s.push(curr);
	    while(!temp.isEmpty()){
	        s.push(temp.pop());
	    }
	}
}
