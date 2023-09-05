Number of distinct islands(BFS,DFS)
Note:- Instead of using hashset<ArrayList>, we can store the answer in the StringBuilder and at last put it in arraylist and compare, the compare can be done with the try to do it in O(2n)complexity with Node(link[26],count).while checking if count==2, make ans++;
Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to be distinct if and only if one island is not equal to another (not rotated or reflected).
Example 1:
Input:
grid[][] = {{1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1}}
Output:
1
Explanation:
grid[][] = {{1, 1, 0, 0, 0}, 
            {1, 1, 0, 0, 0}, 
            {0, 0, 0, 1, 1}, 
            {0, 0, 0, 1, 1}}
Same colored islands are equal.
We have 2 equal islands, so we 
have only 1 distinct island.

Example 2:
Input:
grid[][] = {{1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1}}
Output:
3
Explanation:
grid[][] = {{1, 1, 0, 1, 1}, 
            {1, 0, 0, 0, 0}, 
            {0, 0, 0, 0, 1}, 
            {1, 1, 0, 1, 1}}
Same colored islands are equal.
We have 4 islands, but 2 of them
are equal, So we have 3 distinct islands.

Your Task:
You don't need to read or print anything. Your task is to complete the function countDistinctIslands() which takes the grid as an input parameter and returns the total number of distinct islands.
Expected Time Complexity: O(n * m)
Expected Space Complexity: O(n * m)
Constraints:
1 ≤ n, m ≤ 500
grid[i][j] == 0 or grid[i][j] == 1
class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}


class Solution {

    int countDistinctIslands(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        HashSet<ArrayList<String>> set=new HashSet<>();
        for(int row=0;row<n;row++)
        {
            for(int col=0;col<m;col++)
            {
                if(grid[row][col]==1 && vis[row][col]==0)
                {
                  ArrayList<String> island = new ArrayList<>();
                    bfs(row,col,vis,grid,island,row,col);
                    //System.out.println(island);
                    set.add(island);
                }
            }
        }
        
        return set.size();
    }
   

 private String toString(int row,int col){
        return Integer.toString(row)+" "+Integer.toString(col);
    }
    





private void bfs(int ro,int co,int vis[][],int grid[][],ArrayList<String> island, int row0, int col0){
        vis[ro][co]=1;
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(ro,co));
        int n=grid.length;
        int m=grid[0].length;
        
        int neighbours[][]={{-1,0},{1,0},{0,-1},{0,1}};
        
        
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            island.add(toString(row-row0,col-col0));
        
            q.remove();
           
                for(int delta=0;delta<neighbours.length;delta++){
                    int nrow=row+neighbours[delta][0];
                    int ncol=col+neighbours[delta][1];
                    if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&grid[nrow][ncol]==1&&vis[nrow][ncol]==0){
                        vis[nrow][ncol]=1;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            
        }
    }
}


