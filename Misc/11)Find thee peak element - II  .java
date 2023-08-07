Find thee peak element - II                  LC-1901      
A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.
Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].
You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.
Example 1:
 
Input: mat = [[1,4],[3,2]]
Output: [0,1]
Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.
Example 2:
 
Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
Output: [1,1]
Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
 
Constraints:
•	m == mat.length
•	n == mat[i].length
•	1 <= m, n <= 500
•	1 <= mat[i][j] <= 105
•	No two adjacent cells are equal.
Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(1)







class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        int n=mat.length;
        int m=mat[0].length;

        if(n==1&&m==1)return new int[]{0,0};

        int i=0,j=0;
        int curr=mat[0][0];

        while(true)
        {
            boolean flag=true;
            int max=0;
            int max_i=i;
            int max_j=j;

            if(i>0&&curr<mat[i-1][j]&&flag==true)
            {
                //System.out.println("In 1");
                flag=false;
                max=mat[i-1][j];
                max_i=i-1;
            }

            if(j>0&&curr<mat[i][j-1]&&flag==true)
            {
                 //System.out.println("In 2");
                flag=false;
                max=mat[i][j-1];
                max_j=j-1;
 .           }

            if(i<n-1&&curr<mat[i+1][j]&&flag==true)
            {
                 //System.out.println("In 3");
                flag=false;
                max=mat[i+1][j];
                max_i=i+1;
            }
.;;;;;
            if(j<m-1&&curr<mat[i][j+1]&&flag==true)
            {
                 //System.out.println("In 4");
                flag=false;
                max=mat[i][j+1];
                max_j=j+1;
            }

            if(flag==true)
            {
                return new int[]{i,j};
            }
            else
            {
                curr=max;
                i=max_i;
                j=max_j;
            }
        }
        
    }
}
Suggested by others:O(nlogm) complexity
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int startCol = 0, endCol = mat[0].length-1;
        
        while(startCol <= endCol){
            int maxRow = 0, midCol = startCol + (endCol-startCol)/2;
            
            for(int row=0; row<mat.length; row++){
                 maxRow = mat[row][midCol] >= mat[maxRow][midCol]? row : maxRow;  
            }
            
            boolean leftIsBig    =   midCol-1 >= startCol  &&  mat[maxRow][midCol-1] > mat[maxRow][midCol];
            boolean rightIsBig   =   midCol+1 <= endCol    &&  mat[maxRow][midCol+1] > mat[maxRow][midCol];
            
            if(!leftIsBig && !rightIsBig)   // we have found the peak element
                return new int[]{maxRow, midCol};
            
            else if(rightIsBig)  // if rightIsBig, then there is an element in 'right' that is bigger than all the elements in the 'midCol', 
                startCol = midCol+1; //so 'midCol' cannot have a 'peakPlane'
            
            else // leftIsBig
                endCol = midCol-1;
        }
        return null;
    }
}
 
Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(1)
