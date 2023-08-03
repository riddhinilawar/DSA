Distance from the Source (Bellman-Ford Algorithm)

Given a weighted, directed and connected graph of V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S.
Note: If the Graph contains a negative cycle then return an array consisting of only -1.
Example 1:
Input:
 
E = [[0,1,9]]
S = 0
Output:
0 9
Explanation:
Shortest distance of all nodes from
source is printed.
Example 2:
Input:
 
E = [[0,1,5],[1,0,3],[1,2,-1],[2,0,1]]
S = 2
Output:
1 6 0
Explanation:
For nodes 2 to 0, we can follow the path-
2-0. This has a distance of 1.
For nodes 2 to 1, we cam follow the path-
2-0-1, which has a distance of 1+5 = 6,
 
Your Task:
You don't need to read input or print anything. Your task is to complete the function bellman_ford( ) which takes a number of vertices V and an E-sized list of lists of three integers where the three integers are u,v, and w; denoting there's an edge from u to v, which has a weight of w and source node S as input parameters and returns a list of integers where the ith integer denotes the distance of an ith node from the source node.
If some node isn't possible to visit, then its distance should be 100000000(1e8). Also, If the Graph contains a negative cycle then return an array consisting of only -1.
 
Expected Time Complexity: O(V*E).
Expected Auxiliary Space: O(V).
 
Constraints:
1 ≤ V ≤ 500
1 ≤ E ≤ V*(V-1)
-1000 ≤ adj[i][j] ≤ 1000
0 ≤ S < V











class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        
        int dist[]=new int[V];
        Arrays.fill(dist,100000000);
        dist[S]=0;
        
        for(int i=0;i<V-1;i++){
            relax(dist,edges);
        }
        
        int[] checkNegativeCycle = dist.clone();
        
        relax(checkNegativeCycle,edges);

        if(!Arrays.equals(dist, checkNegativeCycle))
            return new int[]{-1};
        
        
        return dist;
    }
    public static void relax(int dist[],ArrayList<ArrayList<Integer>> edges){
        for(List list : edges){
            if(dist[(int)list.get(0)] + (int)list.get(2) < dist[(int)list.get(1)])
                dist[(int)list.get(1)] = dist[(int)list.get(0)] + (int)list.get(2);
        }
    }
}


