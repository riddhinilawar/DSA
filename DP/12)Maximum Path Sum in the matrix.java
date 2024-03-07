You have been given an N*M matrix filled with integer numbers, find the maximum sum that can be obtained from a path starting from any cell in the first row to any cell in the last row.

From a cell in a row, you can move to another cell directly below that row, or diagonally below left or right. So from a particular cell (row, col), we can move in three directions i.e.

Down: (row+1,col)
Down left diagonal: (row+1,col-1)
Down right diagonal: (row+1, col+1)
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= T <= 50
1 <= N <= 100
1 <= M <= 100
-10^4 <= matrix[i][j] <= 10^4

Where 'T' is the number of test cases.
Where 'N' is the number of rows in the given matrix, and 'M' is the number of columns in the given matrix.
And, matrix[i][j] denotes the value at (i,j) cell in the matrix.

Time Limit: 1sec
Input 1 :
2
4 4
1 2 10 4
100 3 2 1
1 1 20 2
1 2 2 1
3 3
10 2 3
3 7 2
8 1 5
Output 1 :
105
25
Explanation Of Input 1 :
In the first test case for the given matrix,

The maximum path sum will be 2->100->1->2, So the sum is 105(2+100+1+2).

In the second test case for the given matrix, the maximum path sum will be 10->7->8, So the sum is 25(10+7+8).
Input 2 :
2
3 3
1 2 3
9 8 7
4 5 6
4 6
10 10 2 -13 20 4
1 -9 -81 30 2 5
0 10 4 -79 2 -10
1 -5 2 20 -11 4
Output 2 :
17
74
Explanation Of Input 2 :
In the first test case for the given matrix, the maximum path sum will be 3->8->6, So the sum is 17(3+8+6).

In the second test case for the given matrix, the maximum path sum will be 20->30->4->20, So the sum is 74(20+30+4+20).

=========================================================RECURSION======================================================
import java.util.* ;
import java.io.*; 

public class Solution {
	public static int getMaxPathSum(int[][] matrix) {
		int totalRow=matrix.length;
		int totalCol=matrix[0].length;
		int ans=-1000000009;
		for( int col=0;col<totalCol;col++)
			ans=Math.max(ans,helper(totalRow-1,col,totalCol,matrix));
		return ans;
	}
	public static int helper(int currRow,int currCol,int totalCol,int matrix[][]){
		
		if(currCol<0 ||currCol>=totalCol){
			return -1000000009;
		}

		if(currRow==0){
			return matrix[currRow][currCol];
		}

		int totalCost=-1000000009;

		totalCost=Math.max(totalCost,matrix[currRow][currCol]+helper(currRow-1,currCol+1,totalCol,matrix));
		totalCost=Math.max(totalCost,matrix[currRow][currCol]+helper(currRow-1,currCol,totalCol,matrix));
		totalCost=Math.max(totalCost,matrix[currRow][currCol]+helper(currRow-1,currCol-1,totalCol,matrix));

		return totalCost;
	}
}

TC:O(3^N)
SC:O(N)
========================================================Memoization===================================



import java.util.* ;
import java.io.*; 

public class Solution {
	public static int getMaxPathSum(int[][] matrix) {
		int totalRow=matrix.length;
		int totalCol=matrix[0].length;
		int ans=-1000000009;
		int dp[][]=new int[totalRow][totalCol];
		for(int temp[]:dp){
			Arrays.fill(temp,-1000000099);
		}
		for( int col=0;col<totalCol;col++)
			ans=Math.max(ans,helper(totalRow-1,col,totalCol,matrix, dp));
		return ans;
	}
	public static int helper(int currRow,int currCol,int totalCol,int matrix[][],int dp[][]){
		
		if(currCol<0 ||currCol>=totalCol){
			return -1000000009;
		}

		if(currRow==0){
			return dp[currRow][currCol]=matrix[currRow][currCol];
		}

		if(dp[currRow][currCol]!=-1000000099){
			return dp[currRow][currCol];
		}
		int totalCost=-1000000009;

		totalCost=Math.max(totalCost,matrix[currRow][currCol]+helper(currRow-1,currCol+1,totalCol,matrix,dp));
		totalCost=Math.max(totalCost,matrix[currRow][currCol]+helper(currRow-1,currCol,totalCol,matrix,dp));
		totalCost=Math.max(totalCost,matrix[currRow][currCol]+helper(currRow-1,currCol-1,totalCol,matrix,dp));

		return dp[currRow][currCol]=totalCost;
	}
}
TC=O(N*M)
SC:O(N^M)
=======================================================TABULATION============================================


import java.util.* ;
import java.io.*; 

public class Solution {
	public static int getMaxPathSum(int[][] matrix) {
		int totalRow=matrix.length;
		int totalCol=matrix[0].length;

		int dp[][]=new int[totalRow][totalCol];

		int ans=-1000000009;

		for(int i=0;i<totalCol;i++){
			dp[0][i]=matrix[0][i];
		}

		for(int i=1;i<totalRow;i++){
			for(int j=0;j<totalCol;j++){
				int totalCost=-1000000009;

				if((j+1)<totalCol)totalCost=Math.max(totalCost,matrix[i][j]+dp[i-1][j+1]);
				totalCost=Math.max(totalCost,matrix[i][j]+dp[i-1][j]);
				if((j-1)>=0)totalCost=Math.max(totalCost,matrix[i][j]+dp[i-1][j-1]);

				dp[i][j]=totalCost;
			}
		}
		
		
		for( int col=0;col<totalCol;col++)
			ans=Math.max(ans,dp[totalRow-1][col]);
		return ans;
	}
	public static int helper(int currRow,int currCol,int totalCol,int matrix[][],int dp[][]){
		
		if(currCol<0 ||currCol>=totalCol){
			return -1000000009;
		}

		if(currRow==0){
			return dp[currRow][currCol]=matrix[currRow][currCol];
		}

		if(dp[currRow][currCol]!=-1000000099){
			return dp[currRow][currCol];
		}
		int totalCost=-1000000009;

		totalCost=Math.max(totalCost,matrix[currRow][currCol]+helper(currRow-1,currCol+1,totalCol,matrix,dp));
		totalCost=Math.max(totalCost,matrix[currRow][currCol]+helper(currRow-1,currCol,totalCol,matrix,dp));
		totalCost=Math.max(totalCost,matrix[currRow][currCol]+helper(currRow-1,currCol-1,totalCol,matrix,dp));

		return dp[currRow][currCol]=totalCost;
	}
}

TC:O(N*M);
SC=O(N*M)
=========================================SPACE OPTIMIZATION===============================

can be possible by taking the previous row as we just need to previous row to compute the current row


TC:O(N*M);
SC=O(M)
