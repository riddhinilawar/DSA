52. N-Queens II
TC=N!*N 
SC=N SQUARE
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 

Example 1:


Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 9


class Solution {
    
    public int totalNQueens(int n) {
        int res[]=new int[1];
        boolean upperdiag[]=new boolean[(2*n)-1];
        boolean lowerdiag[]=new boolean[(2*n)-1];
        boolean left[]=new boolean[n];
        dfs(0, res,upperdiag,lowerdiag,left,n);
        return res[0];
    }

    static void dfs(int col, int[] res,boolean upperdiag[],boolean lowerdiag[],boolean left[],int n) {
        if (col == n) {
            res[0]++;
            return;
        }

        for (int row = 0; row < n; row++) {
            if (upperdiag[row+col]==false && left[row]==false && lowerdiag[(n-1)+(col-row)]==false) {
                upperdiag[row+col]=true;
                left[row]=true;
                lowerdiag[(n-1)+(col-row)]=true;
                dfs(col + 1, res,upperdiag,lowerdiag,left,n);
                upperdiag[row+col]=false;
                left[row]=false;
                lowerdiag[(n-1)+(col-row)]=false;
            }
        }
    }
}
===============================================================================================================================================

class Solution {
    
    public int totalNQueens(int n) {
        int res[]=new int[1];
        boolean upperdiag[]=new boolean[(2*n)-1];
        boolean lowerdiag[]=new boolean[(2*n)-1];
        boolean left[]=new boolean[n];
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return dfs(0, res,upperdiag,lowerdiag,left,n,dp);
    }

    static int dfs(int col, int[] res,boolean upperdiag[],boolean lowerdiag[],boolean left[],int n,int dp[]) {
        if (col == n) {
            return 1;
        }
        //if(dp[col]!=-1)return dp[col];
        int ans=0;
        for (int row = 0; row < n; row++) {
            if (upperdiag[row+col]==false && left[row]==false && lowerdiag[(n-1)+(col-row)]==false) {
                upperdiag[row+col]=true;
                left[row]=true;
                lowerdiag[(n-1)+(col-row)]=true;
                ans+=dfs(col + 1, res,upperdiag,lowerdiag,left,n,dp);
                upperdiag[row+col]=false;
                left[row]=false;
                lowerdiag[(n-1)+(col-row)]=false;
            }
        }
        return dp[col]= ans;
    }
}
