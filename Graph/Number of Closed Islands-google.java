
1254. Number of Closed Islands

Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.

 

Example 1:



Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation: 
Islands in gray are closed because they are completely surrounded by water (group of 1s).
Example 2:



Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1
Example 3:

Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2
 

Constraints:

1 <= grid.length, grid[0].length <= 100
0 <= grid[i][j] <=1

class Solution {
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;


        for(int i=0;i<n;i++){
            if(grid[i][0]==0)makeIslandWater(i,0,grid,n,m);//for all rows first column//
            if(grid[i][m-1]==0)makeIslandWater(i,m-1,grid,n,m);//for all rows last column//
        }

        for(int j=0;j<m;j++){
            if(grid[0][j]==0)makeIslandWater(0,j,grid,n,m);//for all columns first row//
            if(grid[n-1][j]==0)makeIslandWater(n-1,j,grid,n,m);//for all columns last row//
        }


        int totalComponents=0;
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(grid[i][j]==0){
                    makeIslandWater(i,j,grid,n,m);
                    totalComponents++;
                }
            }
        }
        return totalComponents;
    }
    public void makeIslandWater(int i,int j,int grid[][],int n,int m){
        if(i<0 || j<0 || i==n || j==m || grid[i][j]==1)return;
        grid[i][j]=1;
        makeIslandWater(i+1,j,grid,n,m);
        makeIslandWater(i-1,j,grid,n,m);
        makeIslandWater(i,j+1,grid,n,m);
        makeIslandWater(i,j-1,grid,n,m);
    }
}
