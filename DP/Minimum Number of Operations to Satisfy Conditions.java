3122. Minimum Number of Operations to Satisfy Conditions

You are given a 2D matrix grid of size m x n. In one operation, you can change the value of any cell to any non-negative number. You need to perform some operations such that each cell grid[i][j] is:

Equal to the cell below it, i.e. grid[i][j] == grid[i + 1][j] (if it exists).
Different from the cell to its right, i.e. grid[i][j] != grid[i][j + 1] (if it exists).
Return the minimum number of operations needed.

 

Example 1:

Input: grid = [[1,0,2],[1,0,2]]

Output: 0

Explanation:



All the cells in the matrix already satisfy the properties.

Example 2:

Input: grid = [[1,1,1],[0,0,0]]

Output: 3

Explanation:



The matrix becomes [[1,0,1],[1,0,1]] which satisfies the properties, by doing these 3 operations:

Change grid[1][0] to 1.
Change grid[0][1] to 0.
Change grid[1][2] to 1.
Example 3:

Input: grid = [[1],[2],[3]]

Output: 2

Explanation:



There is a single column. We can change the value to 1 in each cell using 2 operations.

 

Constraints:

1 <= n, m <= 1000
0 <= grid[i][j] <= 9

class Solution {
    //DP Question::get the cost for keeping value in current column and try with every other value.
    int dp[][];
    
    public int minimumOperations(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        
        dp=new int[cols][11];
        for(int d[]:dp)Arrays.fill(d,-1);

        
        //for every record we finds 3 possible records to keep and its cost//
        List<Pair> list[] = new ArrayList[cols];
        for(int i=0;i<cols;i++){
            
            int[][] freq = new int[10][2];
            for(int j=0;j<=9;j++){
                freq[j][0]=j;
            }

            for(int j=0;j<rows;j++){
                int element=grid[j][i];
                freq[element][1]++;
            }

            list[i]=getThreeMaxRecords(freq,rows);
        }
        return helper(0,-1,list,cols); 
    }
    public int helper(int idx,int prev,List<Pair> list[],int totalCols){
        if(idx==totalCols){
            return 0;
        }
        if(dp[idx][prev+1]!=-1){
            return dp[idx][prev+1];
        }
        int totalCost=1000000;
        
        List<Pair> currRecord = list[idx];

        for(Pair p:currRecord){
            int value=p.value;
            int cost=p.cost;

            if(value!=prev){
                totalCost=Math.min(totalCost,cost+helper(idx+1,value,list,totalCols));
            }
            else if(prev==-1){
                totalCost=Math.min(totalCost,cost+helper(idx+1,value,list,totalCols));
            }
        }

        return dp[idx][prev+1]=totalCost;
    }
    public List<Pair> getThreeMaxRecords(int[][] freq,int totalRows){
        Arrays.sort(freq,(a,b)->b[1]-a[1]);

        List<Pair> list = new ArrayList<>();

        for(int i=0;i<3;i++){
            list.add(new Pair(freq[i][0],totalRows-freq[i][1]));
        }

        return list;
    }
}
class Pair{
    int value;
    int cost;
    Pair(int value,int cost){
        this.value=value;
        this.cost=cost;
    }
}
