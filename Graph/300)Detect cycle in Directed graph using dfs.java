Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.

Example 1:
Input:

 

Output: 1
Explanation: 3 -> 3 is a cycle

Example 2:
Input:
 

Output: 0
Explanation: no cycle in the graph

Your task:
You dont need to read input or print anything. Your task is to complete the function isCyclic() which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns a boolean value denoting if the given directed graph contains a cycle or not.

Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)

Constraints:
1 ≤ V, E ≤ 105




class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[]=new int[V];
        int pathvis[]=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0)
                if(dfs(i,adj,vis,pathvis)==true)return true;
        }
        return false;
    }
    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int vis[],int pathvis[]){
        vis[node]=1;
        pathvis[node]=1;
        
        for(int i:adj.get(node)){
            if(vis[i]==0){
                if(dfs(i,adj,vis,pathvis)==true)return true;
            }
            else if(pathvis[i]==1)return true;
        }
        pathvis[node]=0;
        return false;
    }
}

