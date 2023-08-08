Binary Search on rotated Array ,gfg            LC-33
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.
 
Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:
Input: nums = [1], target = 0
Output: -1
 
Constraints:
•	1 <= nums.length <= 5000
•	-104 <= nums[i] <= 104
•	All values of nums are unique.
•	nums is an ascending array that is possibly rotated.
•	-104 <= target <= 104
Binary Search Application





class Solution {
    public int search(int[] nums, int target) {
        return function(nums,0,nums.length-1,target);
    }
    public int function(int arr[],int low,int high,int target)
    {
        if(low>high)return -1;
        
        int mid=low+(high-low)/2;
    
        
        if(arr[mid]==target)
            return mid;
        
        if(arr[mid]>=arr[low])
        {
            if(target>=arr[low]&&target<arr[mid])
                return funBS(arr,low,mid-1,target);
            else
                return function(arr,mid+1,high,target);
        }
        else
        {
            if(target>arr[mid]&&target<=arr[high])
                return funBS(arr,mid+1,high,target);
            else
                return function(arr,low,mid-1,target);
        }
    }
    public int funBS(int arr[],int low,int high,int target)
    {
        if(low>high)return -1;
        
        int mid=low+(high-low)/2;
        if(arr[mid]==target) return mid;
        else if(arr[mid]>target) return funBS(arr,low,mid-1,target);
        else return funBS(arr,mid+1,high,target);
    }
}
Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)
