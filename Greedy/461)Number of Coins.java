Given a value V and array coins[] of size M, the task is to make the change for V cents, given that you have an infinite supply of each of coins{coins1, coins2, ..., coinsm} valued coins. Find the minimum number of coins to make the change. If not possible to make change then return -1.


Example 1:

Input: V = 30, M = 3, coins[] = {25, 10, 5}
Output: 2
Explanation: Use one 25 cent coin
and one 5 cent coin
Example 2:
Input: V = 11, M = 4,coins[] = {9, 6, 5, 1} 
Output: 2 
Explanation: Use one 6 cent coin
and one 5 cent coin

Your Task:  
You don't need to read input or print anything. Complete the function minCoins() which takes V, M and array coins as input parameters and returns the answer.

Expected Time Complexity: O(V*M)
Expected Auxiliary Space: O(V)

Constraints:
1 ≤ V*M ≤ 106
All array elements are distinct

class Solution{
    static int cc(int c[],int n,int s,int dp[][]){
        if(s==0){
            return 0;
        }
        if(n==0){
            return 99999;
        }
        if(dp[n][s]!=-1){
            return dp[n][s];
        }
        if(c[n-1]<=s){
            return dp[n][s]=Math.min((1+cc(c,n,s-c[n-1],dp)),cc(c,n-1,s,dp));
        }
        return dp[n][s]=cc(c,n-1,s,dp);
    }
    public int minCoins(int coins[], int N, int sum) 
    { 
        int dp[][]=new int[N+1][sum+1];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        cc(coins,N,sum,dp);
        if(dp[N][sum]==99999){
            return -1;
        }
        return dp[N][sum];
    } 
}
