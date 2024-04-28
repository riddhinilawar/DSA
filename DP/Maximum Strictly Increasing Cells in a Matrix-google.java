2713. Maximum Strictly Increasing Cells in a Matrix

Given a 1-indexed m x n integer matrix mat, you can select any cell in the matrix as your starting cell.

From the starting cell, you can move to any other cell in the same row or column, but only if the value of the destination cell is strictly greater than the value of the current cell. You can repeat this process as many times as possible, moving from cell to cell until you can no longer make any moves.

Your task is to find the maximum number of cells that you can visit in the matrix by starting from some cell.

Return an integer denoting the maximum number of cells that can be visited.

 

Example 1:



Input: mat = [[3,1],[3,4]]
Output: 2
Explanation: The image shows how we can visit 2 cells starting from row 1, column 2. It can be shown that we cannot visit more than 2 cells no matter where we start from, so the answer is 2. 
Example 2:



Input: mat = [[1,1],[1,1]]
Output: 1
Explanation: Since the cells must be strictly increasing, we can only visit one cell in this example. 
Example 3:



Input: mat = [[3,1,6],[-9,5,7]]
Output: 4
Explanation: The image above shows how we can visit 4 cells starting from row 2, column 1. It can be shown that we cannot visit more than 4 cells no matter where we start from, so the answer is 4. 
 

Constraints:

m == mat.length 
n == mat[i].length 
1 <= m, n <= 105
1 <= m * n <= 105
-105 <= mat[i][j] <= 105


   

class Solution {

    public int maxIncreasingCells(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return 0;

        int cols = matrix[0].length;
        Map<Integer, List<int[]>> valueToCells = new TreeMap<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int value = matrix[i][j];
                valueToCells.computeIfAbsent(value, k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        int[][] dp = new int[rows][cols];
        int[] maxInRowOrCol = new int[rows + cols];

        for (List<int[]> cellList : valueToCells.values()) {
            for (int[] cell : cellList) {
                int row = cell[0], col = cell[1];
                dp[row][col] = Math.max(maxInRowOrCol[row], maxInRowOrCol[rows + col]) + 1;
            }

            for (int[] cell : cellList) {
                int row = cell[0], col = cell[1];
                maxInRowOrCol[row] = Math.max(maxInRowOrCol[row], dp[row][col]);
                maxInRowOrCol[rows + col] = Math.max(maxInRowOrCol[rows + col], dp[row][col]);
            }
        }

        int maxIncreasingCells = 0;
        for (int max : maxInRowOrCol) {
            maxIncreasingCells = Math.max(maxIncreasingCells, max);
        }

        return maxIncreasingCells;
    }

  
}
