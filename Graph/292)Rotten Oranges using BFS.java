Rotten Oranges: (BFS)
You are given an m x n grid where each cell can have one of three values:
•	0 representing an empty cell,
•	1 representing a fresh orange, or
•	2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 
Example 1:
 
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 
Constraints:
•	m == grid.length
•	n == grid[i].length
•	1 <= m, n <= 10
•	grid[i][j] is 0, 1, or 2.


class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        Queue<Pair> q = new LinkedList<Pair>();

        int cntfresh=0;

        for(int row=0;row<n;row++)
            for(int col=0;col<m;col++){
                if(grid[row][col]==1)cntfresh++;
                if(grid[row][col]==2){
                    q.add(new Pair(row,col,0));
                    vis[row][col]=1;
                }
            }
        int neighbours[][]={{-1,0},{1,0},{0,-1},{0,1}};
        int cnt1=0;
        int ans=0;
        while(!q.isEmpty()){
            int ro=q.peek().first;
            int co=q.peek().second;
            int tm=q.peek().tm;
            q.remove();

            for(int delta=0;delta<neighbours.length;delta++){
                int nrow=ro+neighbours[delta][0];
                int ncol=co+neighbours[delta][1];
                int ntm=tm;
                ans=Math.max(ans,ntm);

                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]!=1){
                    grid[nrow][ncol]=2;
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol,ntm+1));
                    cnt1++;
                }
            }
        }
        if(cnt1!=cntfresh)return -1;
        return ans;
    }
}
class Pair
{
    int first;
    int second;
    int tm;
    Pair(int first,int second,int tm)
    {
        this.first=first;
        this.second=second;
        this.tm=tm;
    }
}
