Given a 2D grid of n*m of characters and a word, find all occurrences of given word in grid. A word can be matched in all 8 directions at any point. Word is said to be found in a direction if all characters match in this direction (not in zig-zag form). The 8 directions are, horizontally left, horizontally right, vertically up, vertically down, and 4 diagonal directions.

Note: The returning list should be lexicographically smallest. If the word can be found in multiple directions starting from the same coordinates, the list should contain the coordinates only once. 

Example 1:

Input: 
grid = {{a,b,c},{d,r,f},{g,h,i}},
word = "abc"
Output: 
{{0,0}}
Explanation: 
From (0,0) we can find "abc" in horizontally right direction.
Example 2:

Input: 
grid = {{a,b,a,b},{a,b,e,b},{e,b,e,b}}
word = "abe"
Output: 
{{0,0},{0,2},{1,0}}
Explanation: 
From (0,0) we can find "abe" in right-down diagonal. 
From (0,2) we can find "abe" in left-down diagonal. 
From (1,0) we can find "abe" in horizontally right direction.
Your Task:
You don't need to read or print anything, Your task is to complete the function searchWord() which takes grid and word as input parameters and returns a list containing the positions from where the word originates in any direction. If there is no such position then returns an empty list.

Expected Time Complexity: O(n*m*k) where k is constant
Expected Space Complexity: O(1)

Constraints:
1 <= n <= m <= 50
1 <= |word| <= 15

class Solution
{
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    public int[][] searchWord(char[][] grid, String word)
    {
        ArrayList<int[]> list=new ArrayList<>();
       
        int n=grid.length;
        int m=grid[0].length;
       
       
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==word.charAt(0)){
                    for(int dir[]:directions){
                        if(dfs(i,j,grid,word,n,m,0,dir[0],dir[1])){
                            list.add(new int[]{i,j});
                            break;
                        }
                    }
               }
           }
       }
       return list.toArray(new int[0][]);
    }
    public boolean dfs(int i,int j,char grid[][],String word,int n,int m,int idx,int dir0,int dir1){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]!=word.charAt(idx) || idx>=word.length())
            return false;
        
        if(idx==word.length()-1)
            return true;
        
        if(dfs(i+dir0,j+dir1,grid,word,n,m,idx+1,dir0,dir1))
            return true;
                
        return false;     
    }
}
