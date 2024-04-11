329. Longest Increasing Path in a Matrix

Note::Normal dfs traversal, disconnected components if the component is not visited first make it as first component  and start finding.
  
Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

 

Example 1:


Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:


Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
Example 3:

Input: matrix = [[1]]
Output: 1
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
0 <= matrix[i][j] <= 231 - 1


class Solution {
    int dir[][]={{0,1},{0,-1},{-1,0},{1,0}};
    int dp[][];

    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        dp=new int[n][m];
        for(int d[]:dp)Arrays.fill(d,-1);

        int ans=0;

        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(dp[i][j]==-1)
                    ans=Math.max(ans,1+helper(i,j,n,m,matrix));

        return ans;
    }
    public int helper(int i,int j,int n,int m,int matrix[][]){
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        //System.out.println(i+" "+j);
        int ans=0;
        for(int neg=0;neg<4;neg++){
            int ni=i+dir[neg][0];
            int nj=j+dir[neg][1];

            
            if(ni>=0 &&  nj>=0 && ni<n && nj<m && matrix[ni][nj]>matrix[i][j]){
                ans=Math.max(ans,1+helper(ni,nj,n,m,matrix));
            }
        }

        return dp[i][j]=ans;

    }
}
