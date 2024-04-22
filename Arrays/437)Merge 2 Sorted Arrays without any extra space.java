Merge 2 Sorted Arrays without any extra
space                                                     LC-88,gfg
Solution1: Brute Force-
Intuition: We can use a new array of size n+m and put all elements of arr1 and arr2 in it, and sort it. After sorting it, but all the elements in arr1 and arr2.
Approach:
Make an arr3 of size n+m.
Put elements arr1 and arr2 in arr3.
Sort the arr3.
Now first fill the arr1 and then fill remaining elements in arr2. 
Time complexity: O(n*log(n))+O(n)+O(n)
Space Complexity: O(n) 
Solution 2: Without using space-
Intuition: We can think of Iterating in arr1 and whenever we encounter an element that is greater than the first element of arr2, just swap it. Now rearrange the arr2 in a sorted manner, after completion of the loop we will get elements of both the arrays in non-decreasing order.
Approach:
Use a for loop in arr1.
Whenever we get any element in arr1 which is greater than the first element of arr2,swap it.
Rearrange arr2.
Repeat the process.
Time complexity: O(n*m)
Space Complexity: O(1) 
Solution 3: Gap method-
Approach:
Initially take the gap as (m+n)/2;
Take as a pointer1 = 0 and pointer2 = gap.
Run a oop from pointer1 &  pointer2 to  m+n and whenever arr[pointer2]<arr[pointer1], just swap those.
After completion of the loop reduce the gap as gap=gap/2.
Repeat the process until gap>0.
Time complexity: O(n+m)
Space Complexity: O(1)

Approach 1
public static void merge(long arr1[], long arr2[], int n, int m) 
	{
		
		for(int i=0;i<n;i++)
		{
			if(arr1[i]>arr2[0])
			{
				long temp=arr1[i];
				arr1[i]=arr2[0];
				arr2[0]=temp;
			}
			
			
			int j=0;
			long first=arr2[0];
			for(j=1;j<m&&arr2[j]<first;j++)
			{
				arr2[j-1]=arr2[j];
			}
			arr2[j-1]=first;
			
		}
		
		for(int k=0;k<n;k++)
		{
			System.out.print(arr1[k]+" ");		
		}
		System.out.println();
		for(int k=0;k<m;k++)
		{
			System.out.print(arr2[k]+" ");		
		}
	}
Approach 2:
public static void merge(long arr1[], long arr2[], int n, int m) 
	{
		
		for(int i=0;i<n;i++)
		{
			if(arr1[i]>arr2[0])
			{
				long temp=arr1[i];
				arr1[i]=arr2[0];
				arr2[0]=temp;
			}
			
			
			int j=0;
			long first=arr2[0];
			for(j=1;j<m&&arr2[j]<first;j++)
			{
				arr2[j-1]=arr2[j];
			}
			arr2[j-1]=first;
			
		}
		
		for(int k=0;k<n;k++)
		{
			System.out.print(arr1[k]+" ");		
		}
		System.out.println();
		for(int k=0;k<m;k++)
		{
			System.out.print(arr2[k]+" ");		
		}
	}

=================SHELL SORT TECHNIQUE=====GAP METHOD================================================================
Note::here we use ceil because, floor will skip some elements
Ex::[0,1,2][0,1,2,3], with floor gaps here are 3,1:: with ceil gaps here are 4,2,1.
	
Approach 3(same as of leetcode, but not exact, change in sizes):

static void swap(int a,int b)
    {
        int temp=a;
        a=b;
        b=temp;
    }
   static void merge(int ar1[], int ar2[], int n, int m) {
  // code here 
  int gap =(int) Math.ceil((double)(n + m) / 2.0);
  while (gap > 0) {
    int i = 0;
    int j = gap;
    while (j < (n + m)) {
      if (j < n && ar1[i] > ar1[j]) {
        swap(ar1[i], ar1[j]);
      } else if (j >= n && i < n && ar1[i] > ar2[j - n]) {
        swap(ar1[i], ar2[j - n]);
      } else if (j >= n && i >= n && ar2[i - n] > ar2[j - n]) {
        swap(ar2[i - n], ar2[j - n]);
      }
      j++;
      i++;
    }
    if (gap == 1) {
      gap = 0;
    } else {
      gap =(int) Math.ceil((double) gap / 2.0);
    }
  }
}
Leetcode:
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        
        
        System.out.println(m+" "+n);
        
         int gap =(int) Math.ceil((double)(m+n) / 2.0);
        
        System.out.println(gap);
        
        while(gap>0)
        {
            
            int i=0;
            int j=gap;
            
            System.out.println(i+" "+j);
            
            while(j<m+n)
            {
                if(j<m&&nums1[i]>nums1[j])
                {
                    int temp=nums1[i];
                    nums1[i]=nums1[j];
                    nums1[j]=temp;
                }
                else if(i<m&&j>=m&&nums1[i]>nums2[j-m])
                {
                    int temp=nums1[i];
                    nums1[i]=nums2[j-m];
                    nums2[j-m]=temp;
                }
                else if(i>m&&j>m&&nums2[i-m]>nums2[j-m])
                {
                    int temp=nums2[i-m];
                    nums2[i-m]=nums2[j-m];
                    nums2[j-m]=temp;
                }
                i++;
                j++;
            }
            if(gap==1)
                gap=0;
            else
            gap =(int) Math.ceil((double)gap / 2.0);
        }
        
        for(int k=0,l=m;k<nums2.length;k++,l++)
        {
            nums1[l]=nums2[k];
        }
    }
}
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 
Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:
Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

