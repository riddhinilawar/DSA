
package graph;

public class WeightedGraphMatrix {
	public static void main(String[] args) {
		
		//input
		int n=5,m=6;
		int edges[][]= {{1,2,2},{1,3,3},{3,4,4},{2,4,1},{2,5,6},{4,5,3}};
		
		int mat[][]=new int[n+1][n+1];
		for(int i=0;i<edges.length;i++)
		{
			mat[edges[i][0]][edges[i][1]]=edges[i][2];
			mat[edges[i][1]][edges[i][0]]=edges[i][2];
		}
		
		print(mat);
	}
	
	public static void print(int mat[][])
	{
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat[0].length;j++)
			{
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
	}
}
