package pra;
import java.util.*;
public class MaximumSubarraySumBruteForceAlgo {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number:");
		int n=sc.nextInt();
		System.out.println("enter the number of elements in the array:");
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		sc.close();
		
		//logic
		int sum=0;
		int ans=0;
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				sum=0;
				for(int k=i;k<=j;k++)
				{
					//System.out.print(arr[k]+" ");
					sum=sum+arr[k];
				}
				//System.out.println();
				if(sum>ans)ans=sum;
				
			}
		}
		System.out.println("Maximum SubArray Sum: "+ans );
	}
}
/*
Enter the number:
4
enter the number of elements in the array:
-1
4
7
2
Maximum SubArray Sum: 13

*/
