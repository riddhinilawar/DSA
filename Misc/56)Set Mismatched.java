Set Mismatched                                                                       LC-645
You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
You are given an integer array nums representing the data status of this set after the error.
Find the number that occurs twice and the number that is missing and return them in the form of an array.
 
Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]
Example 2:
Input: nums = [1,1]
Output: [1,2]
 
Constraints:
•	2 <= nums.length <= 104
•	1 <= nums[i] <= 104
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        int res[]=new int[2];
        for(int i:nums)
        {
            if(nums[Math.abs(i)-1]>0) nums[Math.abs(i)-1]*=-1;
            else res[0]=Math.abs(i);
        }
        
        for(int i=0;i<n;i++)if(nums[i]>0)res[1]=i+1;
        
        return res;
    }
}
