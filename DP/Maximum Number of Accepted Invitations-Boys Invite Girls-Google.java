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
class Solution {
    public:
      bool bipartiteMatch(const vector<vector<int>>& grid, int u, vector<bool> visited,            
      vector<int>& girls) {
       int m = grid.size();
       int n = grid[0].size();
       for (int v = 0; v < n; v++) {
        if (grid[u][v] && !visited[v]) {
            visited[v] = true;
            if (girls[v] < 0 || bipartiteMatch(grid, girls[v], visited, girls)) {
                girls[v] = u;
                return true;
            }
        }
   }
   return false;
  }

int maximumInvitations(vector<vector<int>>& grid) {
    int m = grid.size();
    int n = grid[0].size();
    vector<int> grils(n, -1);
    int matches = 0;

    for (int u = 0; u < m; u++) {
        vector<bool> visited(n, false);
        if (bipartiteMatch(grid, u, visited, grils)) {
            matches++;
        }
    }
    return matches;
 }
};

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
