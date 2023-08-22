Reverse Spiral form of matrix,gfg
Given a matrix as 2D array. Find the reverse spiral traversal of the matrix. 
Example 1:
Input: R = 3, C = 3
  a = {{9, 8, 7},
       {6, 5, 4},
       {3, 2, 1}}
Output: 5 6 3 2 1 4 7 8 9
Explanation: Spiral form of the matrix
in reverse order starts from the centre 
and goes outward.
 
Example 2:
Input: R = 4, C = 4 
  a = {{1, 2, 3, 4},
       {5, 6, 7, 8},
       {9, 10, 11, 12}, 
       {13, 14, 15, 16}}
Output: 10 11 7 6 5 9 13 14 15 16 12 8 4 3 2 1
Explanation: 
 
Your Task:  
You dont need to read input or print anything. Complete the function reverseSpiral() which takes R, C and a as input parameters and returns the matrix in reverse spiral form.
Constraints:
1 <= R,C <=100
1 <= a[R][C] <=100
Expected Time Complexity: O(M*N)
Expected Auxiliary Space: O(1)



class Solution
{
    public int[] reverseSpiral(int R, int C, int[][] a)
    {
        int ans[]=new int[R*C];
        int idx=R*C-1;
        
        int top=0,left=0,right=C-1,bottom=R-1;
        
        
        while(top<=bottom && left<=right)
        {
            for(int i=left;i<=right;i++)
            {
                ans[idx] = a[top][i];
                idx--;
            }
            top++;
            
            for(int i=top;i<=bottom;i++)
            {
                ans[idx] = a[i][right];
                idx--;
            }
            right--;
            
            if(top<=bottom && left<=right)
            {
            for(int i=right;i>=left;i--)
            {
                ans[idx] = a[bottom][i];
                idx--;
            }
            bottom--;
            }
            
             if(top<=bottom && left<=right)
            {
            for(int i=bottom;i>=top;i--)
            {
                ans[idx] = a[i][left];
                idx--;
            }
            left++;
            }
            
        }
        return ans;
    }
}
