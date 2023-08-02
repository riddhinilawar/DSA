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
        
        int[] chechNegativeCycle = dist.clone();
        
        relax(chechNegativeCycle,edges);

        if(!Arrays.equals(dist, chechNegativeCycle))
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

















Floyd Warshall

The problem is to find the shortest distances between every pair of vertices in a given edge-weighted directed graph. The graph is represented as an adjacency matrix of size n*n. Matrix[i][j] denotes the weight of the edge from i to j. If Matrix[i][j]=-1, it means there is no edge from i to j.
Do it in-place.
Example 1:
Input: matrix = {{0,25},{-1,0}}
 
Output: {{0,25},{-1,0}}
 
Explanation: The shortest distance between
every pair is already given(if it exists).
Example 2:
Input: matrix = {{0,1,43},{1,0,6},{-1,-1,0}}
 
Output: {{0,1,7},{1,0,6},{-1,-1,0}}
 
Explanation: We can reach 2 from 0 as 0->1->2
and the cost will be 1+6=7 which is less than 
43.
Your Task:
You don't need to read, return or print anything. Your task is to complete the function shortest_distance() which takes the matrix as input parameter and modifies the distances for every pair in-place.
Expected Time Complexity: O(n3)
Expected Space Complexity: O(1)
Constraints:
1 <= n <= 100
-1 <= matrix[ i ][ j ] <= 1000


class Solution {
    public void shortest_distance(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int)(1e9);
                }
                if (i == j) matrix[i][j] = 0;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j],
                                            matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == (int)(1e9)) {
                    matrix[i][j] = -1;
                }
            }
        }
    }
}


































City With the Smallest Number of Neighbors at a Threshold Distance

There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi , toi ,weighti]  represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distance Threshold. You need to find out a city with the smallest number of cities that are reachable through some path and whose distance is at most Threshold Distance, If there are multiple such cities, our answer will be the city with the greatest number.
Note: that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.
Example 1:
Input:
N=4,M=4
edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]]
distanceThreshold = 4
Output:3
Explaination:The neighboring cities at a distanceThreshold = 4 for each city are:
City 0 -> [City 1, City 2] 
City 1 -> [City 0, City 2, City 3] 
City 2 -> [City 0, City 1, City 3] 
City 3 -> [City 1, City 2] 
Cities 0 and 3 have 2 neighboring cities at a distanceThreshold = 4, but we have to return city 3 since it has the greatest number.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findCity( ) which takes a No of nodes N and vector of edges and ThresHold Distance. and Return the city with the smallest number of cities that are reachable through some path and whose distance is at most Threshold Distance, If there are multiple such cities, return the city with the greatest number.
Expected Time Complexity: O(V^2 + EVlogV)
Expected Auxiliary Space:  O(N^3)

Constraints:
1 ≤ N≤ 100
1 <= edges.length <= n*(n-1)/2
edges[i].length == 3
0 <= fromi < toi < n
1 <= weight, distanceThreshold <= 10^4
All pairs (fromi, toi) are distinct

class Solution {

    int findCity(int n, int m, int edges[][],
                 int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                dist[i][j] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        for (int i = 0; i < n; i++) dist[i][i] = 0;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] == Integer.MAX_VALUE ||
                            dist[k][j] == Integer.MAX_VALUE)
                        continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int cntCity = n;
        int cityNo = -1;
        for (int city = 0; city < n; city++) {
            int cnt = 0;
            for (int adjCity = 0; adjCity < n; adjCity++) {
                if (dist[city][adjCity] <= distanceThreshold)
                    cnt++;
            }

            if (cnt <= cntCity) {
                cntCity = cnt;
                cityNo = city;
            }
        }
        return cityNo;
    }
}



