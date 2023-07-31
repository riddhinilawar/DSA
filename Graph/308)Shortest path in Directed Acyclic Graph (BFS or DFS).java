Shortest path in Directed Acyclic Graph
Given a Directed Acyclic Graph of N vertices from 0 to N-1 and a 2D Integer array(or vector) edges[ ][ ] of length M, where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i, 0<=i
Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.
 
Example:
Input:
n = 6, m= 7
edge=[[0,1,2],[0,4,1],[4,5,4]
,[4,2,2],[1,2,3],[2,3,6],[5,3,1]]

Output:
0 2 3 6 1 5
 
Your Task:
You don't need to print or input anything. Complete the function shortest path() which takes an integer N as number of vertices, an integer M as number of edges and a 2D Integer array(or vector) edges as the input parameters and returns an integer array(or vector), denoting the list of distance from src to all nodes.
 
Constraint:
1 <= n,m <= 100
0 <= edgei,0,edgei,1 < n
 
 
Expected Time Complexity: O(N+E), where N is the number of nodes and E is edges
Expected Space Complexity: O(N)








Using DFS: (Preffered)
class Solution {

	public int[] shortestPath(int n,int m, int[][] edges) {
		boolean vis[]=new boolean[n];
		int dist[]=new int[n];
		Arrays.fill(dist,-1);
		dist[0]=0;

		ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
		for(int i=0;i<n;i++)adj.add(new ArrayList<>());

		for(int i=0;i<m;i++){
			adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
		}

		//handling exception
		if(adj.get(0).size()==0){
			return dist;
		}

		Stack<Integer> stack=new Stack<Integer>();

		dfs(0,adj,vis,stack);        

		while(!stack.isEmpty()){
			int node=stack.pop();
			for(Pair p:adj.get(node)){
				if(dist[p.to]==-1)
					dist[p.to]=dist[node]+p.weight;
				else if(dist[p.to]>(dist[node]+p.weight))
					dist[p.to]=(dist[node]+p.weight);
			}
		}
		return dist;
	}
	public void dfs(int node, ArrayList<ArrayList<Pair>> adj,boolean vis[],Stack<Integer> stack) 
	{
		vis[node]=true;
		for(Pair it: adj.get(node)){
			if(vis[it.to]==false){
				dfs(it.to,adj,vis,stack);
			}
		}
		stack.push(node);
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

Using BFS: (Preffered)
class Solution {

	public int[] shortestPath(int n,int m, int[][] edges) {
		int indegree[]=new int[n];
		int dist[]=new int[n];
		Arrays.fill(dist,-11);
		dist[0]=0;
		ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
		for(int i=0;i<n;i++)adj.add(new ArrayList<>());

		for(int i=0;i<m;i++){
			adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
			indegree[edges[i][1]]++;
		}

		if(adj.get(0).size()==0){
			Arrays.fill(dist,-1);
			dist[0]=0;
			return dist;
		}

		Stack<Integer> stack=new Stack<>();
		Queue<Integer> q=new LinkedList<>();
		ArrayList<Integer> ar=new ArrayList<>();

		for(int i=0;i<n;i++){
			if(indegree[i]==0){
				q.add(i);
				ar.add(i);
				dist[i]=-1;
			}
		}

		while(!q.isEmpty()){
			int node=q.poll();
			for(Pair p:adj.get(node)){
				indegree[p.to]--;
				if(indegree[p.to]==0){
					ar.add(p.to);
					q.add(p.to);
				}
			}
		}
		for(int i=ar.size()-1;i>=0;i--)stack.push(ar.get(i));

		dist[0]=0;
		while(!stack.isEmpty()){
			int node=stack.pop();
			if(dist[node]==-1)continue;
			for(Pair p:adj.get(node)){
				if(dist[p.to]==-11)
					dist[p.to]=dist[node]+p.weight;
				else if(dist[p.to]>(dist[node]+p.weight))
					dist[p.to]=(dist[node]+p.weight);
			}
		}
		return dist;
	}}  
Note: Pair class code is as of bfs


