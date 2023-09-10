2812. Find the Safest Path in a Grid


You are given a 0-indexed 2D matrix grid of size n x n, where (r, c) represents:

A cell containing a thief if grid[r][c] = 1
An empty cell if grid[r][c] = 0
You are initially positioned at cell (0, 0). In one move, you can move to any adjacent cell in the grid, including cells containing thieves.

The safeness factor of a path on the grid is defined as the minimum manhattan distance from any cell in the path to any thief in the grid.

Return the maximum safeness factor of all paths leading to cell (n - 1, n - 1).

An adjacent cell of cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) and (r - 1, c) if it exists.

The Manhattan distance between two cells (a, b) and (x, y) is equal to |a - x| + |b - y|, where |val| denotes the absolute value of val.

 

Example 1:


Input: grid = [[1,0,0],[0,0,0],[0,0,1]]
Output: 0
Explanation: All paths from (0, 0) to (n - 1, n - 1) go through the thieves in cells (0, 0) and (n - 1, n - 1).
Example 2:


Input: grid = [[0,0,1],[0,0,0],[0,0,0]]
Output: 2
Explanation: The path depicted in the picture above has a safeness factor of 2 since:
- The closest cell of the path to the thief at cell (0, 2) is cell (0, 0). The distance between them is | 0 - 0 | + | 0 - 2 | = 2.
It can be shown that there are no other paths with a higher safeness factor.
Example 3:


Input: grid = [[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]]
Output: 2
Explanation: The path depicted in the picture above has a safeness factor of 2 since:
- The closest cell of the path to the thief at cell (0, 3) is cell (1, 2). The distance between them is | 0 - 1 | + | 3 - 2 | = 2.
- The closest cell of the path to the thief at cell (3, 0) is cell (3, 2). The distance between them is | 3 - 3 | + | 0 - 2 | = 2.
It can be shown that there are no other paths with a higher safeness factor.
 

Constraints:

1 <= grid.length == n <= 400
grid[i].length == n
grid[i][j] is either 0 or 1.
There is at least one thief in the grid.


class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n=grid.size();
        int m=grid.get(0).size();

        if(grid.get(0).get(0)==1 || grid.get(n-1).get(m-1)==1)
            return 0;

        int dist[][]=new int[n][m];

        Queue<Tuple> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid.get(i).get(j)==1)
                    q.add(new Tuple(i,j,0));
            }
        }

        int directions[][]={{0,-1},{0,1},{-1,0},{1,0}};

        while(!q.isEmpty()){
            Tuple t=q.remove();
            int i=t.i;
            int j=t.j;
            int odist=t.dist;

            for(int delta=0;delta<4;delta++){
                int ni=i+directions[delta][0];
                int nj=j+directions[delta][1];
                int ndist=odist+1;

                if(ni>=0 && nj>=0 && ni<n && nj<m && dist[ni][nj]==0 && grid.get(ni).get(nj)!=1){
                    dist[ni][nj]=ndist;
                    q.add(new Tuple(ni,nj,ndist));
                }
            }
        }

        
        int ans=Integer.MIN_VALUE;
        
        /*for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }*/
        
        PriorityQueue<Tuple> pq = 
        new PriorityQueue<Tuple>((x,y) -> y.dist - x.dist);
       

        int[][] dp = new int[n][m]; 
 
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                dp[i][j] = Integer.MAX_VALUE; 
                if(grid.get(i).get(j)==1)
                    dp[i][j] = -1;
            }
        }
        
        dp[0][0] = dist[0][0]; 
        pq.add(new Tuple(0, 0, dp[0][0])); 

        int dr[] = {-1, 0, 1, 0}; 
        int dc[] = {0, 1, 0, -1}; 
        
    
        while(pq.size() != 0) {
            Tuple it = pq.peek(); 
            pq.remove(); 
            int diff = it.dist; 
            int row = it.i; 
            int col = it.j; 
           
        
            //if(row == n-1 && col == m-1) return diff;   //also works fine
         
            for(int i = 0;i<4;i++) {
                int newr = row + dr[i]; 
                int newc = col + dc[i];
                
              
                if(newr>=0 && newc >=0 && newr < n && newc < m) {

                    int newDiff=Math.min(diff,dist[newr][newc]);

                    
                    if(dp[newr][newc]==Integer.MAX_VALUE || newDiff > dp[newr][newc]) {
                        dp[newr][newc] = newDiff; 
                        pq.add(new Tuple(newr, newc,newDiff)); 
                        //System.out.println(newr+" "+newc+" "+newDiff);
                    }
                }
            }
        }
        if(dp[n-1][m-1]==Integer.MAX_VALUE)return 0;
        return dp[n-1][m-1];
    }
}
class Tuple{
    int i;
    int j;
    int dist;
    Tuple(int i,int j, int dist){
        this.i=i;
        this.j=j;
        this.dist=dist;
    }
}
