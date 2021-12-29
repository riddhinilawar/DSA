package pra;
import java.util.*;
public class MaximumCircularSubArraySum {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number: ");
		int n=sc.nextInt();
		System.out.println("enter the elents in array: ");
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		sc.close();
		int nw_ans=fun(arr,n);
		int aarr[]=new int[n];
		int totalsum=0;
		for(int i=0;i<n;i++)
		{
			totalsum=totalsum+arr[i];
			aarr[i]=-arr[i];	
		}
		int w_ans=totalsum+fun(aarr,n);
		System.out.println("maximum circular sub array sum is: "+Math.max(nw_ans, w_ans));
	}
	public static int fun(int aarr[],int n)
	{
		int cursum=0;
		int maxsum=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			cursum=cursum+aarr[i];
			if(cursum<0)cursum=0;
			maxsum=Math.max(maxsum, cursum);
		}
		return maxsum;
	}
}
