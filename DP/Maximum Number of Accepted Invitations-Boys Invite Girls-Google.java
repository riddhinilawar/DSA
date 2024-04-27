LeetCode 1820. Maximum Number of Accepted Invitations

There are m boys and n girls in a class attending an upcoming party.

You are given an m x n integer matrix grid, where grid[i][j] equals 0 or 1. If grid[i][j] == 1, then that means the ith boy can invite the jth girl to the party. A boy can invite at most one girl, and a girl can accept at most one invitation from a boy.

Return the maximum possible number of accepted invitations.

Example 1:

Input: grid = [[1,1,1],
              [1,0,1],
              [0,0,1]]
Output: 3

  Explanation: The invitations are sent as follows:
  - The 1st boy invites the 2nd girl.
  - The 2nd boy invites the 1st girl.
  - The 3rd boy invites the 3rd girl.
Example 2:

Input: grid = [[1,0,1,0],
              [1,0,0,0],
              [0,0,1,0],
              [1,1,1,0]]
Output: 3

Explanation: The invitations are sent as follows:
-The 1st boy invites the 3rd girl.
-The 2nd boy invites the 1st girl.
-The 3rd boy invites no one.
-The 4th boy invites the 2nd girl.
Constraints:

grid.length == m

grid[i].length == n

1 <= m, n <= 200

grid[i][j] is either 0 or 1.
Solution
import java.util.Arrays;

public class Solution {
    public boolean bipartiteMatch(int[][] grid, int u, boolean[] visited, int[] girls) {
        int m = grid.length;
        int n = grid[0].length;
        for (int v = 0; v < n; v++) {
            if (grid[u][v] == 1 && !visited[v]) {
                visited[v] = true;
                if (girls[v] < 0 || bipartiteMatch(grid, girls[v], visited, girls)) {
                    girls[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    public int maximumInvitations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] girls = new int[n];
        Arrays.fill(girls, -1);
        int matches = 0;

        for (int u = 0; u < m; u++) {
            boolean[] visited = new boolean[n];
            if (bipartiteMatch(grid, u, visited, girls)) {
                matches++;
            }
        }
        return matches;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {
            {1, 0, 1},
            {0, 1, 0},
            {1, 1, 0}
        };
        System.out.println(solution.maximumInvitations(grid)); // Output: 2
    }
}

=================================================My Solution=========================
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        // int  mat[][]=
        // {{1,1,1},
        //  {1,0,1},
        //  {0,0,1}};
        
        int  mat[][]=
        {{0,1,1,0},
         {1,0,0,0},
         {0,0,1,0},
         {1,1,1,1}};
        System.out.println(maximumInvitations(mat));
    }
    public static int maximumInvitations(int mat[][]){
        int m=mat.length;
        int n=mat[0].length;
        
        int vis[] = new int[m];
        
        return helper(0,n,m,vis,mat);
    }
    public static int helper(int idx,int totalRows,int totalCols,int vis[],int mat[][]){
        if(idx>=totalRows){
            return 0;
        }
        int max=0;
        
        for(int j=0;j<totalCols;j++){
            if(mat[idx][j]==1 && vis[j]!=1){
                vis[j]=1;
                max=Math.max(max,1+helper(idx+1,totalRows,totalCols,vis,mat));
                vis[j]=0;
            }
            max=Math.max(max,helper(idx+1,totalRows,totalCols,vis,mat));
        }
        
        return max;
    }
}
