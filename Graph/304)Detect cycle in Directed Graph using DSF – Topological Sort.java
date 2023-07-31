Detect cycle in Directed Graph using BFS – Topological Sort
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
        int indegree[]=new int[V];
        Queue<Integer> q=new LinkedList<Integer>();
        
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)q.add(i);
        }
        
        int cnt=0;
        while(!q.isEmpty()){
            int node=q.peek();
            cnt++;
            q.remove();
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0)q.add(it);
            }
        }
        if(cnt==V)
        return false;
        else
        return true;
    }
} 

