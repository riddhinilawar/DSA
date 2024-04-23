310. Minimum Height Trees

A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

 

Example 1:


Input: n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]
Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
Example 2:


Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
Output: [3,4]
 

Constraints:

1 <= n <= 2 * 104
edges.length == n - 1
0 <= ai, bi < n
ai != bi
All the pairs (ai, bi) are distinct.
The given input is guaranteed to be a tree and there will be no repeated edges.


class Solution {
    //Start BFS from all the nodes whose indegree is 1//Do khan's algo:TOPOSORT
    //While doing toposort the last nodes are left in queue is the answer
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        //edge case
        if(n == 1) return Collections.singletonList(0);

        HashMap<Integer,ArrayList<Integer>> levelDetails = new HashMap<>();
        HashMap<Integer,ArrayList<Integer>> adjList = new HashMap<>();
        int inDegrees[]=new int[n];

        for(int edge[]:edges){
            adjList.putIfAbsent(edge[0],new ArrayList<Integer>());
            adjList.putIfAbsent(edge[1],new ArrayList<Integer>());
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
            inDegrees[edge[0]]++;
            inDegrees[edge[1]]++;
        }

        //bfs from all nodes whose indegree is 1
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDegrees[i]==1){
                q.add(i);
            }
        }

        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){

                int curr=q.remove();
                levelDetails.putIfAbsent(level,new ArrayList<>());
                levelDetails.get(level).add(curr);

                if(adjList.get(curr)==null)continue;
                for(int neg:adjList.get(curr)){
                    inDegrees[neg]--;
                    if(inDegrees[neg]==1){
                        q.add(neg);
                    }
                }
            }
            level++;
        }

        return levelDetails.get(levelDetails.size()-1);
    }
}
