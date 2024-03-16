525. Contiguous Array


Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.


class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        int prefix0[]=new int[n];
        int prefix1[]=new int[n];

        HashMap<Integer,Integer> map=new HashMap<>();


        int ans=0;
        if(nums[0]==0){
            prefix0[0]=1;
        }
        else{
            prefix1[0]=1;
        }
        map.put(prefix0[0]-prefix1[0],0);
       
        for(int i=1;i<n;i++){
            if(nums[i]==0){
                prefix0[i]=prefix0[i-1]+1;
                prefix1[i]=prefix1[i-1];
            }
            else{
                prefix0[i]=prefix0[i-1];
                prefix1[i]=prefix1[i-1]+1;
            }
           
            if(prefix0[i]==prefix1[i]){
                ans=Math.max(ans,i+1);
            }
            if(map.containsKey(prefix0[i]-prefix1[i])==false){
                map.put(prefix0[i]-prefix1[i],i);
            }
            else{
                ans=Math.max(ans,i-map.get(prefix0[i]-prefix1[i]));
            }
        }
        
        //System.out.println(map);

        return ans;
    }
}
