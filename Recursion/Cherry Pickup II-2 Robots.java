1463. Cherry Pickup II

You are given a rows x cols matrix grid representing a field of cherries where grid[i][j] represents the number of cherries that you can collect from the (i, j) cell.

You have two robots that can collect cherries for you:

Robot #1 is located at the top-left corner (0, 0), and
Robot #2 is located at the top-right corner (0, cols - 1).
Return the maximum number of cherries collection using both robots by following the rules below:

From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
When both robots stay in the same cell, only one takes the cherries.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in grid.
 

Example 1:


Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
Output: 24
Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12.
Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12.
Total of cherries: 12 + 12 = 24.
Example 2:


Input: grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
Output: 28
Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (1 + 9 + 5 + 2) = 17.
Cherries taken by Robot #2, (1 + 3 + 4 + 3) = 11.
Total of cherries: 17 + 11 = 28.
 

Constraints:

rows == grid.length
cols == grid[i].length
2 <= rows, cols <= 70
0 <= grid[i][j] <= 100


  class Solution {
    
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int dp[][][]=new int[rows][cols][cols];
        for(int arr1[][]:dp)for(int arr2[]:arr1)Arrays.fill(arr2,-1);
        return helper(grid, 0, 0, cols-1,dp);
    }
    
    public int helper(int[][] grid, int currRow, int robotACol, int robotBCol,int dp[][][]) {
        
        if(robotACol < 0 || robotBCol < 0 || robotACol >= grid[0].length || robotBCol >= grid[0].length) return 0;
        
        if(currRow == grid.length) return 0; // last row
        
        if(dp[currRow][robotACol][robotBCol]!=-1){
            return dp[currRow][robotACol][robotBCol];
        }


        int result = 0;
        result += grid[currRow][robotACol];
        result += grid[currRow][robotBCol];
        
        int max = 0; // DFS for next row
        for(int x=robotACol-1;x<=robotACol+1;x++) {
            for(int y=robotBCol-1;y<=robotBCol+1;y++) {
                if(x < y) {
                    max = Math.max(max, helper(grid, currRow+1, x, y,dp));
                }
            }
        }
        
        result += max; // add maximum result
        return dp[currRow][robotACol][robotBCol]=result;
    }
}

=========================================================================================================

class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];
        int ans = 0;

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                Arrays.fill(dp[i][j], -1);

        dp[0][0][n-1] = grid[0][0] + grid[0][n-1];

        for(int i=1;i<m;i++) {
            for(int j=0;j<n;j++) { // robotA
                for(int k=j+1;k<n;k++) { // robotB
                    int max = -1;
                    for(int x=-1;x<=1;x++) { // we will have total 9 combinations
                        for(int y=-1;y<=1;y++) {
                            if(j+x >= 0 && j+x < n && k+y >= 0 && k+y < n)
                                max = Math.max(
                                    max,
                                    dp[i-1][j+x][k+y]
                                );
                        }
                    }
                    if(max != -1)
                        dp[i][j][k] = max + grid[i][j] + grid[i][k];
                    if(ans < dp[i][j][k]) ans = dp[i][j][k];
                }
            }
        }

        return ans;
    }
}
