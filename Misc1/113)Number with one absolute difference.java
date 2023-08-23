Number with one absolute difference ,gfg                                                                      
Given a number N. The task is to return all the numbers less than or equal to N in increasing order, with the fact that absolute difference between any adjacent digits of number should be 1.
Example 1:  Input: N = 20  Output: 10 12    Explanation: Diff between 1 and 0 and, Diff between 1 and 2 is one.
Example 2:  Input:  N = 9   Output: -1          Explanation: No such number exist.
Your Task:
You don't need to read input or print anything. Your task is to complete the function absDifOne() which takes an integer as input and returns a list of numbers.
Expected Time Complexity : O(2Number of Digits in N)
Expected Auxiliary Space : O(2Number of Digits in N)
Constraints:
1 <= N <= 1012
Expected Time Complexity: O(2Number of Digits in N)
Expected Auxiliary Space: O(2Number of Digits in N)
Time complexity: O(N)
class Solution{
    ArrayList<Long> absDifOne(long N){
    ArrayList<Long> ans=new ArrayList<Long>();
        if(N<=9)
        {
            ans.add((long)-1);
            return ans;
        }
        for(int i=10;i<=N;i++)
        {
            if(stepNum(i)==true)ans.add((long)i);
        }
        return ans;
    }
    boolean stepNum(int num)
    {
        int prev=num%10;
        num=num/10;
        while(num>0)
        {
            int temp= num%10;
            num=num/10;
            if(Math.abs(prev-temp)!=1)return false;
            prev=temp;
        }
        return true;
    }
}
