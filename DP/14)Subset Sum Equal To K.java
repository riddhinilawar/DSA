Subset Sum Equal To K

Problem statement
You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.

Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.

For Example :
If ‘ARR’ is {1,2,3,4} and ‘K’ = 4, then there exists 2 subsets with sum = 4. These are {1,3} and {4}. Hence, return true.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 5
1 <= N <= 10^3
0 <= ARR[i] <= 10^9
0 <= K <= 10^3

Time Limit: 1 sec
Sample Input 1:
2
4 5
4 3 2 1
5 4
2 5 1 6 7
Sample Output 1:
true
false
Explanation For Sample Input 1:
In example 1, ‘ARR’ is {4,3,2,1} and ‘K’ = 5. There exist 2 subsets with sum = 5. These are {4,1} and {3,2}. Hence, return true.
In example 2, ‘ARR’ is {2,5,1,6,7} and ‘K’ = 4. There are no subsets with sum = 4. Hence, return false.
Sample Input 2:
2
4 4
6 1 2 1
5 6
1 7 2 9 10
Sample Output 2:
true
false
Explanation For Sample Input 2:
In example 1, ‘ARR’ is {6,1,2,1} and ‘K’ = 4. There exist 1 subset with sum = 4. That is {1,2,1}. Hence, return true.
In example 2, ‘ARR’ is {1,7,2,9,10} and ‘K’ = 6. There are no subsets with sum = 6. Hence, return false.

======================================RECURSION==================================


import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        return helper(n-1,k,arr);
    }
    public static boolean helper(int idx,int target,int[] arr){
        if(target==0){
            return true;
        }
        if(idx==-1){
            return false;
        }

        boolean notTaken=helper(idx-1,target,arr);
        boolean taken=false;
        if(arr[idx]<=target)taken=helper(idx-1,target-arr[idx],arr);

        return notTaken||taken;
    }
}
TC:O(2^N)
SC:O(N)

===================================================MEMOIZATION=================================

import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean dp[][]=new boolean[n+1][k+1];
        return helper(n-1,k,arr,dp);
    }
    public static boolean helper(int idx,int target,int[] arr,boolean[][] dp){
        if(target==0){
            return true;
        }
        if(idx==-1){
            return false;
        }
        if(dp[idx][target]==true){
            return true;
        }

        boolean notTaken=helper(idx-1,target,arr,dp);
        boolean taken=false;
        if(arr[idx]<=target)taken=helper(idx-1,target-arr[idx],arr,dp);

        return dp[idx][target]=notTaken||taken;
    }
}

SC:O(N*TARGET)
TC:O(N*TARGET)
=================================================TABULATION=========================================================

import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
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
SC:O(N*TARGET)
TC:O(N*TARGET)
