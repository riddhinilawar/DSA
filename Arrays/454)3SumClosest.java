Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 

Constraints:

3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-104 <= target <= 104

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);

        int diff = Integer.MAX_VALUE;
        int ans=0;

        for(int i=0;i<n-2;i++){

            int tar = target - nums[i];

            int j=i+1;
            int k=n-1;

            while(j<k){
             //   System.out.println(nums[i]+" "+nums[j]+" "+nums[k]);

                if(diff > Math.abs(target - (nums[i]+nums[j]+nums[k]))){
                    diff = Math.abs(target - (nums[i]+nums[j]+nums[k]));
                   // System.out.println(diff);
                    ans=nums[i]+nums[j]+nums[k];
                }

                if(nums[j]+nums[k] < tar){
                    j++;
                }
                else{
                    k--;
                }

            }

        }
        return ans;
    }
}
