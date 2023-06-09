Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105

Approach: two pinters
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        HashSet<List<Integer>> set=new HashSet<>();
        int target=0;
        int n=nums.length;
        Arrays.sort(nums);
        
        for(int i=0;i<n-2;i++){
            int j=i+1;
            int k=n-1;
            int find=-nums[i];
            while(j<k){
                if(nums[j]+nums[k]==find){
                    List<Integer> ll = new LinkedList<>();
                    ll.add(nums[i]);
                    ll.add(nums[j]);
                    ll.add(nums[k]);
                    set.add(ll);
                }
                if(nums[j]+nums[k]>find)
                    k--;
                else
                    j++;
            }
        }
	    List<List<Integer>> ans= new ArrayList<>(set);
	    return ans;
    }
}
	
Approach: Binary Search
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        HashSet<List<Integer>> set=new HashSet<>();
        
        int n=nums.length;
        Arrays.sort(nums);
        
        for(int i=0;i<n;i++)
        {
            
            for(int j=i+1;j<n;j++)
            {
                
                List<Integer> ll=new ArrayList<Integer>();
                
                int target=(0-nums[i]-nums[j]);
                
                if(BS(nums,j+1,n-1,target)==true)
                {
                    ll.add(nums[i]);
                    ll.add(nums[j]);
                    ll.add(target);
                    set.add(ll);
                }
            }
        }
        
	     List<List<Integer>> ans= new ArrayList<>(set);
	        
	        return ans;
     
    }
    public boolean BS(int nums[],int start,int end,int target)
    {
        while(start<=end)
        {
             int mid=start+(end-start)/2;
            
             if(nums[mid]==target)return true;
            
             if(nums[mid]>target) return BS(nums,start,mid-1,target);
             else return BS(nums,mid+1,end,target);
        }
        return false;
    }
}
