238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

=============================get the prefix product for rightside product while going throught left get the left side prefix product=====

TC::O(n)
SC::O(n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int leftP = 1;
        leftProduct[0] = 1;

        for(int i=1; i<nums.length; i++) {
            leftP *= nums[i-1];
            leftProduct[i] = leftP;
        }

        int rightP = 1;
        for(int i=nums.length-2; i>=0; i--) {
            rightP *= nums[i+1];
            leftProduct[i] *= rightP;
        }

        return leftProduct;
    }
}
=============count zeros====if count is more than 1 put 0 and return else normal============= 
TC::O(n)
SC::O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int zeroCount=0;
        int totalProduct=1;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zeroCount++;
            }
            else{
                totalProduct*=nums[i];
            }
        }

        int ans[]=new int[n];
        if(zeroCount>1){
            Arrays.fill(ans,0);
            return ans;
        }

        for(int i=0;i<n;i++){
            if(nums[i]==0){
                ans[i]=totalProduct;                
            }
            else if(zeroCount==1){
                ans[i]=0;
            }
            else{
                ans[i]=totalProduct/nums[i];
            }
        }
        
        return ans;
    }
}
