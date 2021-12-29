package pra;
import java.util.*;
public class MaximumSubArraySumCumulativeSumApproach {
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
		
		int cursum[]=new int[n+1];
		cursum[0]=0;
		for(int i=1;i<n+1;i++)
		{
			cursum[i]=cursum[i-1]+arr[i-1];
		}
		
		int ans=Integer.MIN_VALUE;
		for(int i=1;i<=n;i++)
		{
			int sum=0;
			for(int j=0;j<i;j++)
			{
				sum=cursum[i]-cursum[j];
				//System.out.println(sum+" "+cursum[i]+" "+cursum[j]);
				ans=Math.max(ans, sum);
			}
		}
		System.out.println("Maximum Sum is: "+ans);
	}
}
