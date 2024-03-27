Find shortest safe route in a matrix


Given a matrix mat[][] with r rows and c columns, where some cells are landmines (marked as 0) and others are safe to traverse. Your task is to find the shortest safe route from any cell in the leftmost column to any cell in the rightmost column of the mat. You cannot move diagonally, and you must avoid both the landmines and their adjacent cells (up, down, left, right), as they are also unsafe.

Example 1:

Input:
mat = [1, 0, 1, 1, 1],
      [1, 1, 1, 1, 1],
      [1, 1, 1, 1, 1],
      [1, 1, 1, 0, 1],
      [1, 1, 1, 1, 0]
Output: 
6
Explanation: 
We can see that length of shortest
safe route is 6
[1 0 1 1 1]
[1 1 1 1 1] 
[1 1 1 1 1]
[1 1 1 0 1] 
[1 1 1 1 0]
Example 2:

Input:
mat = [1, 1, 1, 1, 1],
      [1, 1, 0, 1, 1],
      [1, 1, 1, 1, 1]
Output: 
-1
Explanation: There is no possible path from
first column to last column.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findShortestPath() which takes the matrix as an input parameter and returns an integer denoting the shortest safe path from any cell in the leftmost column to any cell in the rightmost column of mat. If there is no possible path, return -1. 

Expected Time Complexity: O(r * c)
Expected Auxiliary Space: O(r * c)

Constraints:
1 <= r, c <= 103
0 <= mat[][] <= 1


=============================================Recursive Approach===========================================

class Solution {
    public static int findShortestPath(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int mtx[][]=new int[n][m];
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(mat[i][j]==0){
                    
                    mtx[i][j]=2;
                    if(i>0){
                        mtx[i-1][j]=2;
                    }
                    if(i<n-1){
                        mtx[i+1][j]=2;
                    }
                    if(j>0){
                        mtx[i][j-1]=2;
                    }
                    if(j<m-1){
                        mtx[i][j+1]=2;
                    }
                }
            }
        }
        
        int ans=(int)1e5;
        for(int i=0;i<n;i++){
            vis[i][0]=true;
            if(mtx[i][0]!=2)
                ans=Math.min(ans,helper(i,0,mtx,n,m,vis));
        }
        return (ans==(int)1e5)?-1:ans;
    }
    
    public static int helper(int row,int col,int[][] mtx,int n,int m,boolean vis[][]){
        if(col==m-1){
            return 1;
        }
        if(row<0 || row>=n){
            return (int)1e5;
        }
        if(col<0){
            return (int)1e5;
        }
        
        int neg[][]={{0,1},{0,-1},{1,0},{-1,0}};
        
        int total=(int)1e5;
        for(int d=0;d<4;d++){
            int nrow=row+neg[d][0];
            int ncol=col+neg[d][1];
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && mtx[nrow][ncol]!=2 && vis[nrow][ncol]==false){
                vis[nrow][ncol]=true;
                total=Math.min(total,1+helper(nrow,ncol,mtx,n,m,vis));
                vis[nrow][ncol]=false;
            }
            
        }
        
        return total;
        
    }
}
