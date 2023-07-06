Selection Sort
Expected Time Complexity:
 Best : O(N2)
 Average: O(N2)
 Worst: O(N2)
Expected Auxiliary Space: O(1)
Iterative:
for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
            {
                if (arr[j] < arr[min_idx])
                {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
	
Recursive:
public static int[] SelectionSort(int arr[],int index,int curr)
	{
		if(index>=arr.length-1)
			return arr;
		else
		{
			int min=Integer.MAX_VALUE;
			for(int i=index+1;i<arr.length;i++)
			{
				if(arr[i]<min)min=i;
			}
			int temp=arr[curr];
			arr[curr]=arr[min];
			arr[min]=temp;
			return SelectionSort(arr,index+1,curr+1);
		}
	}
Recursive call : SelectionSort(arr,1,0);
