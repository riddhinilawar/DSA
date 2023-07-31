Shortest path in Undirected Graph having unit distance

You are given an Undirected Graph having unit weight, Find the shortest path from src(0) to all the vertex and if it is unreachable to reach any vertex, then return -1 for that vertex.

Example:
Input:
n = 9, m= 10
edges=[[0,1],[0,3],[3,4],[4 ,5]
,[5, 6],[1,2],[2,6],[6,7],[7,8],[6,8]] 
src=0
Output:
0 1 2 1 2 3 3 4 4

Your Task:
You don't need to print or input anything. Complete the function shortest path() which takes a 2d vector or array edges representing the edges of undirected graph with unit weight, an integer N as number nodes, an integer M as number of edges and an integer src as the input parameters and returns an integer array or vector, denoting the vector of distance from src to all nodes.

Constraint:
1<=n,m<=100
1<=adj[i][j]<=100

Expected Time Complexity: O(N + E), where N is the number of nodes and E is edges
Expected Space Complexity: O(N)










class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        int vis[]=new int[n];
        int dist[]=new int[n];
        Arrays.fill(dist,-1);
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src,0));
        vis[src]=1;
        dist[src]=0;
        
        while(!q.isEmpty()){
            int node=q.peek().to;
            int weight=q.peek().weight;
            q.remove();
            for(int i:adj.get(node)){
                if(dist[i]==-1)dist[i]=weight+1;
                else if(dist[i]>weight+1)dist[i]=weight+1;
                if(vis[i]==0){
                    vis[i]=1;
                    q.add(new Pair(i,weight+1));
                    
                }
            }
        }
        return dist;
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

