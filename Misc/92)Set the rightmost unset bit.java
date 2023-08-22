Set the rightmost unset bit,gfg                                                                       
Given a non-negative number N. The problem is to set the rightmost unset bit in the binary representation of N. If there are no unset bits, then just leave the number as it is.
Example 1:
Input:
N = 6
Output:
7
Explanation:
The binary representation of 6 is 110.
After setting right most bit it becomes
111 which is 7.
Example 2:
Input:
N = 15
Output:
15
Explanation:
The binary representation of 15 is 1111.
As there is no unset bit it remains the
same.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function setBit() which takes an integer N as input parameter and returns the integer after setting a rightmost unset bit.
Expected Time Complexity: O(LogN)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 109

class Solution{
    static int setBit(int n){
        if ((n & (n + 1))==0)
        return n;
        return n | (n + 1);
    }
}
Edge case: which have all bit as 1.
Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)
