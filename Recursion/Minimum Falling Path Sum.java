931. Minimum Falling Path Sum

Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

 

Example 1:


Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.
Example 2:


Input: matrix = [[-19,57],[-40,-5]]
Output: -59
Explanation: The falling path with a minimum sum is shown.
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
-100 <= matrix[i][j] <= 100

class Solution {
    int memo[][];
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        memo=new int[n][n];
        
        for(int temp[]:memo)
            Arrays.fill(temp,Integer.MIN_VALUE);

        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int temp=helper(0,i,matrix,n);
            ans=Math.min(ans,temp);
        }
        return ans;
    }
    public int helper(int row,int col,int matrix[][],int n){
        if(row==n-1 && (col>=0 && col<=n-1)){
            return matrix[row][col];
        }
        if(row<0 || row>=n ||col<0 ||col>=n){
            return 1000000;
        }
        if(memo[row][col]!=Integer.MIN_VALUE){
            return memo[row][col];
        }
        int min=Integer.MAX_VALUE;
        min=Math.min(helper(row+1,col+1,matrix,n),min);
        min=Math.min(helper(row+1,col,matrix,n),min);
        min=Math.min(helper(row+1,col-1,matrix,n),min);
        return memo[row][col] = matrix[row][col]+min;
    }
}
