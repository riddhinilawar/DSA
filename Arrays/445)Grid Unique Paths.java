There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 

Constraints:

1 <= m, n <= 100


class Solution {
    public static int solve(int m,int n,int i,int j,int [][]dp){
        //base case
        if(i==m-1 && j==n-1)return 1;
        if(i>=m || j>=n)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int down = solve(m,n,i+1,j,dp);
        int right = solve(m,n,i,j+1,dp);
        return dp[i][j]= down+right;
    }
    public int uniquePaths(int m, int n) {
        //create a dp array 
        int [][] dp = new int[m][n];
        for(int [] rows:dp)Arrays.fill(rows,-1);
        return solve(m,n,0,0,dp);
    }
}

Recursive Approach (gives TLE):

class Solution {
    public int uniquePaths(int m, int n) {
        int ans[]=new int[]{0};
        dp(0,0,m,n,ans);
        return ans[0];
    }
    public void dp(int i,int j,int m,int n,int ans[]){
        if(i==m-1 && j==n-1)
            ans[0]++;
        if(i>=m || j>=n)
            return;
        System.out.println(i+" "+j);
        dp(i+1,j,m,n,ans);
        dp(i,j+1,m,n,ans);
    }
}
