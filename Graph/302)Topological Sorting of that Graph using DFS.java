Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.

Example 1:
Input:
 
Output:
1
Explanation:
The output 1 denotes that the order is
valid. So, if you have, implemented
your function correctly, then output
would be 1 for all test cases.
One possible Topological order for the
graph is 3, 2, 1, 0.
Example 2:
Input:
 
Output:
1
Explanation:
The output 1 denotes that the order is
valid. So, if you have, implemented
your function correctly, then output
would be 1 for all test cases.
One possible Topological order for the
graph is 5, 4, 2, 1, 3, 0.

Your Task:
You don't need to read input or print anything. Your task is to complete the function topoSort()  which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns an array consisting of a the vertices in Topological order. As there are multiple Topological orders possible, you may return any of them. If your returned topo sort is correct then console output will be 1 else 0.

Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).
Constraints:
2 ≤ V ≤ 104
1 ≤ E ≤ (N*(N-1))/2

Using DFS:
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        Stack<Integer> stack=new Stack<Integer>();
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,adj,vis,stack);
            }
        }
      
        int ans[]=new int[V];
        int idx=0;
        while(!stack.isEmpty()){
            ans[idx]=stack.pop();
            idx++;
        }
        
        return ans;
    }
    static void dfs(int node, ArrayList<ArrayList<Integer>> adj,boolean vis[],Stack<Integer> stack) 
    {
        vis[node]=true;
        for(int it: adj.get(node)){
            if(vis[it]==false){
                dfs(it,adj,vis,stack);
            }
        }
        stack.push(node);
    }
}
