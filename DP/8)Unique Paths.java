Problem statement
You are present at point ‘A’ which is the top-left cell of an M X N matrix, your destination is point ‘B’, which is the bottom-right cell of the same matrix. Your task is to find the total number of unique paths from point ‘A’ to point ‘B’.In other words, you will be given the dimensions of the matrix as integers ‘M’ and ‘N’, your task is to find the total number of unique paths from the cell MATRIX[0][0] to MATRIX['M' - 1]['N' - 1].

To traverse in the matrix, you can either move Right or Down at each step. For example in a given point MATRIX[i] [j], you can move to either MATRIX[i + 1][j] or MATRIX[i][j + 1].

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 ≤ T ≤ 100
1 ≤ M ≤ 15
1 ≤ N ≤ 15

Where ‘M’ is the number of rows and ‘N’ is the number of columns in the matrix. 

Time limit: 1 sec
Sample Input 1:
2
2 2
1 1
Sample Output 1:
2
1
Explanation of Sample Output 1:
In test case 1, we are given a 2 x 2 matrix, to move from matrix[0][0] to matrix[1][1] we have the following possible paths.

Path 1 = (0, 0) -> (0, 1) -> (1, 1)
Path 2 = (0, 0) -> (1, 0) -> (1, 1)

Hence a total of 2 paths are available, so the output is 2.

In test case 2, we are given a 1 x 1 matrix, hence we just have a single cell which is both the starting and ending point. Hence the output is 1.
Sample Input 2:
2
3 2
1 6
Sample Output 2:
3
1
Explanation of Sample Output 2:
In test case 1, we are given a 3 x 2 matrix, to move from matrix[0][0] to matrix[2][1] we have the following possible paths.

Path 1 = (0, 0) -> (0, 1) -> (1, 1) -> (2, 1)
Path 2 = (0, 0) -> (1, 0) -> (2, 0) -> (2, 1)
Path 3 =  (0, 0) -> (1, 0) -> (1, 1) -> (2, 1)

Hence a total of 3 paths are available, so the output is 3.

In test case 2, we are given a 1 x 6 matrix, hence we just have a single row to traverse and thus total path will be 1.



========================================RECURSION============================================



import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
		return helper(m-1,n-1);
	}
	public static int helper(int m,int n){
		if(m==0 && n==0){
			return 1;
		}
		if(m<0 || n<0){
			return 0;
		}
		int left=helper(m-1,n);
		int top=helper(m,n-1);
		return left+top;
	}
}

TC:-O(branches to the power depth) ~ O(2^(m*n))
SC:-O(m*n)


=============================================Memoization============================================

import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
		int dp[][]=new int[m][n];
		for(int temp[]:dp)Arrays.fill(temp,-1);
		return helper(m-1,n-1,dp);
	}
	public static int helper(int m,int n,int[][]dp){
		if(m==0 && n==0){
			return 1;
		}
		if(m<0 || n<0){
			return 0;
		}
		if(dp[m][n]!=-1){
			return dp[m][n];
		}
		
		int left=helper(m-1,n,dp);
		int top=helper(m,n-1,dp);
		return dp[m][n]=left+top;
	}
}



TC:O(N*M)
SC:O(N*M)

  
============================================Tabulation==================================================

import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
		int dp[][]=new int[m][n];
		dp[0][0]=1;

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){

				if(i==0 && j==0)continue;

				int up=0;
				int left=0;
				if(i-1>=0)up=dp[i-1][j];
				if(j-1>=0)left=dp[i][j-1];
				dp[i][j]=up+left;
			}
		}

		return dp[m-1][n-1];
	}
}


TC:O(N*M)
SC:O(N*M)

=======================================Space Optimization=============================================

import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
		int dp[]=new int[n];
		Arrays.fill(dp,1);

		for(int i=1;i<m;i++){
			int temp[]=new int[n];
			temp[0]=1;

			for(int j=1;j<n;j++){

				int up=0;
				int left=0;
				
				up=dp[j];
				left=temp[j-1];
				
				temp[j]=up+left;
			}
			dp=temp;
		}

		return dp[n-1];
	}
}


TC:O(N*M)
SC:O(M)
