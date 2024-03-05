We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 

Constraints:

2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0



class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack<>();


        for(int i=0 ; i<asteroids.length ; i++){
            boolean flag=false;
            if(!stack.isEmpty() &&  stack.peek()>0 && asteroids[i]<0 )
            {
                while(!stack.isEmpty() &&  stack.peek()>0 && asteroids[i]<0){
                    if(Math.abs(stack.peek()) >= Math.abs(asteroids[i])){
                        if(stack.peek() == -asteroids[i])stack.pop();
                         flag=false;
                        break;
                    }
                    else{
                        stack.pop();
                        flag=true;
                    }
                }
                if(flag==true)stack.push(asteroids[i]);
            }
            else{
                stack.push(asteroids[i]);
            }
        }
        int ans[]=new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--){
            ans[i]=stack.pop();
        }
        return ans;
    }
}
=========================================================================================

import java.util.Stack;

public class AsteroidCollision {
	public static void main(String args[]){
    
		int arr[]={-5,5,10,-5};// {10,6,-8,-8,8,9};
		Stack<Integer> s=new Stack<Integer>();

		for(int i=0;i<arr.length;i++){
      
			int curr=arr[i];
			
      if(s.isEmpty()==false)
			{
				if(-(curr)==s.peek())
				{
					s.pop();

				}
				else if(curr>0 && s.peek()>0)
				{
					s.push(curr);

				}
				else if(curr<0 && s.peek()<0)
				{
					s.push(curr);

				}
				else
				{
					int curr1=Math.abs(curr);
					int	temp1=Math.abs(s.peek());

					if(curr1>temp1)
					{
						s.pop();
						i--;
					}

				}
			}
			else
			{
				s.push(curr);

			}
		}

		//System.out.println(s);
	}
}
