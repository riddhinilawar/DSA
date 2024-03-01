Problem statement
Given a ‘N’ * ’M’ maze with obstacles, count and return the number of unique paths to reach the right-bottom cell from the top-left cell. A cell in the given maze has a value '-1' if it is a blockage or dead-end, else 0. From a given cell, we are allowed to move to cells (i+1, j) and (i, j+1) only. Since the answer can be large, print it modulo 10^9 + 7.

For Example :
Consider the maze below :
0 0 0 
0 -1 0 
0 0 0

There are two ways to reach the bottom left corner - 

(1, 1) -> (1, 2) -> (1, 3) -> (2, 3) -> (3, 3)
(1, 1) -> (2, 1) -> (3, 1) -> (3, 2) -> (3, 3)

Hence the answer for the above test case is 2.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= T <= 10
1 <= N,M <= 200

Note: It is guaranteed that the top-left cell does not have an obstacle.

Time Limit: 1 sec
Sample Input 1 :
2    
2 2
0 0
0 0
3 3
0 0 0 
0 -1 0 
0 0 0
Sample Output 1 :
2
2
Explanation For Sample Output 1 :
For the first test case, there are two possible paths to reach (2, 2) from (1, 1) : 
    (1, 1) -> (1, 2) -> (2, 2)
    (1, 1) -> (2, 1) -> (2, 2)

For the second test case, there are two ways to reach the bottom left corner - 
(1, 1) -> (1, 2) -> (1, 3) -> (2, 3) -> (3, 3)
(1, 1) -> (2, 1) -> (3, 1) -> (3, 2) -> (3, 3)
Sample Input 2 :
1
2 2
0 -1
-1  0
Sample Output 2 :
0



====================================Recursion========================================
import java.util.*;
public class Solution {
    static int mazeObstacles(int m, int n, ArrayList<ArrayList<Integer>> mat) {
        return helper(m-1,n-1,mat);
	}
	public static int helper(int m,int n,ArrayList<ArrayList<Integer>> mat){
    if(m>=0 && n>=0 && mat.get(m).get(n)==-1)return 0;
		if(m==0 && n==0){
			return 1;
		}
		if(m<0 || n<0){
			return 0;
		}
		int left=helper(m-1,n,mat);
		int top=helper(m,n-1,mat);
		return left+top;
	}

}


TC:-O(branches to the power depth) ~ O(2^(m*n))
SC:-O(m*n)

================================Memoization===========================================

import java.util.*;
public class Solution {
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int dp[][]=new int[n][m];
		for(int temp[]:dp)Arrays.fill(temp,-1);
        return helper(n-1,m-1,mat,dp);
	}
	public static int helper(int n,int m,ArrayList<ArrayList<Integer>> mat,int[][] dp){
        if(m>=0 && n>=0 && mat.get(n).get(m)==-1){
			return dp[n][m]=0;
		}
		if(m==0 && n==0){
			return dp[n][m]=1;
		}
		if(m<0 || n<0){
			return 0;
		}
        if(dp[n][m]!=-1){
			return dp[n][m];
		}
		int left=helper(n-1,m,mat,dp);
		int top=helper(n,m-1,mat,dp);
		return dp[n][m]=left+top;
	}

}
TC:O(N*M)
SC:O(N*M)

================================Tabulation========================================
import java.util.*;
public class Solution {
    static int mazeObstacles(int m, int n, ArrayList<ArrayList<Integer>> mat) {
		if(mat.get(0).get(0)==-1)return 0;
		if(mat.get(m-1).get(n-1)==-1)return 0;
        int dp[][]=new int[m][n];
		dp[0][0]=1;

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				
				if(mat.get(i).get(j)==-1){
					dp[i][j]=0;
					continue;
				}
				
				if(i==0 && j==0){
					continue;
				}
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

=================================Space Optimization============================================
