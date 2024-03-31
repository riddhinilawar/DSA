3098. Find the Sum of Subsequence Powers

You are given an integer array nums of length n, and a positive integer k.
The power of a subsequence is defined as the minimum absolute difference between any two elements in the subsequence.
Return the sum of powers of all subsequences of nums which have length equal to k.
Since the answer may be large, return it modulo 109 + 7.


Example 1:
Input: nums = [1,2,3,4], k = 3
Output: 4
Explanation:
There are 4 subsequences in nums which have length 3: [1,2,3], [1,3,4], [1,2,4], and [2,3,4]. The sum of powers is |2 - 3| + |3 - 4| + |2 - 1| + |3 - 4| = 4.
Example 2:
Input: nums = [2,2], k = 2
Output: 0
Explanation:
The only subsequence in nums which has length 2 is [2,2]. The sum of powers is |2 - 2| = 0.
Example 3:
Input: nums = [4,3,-1], k = 2
Output: 10
Explanation:
There are 3 subsequences in nums which have length 2: [4,3], [4,-1], and [3,-1]. The sum of powers is |4 - 3| + |4 - (-1)| + |3 - (-1)| = 10.

Constraints:

2 <= n == nums.length <= 50
-108 <= nums[i] <= 108 
2 <= k <= n

class Solution {
    int mod=(int)1e9+7;
    int dp[][][];
    public int sumOfPowers(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int idx=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)continue;
                int diff=Math.abs(nums[i]-nums[j]);
                if(map.containsKey(diff)==false){
                    map.put(diff,idx++);
                }
            }
        }
        map.put(Integer.MAX_VALUE,idx++);
        dp=new int[50][50][map.size()];
        for(int arr1[][]:dp){
            for(int arr2[]:arr1){
                Arrays.fill(arr2,-1);
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=helper(i,nums,k-1,Integer.MAX_VALUE,map)%mod;
            sum%=mod;
        }
        return sum;
        
    }
    public int helper(int idx,int nums[],int k,int minAbs,HashMap<Integer,Integer> map){
        if(k==0){
            return minAbs%mod;
        }
        if(idx>=nums.length){
            return 0;
        }

        int midx=map.get(minAbs);
        if(dp[idx][k][midx]!=-1){
            return dp[idx][k][midx];
        }

        int sum=0;

        for(int i=idx+1;i<nums.length;i++){
            sum+=helper(i,nums,k-1,Math.min(minAbs,Math.abs(nums[idx]-nums[i])),map)%mod;
            sum%=mod;
        }
        return dp[idx][k][midx]=sum%mod;
    }
}
