1992. Find All Groups of Farmland

You are given a 0-indexed m x n binary matrix land where a 0 represents a hectare of forested land and a 1 represents a hectare of farmland.

To keep the land organized, there are designated rectangular areas of hectares that consist entirely of farmland. These rectangular areas are called groups. No two groups are adjacent, meaning farmland in one group is not four-directionally adjacent to another farmland in a different group.

land can be represented by a coordinate system where the top left corner of land is (0, 0) and the bottom right corner of land is (m-1, n-1). Find the coordinates of the top left and bottom right corner of each group of farmland. A group of farmland with a top left corner at (r1, c1) and a bottom right corner at (r2, c2) is represented by the 4-length array [r1, c1, r2, c2].

Return a 2D array containing the 4-length arrays described above for each group of farmland in land. If there are no groups of farmland, return an empty array. You may return the answer in any order.

 

Example 1:


Input: land = [[1,0,0],[0,1,1],[0,1,1]]
Output: [[0,0,0,0],[1,1,2,2]]
Explanation:
The first group has a top left corner at land[0][0] and a bottom right corner at land[0][0].
The second group has a top left corner at land[1][1] and a bottom right corner at land[2][2].
Example 2:


Input: land = [[1,1],[1,1]]
Output: [[0,0,1,1]]
Explanation:
The first group has a top left corner at land[0][0] and a bottom right corner at land[1][1].
Example 3:


Input: land = [[0]]
Output: []
Explanation:
There are no groups of farmland.
 

Constraints:

m == land.length
n == land[i].length
1 <= m, n <= 300
land consists of only 0's and 1's.
Groups of farmland are rectangular in shape.

class Solution {
    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]> list = new ArrayList<>();
        int n=land.length;
        int m=land[0].length;
        int vis[][]=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && land[i][j]==1){
                    int last[]=helper(i,j,land,vis);
                    list.add(new int[]{i,j,last[0],last[1]});
                }
            }
        }
       
        return list.toArray(new int[0][]);
    }
    public int[] helper(int row,int col,int land[][],int vis[][]){
        Queue<Pair> q = new LinkedList<>();
        int lasti=row;
        int lastj=col;
        q.add(new Pair(row,col));
        
        int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
        
        while(!q.isEmpty()){
            Pair p=q.remove();
            int i=p.i;
            int j=p.j;

            for(int d=0;d<4;d++){
                int newi=i+dir[d][0];
                int newj=j+dir[d][1];
                if(newi>=0 && newj>=0 && newi<land.length && newj<land[0].length && vis[newi][newj]==0 && land[newi][newj]==1){
                    lasti=Math.max(lasti,newi);
                    lastj=Math.max(lastj,newj);
                    vis[newi][newj]=1;
                    q.add(new Pair(newi,newj));
                }
            }
        }

        return new int[]{lasti,lastj};

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
