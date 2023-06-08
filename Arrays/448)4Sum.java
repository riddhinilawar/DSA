Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 

Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                long find=((long)target-(long)nums[i]-(long)nums[j]);
                int k=j+1;
                int l=nums.length-1;
                while(k<l){
                    if(nums[k]+nums[l]==find){
                        List<Integer> child=new ArrayList<>();
                        child.add(nums[i]);
                        child.add(nums[j]);
                        child.add(nums[k]);
                        child.add(nums[l]);
                        k++;
                        if(list.contains(child)==false)
                            list.add(child);
                    }
                    else if(nums[k]+nums[l]>find){
                        l--;
                    }
                    else{
                        k++;
                    }
                }
            }
        }
        return list;
    }
}
