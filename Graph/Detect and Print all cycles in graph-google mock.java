Imagine we are a software development company and we manage our dev process using an issue tracking tool. Each issue has an ID and also a list of IDs of issues which block it (Blockers or parents). As a result we have 1 or multiple unidirectional graphs because there could have several root issues (Epics).

At some point in time someone added an issue A as a Blocker of issue B. But because A was already blocked by the descendants of the current issue B (descendants of B are the issues that are transitively blocked by B), this created a circular dependency. After this our UI issue tracking tool (Taskflow) stopped showing issues correctly. Our task is to find out all circular dependency loops.

The input is a 2D boolean array of blockers assignments. The row number is the issue ID. The column number is Blocker issue ID. So entry (i, j) is True means that issue i is blocked by issue j.
Example input:
- 0 1 2 3
0 False False True
1 True False False
2 False True Fals

The output is a list of dependency cycles. The order inside one cycle doesn't matter.
Example:
[
[0, 2, 1] (as well can be 2,1,0 or 1,0,2)
]

edge(0,2)(1,0)(2,1)--adjList

0→2→1->0

Disconnected compo. 

Vis 


Public ArrayList<ArrayList<Integer>> taskflowCycleDetection(boolean[][] matrix){
	ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
	int totalTasks=matrix.length;
	for(int i=0;i<totalTasks;i++){
		adjList.add(i,new ArrayList<>());
	}
	int vis[]=new int[totalTasks];
	Int pathVis[]=new int[totalTasks];
	
	ArrayList<ArrayList<Integer>> allCycles=new ArrayList<>();
	
	for(int i=0;i<totalTasks;i++){
		for(int j=0;j<totalTasks;j++){
			if(matrix[i][j]==true){
				adjList.get(i).add(j);
			}
		}
	}
	
	for(int i=0;i<totalTasks;i++){
		if(vis[i]!=1){
			ArrayList<Integer> cycle = new ArrayList<>();
			Int cycleStart=dfs(i,adjList,vis,pathVis,cycle,i);
			if(cycleStart!=-1){
				ArrayList<Integer> exactCycleNodes=new ArrayList<>();
				Boolean isPartOfCycle=false;
				for(int node:cycle){
					if(node==cycleStart){
						isPartOfCycle=true;
					}
					if(isPartOfCycle==true){
						exactCycleNodes.add(node);
					}
				}
				allCycles.add(exactCycleNodes);
			}
		}
	}
}
return allCycles;

}
Public int dfs(int node,ArrayList<ArrayList<Integer>> adjList, int vis[],int pathVis[],ArrayList<Integer> cycle,int startNode){
	vis[node]=1;
	pathVis[node]=startNode;
	cycle.add(node);
	for(int neg:adjList.get(node)){
		if(vis[neg]==0){
			Int cycleDetectNode=dfs(neg,adjList,vis,pathVis,cycle,startNode);
			if(cycleDetectNode!=-1)return cycleDetectNode;
		}
		Else if(pathVis[neg]==startNode){
			Return neg;
		}
	}
	cycle.remove(cycle.length()-1);
	pathVis[node]=0;
	Return -1;
	
	}	

1 <-  3
|    |
2 - > 4 <-5
