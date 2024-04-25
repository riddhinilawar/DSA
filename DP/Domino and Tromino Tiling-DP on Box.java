790. Domino and Tromino Tiling
Refer::https://leetcode.com/problems/domino-and-tromino-tiling/description/comments/1566271

You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.


Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 109 + 7.

In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.

 

Example 1:


Input: n = 3
Output: 5
Explanation: The five different ways are show above.
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 1000

class Solution {
    //Note::Forms a pattern, 1,2,5,11,24,...
    public int numTilings(int n) {
        long[] dp = new long[n+3]; 
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 5;

        for (int i = 3; i < n; i ++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % 1000000007;
        }
        return (int)dp[n - 1];
    }
}
