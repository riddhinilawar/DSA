Bubble Sort
Expected Time Complexity:
Best : O(N)  - count the swaps for first pass if it is equal to the no of element -1, then arr is already sorted, no need to perform further steps, return.
Average: O(N2) 
Worst: O(N2)
Expected Auxiliary Space: O(1)

Normal:
for(int i=0;i<n-1;i++)
		{
			for(int j=0;j<n-1-i;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;;
				}
			}
		}


Best Complexity:
for(int i=0;i<n-1;i++)
		{
			int swaps=0;
			for(int j=0;j<n-1-i;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swaps++;
				}
			}
			if(swaps==0&&i==0)
			{
				System.out.println("Array is sorted with best time complexity that is O(n)");
				break;
			}
		}


Descending:
for(int i=0;i<n-1;i++)
		{
			for(int j=0;j<n-1-i;j++)
			{
				if(arr[j]<arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;;
				}
			}
		}



String:
for(int i=0;i<n-1;i++)
		{
			for(int j=0;j<n-1-i;j++)
			{
				int res=arr[j].compareTo(arr[j+1]);
				if(res>0)
				{
					String temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;;
				}
			}
		}


Recursive: 
public static void BubbleSort(int arr[],int index)
	{
		if(index>arr.length-1)
		{
			return;
		}
		for(int i=0;i<arr.length-index-1;i++)
		{
			if(arr[i]>arr[i+1])
			{
				int temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
		}
		BubbleSort(arr,index+1);
	}
Function call: BubbleSort(arr, 0);
