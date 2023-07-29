Number of Islands using DSF/ recursion:
public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    clearRestOfLand(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void clearRestOfLand(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') return;
        
        grid[i][j] = '0';
        clearRestOfLand(grid, i+1, j);
        clearRestOfLand(grid, i-1, j);
        clearRestOfLand(grid, i, j+1);
        clearRestOfLand(grid, i, j-1);
        return;
    }
}


---------------------------------------------------------------------------------------------------------------------------------------------------------



Number of Islands: (8 directions)
class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        int cnt=0;
        for(int row=0;row<n;row++)
        {
            for(int col=0;col<m;col++)
            {
                if(grid[row][col]=='1' && vis[row][col]==0)
                {
                    cnt++;
                    bfs(row,col,vis,grid);
                }
            }
        }
        return cnt;
    }
    
private void bfs(int ro,int co,int vis[][],char grid[][]){
        vis[ro][co]=1;
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(ro,co));
        int n=grid.length;
        int m=grid[0].length;
        
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            q.remove();
            for(int deltarow=-1;deltarow<=1;deltarow++){
                for(int deltacol=-1;deltacol<=1;deltacol++){
                    int nrow=row+deltarow;
                    int ncol=col+deltacol;
                    if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&grid[nrow][ncol]=='1'&&vis[nrow][ncol]==0){
                        vis[nrow][ncol]=1;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            }
        }
    }
}

--------------------------------------------------------------------------------------------------------------------------------------------------------


Number of Island: (4 directions)
class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        int cnt=0;
        for(int row=0;row<n;row++)
        {
            for(int col=0;col<m;col++)
            {
                if(grid[row][col]=='1' && vis[row][col]==0)
                {
                    cnt++;
                    bfs(row,col,vis,grid);
                }
            }
        }
        return cnt;
    }
    private void bfs(int ro,int co,int vis[][],char grid[][]){
        vis[ro][co]=1;
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(ro,co));
        int n=grid.length;
        int m=grid[0].length;
        
        int neighbours[][]={{-1,0},{1,0},{0,-1},{0,1}};
        
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            q.remove();
           
                for(int delta=0;delta<neighbours.length;delta++){
                    int nrow=row+neighbours[delta][0];
                    int ncol=col+neighbours[delta][1];
                    if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&grid[nrow][ncol]=='1'&&vis[nrow][ncol]==0){
                        vis[nrow][ncol]=1;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            
        }
    }
}


