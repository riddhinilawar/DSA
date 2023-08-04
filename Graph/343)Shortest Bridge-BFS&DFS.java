934. Shortest Bridge

You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
You may change 0's to 1's to connect the two islands to form one island.
Return the smallest number of 0's you must flip to connect the two islands.
 
Example 1:
Input: grid = [[0,1],[1,0]]
Output: 1
Example 2:
Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2
Example 3:
Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1
 
Constraints:
n == grid.length == grid[i].length
2 <= n <= 100
grid[i][j] is either 0 or 1.
There are exactly two islands in grid.


class Solution {
    public int shortestBridge(int[][] grid) {
        
        int m=grid.length;
        int n=grid[0].length;

        Queue<Pair> q= new LinkedList<>();
        int neg[][]={{1,0},{-1,0},{0,1},{0,-1}};
        int vis[][]=new int[n][m];

        boolean breakk=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    changeValueDFS(i,j,neg,q,n,m,vis,grid);
                    breakk=true;
                    break;
                }
            }
            if(breakk==true)break;
        }

        int level=0;
        

        while(!q.isEmpty()){

            int size=q.size();

            for(int k=0;k<size;k++){

                Pair p = q.poll();
                int i=p.i;
                int j=p.j;

                for(int[]ne:neg){
                    int ni=i+ne[0];
                    int nj=j+ne[1];

                    if(ni>=0 && nj>=0 && ni<n && nj<m && vis[ni][nj]==0 && grid[ni][nj]!=2){
                        if(grid[ni][nj]==1)return level;
                        vis[ni][nj]=1;
                        q.add(new Pair(ni,nj));
                    }
                }
            }

            level++;
        }

        return level;

    }

    public void changeValueDFS(int i,int j,int neg[][],Queue<Pair> q,int n,int m,int vis[][],int grid[][]){
        vis[i][j] = 1;
        grid[i][j] = 2;
        q.add(new Pair(i,j));

        for(int ne=0;ne<4;ne++){
            int ni=i+neg[ne][0];
            int nj=j+neg[ne][1];

            if(ni>=0 && nj>=0 && ni<n && nj<m && grid[ni][nj]==1 && vis[ni][nj]==0){
                changeValueDFS(ni,nj,neg,q,n,m,vis,grid);
            }
        }
    }
}
class Pair{
    int i;
    int j;
    Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}
