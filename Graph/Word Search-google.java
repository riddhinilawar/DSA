79. Word Search

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 

Follow up: Could you use search pruning to make your solution faster with a larger board?

class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        int vis[][]=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(word.charAt(0)==board[i][j] && helper(0,i,j,board,word,n,m,vis)==true)
                    return true;
            }
        }
        return false;
    }

    public boolean helper(int idx,int i,int j,char[][] board, String word,int n,int m,int vis[][]){
        if(idx==word.length()-1){
            return true;
        }
        vis[i][j]=1;
        int neg[][]={{0,1},{0,-1},{1,0},{-1,0}};
        for(int d=0;d<4;d++){
            int nrow=i+neg[d][0];
            int ncol=j+neg[d][1];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && idx+1<word.length() && board[nrow][ncol]==word.charAt(idx+1) && vis[nrow][ncol]==0){
                if(helper(idx+1,nrow,ncol,board,word,n,m,vis)==true)return true;
            }
        }
        //vis[i][j]=0;
        return false;
    }
}
