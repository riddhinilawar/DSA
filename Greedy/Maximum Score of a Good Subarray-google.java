1793. Maximum Score of a Good Subarray

You are given an array of integers nums (0-indexed) and an integer k.

The score of a subarray (i, j) is defined as min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1). A good subarray is a subarray where i <= k <= j.

Return the maximum possible score of a good subarray.

 

Example 1:

Input: nums = [1,4,3,7,4,5], k = 3
Output: 15
Explanation: The optimal subarray is (1, 5) with a score of min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15. 
Example 2:

Input: nums = [5,5,4,5,4,1,1,1], k = 0
Output: 20
Explanation: The optimal subarray is (0, 4) with a score of min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 2 * 104
0 <= k < nums.length

class Solution {
    public int maximumScore(int[] nums, int k) {
        int i=k-1,j=k+1,n=nums.length;
        int ans=nums[k];
        int min=nums[k];

        while(i>=0 || j<n){
            //System.out.println((i+1)+" "+(j-1)+" "+min+" "+ans);
            if(i==-1){
                
                min=Math.min(min,nums[j]);
                j++;
                ans=Math.max(ans,min*(j-i-1));
                
            }
            else if(j==n){
                
                min=Math.min(min,nums[i]);
                i--;
                ans=Math.max(ans,min*(j-i-1));
                
            }
            else if(nums[i]>=nums[j]){
                
                min=Math.min(min,nums[i]);
                i--;
                ans=Math.max(ans,min*(j-i-1));
                
            }
            else{
                
                min=Math.min(min,nums[j]);
                j++;
                ans=Math.max(ans,min*(j-i-1));
                
            }
           
        }
        
        return ans;
    }
}
