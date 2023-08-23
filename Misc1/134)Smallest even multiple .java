Smallest even multiple                                                     LC-2413
Given a positive integer n, return the smallest positive integer that is a multiple of both 2 and n.
 
Example 1:
Input: n = 5
Output: 10
Explanation: The smallest multiple of both 5 and 2 is 10.
Example 2:
Input: n = 6
Output: 6
Explanation: The smallest multiple of both 6 and 2 is 6. Note that a number is a multiple of itself.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
class Solution {
    public int smallestEvenMultiple(int n) {
        for(int i=2;i<=Integer.MAX_VALUE;i=i+2){
            if(i%n==0)return i;
        }
        return 0;
    }
}
