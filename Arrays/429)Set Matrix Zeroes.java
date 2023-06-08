Set Matrix Zeroes                                         LC-73


Problem Statement: Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix.
Solution 1:
Approach: Using brute force
Assuming all the elements in the matrix are non-negative. Traverse through the matrix and if you find an element with value 0, then change all the elements in its row and column to -1, except when an element is 0. The reason for not changing other elements to 0, but -1, is because that might affect other columns and rows. Now traverse through the matrix again and if an element is -1 change it to 0, which will be the answer.

Time Complexity:O((N*M)*(N + M)). O(N*M) for traversing through each element and (N+M)for traversing to row and column of elements having value 0.
Space Complexity:O(1)

Solution 2: Better approach
Intuition: Instead of traversing through each row and column, we can use dummy arrays to check if the particular row or column has an element 0 or not, which will improve the time complexity.
Approach:Take two dummy array one of size of row and other of size of column.Now traverse through the array.If matrix[i][j]==0 then set dummy1[i]=0(for row) and dummy2[j]=0(for column).Now traverse through the array again and if dummy1[i]==0  || dummy2[j]==0 then arr[i][j]=0,else continue.

Time Complexity: O(N*M + N*M) 
Space Complexity: O(N)
Solution 3:Optimizing the better approach.
Intuition: Instead of taking two dummy arrays we can use the first row and column of the matrix for the same work. This will help to reduce the space complexity of the problem. While traversing for the second time the first row and column will be computed first, which will affect the values of further elements that’s why we traversing in the reverse direction.
Approach:Instead of taking two separate dummy array,take first row and column of the matrix as the array for checking whether the particular column or row has the value 0 or not.Since matrix[0][0] are overlapping.Therefore take separate variable col0(say) to check if the 0th column has 0 or not and use matrix[0][0] to check if the 0th row has 0 or not.Now traverse from last element to the first element and check if matrix[i][0]==0 || matrix[0][j]==0 and if true set matrix[i][j]=0,else continue.

Time Complexity: O(2*(N*M)), as we are traversing two times in a matrix,
Space Complexity: O(1).




LC 73. Set Matrix Zeroes

 
Leetcode
class Solution {
    public void setZeroes(int[][] m) {
        int rows=m.length;
        int column=m[0].length;
        int col0=1;
        
        for(int i=0;i<rows;i++)
        {
            if(m[i][0]==0)col0=0;
            for(int j=1;j<column;j++)
            {
                if(m[i][j]==0)
                {
                    m[i][0]=0;
                    m[0][j]=0;
                }
            }
        }
        
        for(int i=rows-1;i>=0;i--)
        {
            
            for(int j=column-1;j>0;j--)
            {
                if(m[i][0]==0||m[0][j]==0)
                {
                    m[i][j]=0;
                }
            }
            if(col0==0)m[i][0]=0;
        }
        
    }
}
Exceptions:
Input:[[-4,-2147483648,6,-7,0],[-8,6,-8,-6,0],[2147483647,2,-9,-6,-10]]
Output:[[0,0,0,0,0],[0,0,0,0,0],[0,2,-9,-6,0]]
Expected:[[0,0,0,0,0],[0,0,0,0,0],[2147483647,2,-9,-6,0]]
While traversing through matrix 2nd time , loop two should end at 1

Input:[[1,0]]
Output:[[1,0]]
Expected:[[0,0]]
Col0 should be maintained to for column 0 record

Constraints:
m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 
Follow up:
A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

//actual logic
		
        int r_arr[]=new int[matrix.length];
        int c_arr[]=new int[matrix[0].length];
        
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    r_arr[i]=-1;
                    c_arr[j]=-1;
                }
            }
        }
        
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(r_arr[i]==-1||c_arr[j]==-1)
                {
                    matrix[i][j]=0;
                }
            }
        }
