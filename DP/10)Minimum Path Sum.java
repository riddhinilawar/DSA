Problem statement
Ninjaland is a country in the shape of a 2-Dimensional grid 'GRID', with 'N' rows and 'M' columns. Each point in the grid has some cost associated with it.



Find a path from top left i.e. (0, 0) to the bottom right i.e. ('N' - 1, 'M' - 1) which minimizes the sum of the cost of all the numbers along the path. You need to tell the minimum sum of that path.



Note:
You can only move down or right at any point in time.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 100   
1 <= N, M <= 10^2
1 <= GRID[i][j] <= 10^5

Where 'GRID[i][j]' denotes the value of the cell in the matrix.

Time limit: 1 sec
Sample Input 1:
2
2 3
5 9 6
11 5 2
1 1
5
Sample Output 1:
21
5
Explanation For Sample Output 1:
In test case 1, Consider a grid of 2*3:

For this the grid the path with minimum value is (0,0) -> (0,1) -> (1,1) -> (1,2). And the sum along this path is 5 + 9 +5 + 2 = 21. So the ans is 21.

In test case 2, The given grid is:

For this the grid the path with minimum value is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2).The sum along this path is 1 + 2 + 3 + 4 + 9 = 19.
Sample Input 2:
2
2 2
5 6
1 2
3 3
1 2 3
4 5 4
7 5 9
Sample Output 2:
8
19
Explanation For Sample Output 2:
In test case 1, For this the grid the path with minimum value is (0,0) -> (1,0) -> (1,1). The sum along this path is 5 + 1 + 2 = 8.

In test case 2, The given grid is:

For this the grid the path with minimum value is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2).The sum along this path is 1 + 2 + 3 + 4 + 9 = 19.



===========================================Recursion===============================
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minSumPath(int[][] grid) {
    	int n=grid.length;
        int m=grid[0].length;
        return helper(n-1,m-1,grid);
    }
    public static int helper(int i,int j,int grid[][]){
        if(i==0 && j==0){
            return grid[i][j];
        }
        if(i<0 || j<0){
            return 10000000;
        }

        int left=grid[i][j]+helper(i,j-1,grid);
        int up=grid[i][j]+helper(i-1,j,grid);

        return Math.min(left,up);
    }
}


TC:O(2^(N*M))
SC:O(N+M) STACK SPACE


===========================================Memization===================================

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minSumPath(int[][] grid) {
    	int n=grid.length;
        int m=grid[0].length;
        int dp[][]=new int[n][m];
        for(int temp[]:dp)Arrays.fill(temp,-1);
        return helper(n-1,m-1,grid,dp);
    }
    public static int helper(int i,int j,int grid[][],int dp[][]){
        if(i==0 && j==0){
            return grid[i][j];
        }
        if(i<0 || j<0){
            return 10000000;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int left=grid[i][j]+helper(i,j-1,grid,dp);
        int up=grid[i][j]+helper(i-1,j,grid,dp);

        return dp[i][j]=Math.min(left,up);
    }
}


TC:O(N*M)
SC:O(N*M)

=========================================Tabulation======================================
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minSumPath(int[][] grid) {
    	int n=grid.length;
        int m=grid[0].length;
        int dp[][]=new int[n][m];
        
        dp[0][0]=grid[0][0];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(i==0 && j==0) continue;
                
                int left=1000000000;
                int up=1000000000;

                if(i-1>=0)up=dp[i-1][j];
                if(j-1>=0)left=dp[i][j-1];

                dp[i][j]=grid[i][j]+Math.min(up,left);
            }
        }

        return dp[n-1][m-1];
    }
}

TC:O(N*M)
SC:O(N*M)
========================================Space Optimization===================================

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minSumPath(int[][] grid) {
    	int n=grid.length;
        int m=grid[0].length;
        int dp[]=new int[m];
        
        for(int i=0;i<m;i++){
            if(i==0)dp[i]=grid[0][i];
            else dp[i]=dp[i-1]+grid[0][i];
        }

        for(int i=1;i<n;i++){
            int temp[]=new int[m];
            temp[0]=grid[i][0]+dp[0];
            for(int j=1;j<m;j++){

                int left=1000000000;
                int up=1000000000;

                up=dp[j];
                left=temp[j-1];

                temp[j]=grid[i][j]+Math.min(up,left);
            }
            dp=temp;
        }

        return dp[m-1];
    }
}
  
TC:O(N*M)
SC:O(M)
  
