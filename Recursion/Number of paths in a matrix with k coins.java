Given a n x n matrix such that each of its cells contains some coins. Count the number of ways to collect exactly k coins while moving from top left corner of the matrix to the bottom right. From a cell (i, j), you can only move to (i+1, j) or (i, j+1).

Example 1:

Input:
k = 12, n = 3
arr[] = [[1, 2, 3], 
       [4, 6, 5], 
       [3, 2, 1]]
Output: 
2
Explanation: 
There are 2 possible paths with exactly 12 coins, (1 + 2 + 6 + 2 + 1) and (1 + 2 + 3 + 5 + 1).
Example 2:

Input:
k = 16, n = 3
arr[] = [[1, 2, 3], 
       [4, 6, 5], 
       [9, 8, 7]]
Output: 
0 
Explanation: 
There are no possible paths that lead to sum=16
Your Task:  
You don't need to read input or print anything. Your task is to complete the function numberOfPath() which takes n, k and 2D matrix arr[][] as input parameters and returns the number of possible paths.

Expected Time Complexity: O(n*n*k)
Expected Auxiliary Space: O(n*n*k)

Constraints:

1 <= k < 100
1 <= n < 100
0 <= arrij <= 200


class Solution {
    long numberOfPath(int n, int k, int [][]arr) {
        
        long dp[][][]=new long[n][n][k+1];
        
        for(long arr1[][]:dp){
            for(long arr2[]:arr1){
                Arrays.fill(arr2,-1l);
            }
        }
        
        return helper(0,0,n,k,arr,dp);
    }
    long helper(int i,int j,int n,int k,int arr[][], long dp[][][]){
        if(i==n || j==n || k<0){
            return 0;
        }
        if(i==n-1 && j==n-1 && k==arr[n-1][n-1]){
            return 1;
        }
        if(dp[i][j][k]!=-1){
            return dp[i][j][k];
        }
        long right=helper(i,j+1,n,k-arr[i][j],arr,dp);
        long bottom=helper(i+1,j,n,k-arr[i][j],arr,dp);
        
        return dp[i][j][k]=right+bottom;
    }
}



Note:-Generally gets wrong
if(i==n-1 && j==n-1 && k==arr[n-1][n-1]){
    return 1;
}
