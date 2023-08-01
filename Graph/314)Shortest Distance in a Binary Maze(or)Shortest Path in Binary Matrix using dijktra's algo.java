
Shortest Distance in a Binary Maze

Given a n * m matrix grid where each element can either be 0 or 1. You need to find the shortest distance between a given source cell to a destination cell. The path can only be created out of a cell if its value is 1. 
If the path is not possible between source cell and destination cell, then return -1.
Note : You can move into an adjacent cell if that adjacent cell is filled with element 1. Two cells are adjacent if they share a side. In other words, you can move in one of the four directions, Up, Down, Left and Right. The source and destination cell are based on the zero based indexing.
Example 1:
Input:
grid[][] = {{1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 1}}
source = {0, 1}
destination = {2, 2}
Output:
3
Explanation:
1 1 1 1
1 1 0 1
1 1 1 1
1 1 0 0
1 0 0 1
The highlighted part in the matrix denotes the 
shortest path from source to destination cell.
Example 2:
Input:
grid[][] = {{1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0},
            {1, 0, 1, 0, 1}}
source = {0, 0}
destination = {3, 4}
Output:
-1
Explanation:
The path is not possible between source and 
destination, hence return -1.
Your Task:
You don't need to read or print anything. Your task is to complete the function shortestPath() which takes the a 2D integer array grid, source cell and destination cell as an input parameters and returns the shortest distance between source and destination cell.
Expected Time Complexity: O(n * m)
Expected Space Complexity: O(n * m)
Constraints:
•	1 ≤ n, m ≤ 500
•	grid[i][j] == 0 or grid[i][j] == 1
•	The source and destination cells are always inside the given matrix.
class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        int si=source[0];
        int sj=source[1];
        
        if(grid[si][sj]==0)
            return -1;
        
        int di=destination[0];
        int dj=destination[1];
        
        if(grid[di][dj]==0)
            return -1;
        
        if(si==di && sj==dj)
            return 0;
        
        int n=grid.length;
        int m=grid[0].length;
        
        int vis[][]=new int[n][m];
        
        vis[si][sj]=1;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,si,sj));
        
        int neg[][]={{0,1},{0,-1},{1,0},{-1,0}};
        
        while(!q.isEmpty()){
            
            Pair p = q.poll();
            
            int i=p.i;
            int j=p.j;
            int distance=p.dist;
            
            for(int k=0;k<4;k++){
                
                int ni=i+neg[k][0];
                int nj=j+neg[k][1];
                int ndistance=distance+1;
                
                //System.out.println(ni+" "+nj);

                if(ni>=0 && nj>=0 && ni<n && nj<m && grid[ni][nj]==1 && vis[ni][nj]==0){
                    vis[ni][nj]=1;
                    if(ni == di && nj == dj)
                        return ndistance;
                    
                    q.add(new Pair( ndistance,ni,nj));
                }
                
            }
        }
        
        return -1;
    }
}
class Pair{
    int dist;
    int i;
    int j;
    Pair(int dist,int i,int j){
        this.dist=dist;
        this.i=i;
        this.j=j;
    }
}



































1091. Shortest Path in Binary Matrix

Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.
 
Example 1:
 
Input: grid = [[0,1],[1,0]]
Output: 2
Example 2:
 
Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
Example 3:
Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
 
Constraints:
n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1

class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n=grid.length;
        int m=grid[0].length;

        int si=0;
        int sj=0;
        
        if(grid[si][sj]==1)
            return -1;
        
        int di=n-1;
        int dj=m-1;
        
        if(grid[di][dj]==1)
            return -1;
        
        if(si==di && sj==dj)
            return 1;
        
        
        
        int vis[][]=new int[n][m];
        
        vis[si][sj]=1;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,si,sj));
        
        int neg[][]={{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
        
        while(!q.isEmpty()){
            
            Pair p = q.poll();
            
            int i=p.i;
            int j=p.j;
            int distance=p.dist;
            
            for(int k=0;k<8;k++){
                
                int ni=i+neg[k][0];
                int nj=j+neg[k][1];
                int ndistance=distance+1;
                
                //System.out.println(ni+" "+nj);

                if(ni>=0 && nj>=0 && ni<n && nj<m && grid[ni][nj]==0 && vis[ni][nj]==0){
                    vis[ni][nj]=1;

                    if(ni == di && nj == dj)
                        return ndistance+1;
                    
                    q.add(new Pair( ndistance,ni,nj));
                }
                
            }
        }
        
        return -1;
    }
}
class Pair{
    int dist;
    int i;
    int j;
    Pair(int dist,int i,int j){
        this.dist=dist;
        this.i=i;
        this.j=j;
    }
}










