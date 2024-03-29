90. Subsets II


Given an integer array nums that may contain duplicates, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        ArrayList<Integer> temp = new ArrayList<>();
        helper(0,set,nums,temp);
        return new ArrayList<>(set);
    }
    void helper(int curr,HashSet<ArrayList<Integer>> set,int nums[],ArrayList<Integer> temp)    
    {

        if(curr==nums.length){
            set.add(new ArrayList<>(temp));
            return;
        }
        
        temp.add(nums[curr]);
        helper(curr+1,set,nums,temp);
        temp.remove(temp.size()-1);
        helper(curr+1,set,nums,temp);
    }
}

======================================================================================================================

 class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans =new ArrayList<>();
        helper(0,arr,ans,new ArrayList<>());
        return ans;
    }
    
    public void helper(int idx,int[] arr,List<List<Integer>> ans,List<Integer> temp){
        
        ans.add(new ArrayList<>(temp));

        for(int i=idx;i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1])continue;
            
            temp.add(arr[i]);
            helper(i+1,arr,ans,temp);
            temp.remove(temp.size()-1);
        }
    }
}
