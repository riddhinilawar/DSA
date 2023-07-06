Expected Time Complexity:Best : O(NlogN)  
Average: O(NlogN) 
Worst: O(N2)
Expected Auxiliary Space: O(logN)-in worst case

Quick Sort - gfg
package sort;

class Quick{

	public static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int partition(int[] arr, int low, int high)
	{

		int pivot = arr[high]; 
		int i = (low - 1); 

		for(int j = low; j <= high - 1; j++)
		{
			if (arr[j] < pivot) 
			{
				i++; 
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}
	public static void quickSort(int[] arr, int low, int high)
	{
		if (low < high) 
		{

			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}
	public static void printArray(int[] arr, int size)
	{
		for(int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");

		System.out.println();
	}
	public static void main(String[] args)
	{
		int[] arr = { 10, 7, 8, 9, 1, 5 };
		int n = arr.length;

		quickSort(arr, 0, n - 1);
		System.out.println("Sorted array: ");
		printArray(arr, n);
	}
}



Quick Sort- kunal Kushwaha Approah
package quickSort;

public class KunalKushwahaApproach {
	public static void main(String[] args)
	{
		int[] arr = { 2, 1, 6, 10, 4, 1, 3, 9, 7};
		int n = arr.length;
		System.out.println("Sorted array: ");
		quickSort(arr, 0, n - 1);

		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void quickSort(int arr[],int low,int high)
	{
		if(low>high)return;

		int start=low;
		int end=high;
		int mid=low+(high-low)/2;
		int pivot=arr[mid];

		while(start<=end)
		{
			while(arr[start]<pivot)
			{
				start++;
			}
			while(arr[end]>pivot)
			{
				end--;
			}
			if(start<=end)
			{
				int temp=arr[start];
				arr[start]=arr[end];
				arr[end]=temp;
				start++;
				end--;
			}
		}
		quickSort(arr,low,end);
		quickSort(arr,start,high);
	}

}

