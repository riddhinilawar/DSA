package pra;

import java.util.Scanner;

public class MaximumSubArraySumKadanesAlgo {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number:");
		int n=sc.nextInt();
		System.out.println("Enter the elments in the array:");
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		sc.close();
		
		//logic
		int cursum=0;
		int maxsum=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			cursum=cursum+arr[i];
			if(cursum<0)cursum=0;
			maxsum=Math.max(maxsum, cursum);
		}
		System.out.println("Sum is: "+maxsum);
		
	}
}
