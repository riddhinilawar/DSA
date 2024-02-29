You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45


====================================recursion=====================================
class Solution {
    public int climbStairs(int n) {
        return climbStairsHelper(n, dp);
    }

    public int climbStairsHelper(int n, int[] dp){
        if(n<0)
            return 0;
        if(n == 0)
            return 1;
        return climbStairsHelper(n-1,dp) + climbStairsHelper(n-2,dp);
    }
}

  
TC:O(2^n)
SC:stack space
====================================memoization===================================

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return climbStairsHelper(n, dp);
    }

    public int climbStairsHelper(int n, int[] dp){
        if(n<0)
            return 0;
        if(n == 0)
            return 1;

        if(dp[n] != -1)
            return dp[n];

        dp[n] =  climbStairsHelper(n-1,dp) + climbStairsHelper(n-2,dp);
        
        return dp[n];
    }
}

TC:O(n)
SC:O(n)
====================================tabulation=====================================
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
}

TC:O(n)
SC:O(n)
=================================space optimization=================================
class Solution {
    public int climbStairs(int n) {
        int way0=1;
        int way1=1;
        int temp;
        for(int i=2;i<=n;i++){
            temp=way1;
            way1=way0+way1;
            way0=temp;
        }
        return way1;
    }
}
SC:O(1)
TC:O(n)
