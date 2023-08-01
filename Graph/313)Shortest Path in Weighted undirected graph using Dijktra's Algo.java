Shortest Path in Weighted undirected graph

You are given a weighted undirected graph having n+1 vertices numbered from 0 to n and m edges describing there are edges between a to b with some weight, find the shortest path between the vertex 1 and the vertex n and if path does not exist then return a list consisting of only -1.
Example:
Input:
n = 5, m= 6
edges = [[1,2,2], [2,5,5], [2,3,4], [1,4,1],[4,3,3],[3,5,1]]
Output:
1 4 3 5
Explaination:
Shortest path from 1 to n is by the path 1 4 3 5

Your Task:
You don't need to read input or print anything. Your task is to complete the function shortestPath() which takes n vertex and m edges and vector of edges having weight as inputs and returns the shortest path between vertex 1 to n.
Expected Time Complexity: O(m* log(n))
Expected Space Complexity: O(n)
Constraint:
2 <= n <= 105
0 <= m <= 105
0<= a, b <= n
1 <= w <= 105











// User function Template for Java

class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        
        HashMap<Integer,ArrayList<Pair>> adj=new HashMap<>();
        for(int i=0;i<=n;i++) adj.put(i,new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][2],edges[i][1]));
            adj.get(edges[i][1]).add(new Pair(edges[i][2],edges[i][0]));
        }
        
        ArrayList<Integer> ans= new ArrayList<>();
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.distance-y.distance);
        pq.add(new Pair(0,1));
        
        int dist[]=new int[n+1];
        int parent[]=new int[n+1];
        
        for(int i=0;i<n+1;i++){
            dist[i]=Integer.MAX_VALUE;
            parent[i]=i;
        }
        dist[1]=1;
        
        while(!pq.isEmpty()){
            int curr=pq.peek().node;
            int currdis=pq.peek().distance;
            pq.remove();
            for(Pair neighbour:adj.get(curr)){
                int adjnode=neighbour.node;
                int adjdist=neighbour.distance;
                
                if(currdis+adjdist < dist[adjnode]){
                
                    dist[adjnode] = currdis+adjdist;
                    parent[adjnode]= curr;
                    pq.add(new Pair(dist[adjnode],adjnode));
                }
            }
        }
        
       
        if(dist[n]==Integer.MAX_VALUE){
            ans.add(-1);
            return ans;
        }
        
        int node=n;
        while(node!=parent[node]){
            ans.add(node);
            node=parent[node];
        }
        ans.add(1);
        Collections.reverse(ans);
        return ans;
    }
}
class Pair{
    int distance;
    int node;
    Pair(int distance,int node){
        this.distance=distance;
        this.node=node;
    }
}

