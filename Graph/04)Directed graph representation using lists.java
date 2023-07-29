package graph;
import java.util.*;
public class UnidirectedGraphList {
	public static void main(String[] args) {
		
		//input
		int n=5,m=6;
		int edges[][]= {{1,2},{1,3},{3,4},{2,4},{2,5},{4,5}};
		
		List<List<Integer>> adjlist = new ArrayList<>();
		
		for(int i=0;i<n+1;i++)
			adjlist.add(new ArrayList<>());
		
		for(int i=0;i<edges.length;i++)
		{
			adjlist.get(edges[i][0]).add(edges[i][1]);
		}
		
		System.out.println(adjlist);
		
	}
}



