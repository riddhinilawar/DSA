Path With Minimum Effort
You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
Example 1:
heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explaination: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
Your Task:
You don't need to read input or print anything. Your task is to complete the function MinimumEffort() which takes the array height  and Returns the minimum effort required to travel from the top-left cell to the bottom-right cell.
Constraints
rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 106
 
Expected Time Complexity: O(Elog(V))
Expected Space Complexity: O(N,M)

class Tuple{
    int distance;
    int row;
    int col;
    public Tuple(int distance,int row, int col){
        this.row = row;
        this.distance = distance;
        this.col = col; 
    }
}
class Solution {
    
    int MinimumEffort(int heights[][]) {

        PriorityQueue<Tuple> pq = 
        new PriorityQueue<Tuple>((x,y) -> x.distance - y.distance);
       
      
        int n = heights.length; 
        int m = heights[0].length; 

        int[][] dist = new int[n][m]; 
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                dist[i][j] = (int)(1e9); 
            }
        }
        
        dist[0][0] = 0; 
        pq.add(new Tuple(0, 0, 0)); 

        int dr[] = {-1, 0, 1, 0}; 
        int dc[] = {0, 1, 0, -1}; 
        
    
        while(pq.size() != 0) {
            Tuple it = pq.peek(); 
            pq.remove(); 
            int diff = it.distance; 
            int row = it.row; 
            int col = it.col; 
            
        
            if(row == n-1 && col == m-1) return diff; 
         
            for(int i = 0;i<4;i++) {
                int newr = row + dr[i]; 
                int newc = col + dc[i];

              
                if(newr>=0 && newc >=0 && newr < n && newc < m) {

                   
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[newr][newc]), diff); 

                    if(newEffort < dist[newr][newc]) {
                        dist[newr][newc] = newEffort; 
                        pq.add(new Tuple(newEffort, newr, newc)); 
                    }
                }
            }
        }
       return dist[n-1][m-1]; 
   }
}






























