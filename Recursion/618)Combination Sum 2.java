Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30

class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> ans =new ArrayList<>();
        helper(0,target,arr,ans,new ArrayList<>());
        return ans;
    }
    public void helper(int curr,int target,int[] arr,List<List<Integer>> ans,List<Integer> temp){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }

         for(int i=curr;i<arr.length;i++){
            if(i>curr && arr[i]==arr[i-1])continue;
            if(arr[i]>target)break;

            temp.add(arr[i]);
            helper(i+1,target-arr[i],arr,ans,temp);
            temp.remove(temp.size()-1);
        }
    }

}
