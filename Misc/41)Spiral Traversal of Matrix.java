Spiral Traversal of Matrix, gfg,LC-54
Given an m x n matrix, return all elements of the matrix in spiral order.
 

Example 1:
 
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]



Example 2:
 
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 
Constraints:
•	m == matrix.length
•	n == matrix[i].length
•	1 <= m, n <= 10
•	-100 <= matrix[i][j] <= 100









Approach:

Printing a matrix in spiral form is the same as peeling an onion layer by layer. Because we are printing the elements layer by layer starting from the outer layers.

 

In this approach, we will be using four loops to print all four sides of the matrix.
1st loop: This will print the elements from left to right.
2nd loop: This will print the elements from top to bottom.
3rd loop: This will print the elements from right to left.
4th loop: This will print the elements from bottom to top.

Steps:
Create and initialize variables top as starting row index, bottom as ending row index left as starting column index, and right as ending column index. As shown in the image given below.

 

In each outer loop traversal print the elements of a square in a clockwise manner.
Print the top row, i.e. Print the elements of the top row from column index left to right and increase the count of the top so that it will move to the next row.
Print the right column, i.e. Print the rightmost column from row index top to bottom and decrease the count of right.
Print the bottom row, i.e. if top <= bottom, then print the elements of a bottom row from column right to left and decrease the count of bottom
Print the left column, i.e. if left <= right, then print the elements of the left column from the bottom row to the top row and increase the count of left.
Run a loop until all the squares of loops are printed.






Leetcode:

class Solution {
    public List<Integer> spiralOrder(int[][] a) {
        
        int n=a.length;
        int m=a[0].length;
        
        
        
        int top=0, right=m-1, bottom=n-1, left=0;
        
        List<Integer> l=new ArrayList<Integer>();
	    
	    while(top<=bottom && left<=right)
	    {
	        for(int i=left;i<=right;i++)
	        {
	            //System.out.print(a[top][i]+" ");
                   l.add(a[top][i]);
	        }
	        top++;
	        
	        for(int i=top;i<=bottom;i++)
	        {
	            //System.out.print(a[i][right]+" ");
                   l.add(a[i][right]);
	        }
	        right--;
	        
	        if(top<=bottom)
	        {
	            for(int i=right;i>=left;i--)
	            {
	                //System.out.print(a[bottom][i]+" ");
                       l.add(a[bottom][i]);
	            }
	            bottom--;
	        }
	        
	        if(left<=right)
	        {
	             for(int i=bottom;i>=top;i--)
	            {
	               //System.out.print(a[i][left]+" ");
                       l.add(a[i][left]);
	            }
	            left++;
	        }
	    }
        return l;
    }
}
GFG: here we need to find the kth element in kth matrix after traversal. 
class Solution {
    public List<Integer> spiralOrder(int[][] a) {
        
        int n=a.length;
        int m=a[0].length;
        
        int top=0, right=m-1, bottom=n-1, left=0;
        
        List<Integer> l=new ArrayList<Integer>();
	    
	    while(top<=bottom && left<=right)
	    {
	        for(int i=left;i<=right;i++)
	        {
	            //System.out.print(a[top][i]+" ");
                l.add(a[top][i]);
	        }
	        top++;
	        
	        for(int i=top;i<=bottom;i++)
	        {
	            //System.out.print(a[i][right]+" ");
                l.add(a[i][right]);
	        }
	        right--;
	        
	        if(top<=bottom)
	        {
	            for(int i=right;i>=left;i--)
	            {
	                //System.out.print(a[bottom][i]+" ");
                    l.add(a[bottom][i]);
	            }
	            bottom--;
	        }
	        
	        if(left<=right)
	        {
	             for(int i=bottom;i>=top;i--)
	            {
	               //System.out.print(a[i][left]+" ");
                     l.add(a[i][left]);
	            }
	            left++;
	        }
	    }
        return l;
    }
}
Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(1)
