
package graph;

public class UnidirectedGraphMatrix {
	public static void main(String[] args) {
		
		//input
		int n=5,m=6;
		int edges[][]= {{1,2},{1,3},{3,4},{2,4},{2,5},{4,5}};
		
		int mat[][]=new int[n+1][n+1];
		for(int i=0;i<edges.length;i++)
		{
			mat[edges[i][0]][edges[i][1]]=1;
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

