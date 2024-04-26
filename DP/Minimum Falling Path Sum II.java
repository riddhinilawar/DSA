1289. Minimum Falling Path Sum II

Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts.

A falling path with non-zero shifts is a choice of exactly one element from each row of grid such that no two elements chosen in adjacent rows are in the same column.

 

Example 1:


Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
Output: 13
Explanation: 
The possible falling paths are:
[1,5,9], [1,5,7], [1,6,7], [1,6,8],
[2,4,8], [2,4,9], [2,6,7], [2,6,8],
[3,4,8], [3,4,9], [3,5,7], [3,5,9]
The falling path with the smallest sum is [1,5,7], so the answer is 13.
Example 2:

Input: grid = [[7]]
Output: 7
 

Constraints:

n == grid.length == grid[i].length
1 <= n <= 200
-99 <= grid[i][j] <= 99

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int min=1000000;
        int n=grid.length;
        int m=grid[0].length;
        int dp[][]=new int[n][m+1];
        for(int d[]:dp)Arrays.fill(d,-1);
        return helper(0,-1,n,m,grid,dp);
    }
    public int helper(int row, int col, int totalRows, int totalCols, int grid[][],int dp[][]){
        if(row>=totalRows){
            return 0;
        }
        if(dp[row][col+1]!=-1){
            return dp[row][col+1];
        }
        int min=1000000;

        for(int j=0;j<totalCols;j++){
            if(j!=col){
                min=Math.min(min,grid[row][j]+helper(row+1,j,totalRows,totalCols,grid,dp));
            }
        }

        return dp[row][col+1]=min;
    }
}
===============================================90% faster===========================================

  class Solution {
    //Find 3 smaller element of each row and just consider them and sum up with previous row//
    public int minFallingPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int firstSmall[]=new int[2];//value,idx
        int secondSmall[]=new int[2];//value,idx
        int thirdSmall[]=new int[2];//value,idx
        firstSmall[0]=Integer.MAX_VALUE;
        secondSmall[0]=Integer.MAX_VALUE;
        thirdSmall[0]=Integer.MAX_VALUE;

        for(int row=0;row<n;row++){

            int currFirstSmall[]=new int[2];//value,idx
            int currSecondSmall[]=new int[2];//value,idx
            int currThirdSmall[]=new int[2];//value,idx
            currFirstSmall[0]=Integer.MAX_VALUE;
            currSecondSmall[0]=Integer.MAX_VALUE;
            currThirdSmall[0]=Integer.MAX_VALUE;

            for(int col=0;col<m;col++){
                if(currFirstSmall[0]>grid[row][col]){

                    currThirdSmall[0]=currSecondSmall[0];
                    currThirdSmall[1]=currSecondSmall[1];

                    currSecondSmall[0]=currFirstSmall[0];
                    currSecondSmall[1]=currFirstSmall[1];

                    currFirstSmall[0]=grid[row][col];
                    currFirstSmall[1]=col;
                }
                else if(currSecondSmall[0]>grid[row][col]){
                    currThirdSmall[0]=currSecondSmall[0];
                    currThirdSmall[1]=currSecondSmall[1];

                    currSecondSmall[0]=grid[row][col];
                    currSecondSmall[1]=col;
                }
                else if(currThirdSmall[0]>grid[row][col]){
                    currThirdSmall[0]=grid[row][col];
                    currThirdSmall[1]=col;
                }
            }

            
            if(firstSmall[0]==Integer.MAX_VALUE){
                firstSmall=currFirstSmall;
                secondSmall=currSecondSmall;
                thirdSmall=currThirdSmall;
            }
            else{
                getMin(firstSmall,secondSmall,thirdSmall,currFirstSmall,currSecondSmall,currThirdSmall);
            }
            
        }
        return Math.min(firstSmall[0],Math.min(secondSmall[0],thirdSmall[0]));
    }
    public void getMin(int firstSmall[],int secondSmall[],int thirdSmall[],int currFirstSmall[],int currSecondSmall[],int currThirdSmall[]){
        // System.out.println("parent:"+firstSmall[0]+" "+firstSmall[1]+" "+secondSmall[0]+" "+secondSmall[1]+" "+thirdSmall[0]+" "+thirdSmall[1]);
        // System.out.println("self:::"+currFirstSmall[0]+" "+currFirstSmall[1]+" "+currSecondSmall[0]+" "+currSecondSmall[1]+" "+currThirdSmall[0]+" "+currThirdSmall[1]);

        int min=Integer.MAX_VALUE;
      
        if(firstSmall[1]!=currFirstSmall[1] && firstSmall[0]<min){
            min=Math.min(min,firstSmall[0]);
        }
        if(secondSmall[1]!=currFirstSmall[1] && secondSmall[0]<min){
            min=Math.min(min,secondSmall[0]);
        }
        if(thirdSmall[1]!=currFirstSmall[1] && thirdSmall[0]<min){
            min=Math.min(min,thirdSmall[0]);
        }
        

        int mmin=Integer.MAX_VALUE;
        if(firstSmall[1]!=currSecondSmall[1] && firstSmall[0]<mmin){
            mmin=Math.min(mmin,firstSmall[0]);
        }
        if(secondSmall[1]!=currSecondSmall[1] && secondSmall[0]<mmin){
            mmin=Math.min(mmin,secondSmall[0]);
        }
        if(thirdSmall[1]!=currSecondSmall[1] && thirdSmall[0]<mmin){
            mmin=Math.min(mmin,thirdSmall[0]);
        }


        int mmmin=Integer.MAX_VALUE;
        if(firstSmall[1]!=currThirdSmall[1] && firstSmall[0]<mmmin){
            mmmin=Math.min(mmmin,firstSmall[0]);
        }
        if(secondSmall[1]!=currThirdSmall[1] && secondSmall[0]<mmmin){
            mmmin=Math.min(mmmin,secondSmall[0]);
        }
        if(thirdSmall[1]!=currThirdSmall[1] && thirdSmall[0]<mmmin){
            mmmin=Math.min(mmmin,thirdSmall[0]);
        }

        
        
        firstSmall[0]=(currFirstSmall[0]+min);
        firstSmall[1]=currFirstSmall[1];

        secondSmall[0]=(currSecondSmall[0]+mmin);
        secondSmall[1]=currSecondSmall[1];

        thirdSmall[0]=(currThirdSmall[0]+mmmin);
        thirdSmall[1]=currThirdSmall[1];

        // System.out.println("result::"+firstSmall[0]+" "+firstSmall[1]+" "+secondSmall[0]+" "+secondSmall[1]+" "+thirdSmall[0]+" "+thirdSmall[1]);
    }
}
