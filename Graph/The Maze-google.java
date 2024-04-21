import java.util.*;

class Solution{
    static int[] dirR = {1,-1,0,0};
    static int[] dirC = {0,0,1,-1};
    static int m, n;
    public boolean solve(int mat[][], int m, int n, int srci, int srcj, int disti, int distj){
        int[][] vis = new int[m][n];
        this.m = m;
        this.n = n;
        
        return dfs(mat, vis, srci, srcj, disti, distj);
    }
    
    boolean dfs(int mat[][], int vis[][], int srci, int srcj, int disti, int distj ){
        
        //if the cell is already visited//
        if(vis[srci][srcj]==1){
            return false;
        }
        
        //If source reached destination//
        if(srci==disti && srcj==distj){
            return true;
        }
        
        vis[srci][srcj] = 1;
        for(int k=0; k<4; k++){
            int negi = srci;
            int negj = srcj;
            int diri= dirR[k];
            int dirj= dirC[k];
            
            //go in the same direction until you hit wall//
            while(negi+diri>=0 && negj+dirj>=0 && negi+diri<n && negj+dirj<m && mat[negi+diri][negj+dirj]!=1){
                negi+=diri;
                negj+=dirj;
            }
            
            if(dfs(mat,vis,negi,negj,disti,distj))return true;
        }
        
        return false;
    }
}


public class Main {
    public static void main(String[] args) {
        // 1st Case //
        // int m = 5, n = 5;
        // int[][] mat = {{0,0,1,0,0},
        //                 {0,0,0,0,0},
        //                 {0,0,0,1,0},
        //                 {1,1,0,1,1},
        //                 {0,0,0,0,0}};
        // int[] source = {0, 4};
        // int[] destination = {4, 4};
        
        // 2nd Case //
        int m = 5, n = 5;
        int[][] mat = {{0,0,1,0,0},
                        {0,0,0,0,0},
                        {0,0,0,1,0},
                        {1,1,0,1,1},
                        {0,0,0,0,0}};
        int[] source = {0, 4};
        int[] destination = {3, 2};
        
        Solution obj = new Solution();
        boolean ans = obj.solve(mat, m, n, source[0], source[1], destination[0], destination[1]);
        System.out.println("Answer : " + ans);
    }
}


/*
490. The Maze
There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.

 

Example 1:

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: true

Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

Example 2:

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: false

Explanation: There is no way for the ball to stop at the destination.

 

Note:

There is only one ball and one destination in the maze.
Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.

*/
