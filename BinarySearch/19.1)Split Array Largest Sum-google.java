410. Split Array Largest Sum
Note:: Whenever the the end is sum..take the value in long variable and check with Integer.MAX_VALUE.

Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
Example 2:

Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 106
1 <= k <= min(50, nums.length)

class Solution {
    public int splitArray(int[] nums, int k) {
        
        long sum=0;
        int start=0;
        int end=0;
        int n=nums.length;

        for(int i=0;i<n;i++){
            sum+=nums[i];
            start=Math.max(start,nums[i]);
        }

        end=(sum>(long)Integer.MAX_VALUE)?Integer.MAX_VALUE:(int)sum;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(helper(nums,mid)<=k){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;

    }
    public int helper(int[] nums, int mid){
        int subArrays=1;
        int sum=0;

        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]>mid){
                sum=nums[i];
                subArrays++;
            }
            else{
                sum+=nums[i];
            }
        }

        return subArrays;
    }
}
