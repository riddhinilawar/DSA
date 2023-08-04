Minimum Spanning Tree

Given a weighted, undirected and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.
 
Example 1:
Input:
3 3
0 1 5
1 2 3
0 2 1
 
Output:
4
Explanation:
 
The Spanning Tree resulting in a weight
of 4 is shown above.
Example 2:
Input:
2 1
0 1 5
 
Output:
5
Explanation:
Only one Spanning Tree is possible
which has a weight of 5.
 
Your task:
Since this is a functional problem you don't have to worry about input, you just have to complete the function  spanningTree() which takes number of vertices V and an adjacency matrix adj as input parameters and returns an integer denoting the sum of weights of the edges of the Minimum Spanning Tree. Here adj[i] contains a list of lists containing two integers where the first integer a[i][0] denotes that there is an edge between i and a[i][0][0] and second integer a[i][0][1] denotes that the distance between edge i and a[i][0][0] is a[i][0][1].
In other words , adj[i][j] is of form  { u , wt } . So,this denotes that i th node is connected to u th node with  edge weight equal to wt.
 
Expected Time Complexity: O(ElogV).
Expected Auxiliary Space: O(V2).
 
Constraints:
2 ≤ V ≤ 1000
V-1 ≤ E ≤ (V*(V-1))/2
1 ≤ w ≤ 1000
Graph is connected and doesn't contain self loops & multiple edges.


class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    
	    int vis[]=new int[V];
	    int sum=0;
	    
	    HashMap<Integer,ArrayList<Pair>> adjlist = new HashMap<>();
	    
	    for(int[] edge:edges){
	        adjlist.putIfAbsent(edge[0],new ArrayList<>());
	        adjlist.putIfAbsent(edge[1],new ArrayList<>());
	        
	        adjlist.get(edge[0]).add(new Pair(edge[1],edge[2]));
	        adjlist.get(edge[1]).add(new Pair(edge[0],edge[2]));
	    }
	    
	    PriorityQueue<Tuple> pq= new PriorityQueue<>((a,b)->a.weight-b.weight);
	    pq.add(new Tuple(0,0,-1));
	    
	    ArrayList<int[]> MSTEdges = new ArrayList<>();
	    
	    while(!pq.isEmpty()){
	        Tuple t = pq.poll();
	        
	        int weight=t.weight;
	        int node=t.node;
	        int parent=t.parent;
	        
	        if(vis[node] == 0){
	            vis[node]=1;
	            sum+=weight;
	            
	            if(parent!=-1)MSTEdges.add(new int[]{node,parent});
	        
	            for(Pair p : adjlist.get(node)){
	                
	                int nnode=p.to;
	                int nweight=p.weight;
	                
	                if(vis[nnode]!=1){
	                    pq.add(new Tuple(nweight,nnode,node));
	                }
	            }
	        }
	        
	    }
	    return sum;
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
class Tuple{
    int weight;
    int node;
    int parent;
    Tuple(int weight,int node,int parent){
        this.weight=weight;
        this.node=node;
        this.parent=parent;
    }
}


