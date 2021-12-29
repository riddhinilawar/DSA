package pra;

import java.util.Arrays;
import java.util.Scanner;

public class PairSumProblem2 {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number:");
		int n=sc.nextInt();
		System.out.println("enter the valur of k:");
		int k=sc.nextInt();
		System.out.println("enter the elements in the aray:");
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(arr);
		int low=0;
		int high=n-1;
		int r=fun(arr,low,high,k);
		if(r==1)System.out.println("no such pairs found");
	}
	public static int fun(int arr[],int low,int high,int k)
	{
		while(low<high)
		{
			if(arr[low]+arr[high]==k)
			{
				System.out.println("pair found at index "+low+" and "+high);
				return 0;
			}
			else if(arr[low]+arr[high]<k)
			{
				low++;
			}
			else
			{
				high--;
			}
		}
		return 1;
	}
}
