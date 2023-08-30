78. Subsets

Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.


class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        helper(0,ans,nums,new ArrayList<>());
        return ans;
    }

    public void helper(int idx, List<List<Integer>> ans, int nums[], List<Integer> temp)
    {
        if(idx==nums.length)
        {
            ans.add(new ArrayList(temp));
            return;
        }

        temp.add(nums[idx]);
        helper(idx+1,ans,nums,temp);
        temp.remove(temp.size()-1);

        helper(idx+1,ans,nums,temp);
        
    }
}
