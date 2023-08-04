Find number of closed islands
Given a binary matrix mat[][] of dimensions NxM such that 1 denotes land and 0 denotes water. Find the number of closed islands in the given matrix.
Note: A closed island is a group of 1s surrounded by only 0s on all the boundaries (except diagonals). In simple words, a closed island is an island whose none of the 1s lie on the edges of the matrix.
Example 1:
Input:
N = 5, M = 8
mat[][] = {{0, 0, 0, 0, 0, 0, 0, 1}, 
           {0, 1, 1, 1, 1, 0, 0, 1}, 
           {0, 1, 0, 1, 0, 0, 0, 1}, 
           {0, 1, 1, 1, 1, 0, 1, 0}, 
           {1, 0, 0, 0, 0, 1, 0, 1}}
Output:
2
Explanation:
mat[][] = {{0, 0, 0, 0, 0, 0, 0, 1}, 
           {0, 1, 1, 1, 1, 0, 0, 1}, 
           {0, 1, 0, 1, 0, 0, 0, 1}, 
           {0, 1, 1, 1, 1, 0, 1, 0}, 
           {1, 0, 0, 0, 0, 1, 0, 1}} 
There are 2 closed islands. The islands in dark are closed because they are completely surrounded by 0s (water). There are two more islands in the last column of the matrix, but they are not completely surrounded by 0s. Hence they are not closed islands. 
Example 2:
Input:
N = 3, M = 3
mat[][] = {{1, 0, 0},
           {0, 1, 0},
           {0, 0, 1}}
Output: 
1
Explanation:
mat[][] = {{1, 0, 0},
          {0, 1, 0},
          {0, 0, 1}}
There is just a one closed island.
Your task:
You dont need to read input or print anything. Your task is to complete the function closedIslands() which takes two integers N and M, and a 2D binary matrix mat as input parameters and returns the number of closed islands.
Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(N*M)
Constraints:
1 ≤ N,M ≤ 500



class Solution
{
    public int closedIslands(int[][] matrix, int N, int M)
    {
        int vis[][]=new int[N][M];
        
        for(int i=0;i<N;i++){
            if(vis[i][0]!=1 && matrix[i][0]==1){
                //System.out.println(i+" 0");
                dfs(matrix,i,0,N,M,vis);
            }
            if(vis[i][M-1]!=1 && matrix[i][M-1]==1){
                //System.out.println(i+" "+(M-1));
                dfs(matrix,i,M-1,N,M,vis);
            }
        }
        
        for(int i=0;i<M;i++){
            if(vis[0][i]!=1 && matrix[0][i]==1){
                //System.out.println("0 "+i);
                dfs(matrix,0,i,N,M,vis);
            }
            if(vis[N-1][i]!=1 && matrix[N-1][i]==1){
                //System.out.println((N-1)+" "+i);
                dfs(matrix,N-1,i,N,M,vis);
            }
        }
        
        int ans=0;
        
        for(int i=1;i<N-1;i++){
            for(int j=1;j<M-1;j++){
                if(vis[i][j]!=1 && matrix[i][j]==1){
                    ans++;
                    dfs(matrix,i,j,N,M,vis);
                }
            }
        }
        
        return ans;
    }
    public void dfs(int[][] matrix, int i, int j, int N,int M, int[][] vis){
        vis[i][j]=1;
        matrix[i][j]=0;
        int neg[][]={{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int n=0;n<4;n++){
            int ni=i+neg[n][0];
            int nj=j+neg[n][1];
            
            if(ni>=0 && nj>=0 && ni<N && nj<M && vis[ni][nj]!=1 && matrix[ni][nj]==1){
                dfs(matrix,ni,nj,N,M,vis);
            }
        }
    }
}


