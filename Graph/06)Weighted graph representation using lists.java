package graph;
import java.util.*;
public class WeightedGraphList {
	public static void main(String[] args) {
		
		//input
		int n=5,m=6;
		int edges[][]= {{1,2,2},{1,3,3},{3,4,4},{2,4,1},{2,5,6},{4,5,3}};
		
		List<List<Pair>> adjlist = new ArrayList<>();
		
		for(int i=0;i<n+1;i++)
			adjlist.add(new ArrayList<>());
		
		for(int i=0;i<edges.length;i++)
		{
			adjlist.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
			adjlist.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
		}
		
		for(int i=0;i<adjlist.size();i++) {
			System.out.print(i+"= ");
			for(Pair p:adjlist.get(i)) {
				System.out.print(" ["+p.to+","+p.weight+"]");
			}
			System.out.println();
		}
		
	}
}
class Pair{
	int to;
	int weight;
	Pair(int to, int weight){
		this.to=to;
		this.weight=weight;
	}
}


