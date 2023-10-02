2876. Count Visited Nodes in a Directed Graph

There is a directed graph consisting of n nodes numbered from 0 to n - 1 and n directed edges.

You are given a 0-indexed array edges where edges[i] indicates that there is an edge from node i to node edges[i].

Consider the following process on the graph:

You start from a node x and keep visiting other nodes through edges until you reach a node that you have already visited before on this same process.
Return an array answer where answer[i] is the number of different nodes that you will visit if you perform the process starting from node i.

 

Example 1:


Input: edges = [1,2,0,0]
Output: [3,3,3,4]
Explanation: We perform the process starting from each node in the following way:
- Starting from node 0, we visit the nodes 0 -> 1 -> 2 -> 0. The number of different nodes we visit is 3.
- Starting from node 1, we visit the nodes 1 -> 2 -> 0 -> 1. The number of different nodes we visit is 3.
- Starting from node 2, we visit the nodes 2 -> 0 -> 1 -> 2. The number of different nodes we visit is 3.
- Starting from node 3, we visit the nodes 3 -> 0 -> 1 -> 2 -> 0. The number of different nodes we visit is 4.
Example 2:


Input: edges = [1,2,3,4,0]
Output: [5,5,5,5,5]
Explanation: Starting from any node we can visit every node in the graph in the process.
 

Constraints:

n == edges.length
2 <= n <= 105
0 <= edges[i] <= n - 1
edges[i] != i

class Solution {
    public int[] countVisitedNodes(List<Integer> edges) {
        
        //Step1:creating adjlist and revAdjlist
        int n=edges.size();
        HashMap<Integer,ArrayList<Integer>> adjlist = new HashMap<>();
        HashMap<Integer,ArrayList<Integer>> revAdjlist = new HashMap<>();
        
		for(int i=0;i<edges.size();i++){
            adjlist.putIfAbsent(i,new ArrayList<Integer>());
			adjlist.get(i).add(edges.get(i));
            
            revAdjlist.putIfAbsent(edges.get(i),new ArrayList<Integer>());
			revAdjlist.get(edges.get(i)).add(i);
		}
        
        
        
        //step2:performing toposort, to get the connected components togeather
        Stack<Integer> dfsResultSet = new Stack<>();
        int vis[]=new int[n];
        for(int i=0;i<n;i++)
        if(vis[i]==0)dfs(i,dfsResultSet,vis,adjlist);
        
        
        
        //Step3:finding the size of all the connected components using Disjoint Set Union & kosaraju's algo' 
        DisjointSet ds = new DisjointSet(n);
        Arrays.fill(vis,0);
        while (!dfsResultSet.isEmpty()) {
            int node = dfsResultSet.peek();
            dfsResultSet.pop();
            if (vis[node] == 0) {
                //System.out.println("node:"+node);
                dfs3(node, vis, revAdjlist,ds);
            }
        }
        
        
        //Step4:for storing repetative calls
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        
        
        
        //step5:iterating and finding the parent, if connected component i.e., size greater than 1, size is the ans, else do dfs and try to avoid recursive calls
        
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            
            
            int parent=ds.findUPar(i);
            int size=ds.size.get(parent);
            
            if(size>1){
                //case 1
                ans[i]=size;
                dp[i]=ans[i];
            }
            else{
                //case 2
                int currNode=i;
                int count=0;
                
                while(dp[currNode]==-1){
                    count++;
                    currNode=edges.get(currNode);
                    
                    int currNodeParent=ds.findUPar(currNode);
                    int currNodeSize=ds.size.get(currNodeParent);
                    
                    if(currNodeSize>1){
                        if(dp[currNode]==-1)dp[currNode]=currNodeSize;
                        break;
                    }
                }
                
                
                
                count+=dp[currNode];
                ans[i]=count;
                dp[i]=count;
            }
        }
        
        return ans;
    }
    public void dfs(int curr,Stack<Integer> dfsResultSet,int vis[],HashMap<Integer,ArrayList<Integer>> adjlist){
        vis[curr]=1;
        
        for(int neg:adjlist.get(curr)){
            if(vis[neg]==0){
                dfs(neg,dfsResultSet,vis,adjlist);
            }
        }
        dfsResultSet.push(curr);
    }
    
    public void dfs3(int curr, int[] vis, HashMap<Integer,ArrayList<Integer>> adjlist ,DisjointSet ds) {
        vis[curr] = 1;
        
        if(adjlist.containsKey(curr)){
            for (Integer neg : adjlist.get(curr)) {
                if (vis[neg] == 0) {
                    ds.unionBySize(curr,neg);
                    dfs3(neg, vis, adjlist,ds);
                }
            }
        }
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

/*
TESTCASES
[1,2,0,0]
[1,2,3,4,0]
[3,6,1,0,5,7,4,3]->n components
[6,3,6,1,0,8,0,6,6]->revAdjList requires
*/
