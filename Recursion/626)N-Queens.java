TC:N!*N
SC:Nsquare

51. N-Queens
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
  
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 

Constraints:

1 <= n <= 9

============================================================Approach 1=================================================
  class Solution {
    
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List < List < String >> res = new ArrayList < List < String >> ();
        dfs(0, board, res);
        return res;
    }

    static void dfs(int col, char[][] board, List < List < String >> res) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (validate(board, row, col)) {
                board[row][col] = 'Q';
                dfs(col + 1, board, res);
                board[row][col] = '.';
            }
        }
    }

    static List < String > construct(char[][] board) {
        List < String > res = new LinkedList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    static boolean validate(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }
}
============================================================Approach 2=================================================
class Solution {
    
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List < List < String >> res = new ArrayList < List < String >> ();
        boolean upperdiag[]=new boolean[(2*n)-1];
        boolean lowerdiag[]=new boolean[(2*n)-1];
        boolean left[]=new boolean[n];
        dfs(0, board, res,upperdiag,lowerdiag,left,n);
        return res;
    }

    static void dfs(int col, char[][] board, List < List < String >> res,boolean upperdiag[],boolean lowerdiag[],boolean left[],int n) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (upperdiag[row+col]==false && left[row]==false && lowerdiag[(n-1)+(col-row)]==false) {
                board[row][col] = 'Q';
                upperdiag[row+col]=true;
                left[row]=true;
                lowerdiag[(n-1)+(col-row)]=true;
                dfs(col + 1, board, res,upperdiag,lowerdiag,left,n);
                board[row][col] = '.';
                upperdiag[row+col]=false;
                left[row]=false;
                lowerdiag[(n-1)+(col-row)]=false;
            }
        }
    }

    static List < String > construct(char[][] board) {
        List < String > res = new LinkedList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
