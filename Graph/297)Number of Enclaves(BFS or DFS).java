Number of Enclaves

You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
 
Example 1:
 
Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.

Example 2:
 
Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.
 
•	Constraints:
•	m == grid.length
•	n == grid[i].length
•	1 <= m, n <= 500
•	grid[i][j] is either 0 or 1.
class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];

        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if((row==0||row==n-1||col==0||col==m-1)&&grid[row][col]==1&&vis[row][col]==0){
                    bfs(row,col,grid,vis);
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0&&grid[i][j]==1){
                    ans++;
                }
            }
        }
        return ans;
    }
    public void bfs(int row,int col,int grid[][],int vis[][]){
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(row,col));
        vis[row][col]=1;
        int negighbours[][]={{0,1},{0,-1},{1,0},{-1,0}};

        while(!q.isEmpty()){
            int ro=q.peek().first;
            int co=q.peek().second;
            q.remove();
            for(int delta=0;delta<negighbours.length;delta++){
                int nrow=ro+negighbours[delta][0];
                int ncol=co+negighbours[delta][1];
                if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&vis[nrow][ncol]==0&&grid[nrow][ncol]==1){
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
    }
}
class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second; }}
