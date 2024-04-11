2407. Longest Increasing Subsequence II, Approach 5 is best among all.

You are given an integer array nums and an integer k.

Find the longest subsequence of nums that meets the following requirements:

The subsequence is strictly increasing and
The difference between adjacent elements in the subsequence is at most k.
Return the length of the longest subsequence that meets the requirements.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: nums = [4,2,1,4,3,4,5,8,15], k = 3
Output: 5
Explanation:
The longest subsequence that meets the requirements is [1,3,4,5,8].
The subsequence has a length of 5, so we return 5.
Note that the subsequence [1,3,4,5,8,15] does not meet the requirements because 15 - 8 = 7 is larger than 3.
Example 2:

Input: nums = [7,4,5,1,8,12,4,7], k = 5
Output: 4
Explanation:
The longest subsequence that meets the requirements is [4,5,8,12].
The subsequence has a length of 4, so we return 4.
Example 3:

Input: nums = [1,5], k = 1
Output: 1
Explanation:
The longest subsequence that meets the requirements is [1].
The subsequence has a length of 1, so we return 1.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i], k <= 105
approach 1)================================================Recursion=====TLE===========================2 power n
class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        return helper(0,-1,k,nums);
    }
    public int helper(int idx,int prevIdx,int k,int nums[]){
        if(idx==nums.length){
            return 0;
        }
        
        int ans=Integer.MIN_VALUE;
        
        if(prevIdx==-1 || ((nums[idx]-nums[prevIdx])>0 && (nums[idx]-nums[prevIdx]) <=k)){
            ans=Math.max(ans,1+helper(idx+1,idx,k,nums));
        }
        ans=Math.max(ans,helper(idx+1,prevIdx,k,nums));

        
        return ans;
    }
}
approach 2)=========================================MEMOIZATION===============MLE============nsquare

class Solution {
    int dp[][];
    public int lengthOfLIS(int[] nums, int k) {
        int n=nums.length;
        dp=new int[n][n+1];
        for(int d[]:dp)Arrays.fill(d,-1);
        return helper(0,-1,k,nums);
    }
    public int helper(int idx,int prevIdx,int k,int nums[]){
        if(idx==nums.length){
            return 0;
        }
        
        if(dp[idx][prevIdx+1]!=-1){
            return dp[idx][prevIdx+1];
        }

        int ans=Integer.MIN_VALUE;
        
        if(prevIdx==-1 || ((nums[idx]-nums[prevIdx])>0 && (nums[idx]-nums[prevIdx]) <=k)){
            ans=Math.max(ans,1+helper(idx+1,idx,k,nums));
        }
        ans=Math.max(ans,helper(idx+1,prevIdx,k,nums));

        
        return dp[idx][prevIdx+1]=ans;
    }
}

approach 3)============================Tabulation==========MLE==============nsquare


class Solution {
    int dp[][];
    public int lengthOfLIS(int[] nums, int k) {
        if(nums.length==1)return 1;

        int n=nums.length;
        dp=new int[n][n+1];
        
        //base case
        for(int prevIdx=n-1;prevIdx>=-1;prevIdx--){
            if(prevIdx!=-1 && ((nums[n-1]-nums[prevIdx])>0 && (nums[n-1]-nums[prevIdx]) <=k))
                dp[n-1][prevIdx+1] = 1;
            else 
                dp[n-1][prevIdx+1] = 0;
        }

        for(int idx=n-2;idx>=0;idx--){
            for(int prevIdx=n-1;prevIdx>=-1;prevIdx--){
                
                int ans=Integer.MIN_VALUE;
        
                if(prevIdx==-1 || ((nums[idx]-nums[prevIdx])>0 && (nums[idx]-nums[prevIdx]) <=k)){
                    ans=Math.max(ans,1+dp[idx+1][idx+1]);
                }
                ans=Math.max(ans,dp[idx+1][prevIdx+1]);

        
                dp[idx][prevIdx+1]=ans;
            }
        }

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<=n;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return dp[0][0];
    }
}
approach 4)==================================n(n+1)/2======================go and check how many previous elements satisfies the condition, pick max values amoong them
class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int n=nums.length;
        int dp[]=new int[n];
        dp[0]=1;
        int ans=1;
        for(int i=1;i<n;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(nums[i]-nums[j] > 0 && nums[i]-nums[j]<=k){
                    max=Math.max(max,dp[j]);
                }
            }
            dp[i]=max+1;
            ans=Math.max(dp[i],ans);
        }
        return ans;
    }
}
approach 5)=============n*k=======================in 1d array maintains all the elements, check last k element for every element and update the ans with max among them.
class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int n=nums.length;
        int dp[]=new int[100001];

        int ans=1;

        for(int i=0;i<n;i++){
            
            int floor=nums[i]-k;

            int start=floor;
            int end=nums[i]-1;

            if(start<1)start=1;

            int max=0;
            for(int j=start;j<=end;j++){
                max=Math.max(max,dp[j]);
            }
            
            dp[nums[i]]=Math.max(dp[nums[i]],max+1);

            ans=Math.max(dp[nums[i]],ans);
        }
        return ans;
    }
}
approach 6)================================TreeSet================================nlogn+n*(k(most of the times less))

class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int n=nums.length;
        TreeMap<Integer,Integer> map = new TreeMap<>();

        int ans=1;

        for(int i=0;i<n;i++){

            int currEle=nums[i];
            
            int start=nums[i]-k;
            int end=nums[i]-1;

            int ceilOfStart=Integer.MAX_VALUE;
            if(map.ceilingKey(start)!=null){
                ceilOfStart=map.ceilingKey(start);
            }
            int floorOfEnd=-1;
            if(map.floorKey(end)!=null){
                floorOfEnd=map.floorKey(end);
            }
 


            if(ceilOfStart==Integer.MAX_VALUE && floorOfEnd==-1){
                map.put(nums[i],1);
            }
            else if(ceilOfStart>end){
                map.put(nums[i],1);
            }
            else if(floorOfEnd<start){
                map.put(nums[i],1);
            }
            else{

                int max=0;
                
               
                Map<Integer, Integer> subMap = map.subMap(ceilOfStart, true, floorOfEnd, true);
                for(int key:subMap.keySet()){
                    max=Math.max(max,map.get(key));
                }

                if(map.containsKey(currEle)){
                    if(map.get(currEle)<max+1)
                        map.put(currEle,max+1);
                }
                else{
                    map.put(currEle,max+1);
                }

                ans=Math.max(map.get(currEle),ans);
            }
        }
        return ans;
    }
}
