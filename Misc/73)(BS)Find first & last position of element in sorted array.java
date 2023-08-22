Find first & last position of element in sorted array LC-34
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
 
Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:
Input: nums = [], target = 0
Output: [-1,-1]
 
Constraints:
•	0 <= nums.length <= 105
•	-109 <= nums[i] <= 109
•	nums is a non-decreasing array.
•	-109 <= target <= 109
Expected Time Complexity: O(log n)~O(n)
Expected Auxiliary Space: O(1)


class Solution {
    public int[] searchRange(int[] arr, int x) {
        int n=arr.length;
        
        if(arr.length==0||arr[arr.length-1]<x) return (new int[]{-1,-1});
       
        
        if(arr[0]==x&&arr[arr.length-1]==x)return (new int[]{0,arr.length-1});
        
        
        int temp= BS(arr,0,arr.length-1,x);
        
        if(arr[temp]!=x||temp>=n)return (new int[]{-1,-1});
        
        //System.out.println(temp);
        int last=temp;
        for(int i=temp;i<n;i++)
        {
            if(arr[i]==x)last++;
            else break;
        }
        
        int first=temp;
        for(int i=temp;i>=0;i--)
        {
            if(arr[i]==x)first--;
            else break;
        }
        
        return (new int[]{first+1,last-1});
    }
    int BS(int arr[],int start,int end,int x)
    {
        int mid=start+(end-start)/2;
        
        if(start>end)
        {
            return mid;
        }
        
        if(arr[mid]==x)return mid;
        else if(arr[mid]>x)
        {
            return BS(arr,start,mid-1,x);
        }
        else
        {
            return BS(arr,mid+1,end,x);
        }
        
    }
}
