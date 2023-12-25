Determinant of a Matrix
Given a square matrix of size n*n. The task is to find the determinant of this matrix.

Example 1:

Input:
n = 4
matrix[][] = {{1, 0, 2, -1},
              {3, 0, 0, 5},
              {2, 1, 4, -3},
              {1, 0, 5, 0}}
Output: 30
Explanation:
Determinant of the given matrix is 30.
Example 2:

Input:
n = 3
matrix[][] = {{1, 2, 3},
              {4, 5, 6},
              {7, 10, 9}}
Output: 12
Explanation:
Determinant of the given matrix is 12.
Your Task:
You don't need to read input or print anything. Complete the function determinantOfMatrix() that takes matrix and its size n as input parameters and returns the determinant of the matrix.

Expected Time Complexity: O(N4)
Expected Auxiliary Space: O(N2)

Constraints:
1 <= N <= 10
-10 <= mat[i][j] <= 10

class Solution{
    //Function for finding determinant of matrix.
    static int determinantOfMatrix(int matrix[][], int n){
        return helper(matrix,n);
    }
    public static int helper(int matrix[][], int n){
        
        if(n==1)return matrix[0][0];
        
        int ans=0;
        int sign=1;
        
        for(int col=0;col<n;col++){
            
            ans+=(sign*(matrix[0][col]*helper(getMatrix(matrix,col,n),n-1)));
            sign*=-1;
            
        }
        
        
        return ans;
    }
    public static int[][] getMatrix(int matrix[][], int col,int n){
        
        int mat[][]=new int[n-1][n-1];
        
        for(int i=1;i<n;i++){
            for(int j=0,k=0;j<n;j++,k++){
                
                if(j==col){
                    k--;
                    continue;
                    
                }
                mat[i-1][k]=matrix[i][j];
                
            }
        }
        
        return mat;
    }
}
