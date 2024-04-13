
1425. Constrained Subsequence Sum

Given an integer array nums and an integer k, return the maximum sum of a non-empty subsequence of that array such that for every two consecutive integers in the subsequence, nums[i] and nums[j], where i < j, the condition j - i <= k is satisfied.

A subsequence of an array is obtained by deleting some number of elements (can be zero) from the array, leaving the remaining elements in their original order.

 

Example 1:

Input: nums = [10,2,-10,5,20], k = 2
Output: 37
Explanation: The subsequence is [10, 2, 5, 20].
Example 2:

Input: nums = [-1,-2,-3], k = 1
Output: -1
Explanation: The subsequence must be non-empty, so we choose the largest number.
Example 3:

Input: nums = [10,-2,-10,-5,20], k = 2
Output: 23
Explanation: The subsequence is [10, -2, -5, 20].
 

Constraints:

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104


=================================================Recursion=========================TLE================
class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
            ans=Math.max(ans,nums[i]+helper(i,nums,k));
        return ans;
    }
    public int helper(int idx,int nums[],int k){
        int cost=0;
        for(int i=idx+1;i<nums.length;i++){
            if(i-idx<=k){
                cost=Math.max(cost,nums[i]+helper(i,nums,k));
            }
        }
        return cost;
    }
}
==================================================== Memo==============================TLE============

class Solution {
    int dp[];
    public int constrainedSubsetSum(int[] nums, int k) {
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
            ans=Math.max(ans,nums[i]+helper(i,nums,k));
        return ans;
    }
    public int helper(int idx,int nums[],int k){
        if(dp[idx]!=-1)return dp[idx];
        int cost=0;
        for(int i=idx+1;i<nums.length;i++){
            if(i-idx<=k){
                cost=Math.max(cost,nums[i]+helper(i,nums,k));
            }
            else{
                break;
            }
        }
        return dp[idx]=cost;
    }
}


========================================Tabulation===============n*k=============TLE=====================
class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n=nums.length;
        int dp[]=new int[n];
        int ans=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int max=0;

            int j=i-k;
            if(j<0)j=0;

            for(;j<i;j++){
                max=Math.max(max,dp[j]);
            }
            
            dp[i]=nums[i]+max;
            ans=Math.max(ans,dp[i]);
        }

        return ans;
    }
}
================================================Heap+Tabulation+sliding window=============n*logk======

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n=nums.length;
        int dp[]=new int[n];
        int ans=Integer.MIN_VALUE;

        PriorityQueue<Entry> pq = new PriorityQueue<>((a,b)->b.value-a.value);
        HashMap<Integer,Entry> mapToObject = new HashMap<>(); 

        for(int i=0;i<n;i++){

            if(i-k-1>=0){
                pq.remove(mapToObject.get(i-k-1));
            }
            
            int max=0;
            if(!pq.isEmpty()){
                max=Math.max(max,pq.peek().value);
            }


            dp[i]=nums[i]+max;
            ans=Math.max(ans,dp[i]);

            Entry entry = new Entry(dp[i]);
            mapToObject.put(i,entry);
            pq.add(entry);
        }

        return ans;
    }
}
class Entry{
    int value;
    Entry(int value){
        this.value=value;
    }
}

================================Using dequeue====================accepted solution===========(n+n)============

  public class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            
            //add the first element in the dequeue to into the curr element.
            nums[i] += !dq.isEmpty() ? nums[dq.peekFirst()] : 0;
            
            //remove from first the curr-kth index elements if exists in dequeue 
            while (!dq.isEmpty() && (nums[i] >= nums[dq.peekLast()])) {
                dq.pollLast();
            }

            //remove from last in the curr formed element is more than the available emenet in the dequeue.
            while (!dq.isEmpty() && (i - dq.peekFirst() >= k )) {
                dq.pollFirst();
            }
            
            //put the curr index in the dequeue if the value is greater than 0, else its of no use
            if (nums[i] > 0) {
                dq.offerLast(i);
            }
        }
        return Arrays.stream(nums).max().getAsInt();
    }
}
