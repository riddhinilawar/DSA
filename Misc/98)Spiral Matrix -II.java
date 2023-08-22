Spiral Matrix -II                                                                      LC-59
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
Example 1:
 
Input: n = 3                Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:
Input: n = 1                Output: [[1]]
Constraints:
•	1 <= n <= 20
Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(1)
class Solution {
    public int[][] generateMatrix(int n) {
        int counter=1;
        int ans[][]=new int[n][n];
        int top=0,right=n-1,bottom=n-1,left=0;
        while(counter<=(n*n))
        {
            for(int i=left;i<=right;i++)
            {
                ans[top][i]=counter;
                counter++;
            }
            top++;
            
            for(int i=top;i<=bottom;i++)
            {
                ans[i][right]=counter;
                counter++;
            }
            right--;
            
            for(int i=right;i>=left;i--)
            {
                ans[bottom][i]=counter;
                counter++;
            }
            bottom--;
            
            for(int i=bottom;i>=top;i--)
            {
                ans[i][left]=counter;
                counter++;
            }
            left++;
        }
        return ans;
    }
}
