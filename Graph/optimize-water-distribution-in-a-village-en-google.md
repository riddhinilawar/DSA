## Problem
Note::Hypothetically adding edge between all the nodes and node 0 cost for this edge will be cost of digging well, and considering node 0 as well
If any of the node is connected with 0 means well is digged.


https://leetcode.com/problems/optimize-water-distribution-in-a-village/
## Problem Description


```
There are n houses in a village. We want to supply water for all the houses by building wells and laying pipes.

For each house i, we can either build a well inside it directly with cost wells[i], or pipe in water from another well to it. The costs to lay pipes between houses are given by the array pipes, where each pipes[i] = [house1, house2, cost] represents the cost to connect house1 and house2 together using a pipe. Connections are bidirectional.

Find the minimum total cost to supply water to all houses.

Example 1:

Input: n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
Output: 3
Explanation: 
The image shows the costs of connecting houses using pipes.
The best strategy is to build a well in the first house with cost 1 and connect the other houses to it with cost 2 so the total cost is 3.

Constraints:

1 <= n <= 10000
wells.length == n
0 <= wells[i] <= 10^5
1 <= pipes.length <= 10000
1 <= pipes[i][0], pipes[i][1] <= n
0 <= pipes[i][2] <= 10^5
pipes[i][0] != pipes[i][1]
```
example 1 pic:

![example 1](https://p.ipic.vip/x8bb04.jpg)


## Solution

From example graph, we can see that this is Shortest path problem/Minimum spanning tree problem. In this problem, in a graph, view cities as nodes, pipe connects two cities as edges with cost.
here, wells costs, it is self connected edge, we can add extra node as root node `0`, and connect all `0` and `i` with costs `wells[i]`. So that we can have one graph/tree, 
and how to get minimun spanning trees / shortest path problem in a graph. Please see below detailed steps for analysis.

Analysis Steps：
1. Create `POJO EdgeCost(node1, node2, cost) - node1, node2, and cost of connect node1 and node2`
2. Assume on `root node 0`，build graph with `node 0 and all nodes(cities)`
3. Connect all nodes with`0`，`[0,i] - i is nodes range from [1,n]`，`0-1` meaning `node 0` and `node 1` connect edge ，value is node `i`'s cost `wells[i]`;
4. Turn cities into nodes, wells' costs and pipes' into  costs into edges value which connected into two cities.
5. Sort all edges (from min to max)
6. Scan all edges, check whether 2 nodes connected or not:（`Union-Find`），
    - if already connected, continue check next edge
    - if not yet connected, +costs, connect 2 nodes
7. If all nodes already connected, get minimum costs, return result
8. (#7 Optimization) for each `union`, total nodes number `n-1`, if `n==0`, then meaning all nodes already connected, can terminate early.

> Here use weighted-Union-find to check whether 2 nodes connceted or not, and union not connected nodes.

For example：`n = 5, wells=[1,2,2,3,2], pipes=[[1,2,1],[2,3,1],[4,5,7]]`

As below pic:

![minimum cost](https://p.ipic.vip/ps5bth.jpg)

From pictures, we can see that all nodes already connected with minimum costs.

#### Complexity Analysis
- *Time Complexity:* `O(ElogE + ElogV) - E number of edge in graph, to do the operation in the union and find for each edge in the list
- *Space Complexity:* `O(E)`



> A graph at most have `n(n-1)/2 - n number of nodes in graph` edges （[Complete Graph](https://www.wikiwand.com/en/Complete_graph)）

## Key Points
1. Build graph with all possible edges.
2. Sort edges by value (costs)
3. Iterate all edges (from min value to max value)
4. For each edges, check whether two nodes already connected (union-find),
    - if already connected, then skip
    - if not connected, then union two nodes, add costs to result

## Code (`Java`)
*Java code*
```java
import java.util.*;
public class Solution {

    public static int supplyWater(int n, int k, int[] wells, int[][] pipes) {
        // Write your code here
        List<EdgeCost> costs = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            costs.add(new EdgeCost(0, i, wells[i - 1]));
        }
        for (int[] p : pipes) {
            costs.add(new EdgeCost(p[0], p[1], p[2]));
        }
        Collections.sort(costs);
        int minCosts = 0;
        DisjointSet dsu = new DisjointSet(n);
        for (EdgeCost edge : costs) {
            int rootX = dsu.findUPar(edge.node1);
            int rootY = dsu.findUPar(edge.node2);
            if (rootX == rootY) continue;
            minCosts += edge.cost;
            dsu.unionBySize(edge.node1, edge.node2);
            // for each union, we connnect one node
            n--;
            // if all nodes already connected, terminate early
            if (n == 0) {
            return minCosts;
            }
        }
        return minCosts;
    }
    
}
class EdgeCost implements Comparable<EdgeCost> {
      int node1;
      int node2;
      int cost;
      public EdgeCost(int node1, int node2, int cost) {
        this.node1 = node1;
        this.node2 = node2;
        this.cost = cost;
      }
  
      @Override
      public int compareTo(EdgeCost o) {
        return this.cost - o.cost;
      }
    }
class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
```
