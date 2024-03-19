85. Maximal Rectangle


Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = [["0"]]
Output: 0
Example 3:

Input: matrix = [["1"]]
Output: 1
 

Constraints:

rows == matrix.length
cols == matrix[i].length
1 <= row, cols <= 200
matrix[i][j] is '0' or '1'.


public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;

        int cLen = matrix[0].length;    // column length
        int rLen = matrix.length;       // row length
        
        int[] h = new int[cLen+1];  // height array 
        int max = 0;
        
        
        for (int row=0;row<rLen;row++) {

            Stack<Integer> s = new Stack<Integer>();

            for (int i=0;i<cLen+1;i++) {
                if (i<cLen)
                    if(matrix[row][i]=='1')
                        h[i]+=1;
                    else h[i]=0;
                
                //if (i<cLen)System.out.println(row+" "+i+" "+h[i]+" "+matrix[row][i]+s);
                int area=0;
                if (s.isEmpty()||h[s.peek()]<h[i])
                    s.push(i);
                else {
                    while(!s.isEmpty()&&h[i]<=h[s.peek()]){
                        int top = s.pop();
                        area = h[top]*(s.isEmpty()?i:(i-s.peek()-1));
                        if (area>max)
                            max = area;
                    }
                    s.push(i);
                }

                //System.out.println(max+" "+s);
            }
        }
        return max;
    }
}
