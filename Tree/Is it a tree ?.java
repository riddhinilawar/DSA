You are given an undirected graph of N nodes and M edges. Return 1 if the graph is a tree, else return 0.

Note: The input graph can have self-loops and multiple edges.

Example 1:

Input:
N = 4, M = 3
G = [[0, 1], [1, 2], [1, 3]]
Output: 
1
Explanation: 
Every node is reachable and the graph has no loops, so it is a tree
Example 2:

Input:
N = 4, M = 3
G = [[0, 1], [1, 2], [2, 0]]
Output: 
0
Explanation: 
3 is not connected to any node and there is a loop 0->1->2->0, so it is not a tree.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function isTree() which takes the integer N (the number nodes in the input graph) and the edges representing the graph as input parameters and returns 1 if the input graph is a tree, else 0.

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 2*105
0 <= M <= 2*105

class Solution {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        HashMap<Integer,ArrayList<Integer>> adjList = new HashMap<>();
        HashSet<Integer> vis = new HashSet<>();
        for(ArrayList<Integer> edge:edges){
            if(edge.get(1)==edge.get(0))return false;
            adjList.putIfAbsent(edge.get(0),new ArrayList<>());
            adjList.putIfAbsent(edge.get(1),new ArrayList<>());
            adjList.get(edge.get(0)).add(edge.get(1));
            adjList.get(edge.get(1)).add(edge.get(0));
        }
        
        boolean ans= helper(0,-1,adjList,vis);
        
        for(int i=0;i<n;i++){
            if(!vis.contains(i))
                return false;
        }
        
        return ans;
    }
    public boolean helper(int curr,int parent,HashMap<Integer,ArrayList<Integer>> adjList,HashSet<Integer> vis){
        vis.add(curr);
        if(adjList.get(curr)!=null){
            for(int neg:adjList.get(curr)){
                if(!vis.contains(neg)){
                    if(helper(neg,curr,adjList,vis)==false)return false;
                }
                else if(neg!=parent){
                    return false;
                }
            }
        }
        return true;
    }
}


Note: If self pointing edge is present handle the edge case.
