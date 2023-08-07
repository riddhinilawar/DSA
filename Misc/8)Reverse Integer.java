Reverse Integer                        LC-7
class Solution {
    public int reverse(int x) {
        int flag=0;
        if(x<0)
        {
            x=-x;
            flag=1;
        }    
        long ans=0;
        while(x>0)
        {
            ans=(ans*10)+(x%10);
            x=x/10;
        }
        if(flag==1)
            ans= -ans;
        if(ans>=Integer.MAX_VALUE||ans<=Integer.MIN_VALUE)
            return 0;
        else
            return (int)ans;
    }
}
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 
Example 1:
Input: x = 123
Output: 321
Example 2:
Input: x = -123
Output: -321
Example 3:
Input: x = 120
Output: 21
 
Constraints:
•	-231 <= x <= 231 - 1
Exception: if no pipe symbol is found return 0.
Remember : always even number of pipes will be present in the string.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
