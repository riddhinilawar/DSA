Unit Area of largest region of 1's
MediumAccuracy: 50.83%Submissions: 63K+Points: 4
Internship Alert!
Become an SDE Intern by topping this monthly leaderboard! 

banner
Given a grid of dimension nxm containing 0s and 1s. Find the unit area of the largest region of 1s.
Region of 1's is a group of 1's connected 8-directionally (horizontally, vertically, diagonally).
 

Example 1:

Input: grid = {{1,1,1,0},{0,0,1,0},{0,0,0,1}}
Output: 5
Explanation: The grid is-
1 1 1 0
0 0 1 0
0 0 0 1
The largest region of 1's is colored
in orange.
Example 2:

Input: grid = {{0,1}}
Output: 1
Explanation: The grid is-
0 1
The largest region of 1's is colored in 
orange.

Your Task:
You don't need to read or print anyhting. Your task is to complete the function findMaxArea() which takes grid as input parameter and returns the area of the largest region of 1's.


Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)
 

Constraints:
1 ≤ n, m ≤ 500

class Solution{
    public int findMaxArea(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    max=Math.max(max,helper(i,j,grid,n,m));
                }
            }
        }
        return max;
    }
    public int helper(int i,int j,int[][] grid,int n,int m){
        int total=1;
        grid[i][j]=0;
        for(int negi=-1;negi<=1;negi++){
            for(int negj=-1;negj<=1;negj++){
                if(i+negi>=0 && j+negj>=0 && i+negi<n && j+negj<m && grid[i+negi][j+negj]==1){
                    total+=helper(i+negi,j+negj,grid,n,m);
                }
            }
        }
        return total;
    }
}
