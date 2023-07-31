Surrounded Regions
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.
 
Example 1:
 

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Notice that an 'O' should not be flipped if:
- It is on the border, or
- It is adjacent to an 'O' that should not be flipped.
The bottom 'O' is on the border, so it is not flipped.
The other three 'O' form a surrounded region, so they are flipped.

Example 2:
Input: board = [["X"]]
Output: [["X"]]
 
Constraints:
•	m == board.length
•	n == board[i].length
•	1 <= m, n <= 200
•	board[i][j] is 'X' or 'O'.




class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int vis[][]=new int[n][m];

        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if((row==0||row==n-1||col==0||col==m-1)&&board[row][col]=='O'&&vis[row][col]==0){
                    bfs(row,col,board,vis);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0&&board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    public void bfs(int row,int col,char board[][],int vis[][]){
        int n=board.length;
        int m=board[0].length;
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
                if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&vis[nrow][ncol]==0&&board[nrow][ncol]=='O'){
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
        this.second=second;
    }}
