85. Maximal Rectangle
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Note:: keep the large element on small in the stack..if small element tries to sit on large element 
then pop out all the largest element and to calculate the area take the help of last element in the stack that is peek element 

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


Solution : TC:NSQUARE
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

========================================================================================================================================================
Solution : TC:NCUBE

class Solution {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        int n=matrix.size();
        int m=matrix[0].size();
        int ans=0;
        vector<vector<int>> dp(matrix.size(),vector<int>(matrix[0].size(),0));
       


        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int y=INT_MAX;
                int x=0;
                dp[i][j]= i-1 >=0 ? dp[i-1][j] : 0;
                if(matrix[i][j]=='1') dp[i][j]++;
                if(matrix[i][j]=='0') dp[i][j]=0;
                for(int k=j;k>=0;k--)
                {
                    if(matrix[i][k]=='1') x++;
                    else break;
                    y= min(y,dp[i][k]);
                    if(y==0) x=0;
                    if(y != INT_MAX) ans= max(ans,x*y);

                }
            }
        }
        return ans;
    }
};
