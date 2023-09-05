Detect cycle in an undirected graph
Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. Graph is in the form of adjacency list where adj[i] contains all the nodes ith node is having edge with. 
Example 1:
Input:  
V = 5, E = 5
adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}} 
Output: 1
Explanation: 

 
1->2->3->4->1 is a cycle.
Example 2:
Input: 
V = 4, E = 2
adj = {{}, {2}, {1, 3}, {2}}
Output: 0
Explanation: 
 
No cycle in the graph.
 
Your Task:
You don't need to read or print anything. Your task is to complete the function isCycle() which takes V denoting the number of vertices and adjacency list as input parameters and returns a boolean value denoting if the undirected graph contains any cycle or not, return 1 if a cycle is present else return 0.
NOTE: The adjacency list denotes the edges of the graph where edges[i] stores all other vertices to which ith vertex is connected.
 
Expected Time Complexity: O(V + E)
Expected Space Complexity: O(V)

 
Constraints:
1 ≤ V, E ≤ 105

BFS:
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                vis[i]=1;
                if(bfs(i,vis,adj)==true)
                    return true;
            }
        }
        
        return false;
    }
    public boolean bfs(int node, int vis[], ArrayList<ArrayList<Integer>> adj){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node,-1));
        while(!q.isEmpty()){
            Pair p=q.remove();
            for(int neg:adj.get(p.node)){
                if(neg!=p.parent){
                    if(vis[neg]==1)return true;
                    vis[neg]=1;
                    q.add(new Pair(neg,p.node));
                }
            }
        }
        return false;
    }
}
class Pair{
    int node;
    int parent;
    Pair(int node,int parent){
        this.node=node;
        this.parent=parent;
    }
}
=====================================================================================================================

 class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[]=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,-1,adj,vis)==true)
                    return true;
            }    
        }
        return false;
    }
    public boolean dfs(int curr,int prev,ArrayList<ArrayList<Integer>> adj,int vis[]){
        vis[curr]=1;
        for(int neg:adj.get(curr)){
            if(neg!=prev){
                if(vis[neg]==1)
                    return true;
                if(dfs(neg,curr,adj,vis)==true)
                        return true;
            }
        }
        return false;
    }
}
