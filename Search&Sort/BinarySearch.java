Binary Search
  
Expected Time Complexity:
Best : O(1) 
Average: O(logN) 
Worst: O(logN) 
Expected Auxiliary Space: O(1)

Iterative: 
class Solution{
    static int searchInSorted(int a[], int N, int K)
    {
        int low=0;
        int high=N-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(a[mid]==K)return true;
            if(a[mid]>K) high=mid-1;
            else low=mid+1;
        }
        return false;
    }
   
}


Recursive:
class Solution {
    int binarysearch(int arr[], int n, int k) {
        return BS(arr,0,n-1,k);
    }
    public static int BS(int a[],int low,int high,int t)
    {
        if(low>high)
        {
            return -1;
        }
        else
        {
            int mid=low+(high-low)/2;
            if(a[mid]==t)return mid;
            if(a[mid]<t)
            {
                int temp=BS(a,mid+1,high,t);
                if(temp!=-1)return temp;
            }
            else
            {
                int temp=BS(a,low,mid-1,t);
                if(temp!=-1)return temp;
            }
            return -1;
        }
        
    }
   
}



Algorithm:
binarySearch(arr, x, low, high)
           if low > high
               return False 
   
           else
               mid = (low + high) / 2 
                   if x == arr[mid]
                   return mid
       
               else if x > arr[mid]        // x is on the right side
                   return binarySearch(arr, x, mid + 1, high)
               
               else                        // x is on the right side
                return binarySearch(arr, x, low, mid - 1)


  
  
  For Descending:
  public static void main(String args[])
	{

		int a[]= {15,11,7,4,3,1 };
		int key=9;
		int low=0;
		int high=a.length-1;
		while(low<=high)
		{

			int mid=low+(high-low)/2;
			if(a[mid]==key)
			{
				System.out.println("element found");
				return;
			}
			if(a[mid]>key)
			{
				low=mid+1;
			}
			else
			{
				high=mid-1;
			}
		}
		System.out.println("element not found");
	}
