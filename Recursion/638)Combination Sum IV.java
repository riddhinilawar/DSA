377. Combination Sum IV


Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.

 

Example 1:

Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
Example 2:

Input: nums = [9], target = 3
Output: 0
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 1000
All the elements of nums are unique.
1 <= target <= 1000
 

Follow up: What if negative numbers are allowed in the given array? How does it change the problem? What limitation we need to add to the question to allow negative numbers?

class Solution {
    int count;
    public int helper(int indx,int target,int []arr,int [] dp){
        //base case
        if(target==0){
            return 1;
        }
        //if it is already computed 
        if(dp[target]!=-1)return dp[target];
        //do all stuff on that index
        int ans =0;
        for(int i =0;i<arr.length;i++){
            if(target>=arr[i]){
                ans+=helper(i,target-arr[i],arr,dp);
            }
        }
        //store and return
        return dp[target]=ans;

    }
    public int combinationSum4(int[] nums, int target) {
        //create a dp array 
        int [] dp = new int[target+1];
        //fill with -1
        Arrays.fill(dp,-1);
        //return the count of combination which sum =target
        return helper(0,target,nums,dp);
    }
}
