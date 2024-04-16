2973. Find Number of Coins to Place in Tree Nodes

You are given an undirected tree with n nodes labeled from 0 to n - 1, and rooted at node 0. You are given a 2D integer array edges of length n - 1, where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.

You are also given a 0-indexed integer array cost of length n, where cost[i] is the cost assigned to the ith node.

You need to place some coins on every node of the tree. The number of coins to be placed at node i can be calculated as:

If size of the subtree of node i is less than 3, place 1 coin.
Otherwise, place an amount of coins equal to the maximum product of cost values assigned to 3 distinct nodes in the subtree of node i. If this product is negative, place 0 coins.
Return an array coin of size n such that coin[i] is the number of coins placed at node i.

 

Example 1:


Input: edges = [[0,1],[0,2],[0,3],[0,4],[0,5]], cost = [1,2,3,4,5,6]
Output: [120,1,1,1,1,1]
Explanation: For node 0 place 6 * 5 * 4 = 120 coins. All other nodes are leaves with subtree of size 1, place 1 coin on each of them.
Example 2:


Input: edges = [[0,1],[0,2],[1,3],[1,4],[1,5],[2,6],[2,7],[2,8]], cost = [1,4,2,3,5,7,8,-4,2]
Output: [280,140,32,1,1,1,1,1,1]
Explanation: The coins placed on each node are:
- Place 8 * 7 * 5 = 280 coins on node 0.
- Place 7 * 5 * 4 = 140 coins on node 1.
- Place 8 * 2 * 2 = 32 coins on node 2.
- All other nodes are leaves with subtree of size 1, place 1 coin on each of them.
Example 3:


Input: edges = [[0,1],[0,2]], cost = [1,2,-2]
Output: [0,1,1]
Explanation: Node 1 and 2 are leaves with subtree of size 1, place 1 coin on each of them. For node 0 the only possible product of cost is 2 * 1 * -2 = -4. Hence place 0 coins on node 0.
 

Constraints:

2 <= n <= 2 * 104
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
cost.length == n
1 <= |cost[i]| <= 104
The input is generated such that edges represents a valid tree.

class Solution {
    HashMap<Integer,ArrayList<Integer>> adjlist = new HashMap<>();
    HashSet<Integer> vis =new HashSet<>();
    int temp[]=new int[6];
    int tempn[]=new int[6];
    
    public long[] placedCoins(int[][] edges, int[] cost) {
        
        int n=edges.length;
        
        for(int i=0;i<n;i++){
            adjlist.putIfAbsent(edges[i][0],new ArrayList<>());
            adjlist.putIfAbsent(edges[i][1],new ArrayList<>());
            adjlist.get(edges[i][0]).add(edges[i][1]);
            adjlist.get(edges[i][1]).add(edges[i][0]);
        }
        
        
        long ans[]=new long[cost.length];
        helper(0,cost,ans);
        return ans;
        
    }
    
    public int[][] helper(int node,int[] cost,long ans[]){
        
        vis.add(node);
        
        int threeMax[][]=new int[2][3];
        Arrays.fill(threeMax[0],Integer.MIN_VALUE);
        Arrays.fill(threeMax[1],Integer.MAX_VALUE);
        threeMax[0][2]=cost[node];
        threeMax[1][2]=cost[node];
        
        for(int neg : adjlist.get(node)){
            
            if(vis.contains(neg))continue;
            int adjThreeMax[][]=helper(neg,cost,ans);
            

            //logic to get the 3 max elements.
            for(int i=0;i<3;i++){
                temp[i]=threeMax[0][i];
                temp[i+3]=adjThreeMax[0][i];
            }
            Arrays.sort(temp);
            for(int i=0;i<3;i++){
                threeMax[0][i]=temp[i+3];
            }
            

            //logic to get the 3 min elements.
            for(int i=0;i<3;i++){
                tempn[i]=threeMax[1][i];
                tempn[i+3]=adjThreeMax[1][i];
            }
            Arrays.sort(tempn);
            for(int i=0;i<3;i++){
                threeMax[1][i]=tempn[i];
            }

            
        }
        
        if(threeMax[0][0]!=Integer.MIN_VALUE && threeMax[0][1]!=Integer.MIN_VALUE && threeMax[0][2]!=Integer.MIN_VALUE){
            //System.out.println(threeMax[0]+" "+threeMax[1]+" "+threeMax[2]);
            
            long answer=((long)threeMax[0][0]*(long)threeMax[0][1]*(long)threeMax[0][2]);
            answer=Math.max(answer,(long)threeMax[0][2]*(long)threeMax[1][0]*(long)threeMax[1][1]);
            if(answer<0l)ans[node]=0l;
            else ans[node]=answer;
        }
        else{
            ans[node]=1l;
        }
        
        
        return threeMax;
    }
}

