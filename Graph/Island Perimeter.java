463. Island Perimeter

Note::Can use BFS or DFS to solve this question

You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 

Example 1:


Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.
Example 2:

Input: grid = [[1]]
Output: 4
Example 3:

Input: grid = [[1,0]]
Output: 4
 

Constraints:

row == grid.length
col == grid[i].length
1 <= row, col <= 100
grid[i][j] is 0 or 1.
There is exactly one island in grid.
class Solution {
    public int islandPerimeter(int[][] grid) {
        int ans=0;
        int n=grid.length;
        int m=grid[0].length;

        int dir[][]={{1,0},{-1,0},{0,-1},{0,1}};

        //for all squares
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                //if land
                if(grid[i][j]==1){
                    for(int d=0;d<4;d++){
                        int newi=i+dir[d][0];
                        int newj=j+dir[d][1];

                        if(newi>=0 && newi<n && newj>=0 && newj<m){
                            //negighbour is water 
                            if(grid[newi][newj]==0)
                                ans++;
                        }
                        else{
                            //border
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
