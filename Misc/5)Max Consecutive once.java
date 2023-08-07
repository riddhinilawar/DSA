Max Consecutive once                     LC-485
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans=1;
        int count=1;
        //handling exception when their is only 1 elemet in the array
        if(nums.length==1)
        {
            if(nums[0]==0)return 0;
            else return 1;
        }
        //handing exception if all elements in array are zero.
        int count0=1;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1]&&nums[i]==1)
            {
                count++;
                ans=Math.max(count,ans);
            }
            else
            {
                count=1;
            }   
            //handling exception
            if(nums[i]==nums[i+1]&&nums[i]==0)
            {
                count0++;
            }
        }
        if(count0==nums.length)return 0;
        else
        return ans;
        /*[1]*/
    }
}
Given a binary array nums, return the maximum number of consecutive 1's in the array.
Example 1:
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:
Input: nums = [1,0,1,1,0,1]
Output: 2
Constraints: 1 <= nums.length <= 105, nums[i] is either 0 or 1.
Exception: if only single number is a input
If all the elements in the array are 0
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
