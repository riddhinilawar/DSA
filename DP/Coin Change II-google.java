518. Coin Change II

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

 

Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1
 

Constraints:

1 <= coins.length <= 300
1 <= coins[i] <= 5000
All the values of coins are unique.
0 <= amount <= 5000
==================================================Memo===================================
class Solution {
    int dp[][];
    public int change(int amount, int[] coins) {
        int n=coins.length;
        dp=new int[n][amount+1];
        for(int d[]:dp)Arrays.fill(d,-1);
        return helper(0,amount,coins);
    }
    public int helper(int idx, int amount,int coins[]){
        if(amount==0){
            return 1;
        }
        if(amount<0){
            return 0;
        }
        if(idx==coins.length){
            return 0;
        }
        if(dp[idx][amount]!=-1){
            return dp[idx][amount];
        }

        int count=0;
        if(amount>=coins[idx]){
            count+=helper(idx,amount-coins[idx],coins);
        }
        count+=helper(idx+1,amount,coins);
        return dp[idx][amount]=count;
    }
}

========================================================================================

 public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        
        return dp[amount];
    }
}
