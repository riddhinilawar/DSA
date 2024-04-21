01 Matrix (BFS)
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.
 
Example 1:
 
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:
 
Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 
Constraints:
•	m == mat.length
•	n == mat[i].length
•	1 <= m, n <= 104
•	1 <= m * n <= 104
•	mat[i][j] is either 0 or 1.
•	There is at least one 0 in mat.




class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int vis[][]=new int[n][m];
        int dis[][]=new int[n][m];
        Queue<Pair> q=new LinkedList<Pair>();

        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(mat[row][col]==0){
                    q.add(new Pair(row,col,0));
                    vis[row][col]=1;
                    dis[row][col]=0;
                }
            }
        }

        int neighbours[][]={{0,-1},{0,1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int ro=q.peek().first;
            int co=q.peek().second;
            int distance=q.peek().distance;
            q.remove();
            //dis[ro][co]=distance;
            
            for(int delta=0;delta<neighbours.length;delta++){
                int nrow=ro+neighbours[delta][0];
                int ncol=co+neighbours[delta][1];
                if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&mat[nrow][ncol]==1&&vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    dis[nrow][ncol]=distance+1;
                    q.add(new Pair(nrow,ncol,distance+1));
                }
            }
          
        }
        return dis;
    }
}
class Pair{
    int first;
    int second;
    int distance;
    Pair(int first,int second,int distance){
        this.first=first;
        this.second=second;
        this.distance=distance;
    }
}
