package pra;
import java.util.*;
public class SubArrayFinding {
	public static void main(String args[])
	{
		//input
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number:");
		int n=sc.nextInt();
		int arr[]=new int[n];
		System.out.println("Enter the elements in array:");
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		sc.close();
		
		//logic
		/*
		for(int k=0;k<n;k++)
		{
			int temp=k;
			for(int i=k;i<n;i++)
			{
				for(int j=i;j<n;j++)
				{
					System.out.print(temp+" ");
					temp++;
				}
				System.out.println();
				temp=k;
			}
		}*/
		
		//logic
				for(int k=0;k<n;k++)
				{
					int temp=k;
					for(int i=k;i<n;i++)
					{
						for(int j=i;j<n;j++)
						{
							System.out.print(arr[temp]+" ");
							temp++;
						}
						System.out.println();
						temp=k;
					}
				}
	}
}
