Pow(X,N), X raised to the power N              LC-50
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
Example 1:
Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:
Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
Constraints:
-100.0 < x < 100.0
-231 <= n <= 231-1
n is an integer.
-104 <= xn <= 104
Leetcode:
class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
		long nn = n;
		if (nn < 0) nn = -1 * nn;
		while (nn > 0) {
			if (nn % 2 == 1) {
				ans = ans * x;
				nn = nn - 1;
			} else {
				x = x * x;
				nn = nn / 2;
			}
		}
		if (n < 0) ans = (double)(1.0) / (double)(ans);
		return ans;
    }}
Solution 1: Brute force approach 
Approach:  Looping from 1 to n and keeping a ans(double) variable. Now every time your loop runs, multiply x with ans. At last, we will return the ans.
Now if n is negative we must check if n is negative, if it is negative divide 1 by the and.
Time Complexity: O(N)    Space Complexity: O(1)
Solution 2: Using Binary Exponentiation ,Time Complexity: O(log n)        Space Complexity: O(1)
Approach: Initialize ans as 1.0  and store a duplicate copy of n i.e nn using to avoid overflow
Check if nn is a negative number, in that case, make it a positive number.Keep on iterating until nn is greater than zero, now if nn is an odd power then multiply x with ans ans reduce nn by 1. Else multiply x with itself and divide nn by two.Now after the entire binary exponentiation is complete and nn becomes zero, check if n is a negative value we know the answer will be 1 by and.
