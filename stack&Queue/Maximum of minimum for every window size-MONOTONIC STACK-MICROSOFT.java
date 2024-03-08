Maximum of minimum for every window size

NOTE: find prev smaller and next smallet using stack..get the window for every elemnt..that element can window is the one where it can place at max..for some you may find less or zero in that case just check with next..if its greater replace

Given an integer array. The task is to find the maximum of the minimum of every window size in the array.
Note: Window size varies from 1 to the size of the Array.

Example 1:

Input:
N = 7
arr[] = {10,20,30,50,10,70,30}
Output: 70 30 20 10 10 10 10 
Explanation: 
1.First element in output
indicates maximum of minimums of all
windows of size 1.
2.Minimums of windows of size 1 are {10},
 {20}, {30}, {50},{10}, {70} and {30}. 
 Maximum of these minimums is 70. 
3. Second element in output indicates
maximum of minimums of all windows of
size 2. 
4. Minimums of windows of size 2
are {10}, {20}, {30}, {10}, {10}, and
{30}.
5. Maximum of these minimums is 30 
Third element in output indicates
maximum of minimums of all windows of
size 3. 
6. Minimums of windows of size 3
are {10}, {20}, {10}, {10} and {10}.
7.Maximum of these minimums is 20. 
Similarly other elements of output are
computed.
Example 2:

Input:
N = 3
arr[] = {10,20,30}
Output: 30 20 10
Explanation: First element in output
indicates maximum of minimums of all
windows of size 1.Minimums of windows
of size 1 are {10} , {20} , {30}.
Maximum of these minimums are 30 and
similarly other outputs can be computed
Your Task:
The task is to complete the function maxOfMin() which takes the array arr[] and its size N as inputs and finds the maximum of minimum of every window size and returns an array containing the result. 

Expected Time Complxity : O(N)
Expected Auxilliary Space : O(N)

Constraints:
1 <= N <= 105
1 <= arr[i] <= 106


class Solution {
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n) {
        int prevSmaller[]=new int[n];
        int nextSmaller[]=new int[n];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<n;i++){
            
            if(stack.isEmpty()){
                prevSmaller[i]=-1;
                stack.push(i);
                continue;
            }
            
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                prevSmaller[i]=-1;
                stack.push(i);
                continue;
            }
            prevSmaller[i]=stack.peek();
            stack.push(i);
        }
        
        
        stack = new Stack<>();
        
        for(int i=n-1;i>=0;i--){
            
            if(stack.isEmpty()){
                nextSmaller[i]=-1;
                stack.push(i);
                //System.out.println(prevSmaller[i]+" "+nextSmaller[i]);
                continue;
            }
            
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                nextSmaller[i]=-1;
                stack.push(i);
                //System.out.println(prevSmaller[i]+" "+nextSmaller[i]);
                continue;
            }
            nextSmaller[i]=stack.peek();
            stack.push(i);
            //System.out.println(prevSmaller[i]+" "+nextSmaller[i]);
        }
        
        
        int ans[]=new int[n];
        
        for(int i=0;i<n;i++){
            
            int prev=prevSmaller[i];
            int next=nextSmaller[i];
            
            if(next==-1)next=n;
            
            int windowsCover=(next-prev)-1;
            
            ans[windowsCover-1]=Math.max(ans[windowsCover-1],arr[i]);
            
        }
        
        int prev=ans[n-1];
        for(int i=n-2;i>=0;i--){
            //System.out.println("i::"+ans[i]);
            if(ans[i]<prev){
                //System.out.println("IN");
                ans[i]=prev;
            }
            else{
                prev=ans[i];
            }
        }
        
        
        return ans;
    }
}
