Search Insert Position,gfg                  LC-35
Binary Search Application
leetcode solution: gfg solution is same as of this.
class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int mid=0;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if(nums[mid]==target)
            {	
                return mid;
            }
            else if(nums[mid]<target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
       if(nums[mid] < target ) return mid+1;

		return mid ;
    }
}
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.
Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4
Constraints:
•	1 <= nums.length <= 104
•	-104 <= nums[i] <= 104
•	nums contains distinct values sorted in ascending order.
•	-104 <= target <= 104
The logic which we wrote above will work fine for all the cases even when the array contains only 1 element.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
