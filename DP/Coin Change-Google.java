322. Coin Change

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
================================================================Recursive===========================================

class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans=helper(0,coins,amount);   
        return (ans==(int)1e9)?-1:ans;
    }
    public int helper(int idx,int[] coins,int amount){
        if(amount==0){
            return 0;
        }
        if(idx==coins.length){
            return (int)1e9;
        }
        
        int notTaken=helper(idx+1,coins,amount);
        int taken=(int)1e9;
        if(amount>=coins[idx])taken=1+helper(idx,coins,amount-coins[idx]);

        return Math.min(taken,notTaken);

    }
}

TC:O(2^t)
SC:O(t)
=======================================================Memoization===================================================

class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[coins.length][amount+1];
        for(int d[]:dp)Arrays.fill(d,-1);
        int ans=helper(0,coins,amount,dp);   
        return (ans==(int)1e9)?-1:ans;
    }
    public int helper(int idx,int[] coins,int amount,int dp[][]){
        if(amount==0){
            return 0;
        }
        if(idx==coins.length){
            return (int)1e9;
        }
        if(dp[idx][amount]!=-1)return dp[idx][amount];
        int notTaken=helper(idx+1,coins,amount,dp);
        int taken=(int)1e9;
        if(amount>=coins[idx])taken=1+helper(idx,coins,amount-coins[idx],dp);

        return dp[idx][amount]=Math.min(taken,notTaken);

    }
}

TC:O(TARGET*N)
SC:O(TARGET*N)
=====================================================Tabulation======================================================
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[coins.length][amount+1];
        for(int d[]:dp)Arrays.fill(d,-1);
        
        for(int i=0;i<coins.length;i++){
            dp[i][0]=0;
        }

        for(int idx=coins.length-1;idx>=0;idx--){
            for(int j=1;j<=amount;j++){
                int notTaken=(int)1e9;
                if(idx+1<coins.length) notTaken=dp[idx+1][j];
                int taken=(int)1e9;
                if(j>=coins[idx])taken=1+dp[idx][j-coins[idx]];

                dp[idx][j]=Math.min(taken,notTaken);
            }
        }
        
        return (dp[0][amount]==(int)1e9)?-1:dp[0][amount];
    }
}
TC:O(TARGET*N)
SC:O(TARGET*N)
