Vertex Cover

Vertex cover of an undirected graph is a list of vertices such that every vertex not in the vertex cover shares their every edge with the vertices in the vertex cover. In other words, for every edge in the graph, atleast one of the endpoints of the graph should belong to the vertex cover. You will be given an undirected graph G, and your task is to determine the smallest possible size of a vertex cover.

Example 1:

Input:
N=5
M=6
edges[][]={{1,2}
           {4, 1},
           {2, 4},
           {3, 4},
           {5, 2},
           {1, 3}}
Output:
3
Explanation:
{2, 3, 4} forms a vertex cover
with the smallest size.
Example 2:

Input:
N=2
M=1
edges[][]={{1,2}} 
Output: 
1 
Explanation: 
Include either node 1 or node 2
in the vertex cover.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function vertexCover() which takes the edge list and an integer n for the number of nodes of the graph as input parameters and returns the size of the smallest possible vertex cover.

Expected Time Complexity: O(M*2N)
Expected Auxiliary Space: O(N2)

 Constraints:
1 <= N <= 16
1 <= M <= N*(N-1)/2
1 <= edges[i][0], edges[i][1] <= N

class Solution {
    private static int getMin(int n, int m, int[][] edges, int idx, HashSet<Integer> st){
        if(idx >= m)
            return 0;
        int v1 = edges[idx][0];
        int v2 = edges[idx][1];
        
        if(!st.contains(v1) && !st.contains(v2)){
            st.add(v1);
            int first = 1 + getMin(n, m, edges, idx+1, st);
            st.remove(v1);
            
            st.add(v2);
            int second = 1 + getMin(n, m, edges, idx+1, st);
            st.remove(v2);
            
            return Math.min(first, second);
        }
        
        return getMin(n, m, edges, idx+1, st);
    }
    public static int vertexCover(int n, int m, int[][] edges) {
       
        HashSet<Integer> st = new HashSet<>();
        return getMin(n, m, edges, 0, st);
    }
}
        
