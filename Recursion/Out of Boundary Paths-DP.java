There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.

Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.

 

Example 1:


Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
Output: 6
Example 2:


Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
Output: 12
 

Constraints:

1 <= m, n <= 50
0 <= maxMove <= 50
0 <= startRow < m
0 <= startColumn < n

class Solution {
    int mod=1000000007;
    int dp[][][];
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp=new int[m][n][maxMove+1];
        for(int i[][]:dp)
            for(int j[]:i)
                Arrays.fill(j,-1);
        return helper(0,m,n,maxMove,startRow,startColumn);
    }
    public int helper(int weight,int m, int n, int maxMove, int currRow, int currColumn){
        if(currRow<0 || currRow>=m || currColumn<0 ||currColumn>=n){
            return 1;
        }
        if(weight>=maxMove){
            return 0;
        }
        if(dp[currRow][currColumn][weight]!=-1){
            return dp[currRow][currColumn][weight];
        }
        long total=0;
        total=(total + helper(weight+1,m,n,maxMove,currRow-1,currColumn)%mod)%mod;
        total=(total + helper(weight+1,m,n,maxMove,currRow+1,currColumn)%mod)%mod;
        total=(total + helper(weight+1,m,n,maxMove,currRow,currColumn-1)%mod)%mod;
        total=(total + helper(weight+1,m,n,maxMove,currRow,currColumn+1)%mod)%mod;
        return dp[currRow][currColumn][weight]=(int)total;
    }
}
