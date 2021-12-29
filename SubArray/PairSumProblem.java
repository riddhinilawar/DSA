package pra;
import java.util.*;
public class PairSumProblem {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number:");
		int n=sc.nextInt();
		System.out.println("enter the elements in array:");
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		System.out.println("enter the value of k:");
		int k=sc.nextInt();
		sc.close();
		
		//logic
		
		int flag=0;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(arr[i]+arr[j]==k)
					flag=1;
			}
		}
		if(flag==1)
		{
			System.out.println("pair sum found");
		}
		else
		{
			System.out.println("pair sum not found");
		}
	}
}
