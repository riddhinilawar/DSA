413. Arithmetic Slices

An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [1,2,3,4]
Output: 3
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
Example 2:

Input: nums = [1]
Output: 0
 

Constraints:

1 <= nums.length <= 5000
-1000 <= nums[i] <= 1000

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        if(n==1)return 0;

        int ans=0;
        int count=0;
        int diff=Integer.MIN_VALUE;

        for(int i=1;i<n;i++){
            if(diff==(nums[i]-nums[i-1])){
                count++;
            }
            else{
                
                if(diff!=Integer.MIN_VALUE){
                    int value=(count+1<3)?0:count-1;
                    ans+=((value)*(value+1))/2;
                    //System.out.println(i+" "+value+" "+count+" "+diff);
                }
                
                count=1;
                diff=nums[i]-nums[i-1];
            }   
        }
        int value=(count+1<3)?0:count-1;
        ans+=((value)*(value+1))/2;
        return ans;
    }
}
