Shortest Source to Destination Path

  Given a 2D binary matrix A(0-based index) of dimensions NxM. Find the minimum number of steps required to reach from (0,0) to (X, Y).
Note: You can only move left, right, up and down, and only through cells that contain 1.

Example 1:

Input:
N=3, M=4
A=[[1,0,0,0], 
   [1,1,0,1],
   [0,1,1,1]]
X=2, Y=3 
Output:
5
Explanation:
The shortest path is as follows:
(0,0)->(1,0)->(1,1)->(2,1)->(2,2)->(2,3).
Example 2:

Input:
N=3, M=4
A=[[1,1,1,1],
   [0,0,0,1],
   [0,0,0,1]]
X=0, Y=3
Output:
3
Explanation:
The shortest path is as follows:
(0,0)->(0,1)->(0,2)->(0,3).
Your Task:
You don't need to read input or print anything. Your task is to complete the function shortestDistance() which takes the integer N, M, X, Y, and the 2D binary matrix A as input parameters and returns the minimum number of steps required to go from (0,0) to (X, Y).If it is impossible to go from (0,0) to (X, Y),then function returns -1. If value of the cell (0,0) is 0 (i.e  A[0][0]=0) then return -1.

Expected Time Complexity:O(N*M)
Expected Auxillary Space:O(N*M)

Constraints:
1 <= N,M <= 250
0 <= X < N
0 <= Y < M
0 <= A[i][j] <= 1



  
  class Solution {
    int shortestDistance(int n, int m, int mat[][], int x, int y) {
        int vis[][]=new int[n][m];

        Queue<Tuple> queue=new LinkedList<>();
        
        //exception case
        if(mat[0][0]==0)return -1;
        if(x==0 && y==0)return 0;
        queue.add(new Tuple(0,0,0));
        
        int directions[][]={{0,1},{0,-1},{1,0},{-1,0}};

        while(!queue.isEmpty()){
            Tuple t=queue.remove();
            int i=t.i;
            int j=t.j;
            int d=t.dist;

            for(int neg=0;neg<directions.length;neg++){
                int ni=i+directions[neg][0];
                int nj=j+directions[neg][1];
                int nd=d+1;

                if(ni>=0 && nj>=0 && ni<n && nj<m && vis[ni][nj]==0 && mat[ni][nj]==1){
                    
                    if(ni==x && nj==y)return nd;
                    
                    vis[ni][nj]=1;
                    queue.add(new Tuple(ni,nj,nd));
                }
            }
        }

        return -1;
    }
};
class Tuple{
    int i;
    int j;
    int dist;
    Tuple(int i,int j,int dist){
        this.i=i;
        this.j=j;
        this.dist=dist;
    }
}
