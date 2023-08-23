Maximum Sum of an Hourglass                                       LC-2428
You are given an m x n integer matrix grid.
We define an hourglass as a part of the matrix with the following form:
 
Return the maximum sum of the elements of an hourglass.
Note that an hourglass cannot be rotated and must be entirely contained within the matrix.
 
Example 1:
 
Input: grid = [[6,2,1,3],[4,2,1,5],[9,2,8,7],[4,1,2,9]]
Output: 30
Explanation: The cells shown above represent the hourglass with the maximum sum: 6 + 2 + 1 + 2 + 9 + 2 + 8 = 30.
Example 2:
 
Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
Output: 35
Explanation: There is only one hourglass in the matrix, with the sum: 1 + 2 + 3 + 5 + 7 + 8 + 9 = 35.
 
Constraints:
•	m == grid.length
•	n == grid[i].length
•	3 <= m, n <= 150
•	0 <= grid[i][j] <= 106
Expected Time Complexity: O(M*N)
Expected Auxiliary Space: O(1)

class Solution {
    public int maxSum(int[][] grid) {

        int rows=grid.length-3;
        int columns=grid[0].length-3;
        int ans=0;
        for(int i=0;i<=rows;i++)
        {
            for(int j=0;j<=columns;j++)
            {
                ans=Math.max(ans,hourglassmax(grid,i,j));
            }
        }
        return ans;
    }
    public int hourglassmax(int[][] grid, int rstart, int cstart) {
        int sum=0;

        sum=grid[rstart][cstart]+
        grid[rstart][cstart+1]+
        grid[rstart][cstart+2]+

        grid[rstart+1][cstart+1]+

        grid[rstart+2][cstart]+
        grid[rstart+2][cstart+1]+
        grid[rstart+2][cstart+2];

        return sum;
    }
}
