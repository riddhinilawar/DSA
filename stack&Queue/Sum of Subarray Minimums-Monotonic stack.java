907. Sum of Subarray Minimums
Solved
Medium
Topics
Companies
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

 

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444
 

Constraints:

1 <= arr.length <= 3 * 104
1 <= arr[i] <= 3 * 104

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int prevSmall[]=new int[n];
        int nextSmall[]=new int[n];

        Stack<Pair> stack1= new Stack<>();
        Stack<Pair> stack2= new Stack<>();

        for(int i=0;i<n;i++){
            if(stack1.isEmpty()){
                prevSmall[i]=-1;
            }
            else{
                while(!stack1.isEmpty() && stack1.peek().num>=arr[i])
                    stack1.pop();
                if(stack1.isEmpty())
                    prevSmall[i]=-1;
                else
                    prevSmall[i]=stack1.peek().idx;
            }
            stack1.push(new Pair(arr[i],i));

            int j=n-1-i;
            if(stack2.isEmpty()){
	            nextSmall[j]=n;
            }
            else{
	            while(!stack2.isEmpty() && stack2.peek().num>arr[j])
	                stack2.pop();
	            if(stack2.isEmpty())
	                nextSmall[j]=n;
	            else
	                nextSmall[j]=stack2.peek().idx;
            }
            stack2.push(new Pair(arr[j],j));
        }

        long ans=0;
        int mod=(int) 1e9 + 7;
        for(int i=0;i<n;i++){
            int prev=i-prevSmall[i];
            int next=nextSmall[i]-i;
            int total=prev*next;
            //System.out.println(prevSmall[i]+" "+nextSmall[i]+" "+next+" "+prev+" "+total);
            ans=(ans%mod+((long)arr[i]%mod*(long)total%mod)%mod)%mod;
        }

        return (int)ans;

    }
}
class Pair{
    int num;
    int idx;
    Pair(int num,int idx){
        this.num=num;
        this.idx=idx;
    }
}
