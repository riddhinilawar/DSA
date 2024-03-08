1463. Cherry Pickup II
Note::Single time traverse for both the robots..try for all the nine posibilities

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


==========================================================RECURSION===========================================

class Solution {
    public int cherryPickup(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;

        return helper(0,0,0,cols-1,rows,cols,grid);
    }
    public int helper(int robot1i, int robot1j, int robot2i, int robot2j, int rows,int cols,int grid[][]){
        if(robot1j<0 || robot1j>=cols ||robot2j<0 ||robot2j>=cols){
            return -100000008;
        }
        // System.out.println(robot1i+" "+robot1j+" "+robot2i+" "+robot2j);
        
        if(robot1i==rows-1){
            if(robot1j==robot2j){
                return grid[robot1i][robot1j];
            }
            else{
                return grid[robot1i][robot1j]+grid[robot2i][robot2j];
            }
        }

        int totalCost=-1;

        for(int delta1=-1;delta1<=1;delta1++){
            for(int delta2=-1;delta2<=1;delta2++){
                int value=0;
                if(robot1j==robot2j){
                    value+= grid[robot1i][robot1j]+helper(robot1i+1,robot1j+delta1,robot2i+1,robot2j+delta2,rows,cols,grid);
                }   
                else{
                    value+= grid[robot1i][robot1j]+grid[robot2i][robot2j]+helper(robot1i+1,robot1j+delta1,robot2i+1,robot2j+delta2,rows,cols,grid);
                }
                totalCost=Math.max(value,totalCost);
            }
        }


        return totalCost;
    }
}


TC:O(3^N * 3^N)
SC:O(N)

===========================================MEMOIZATION============================================================

class Solution {
    public int cherryPickup(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int dp[][][]=new int[rows][cols][cols];
        for(int arr1[][]:dp)for(int arr2[]:arr1)Arrays.fill(arr2,-1);
        return helper(0,0,cols-1,rows,cols,grid,dp);
    }
    public int helper(int robot1i, int robot1j, int robot2j, int rows,int cols,int grid[][],int dp[][][]){
        if(robot1j<0 || robot1j>=cols ||robot2j<0 ||robot2j>=cols){
            return -100000008;
        }
        // System.out.println(robot1i+" "+robot1j+" "+robot2i+" "+robot2j);
        if(dp[robot1i][robot1j][robot2j]!=-1){
            return dp[robot1i][robot1j][robot2j];
        }
        if(robot1i==rows-1){
            if(robot1j==robot2j){
                return grid[robot1i][robot1j];
            }
            else{
                return grid[robot1i][robot1j]+grid[robot1i][robot2j];
            }
        }

        int totalCost=-1;

        for(int delta1=-1;delta1<=1;delta1++){
            for(int delta2=-1;delta2<=1;delta2++){
                int value=0;
                if(robot1j==robot2j){
                    value+= grid[robot1i][robot1j]+helper(robot1i+1,robot1j+delta1,robot2j+delta2,rows,cols,grid,dp);
                }   
                else{
                    value+= grid[robot1i][robot1j]+grid[robot1i][robot2j]+helper(robot1i+1,robot1j+delta1,robot2j+delta2,rows,cols,grid,dp);
                }
                totalCost=Math.max(value,totalCost);
            }
        }


        return dp[robot1i][robot1j][robot2j]=totalCost;
    }
}

TC:O(3*M*M*9)
SC:O(N*M*M)

===========================================TABULATION=======================================================

class Solution {
    public int cherryPickup(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int dp[][][]=new int[rows][cols][cols];
       
        
        for(int robot1j=0;robot1j<cols;robot1j++){
            for(int robot2j=0;robot2j<cols;robot2j++){
                if(robot1j==robot2j){
                    dp[rows-1][robot1j][robot2j]=grid[rows-1][robot1j];
                }
                else{
                    dp[rows-1][robot1j][robot2j]=grid[rows-1][robot1j]+grid[rows-1][robot2j];
                }
            }
        }

        for(int robot1i=rows-2;robot1i>=0;robot1i--){
            for(int robot1j=0;robot1j<cols;robot1j++){
                for(int robot2j=0;robot2j<cols;robot2j++){

                    int totalCost=-1;

                    for(int delta1=-1;delta1<=1;delta1++){
                        for(int delta2=-1;delta2<=1;delta2++){
                            int value=0;
                            if(robot1j+delta1< 0 || robot1j+delta1>=cols || robot2j+delta2<0 ||robot2j+delta2>=cols){
                                value+=-100000008;
                            }
                            else if(robot1j==robot2j){
                                value+= grid[robot1i][robot1j]+dp[robot1i+1][robot1j+delta1][robot2j+delta2];
                            }   
                            else{
                                value+= grid[robot1i][robot1j]+grid[robot1i][robot2j]+dp[robot1i+1][robot1j+delta1][robot2j+delta2];
                            }
                            totalCost=Math.max(value,totalCost);
                        }
                    }

                    dp[robot1i][robot1j][robot2j]=totalCost;

                }
            }
        }

        return dp[0][0][cols-1];
    }
    public int helper(int robot1i, int robot1j, int robot2j, int rows,int cols,int grid[][],int dp[][][]){
        if(robot1j<0 || robot1j>=cols ||robot2j<0 ||robot2j>=cols){
            return -100000008;
        }
        // System.out.println(robot1i+" "+robot1j+" "+robot2i+" "+robot2j);
        if(dp[robot1i][robot1j][robot2j]!=-1){
            return dp[robot1i][robot1j][robot2j];
        }
        if(robot1i==rows-1){
            if(robot1j==robot2j){
                return grid[robot1i][robot1j];
            }
            else{
                return grid[robot1i][robot1j]+grid[robot1i][robot2j];
            }
        }

        int totalCost=-1;

        for(int delta1=-1;delta1<=1;delta1++){
            for(int delta2=-1;delta2<=1;delta2++){
                int value=0;
                if(robot1j==robot2j){
                    value+= grid[robot1i][robot1j]+helper(robot1i+1,robot1j+delta1,robot2j+delta2,rows,cols,grid,dp);
                }   
                else{
                    value+= grid[robot1i][robot1j]+grid[robot1i][robot2j]+helper(robot1i+1,robot1j+delta1,robot2j+delta2,rows,cols,grid,dp);
                }
                totalCost=Math.max(value,totalCost);
            }
        }


        return dp[robot1i][robot1j][robot2j]=totalCost;
    }
}
TC:O(3*M*M*9)
SC:O(N*M*M)
