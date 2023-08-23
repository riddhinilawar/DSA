Subsets- gfg                                                                            LC-78
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
 
Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:
Input: nums = [0]
Output: [[],[0]]
 
Constraints:
•	1 <= nums.length <= 10
•	-10 <= nums[i] <= 10
•	All the numbers of nums are unique.
Expected Time Complexity: O(2 power N)
Expected Auxiliary Space: O(1)
	Due to constraints we could able to use this method
class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0;i<Math.pow(2,nums.length);i++)
        {
            List<Integer> s=new ArrayList<>();
            
            for(int j=0;j<nums.length;j++)
            {
                if((i&(1<<j))>0)
                    s.add(nums[j]);
            }
            
            ans.add(s);
            
        }
        return ans;
    }
}
