3123. Find Edges in Shortest Paths

You are given an undirected weighted graph of n nodes numbered from 0 to n - 1. The graph consists of m edges represented by a 2D array edges, where edges[i] = [ai, bi, wi] indicates that there is an edge between nodes ai and bi with weight wi.

Consider all the shortest paths from node 0 to node n - 1 in the graph. You need to find a boolean array answer where answer[i] is true if the edge edges[i] is part of at least one shortest path. Otherwise, answer[i] is false.

Return the array answer.

Note that the graph may not be connected.

 

Example 1:


Input: n = 6, edges = [[0,1,4],[0,2,1],[1,3,2],[1,4,3],[1,5,1],[2,3,1],[3,5,3],[4,5,2]]

Output: [true,true,true,false,true,true,true,false]

Explanation:

The following are all the shortest paths between nodes 0 and 5:

The path 0 -> 1 -> 5: The sum of weights is 4 + 1 = 5.
The path 0 -> 2 -> 3 -> 5: The sum of weights is 1 + 1 + 3 = 5.
The path 0 -> 2 -> 3 -> 1 -> 5: The sum of weights is 1 + 1 + 2 + 1 = 5.
Example 2:


Input: n = 4, edges = [[2,0,1],[0,1,1],[0,3,4],[3,2,2]]

Output: [true,false,false,true]

Explanation:

There is one shortest path between nodes 0 and 3, which is the path 0 -> 2 -> 3 with the sum of weights 1 + 2 = 3.

 

Constraints:

2 <= n <= 5 * 104
m == edges.length
1 <= m <= min(5 * 104, n * (n - 1) / 2)
0 <= ai, bi < n
ai != bi
1 <= wi <= 105
There are no repeated edges.


class Solution {
    //Same as single weight path find in Dijkastra's
    public boolean[] findAnswer(int n, int[][] edges) {
        
        HashMap<Integer,ArrayList<Pair>> adjList = new HashMap<>();
        for(int i=0;i<n;i++){
            adjList.put(i,new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adjList.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }

        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.weight-y.weight);
        pq.add(new Pair(0,0));

        int dist[]=new int[n];
        HashMap<Integer,ArrayList<Integer>> parent = new HashMap<>();

        for(int i=0;i<n;i++){
            dist[i]=Integer.MAX_VALUE;
            parent.put(i,new ArrayList<>());
        }

        dist[0]=0;

        while(!pq.isEmpty()){
            int curr=pq.peek().to;
            int currWeight=pq.peek().weight;
            pq.remove();

            for(Pair neighbour:adjList.get(curr)){
                int negNode=neighbour.to;
                int negWeight=neighbour.weight;

                if(currWeight+negWeight < dist[negNode]){
                    dist[negNode]=currWeight+negWeight;
                    pq.add(new Pair(negNode,currWeight+negWeight));
                    parent.put(negNode,new ArrayList<>());
                    parent.get(negNode).add(curr);
                }
                else if(currWeight+negWeight == dist[negNode]){
                    parent.get(negNode).add(curr);
                }
            }
        }
        
        //System.out.println(parent);

        int edgeSize=edges.length;
        boolean ans[]=new boolean[edgeSize];

        if(dist[n-1]==Integer.MAX_VALUE){
            return ans;//no path exist
        }
        
        HashSet<String> allEdges = new HashSet();
        dfs(n-1,parent,allEdges);

        //System.out.println(allEdges);
        
        for(int i=0;i<edgeSize;i++){
            int edge[]=edges[i];
            if(allEdges.contains(edge[0]+" "+edge[1]) || allEdges.contains(edge[1]+" "+edge[0])){
                ans[i]=true;
            }
        }
        
        return ans;
        
    }

    public void dfs(int node,HashMap<Integer,ArrayList<Integer>> parent,HashSet<String> allEdges){
        
        for(int neg:parent.get(node)){
            
            allEdges.add(node+" "+neg);
            dfs(neg,parent,allEdges);
            
        }
    }

}
class Pair{
	int to;
	int weight;
	Pair(int to,int weight){
		this.to=to;
		this.weight=weight;
	}
}
