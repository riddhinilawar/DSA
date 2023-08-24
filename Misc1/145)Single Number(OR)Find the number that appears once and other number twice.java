class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];

        if(nums[0]!=nums[1])return nums[0];

        if(nums[n-1]!=nums[n-2])return nums[n-1];

        int start=0;
        int end=n-1;

        while(start<end)
        {
            int mid=start+(end-start)/2;

            if(mid>0&&mid<n-1&&nums[mid]!=nums[mid-1]&&nums[mid]!=nums[mid+1])return nums[mid];

            if((mid%2==0&&nums[mid]==nums[mid+1])||(mid%2==1&&nums[mid]==nums[mid-1]))start=mid+1;
            else end=mid;
        }
        return nums[start];
    }
}

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)



Find the number that appears once and other number twice, gfg
Single Number                          LC-136

class Solution {
    public int singleNumber(int[] nums) {
        int temp=0;
        for(int i=0;i<nums.length;i++)   
        {
            temp=temp^nums[i];
        }
        return temp;
    }
}
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.
 
Example 1:
Input: nums = [2,2,1]
Output: 1
Example 2:
Input: nums = [4,1,2,1,2]
Output: 4
Example 3:
Input: nums = [1]
Output: 1
 
Constraints:
•	1 <= nums.length <= 3 * 104
•	-3 * 104 <= nums[i] <= 3 * 104
•	Each element in the array appears twice except for one element which appears only once.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
