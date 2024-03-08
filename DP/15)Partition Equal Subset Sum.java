Note:Same as previous just target is sum/2 
If sum is odd we can not divide arry in 2 parts so return false..else try to find the subseq in arr with target=sum/2..if exist return true else false

Problem statement
You are given an array 'ARR' of 'N' positive integers. Your task is to find if we can partition the given array into two subsets such that the sum of elements in both subsets is equal.

For example, let’s say the given array is [2, 3, 3, 3, 4, 5], then the array can be partitioned as [2, 3, 5], and [3, 3, 4] with equal sum 10.

Follow Up:

Can you solve this using not more than O(S) extra space, where S is the sum of all elements of the given array?
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= 'T' <= 10
1 <= 'N' <= 100 
1 <= 'ARR'[i] <= 100

Time Limit: 1 sec
Sample Input 1:
2
6
3 1 1 2 2 1
5
5 6 5 11 6
Sample Output 1:
true
false    
Explanation Of Sample Input 1:
For the first test case, the array can be partitioned as ([2,1,1,1] and [3, 2]) or ([2,2,1], and [1,1,3]) with sum 5.

For the second test case, the array can’t be partitioned.
Sample Input 2:
2
9
2 2 1 1 1 1 1 3 3
6
8 7 6 12 4 5
Sample Output 2:
false
true

public class Solution {
	public static boolean canPartition(int[] arr, int n) {

		long sum=0;

		for(int temp:arr)
			sum+=temp;

		if(sum%2!=0){
			return false;
		}

		int k=(int)(sum/2);
		boolean dp[][]=new boolean[n][k+1];
        
        for(int i=0;i<n;i++)
            dp[i][0]=true;

        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        for(int idx=1;idx<n;idx++){
            for(int target=1;target<=k;target++){
                boolean notTaken=dp[idx-1][target];
                boolean taken=false;
                if(arr[idx]<=target)taken=dp[idx-1][target-arr[idx]];

                dp[idx][target]=notTaken||taken;
            }
        }
        return dp[n-1][k];
	}
}
