Given a Directed Graph, find a Mother Vertex in the Graph (if present). 
A Mother Vertex is a vertex through which we can reach all the other vertices of the Graph.

Example 1:

Input: 

Output: 0
Explanation: According to the given edges, all 
nodes can be reaced from nodes from 0, 1 and 2. 
But, since 0 is minimum among 0,1 and 2, so 0 
is the output.
Example 2:

Input: 

Output: -1
Explanation: According to the given edges, 
no vertices are there from where we can 
reach all vertices. So, output is -1.
Your Task:
You don't need to read or print anything. Your task is to complete the function findMotherVertex() which takes V denoting the number of vertices and adjacency list as imput parameter and returns the verticex from through which we can traverse all other vertices of the graph. If there is more than one possible nodes then returns the node with minimum value.If not possible returns -1.

Expected Time Complexity: O(V + E)
Expected Space Compelxity: O(V)

Constraints:
1 ≤ V ≤ 500


  class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj){
        int vertex=0;
        int visited[]=new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                dfs(i,adj,visited);
                vertex=i;
            }
        }
        Arrays.fill(visited,0);
        int cnt=dfs(vertex,adj,visited);
        if(cnt==V)return vertex;
        return -1;
    }
    public int dfs(int currNode, ArrayList<ArrayList<Integer>>adj, int visited[]){
        visited[currNode]=1;
        int count=0;
        for(int negNode:adj.get(currNode)){
            if(visited[negNode]==0){
                count+=dfs(negNode,adj,visited);
            }
        }
        return count+1;
    }
}
