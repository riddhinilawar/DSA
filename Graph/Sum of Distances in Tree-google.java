
834. Sum of Distances in Tree

There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.

You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.

Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.

 

Example 1:


Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
Output: [8,12,6,10,10,10]
Explanation: The tree is shown above.
We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
equals 1 + 1 + 2 + 2 + 2 = 8.
Hence, answer[0] = 8, and so on.
Example 2:


Input: n = 1, edges = []
Output: [0]
Example 3:


Input: n = 2, edges = [[1,0]]
Output: [1,1]
 

Constraints:

1 <= n <= 3 * 104
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
The given input represents a valid tree.


class Solution {

    //to store the cost of the node, and return it ans answer
    int[] cost;

    //to store that for particular node, 
    //how many nodes are present below it, including self.
    int[] count;
    
    //toalNodes in array
    int totalNodes;

    ArrayList<ArrayList<Integer>> adjList;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        
        //normal initialization and creation of adjList
        cost = new int[N];
        count = new int[N];
        this.totalNodes=N;
        adjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < N ; ++i)
            adjList.add(new ArrayList<Integer>());
        for (int[] e : edges) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        //In the dfs, we finds out the cost of root node i.e.,0. 
        //here we get the totaledges 0 requires to go every other node.
        dfs(0, -1);

        //In this dfs, we have the cost of 0, it means parent node, 
        //from parent node we are trying to find the codt of its neighbours(or)child nodes.
        dfs2(0,-1);
       
        return cost;
    }

    public Pair dfs(int node, int pre) {
        Pair currentNode = new Pair(1,0);
        for (int neg : adjList.get(node)) {
            if (neg == pre) continue;
            Pair temp=dfs(neg, node);

            currentNode.value+=temp.nodes;
            currentNode.value+=temp.value;  
            currentNode.nodes+=temp.nodes;
        }
        //cost::cost of all the negibours + totalNumber no nodes below self
        cost[node]=currentNode.value;
        //count::total nodes which are decendent including self
        count[node]=currentNode.nodes;
        return currentNode;
    }


    public void dfs2(int node, int pre) {
        for (int neg : adjList.get(node)) {
            if (neg == pre) continue;
            //if you know the cost of the parent,
            //so how much you are adding to the parent just minus that 
            //reason::because now will from the edge with parents and its above elements
            //so remove below edges that is (nodes below u including you)
            //so add your value that would be 
            //(totalNodes-nodes under me==nodes conidering parent and its above nodes) 
            cost[neg] = cost[node] - count[neg] + totalNodes - count[neg];
            dfs2(neg, node);
        }
    }
}
class Pair{
    //node::totalnodes present below that node including self
    //value::from the particulat node to below nodes, what is the cost of moving
    int nodes;
    int value;
    Pair(int nodes,int value){
        this.nodes=nodes;
        this.value=value;
    }
}
