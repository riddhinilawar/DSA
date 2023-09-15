Given an array arr[] of size N, check if it can be partitioned into two parts such that the sum of elements in both parts is the same.

Example 1:

Input: N = 4
arr = {1, 5, 11, 5}
Output: YES
Explanation: 
The two parts are {1, 5, 5} and {11}.
Example 2:

Input: N = 3
arr = {1, 3, 5}
Output: NO
Explanation: This array can never be 
partitioned into two such parts.
Your Task:
You do not need to read input or print anything. Your task is to complete the function equalPartition() which takes the value N and the array as input parameters and returns 1 if the partition is possible. Otherwise, returns 0.

Expected Time Complexity: O(N*sum of elements)
Expected Auxiliary Space: O(N*sum of elements)

Constraints:
1 ≤ N ≤ 100
1 ≤ arr[i] ≤ 1000
N*sum of elements ≤ 5*106


class Solution{
    static int equalPartition(int N, int arr[]){
        int sum=0;
        
        for(int num:arr)
            sum+=num;
            
        int dp[][]=new int[N+1][sum+1];
        for(int[]d : dp)
            Arrays.fill(d,-1);
        
        return helper(0,N,arr,0,0,dp);
    }
    static int helper(int idx,int N,int arr[],int sumTaken,int sumNotTaken,int dp[][]){
        if(idx==N){
            
            if(sumTaken==sumNotTaken && sumTaken!=0)
                return 1;
            
            return 0;
        }
        
        if(dp[idx][sumTaken]!=-1)return dp[idx][sumTaken];
        
        if(helper(idx+1,N,arr,sumTaken+arr[idx],sumNotTaken,dp)==1)
            return 1;
        
        if(helper(idx+1,N,arr,sumTaken,sumNotTaken+arr[idx],dp)==1)
            return 1;
        
            
        return dp[idx][sumTaken]=0;
    }
}
