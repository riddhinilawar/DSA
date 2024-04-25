
688. Knight Probability in Chessboard

On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves. The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).

A chess knight has eight possible moves it can make, as illustrated below. Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.


Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.

The knight continues moving until it has made exactly k moves or has moved off the chessboard.

Return the probability that the knight remains on the board after it has stopped moving.

 

Example 1:

Input: n = 3, k = 2, row = 0, column = 0
Output: 0.06250
Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.
Example 2:

Input: n = 1, k = 0, row = 0, column = 0
Output: 1.00000
 

Constraints:

1 <= n <= 25
0 <= k <= 100
0 <= row, column <= n - 1

class Solution {
    public double helper(int row, int col, int k, int n, double[][][] dp) {
        if (k == 0) {
            return 1.0;
        }

        if (dp[row][col][k] != -1.0){
            return dp[row][col][k];
        } 
        
        int dir[][] = {{-2,1},{-1,2},{1,2},{2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
        
        double totalCost = 0.0;
        
        for (int d[]:dir) {
            int nrow = row + d[0];
            int ncol = col + d[1];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n) {
                totalCost += helper(nrow, ncol, k - 1, n, dp);
            }
        }

        return dp[row][col][k] = totalCost;
    }

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k + 1];
        for (double[][] arr1 : dp)
            for (double[] arr2 : arr1)
                Arrays.fill(arr2, -1.0);

        //after going k steps how many times kight is in broad//
        double inGrid = helper(row, column, k, n, dp);

        //total chances::8*k//
        for (int i = 0; i < k; i++) {
            inGrid = inGrid / 8;
        }

        return inGrid;
    }
}
