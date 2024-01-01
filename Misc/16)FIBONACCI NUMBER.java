FIBONACCI NUMBER,gfg              LC-509               
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).
 
Example 1:
Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:
Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:
Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 
Constraints:
•	0 <= n <= 30
class Solution {
    public int fib(int n) {
        if(n==0)return 0;
        if(n==1)return 1;
        
        int prev1=0;
        int prev2=1;
        int count=1;
        int temp=0;
        
        while(count<n)
        {
            temp=prev1+prev2;
            prev1=prev2;
            prev2=temp;
            count++;
        }
        
        return temp;
    }
}

=================================================================================================================================================================


class fibonacci {
    static int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }
 
    public static void main(String args[])
    {
        int n = 5;
        System.out.println(
            n + "th Fibonacci Number: " + fib(n));
    }
}
Expected Time Complexity: O(N), for recursive: O(2power n)
Expected Auxiliary Space: O(1), for recusrive: O(logn)

