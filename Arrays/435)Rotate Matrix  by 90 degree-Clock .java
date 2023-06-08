Rotate Matrix  by 90 degree-Clock               LC-48
 
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]         Output: [[7,4,1],[8,5,2],[9,6,3]]
 
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
Constraints:
•	n == matrix.length == matrix[i].length
•	1 <= n <= 20
•	-1000 <= matrix[i][j] <= 1000
Solution 1:Brute force
Approach: Take another dummy matrix of n*n, and then take the first row of the matrix and put it in the last column of the dummy matrix, take the second row of the matrix, and put it in the second last column of the matrix and so.

Time Complexity: O(N*N) to linearly iterate and put it into some other matrix.
Space Complexity: O(N*N) to copy it into some other matrix.

Solution 2: Optimized approach
Intuition: By observation, we see that the first column of the original matrix is the reverse of the first row of the rotated matrix, so that’s why we transpose the matrix and then reverse each row, and since we are making changes in the matrix itself space complexity gets reduced to O(1).
Approach:
Step1: Transpose of the matrix. (transposing means changing columns to rows and rows to columns)
Step2: Reverse each row of the matrix.
Time Complexity: O(N*N) + O(N*N).One O(N*N) for transposing the matrix and the other for reversing the matrix.
Space Complexity: O(1).
Approach 1: public static void rotateby90(int matrix[][], int n) 
	    { 
	        int a[][]=new int[n][n];
	        for(int i=0;i<n;i++)
	        {
	            for(int j=0;j<n;j++)
	            {
	                a[i][j]=matrix[n-1-j][i];
	            }
	        }
	        for(int i=0;i<n;i++)
	        {
	            for(int j=0;j<n;j++)
	            {
	                System.out.print(a[i][j]+" ");
	            }
	            System.out.println();
	        }
	    }

Leetcode Solution:  Approach 2(Tranposition)
class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				int temp=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;
			}
		}
		
		for(int j=0;j<(n/2);j++)
		{
			for(int i=0;i<n;i++)
			{
				//System.out.println(i+" "+j+" "+i+" "+(n-1-j));
				int temp=matrix[i][j];
				matrix[i][j]=matrix[i][n-1-j];
				matrix[i][n-1-j]=temp;
			}
		}
	        
    }
}




Rotate matrix by 90 degrees-anticlock wise

Approach 1: New array 
public static void rotateby90(int matrix[][], int n) 
	    { 
	        int a[][]=new int[n][n];
	        for(int i=0;i<n;i++)
	        {
	            for(int j=0;j<n;j++)
	            {
	                a[i][j]=matrix[j][n-i-1];s
	                //System.out.println("a= i:"+i+" j:"+j+" mat= i:"+j+" j:"+(n-1-i) );
	            }
	        }
	        for(int i=0;i<n;i++)
	        {
	            for(int j=0;j<n;j++)
	            {
	                System.out.print(a[i][j]+" ");
	            }
	            System.out.println();
	        }
	    }
Approach 2: public static void rotateby90(int matrix[][], int n) 
	    { 
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				int temp=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;
			}
		}
		
		for(int i=0;i<(n/2);i++)
		{
			for(int j=0;j<n;j++)
			{
				int temp=matrix[i][j];
				matrix[i][j]=matrix[n-1-i][j];
				matrix[n-1-i][j]=temp;
			}
		}
		
		
		//print
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	    }	}
